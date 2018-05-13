/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import CONTROLADOR.exceptions.NonexistentEntityException;
import CONTROLADOR.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import MODELO.Permiso;
import MODELO.RolUsuario;
import MODELO.RolUsuarioPK;
import MODELO.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ayenni42
 */
public class RolUsuarioJpaController implements Serializable {

    public RolUsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RolUsuario rolUsuario) throws PreexistingEntityException, Exception {
        if (rolUsuario.getRolUsuarioPK() == null) {
            rolUsuario.setRolUsuarioPK(new RolUsuarioPK());
        }
        rolUsuario.getRolUsuarioPK().setUsuarioId(rolUsuario.getUsuario().getId());
        rolUsuario.getRolUsuarioPK().setPermisoId(rolUsuario.getPermiso().getId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Permiso permiso = rolUsuario.getPermiso();
            if (permiso != null) {
                permiso = em.getReference(permiso.getClass(), permiso.getId());
                rolUsuario.setPermiso(permiso);
            }
            Usuario usuario = rolUsuario.getUsuario();
            if (usuario != null) {
                usuario = em.getReference(usuario.getClass(), usuario.getId());
                rolUsuario.setUsuario(usuario);
            }
            em.persist(rolUsuario);
            if (permiso != null) {
                permiso.getRolUsuarioCollection().add(rolUsuario);
                permiso = em.merge(permiso);
            }
            if (usuario != null) {
                usuario.getRolUsuarioCollection().add(rolUsuario);
                usuario = em.merge(usuario);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRolUsuario(rolUsuario.getRolUsuarioPK()) != null) {
                throw new PreexistingEntityException("RolUsuario " + rolUsuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RolUsuario rolUsuario) throws NonexistentEntityException, Exception {
        rolUsuario.getRolUsuarioPK().setUsuarioId(rolUsuario.getUsuario().getId());
        rolUsuario.getRolUsuarioPK().setPermisoId(rolUsuario.getPermiso().getId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RolUsuario persistentRolUsuario = em.find(RolUsuario.class, rolUsuario.getRolUsuarioPK());
            Permiso permisoOld = persistentRolUsuario.getPermiso();
            Permiso permisoNew = rolUsuario.getPermiso();
            Usuario usuarioOld = persistentRolUsuario.getUsuario();
            Usuario usuarioNew = rolUsuario.getUsuario();
            if (permisoNew != null) {
                permisoNew = em.getReference(permisoNew.getClass(), permisoNew.getId());
                rolUsuario.setPermiso(permisoNew);
            }
            if (usuarioNew != null) {
                usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getId());
                rolUsuario.setUsuario(usuarioNew);
            }
            rolUsuario = em.merge(rolUsuario);
            if (permisoOld != null && !permisoOld.equals(permisoNew)) {
                permisoOld.getRolUsuarioCollection().remove(rolUsuario);
                permisoOld = em.merge(permisoOld);
            }
            if (permisoNew != null && !permisoNew.equals(permisoOld)) {
                permisoNew.getRolUsuarioCollection().add(rolUsuario);
                permisoNew = em.merge(permisoNew);
            }
            if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
                usuarioOld.getRolUsuarioCollection().remove(rolUsuario);
                usuarioOld = em.merge(usuarioOld);
            }
            if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
                usuarioNew.getRolUsuarioCollection().add(rolUsuario);
                usuarioNew = em.merge(usuarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                RolUsuarioPK id = rolUsuario.getRolUsuarioPK();
                if (findRolUsuario(id) == null) {
                    throw new NonexistentEntityException("The rolUsuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(RolUsuarioPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RolUsuario rolUsuario;
            try {
                rolUsuario = em.getReference(RolUsuario.class, id);
                rolUsuario.getRolUsuarioPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rolUsuario with id " + id + " no longer exists.", enfe);
            }
            Permiso permiso = rolUsuario.getPermiso();
            if (permiso != null) {
                permiso.getRolUsuarioCollection().remove(rolUsuario);
                permiso = em.merge(permiso);
            }
            Usuario usuario = rolUsuario.getUsuario();
            if (usuario != null) {
                usuario.getRolUsuarioCollection().remove(rolUsuario);
                usuario = em.merge(usuario);
            }
            em.remove(rolUsuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RolUsuario> findRolUsuarioEntities() {
        return findRolUsuarioEntities(true, -1, -1);
    }

    public List<RolUsuario> findRolUsuarioEntities(int maxResults, int firstResult) {
        return findRolUsuarioEntities(false, maxResults, firstResult);
    }

    private List<RolUsuario> findRolUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RolUsuario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public RolUsuario findRolUsuario(RolUsuarioPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RolUsuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getRolUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RolUsuario> rt = cq.from(RolUsuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
