/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import CONTROLADOR.exceptions.IllegalOrphanException;
import CONTROLADOR.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import MODELO.Usuario;
import MODELO.Permisos;
import MODELO.RolUsuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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

    public void create(RolUsuario rolUsuario) {
        if (rolUsuario.getPermisosCollection() == null) {
            rolUsuario.setPermisosCollection(new ArrayList<Permisos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuarioId = rolUsuario.getUsuarioId();
            if (usuarioId != null) {
                usuarioId = em.getReference(usuarioId.getClass(), usuarioId.getId());
                rolUsuario.setUsuarioId(usuarioId);
            }
            Collection<Permisos> attachedPermisosCollection = new ArrayList<Permisos>();
            for (Permisos permisosCollectionPermisosToAttach : rolUsuario.getPermisosCollection()) {
                permisosCollectionPermisosToAttach = em.getReference(permisosCollectionPermisosToAttach.getClass(), permisosCollectionPermisosToAttach.getIdpermisos());
                attachedPermisosCollection.add(permisosCollectionPermisosToAttach);
            }
            rolUsuario.setPermisosCollection(attachedPermisosCollection);
            em.persist(rolUsuario);
            if (usuarioId != null) {
                usuarioId.getRolUsuarioCollection().add(rolUsuario);
                usuarioId = em.merge(usuarioId);
            }
            for (Permisos permisosCollectionPermisos : rolUsuario.getPermisosCollection()) {
                RolUsuario oldRolUsuarioIdOfPermisosCollectionPermisos = permisosCollectionPermisos.getRolUsuarioId();
                permisosCollectionPermisos.setRolUsuarioId(rolUsuario);
                permisosCollectionPermisos = em.merge(permisosCollectionPermisos);
                if (oldRolUsuarioIdOfPermisosCollectionPermisos != null) {
                    oldRolUsuarioIdOfPermisosCollectionPermisos.getPermisosCollection().remove(permisosCollectionPermisos);
                    oldRolUsuarioIdOfPermisosCollectionPermisos = em.merge(oldRolUsuarioIdOfPermisosCollectionPermisos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RolUsuario rolUsuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RolUsuario persistentRolUsuario = em.find(RolUsuario.class, rolUsuario.getId());
            Usuario usuarioIdOld = persistentRolUsuario.getUsuarioId();
            Usuario usuarioIdNew = rolUsuario.getUsuarioId();
            Collection<Permisos> permisosCollectionOld = persistentRolUsuario.getPermisosCollection();
            Collection<Permisos> permisosCollectionNew = rolUsuario.getPermisosCollection();
            List<String> illegalOrphanMessages = null;
            for (Permisos permisosCollectionOldPermisos : permisosCollectionOld) {
                if (!permisosCollectionNew.contains(permisosCollectionOldPermisos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Permisos " + permisosCollectionOldPermisos + " since its rolUsuarioId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (usuarioIdNew != null) {
                usuarioIdNew = em.getReference(usuarioIdNew.getClass(), usuarioIdNew.getId());
                rolUsuario.setUsuarioId(usuarioIdNew);
            }
            Collection<Permisos> attachedPermisosCollectionNew = new ArrayList<Permisos>();
            for (Permisos permisosCollectionNewPermisosToAttach : permisosCollectionNew) {
                permisosCollectionNewPermisosToAttach = em.getReference(permisosCollectionNewPermisosToAttach.getClass(), permisosCollectionNewPermisosToAttach.getIdpermisos());
                attachedPermisosCollectionNew.add(permisosCollectionNewPermisosToAttach);
            }
            permisosCollectionNew = attachedPermisosCollectionNew;
            rolUsuario.setPermisosCollection(permisosCollectionNew);
            rolUsuario = em.merge(rolUsuario);
            if (usuarioIdOld != null && !usuarioIdOld.equals(usuarioIdNew)) {
                usuarioIdOld.getRolUsuarioCollection().remove(rolUsuario);
                usuarioIdOld = em.merge(usuarioIdOld);
            }
            if (usuarioIdNew != null && !usuarioIdNew.equals(usuarioIdOld)) {
                usuarioIdNew.getRolUsuarioCollection().add(rolUsuario);
                usuarioIdNew = em.merge(usuarioIdNew);
            }
            for (Permisos permisosCollectionNewPermisos : permisosCollectionNew) {
                if (!permisosCollectionOld.contains(permisosCollectionNewPermisos)) {
                    RolUsuario oldRolUsuarioIdOfPermisosCollectionNewPermisos = permisosCollectionNewPermisos.getRolUsuarioId();
                    permisosCollectionNewPermisos.setRolUsuarioId(rolUsuario);
                    permisosCollectionNewPermisos = em.merge(permisosCollectionNewPermisos);
                    if (oldRolUsuarioIdOfPermisosCollectionNewPermisos != null && !oldRolUsuarioIdOfPermisosCollectionNewPermisos.equals(rolUsuario)) {
                        oldRolUsuarioIdOfPermisosCollectionNewPermisos.getPermisosCollection().remove(permisosCollectionNewPermisos);
                        oldRolUsuarioIdOfPermisosCollectionNewPermisos = em.merge(oldRolUsuarioIdOfPermisosCollectionNewPermisos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = rolUsuario.getId();
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RolUsuario rolUsuario;
            try {
                rolUsuario = em.getReference(RolUsuario.class, id);
                rolUsuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rolUsuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Permisos> permisosCollectionOrphanCheck = rolUsuario.getPermisosCollection();
            for (Permisos permisosCollectionOrphanCheckPermisos : permisosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This RolUsuario (" + rolUsuario + ") cannot be destroyed since the Permisos " + permisosCollectionOrphanCheckPermisos + " in its permisosCollection field has a non-nullable rolUsuarioId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Usuario usuarioId = rolUsuario.getUsuarioId();
            if (usuarioId != null) {
                usuarioId.getRolUsuarioCollection().remove(rolUsuario);
                usuarioId = em.merge(usuarioId);
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

    public RolUsuario findRolUsuario(Integer id) {
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
    
    //busquedad propia
    public List<RolUsuario> buscarRolUsuarioId(int idUsuario){
        EntityManager em = getEntityManager();
        List<RolUsuario> rolUsuario = new ArrayList<>();
        try {
            em.getTransaction().begin();
            TypedQuery<RolUsuario> q =em.createNamedQuery("RolUsuario.findByUsuarioId", RolUsuario.class);
            q.setParameter("usuarioId", idUsuario);
            rolUsuario = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error RolUsuarioJpaController.buscarrolUsuarioId(): "+e.getMessage());
        } finally {
            em.close();
        }
        return rolUsuario;
    }
    
     public List<RolUsuario> buscarRolUsuarioNombreUsuario (String nombre) {
        List<RolUsuario> RolUsuarios = new ArrayList<>();
        EntityManager em = getEntityManager();
         EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<RolUsuario> q = em.createNamedQuery("RolUsuario.findByUsuarioLike", RolUsuario.class);
            q.setParameter("nombre", nombre);
            RolUsuarios = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error RolUsuarioJpaController.buscarRolUsuarioNombreUsuario() "+e.getMessage() );
        } finally {
            em.close();
        }
        return RolUsuarios;
    }
     
     public List<RolUsuario> buscarRolUsuarioNombreRol (String nombre) {
        List<RolUsuario> RolUsuarios = new ArrayList<>();
        EntityManager em = getEntityManager();
         EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<RolUsuario> q = em.createNamedQuery("RolUsuario.findByNombreRolLike", RolUsuario.class);
            q.setParameter("nombrerol", nombre);
            RolUsuarios = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error RolUsuarioJpaController.buscarRolUsuarioNombreRol() "+e.getMessage() );
        } finally {
            em.close();
        }
        return RolUsuarios;
    }
    
}
