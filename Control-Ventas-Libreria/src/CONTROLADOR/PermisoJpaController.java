/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import CONTROLADOR.exceptions.IllegalOrphanException;
import CONTROLADOR.exceptions.NonexistentEntityException;
import MODELO.Permiso;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import MODELO.RolUsuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ayenni42
 */
public class PermisoJpaController implements Serializable {

    public PermisoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Permiso permiso) {
        if (permiso.getRolUsuarioCollection() == null) {
            permiso.setRolUsuarioCollection(new ArrayList<RolUsuario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<RolUsuario> attachedRolUsuarioCollection = new ArrayList<RolUsuario>();
            for (RolUsuario rolUsuarioCollectionRolUsuarioToAttach : permiso.getRolUsuarioCollection()) {
                rolUsuarioCollectionRolUsuarioToAttach = em.getReference(rolUsuarioCollectionRolUsuarioToAttach.getClass(), rolUsuarioCollectionRolUsuarioToAttach.getRolUsuarioPK());
                attachedRolUsuarioCollection.add(rolUsuarioCollectionRolUsuarioToAttach);
            }
            permiso.setRolUsuarioCollection(attachedRolUsuarioCollection);
            em.persist(permiso);
            for (RolUsuario rolUsuarioCollectionRolUsuario : permiso.getRolUsuarioCollection()) {
                Permiso oldPermisoOfRolUsuarioCollectionRolUsuario = rolUsuarioCollectionRolUsuario.getPermiso();
                rolUsuarioCollectionRolUsuario.setPermiso(permiso);
                rolUsuarioCollectionRolUsuario = em.merge(rolUsuarioCollectionRolUsuario);
                if (oldPermisoOfRolUsuarioCollectionRolUsuario != null) {
                    oldPermisoOfRolUsuarioCollectionRolUsuario.getRolUsuarioCollection().remove(rolUsuarioCollectionRolUsuario);
                    oldPermisoOfRolUsuarioCollectionRolUsuario = em.merge(oldPermisoOfRolUsuarioCollectionRolUsuario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Permiso permiso) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Permiso persistentPermiso = em.find(Permiso.class, permiso.getId());
            Collection<RolUsuario> rolUsuarioCollectionOld = persistentPermiso.getRolUsuarioCollection();
            Collection<RolUsuario> rolUsuarioCollectionNew = permiso.getRolUsuarioCollection();
            List<String> illegalOrphanMessages = null;
            for (RolUsuario rolUsuarioCollectionOldRolUsuario : rolUsuarioCollectionOld) {
                if (!rolUsuarioCollectionNew.contains(rolUsuarioCollectionOldRolUsuario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain RolUsuario " + rolUsuarioCollectionOldRolUsuario + " since its permiso field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<RolUsuario> attachedRolUsuarioCollectionNew = new ArrayList<RolUsuario>();
            for (RolUsuario rolUsuarioCollectionNewRolUsuarioToAttach : rolUsuarioCollectionNew) {
                rolUsuarioCollectionNewRolUsuarioToAttach = em.getReference(rolUsuarioCollectionNewRolUsuarioToAttach.getClass(), rolUsuarioCollectionNewRolUsuarioToAttach.getRolUsuarioPK());
                attachedRolUsuarioCollectionNew.add(rolUsuarioCollectionNewRolUsuarioToAttach);
            }
            rolUsuarioCollectionNew = attachedRolUsuarioCollectionNew;
            permiso.setRolUsuarioCollection(rolUsuarioCollectionNew);
            permiso = em.merge(permiso);
            for (RolUsuario rolUsuarioCollectionNewRolUsuario : rolUsuarioCollectionNew) {
                if (!rolUsuarioCollectionOld.contains(rolUsuarioCollectionNewRolUsuario)) {
                    Permiso oldPermisoOfRolUsuarioCollectionNewRolUsuario = rolUsuarioCollectionNewRolUsuario.getPermiso();
                    rolUsuarioCollectionNewRolUsuario.setPermiso(permiso);
                    rolUsuarioCollectionNewRolUsuario = em.merge(rolUsuarioCollectionNewRolUsuario);
                    if (oldPermisoOfRolUsuarioCollectionNewRolUsuario != null && !oldPermisoOfRolUsuarioCollectionNewRolUsuario.equals(permiso)) {
                        oldPermisoOfRolUsuarioCollectionNewRolUsuario.getRolUsuarioCollection().remove(rolUsuarioCollectionNewRolUsuario);
                        oldPermisoOfRolUsuarioCollectionNewRolUsuario = em.merge(oldPermisoOfRolUsuarioCollectionNewRolUsuario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = permiso.getId();
                if (findPermiso(id) == null) {
                    throw new NonexistentEntityException("The permiso with id " + id + " no longer exists.");
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
            Permiso permiso;
            try {
                permiso = em.getReference(Permiso.class, id);
                permiso.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The permiso with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<RolUsuario> rolUsuarioCollectionOrphanCheck = permiso.getRolUsuarioCollection();
            for (RolUsuario rolUsuarioCollectionOrphanCheckRolUsuario : rolUsuarioCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Permiso (" + permiso + ") cannot be destroyed since the RolUsuario " + rolUsuarioCollectionOrphanCheckRolUsuario + " in its rolUsuarioCollection field has a non-nullable permiso field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(permiso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Permiso> findPermisoEntities() {
        return findPermisoEntities(true, -1, -1);
    }

    public List<Permiso> findPermisoEntities(int maxResults, int firstResult) {
        return findPermisoEntities(false, maxResults, firstResult);
    }

    private List<Permiso> findPermisoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Permiso.class));
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

    public Permiso findPermiso(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Permiso.class, id);
        } finally {
            em.close();
        }
    }

    public int getPermisoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Permiso> rt = cq.from(Permiso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
