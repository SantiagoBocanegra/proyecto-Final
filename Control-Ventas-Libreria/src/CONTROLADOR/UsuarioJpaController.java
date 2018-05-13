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
import MODELO.Empleado;
import MODELO.RolUsuario;
import MODELO.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ayenni42
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getRolUsuarioCollection() == null) {
            usuario.setRolUsuarioCollection(new ArrayList<RolUsuario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado empleadoId = usuario.getEmpleadoId();
            if (empleadoId != null) {
                empleadoId = em.getReference(empleadoId.getClass(), empleadoId.getId());
                usuario.setEmpleadoId(empleadoId);
            }
            Collection<RolUsuario> attachedRolUsuarioCollection = new ArrayList<RolUsuario>();
            for (RolUsuario rolUsuarioCollectionRolUsuarioToAttach : usuario.getRolUsuarioCollection()) {
                rolUsuarioCollectionRolUsuarioToAttach = em.getReference(rolUsuarioCollectionRolUsuarioToAttach.getClass(), rolUsuarioCollectionRolUsuarioToAttach.getRolUsuarioPK());
                attachedRolUsuarioCollection.add(rolUsuarioCollectionRolUsuarioToAttach);
            }
            usuario.setRolUsuarioCollection(attachedRolUsuarioCollection);
            em.persist(usuario);
            if (empleadoId != null) {
                empleadoId.getUsuarioCollection().add(usuario);
                empleadoId = em.merge(empleadoId);
            }
            for (RolUsuario rolUsuarioCollectionRolUsuario : usuario.getRolUsuarioCollection()) {
                Usuario oldUsuarioOfRolUsuarioCollectionRolUsuario = rolUsuarioCollectionRolUsuario.getUsuario();
                rolUsuarioCollectionRolUsuario.setUsuario(usuario);
                rolUsuarioCollectionRolUsuario = em.merge(rolUsuarioCollectionRolUsuario);
                if (oldUsuarioOfRolUsuarioCollectionRolUsuario != null) {
                    oldUsuarioOfRolUsuarioCollectionRolUsuario.getRolUsuarioCollection().remove(rolUsuarioCollectionRolUsuario);
                    oldUsuarioOfRolUsuarioCollectionRolUsuario = em.merge(oldUsuarioOfRolUsuarioCollectionRolUsuario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getId());
            Empleado empleadoIdOld = persistentUsuario.getEmpleadoId();
            Empleado empleadoIdNew = usuario.getEmpleadoId();
            Collection<RolUsuario> rolUsuarioCollectionOld = persistentUsuario.getRolUsuarioCollection();
            Collection<RolUsuario> rolUsuarioCollectionNew = usuario.getRolUsuarioCollection();
            List<String> illegalOrphanMessages = null;
            for (RolUsuario rolUsuarioCollectionOldRolUsuario : rolUsuarioCollectionOld) {
                if (!rolUsuarioCollectionNew.contains(rolUsuarioCollectionOldRolUsuario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain RolUsuario " + rolUsuarioCollectionOldRolUsuario + " since its usuario field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (empleadoIdNew != null) {
                empleadoIdNew = em.getReference(empleadoIdNew.getClass(), empleadoIdNew.getId());
                usuario.setEmpleadoId(empleadoIdNew);
            }
            Collection<RolUsuario> attachedRolUsuarioCollectionNew = new ArrayList<RolUsuario>();
            for (RolUsuario rolUsuarioCollectionNewRolUsuarioToAttach : rolUsuarioCollectionNew) {
                rolUsuarioCollectionNewRolUsuarioToAttach = em.getReference(rolUsuarioCollectionNewRolUsuarioToAttach.getClass(), rolUsuarioCollectionNewRolUsuarioToAttach.getRolUsuarioPK());
                attachedRolUsuarioCollectionNew.add(rolUsuarioCollectionNewRolUsuarioToAttach);
            }
            rolUsuarioCollectionNew = attachedRolUsuarioCollectionNew;
            usuario.setRolUsuarioCollection(rolUsuarioCollectionNew);
            usuario = em.merge(usuario);
            if (empleadoIdOld != null && !empleadoIdOld.equals(empleadoIdNew)) {
                empleadoIdOld.getUsuarioCollection().remove(usuario);
                empleadoIdOld = em.merge(empleadoIdOld);
            }
            if (empleadoIdNew != null && !empleadoIdNew.equals(empleadoIdOld)) {
                empleadoIdNew.getUsuarioCollection().add(usuario);
                empleadoIdNew = em.merge(empleadoIdNew);
            }
            for (RolUsuario rolUsuarioCollectionNewRolUsuario : rolUsuarioCollectionNew) {
                if (!rolUsuarioCollectionOld.contains(rolUsuarioCollectionNewRolUsuario)) {
                    Usuario oldUsuarioOfRolUsuarioCollectionNewRolUsuario = rolUsuarioCollectionNewRolUsuario.getUsuario();
                    rolUsuarioCollectionNewRolUsuario.setUsuario(usuario);
                    rolUsuarioCollectionNewRolUsuario = em.merge(rolUsuarioCollectionNewRolUsuario);
                    if (oldUsuarioOfRolUsuarioCollectionNewRolUsuario != null && !oldUsuarioOfRolUsuarioCollectionNewRolUsuario.equals(usuario)) {
                        oldUsuarioOfRolUsuarioCollectionNewRolUsuario.getRolUsuarioCollection().remove(rolUsuarioCollectionNewRolUsuario);
                        oldUsuarioOfRolUsuarioCollectionNewRolUsuario = em.merge(oldUsuarioOfRolUsuarioCollectionNewRolUsuario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getId();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<RolUsuario> rolUsuarioCollectionOrphanCheck = usuario.getRolUsuarioCollection();
            for (RolUsuario rolUsuarioCollectionOrphanCheckRolUsuario : rolUsuarioCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the RolUsuario " + rolUsuarioCollectionOrphanCheckRolUsuario + " in its rolUsuarioCollection field has a non-nullable usuario field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empleado empleadoId = usuario.getEmpleadoId();
            if (empleadoId != null) {
                empleadoId.getUsuarioCollection().remove(usuario);
                empleadoId = em.merge(empleadoId);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
