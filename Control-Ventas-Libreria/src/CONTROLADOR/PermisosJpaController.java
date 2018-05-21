/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import CONTROLADOR.exceptions.NonexistentEntityException;
import MODELO.Permisos;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import MODELO.RolUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author ayenni42
 */
public class PermisosJpaController implements Serializable {

    public PermisosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Permisos permisos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RolUsuario rolUsuarioId = permisos.getRolUsuarioId();
            if (rolUsuarioId != null) {
                rolUsuarioId = em.getReference(rolUsuarioId.getClass(), rolUsuarioId.getId());
                permisos.setRolUsuarioId(rolUsuarioId);
            }
            em.persist(permisos);
            if (rolUsuarioId != null) {
                rolUsuarioId.getPermisosCollection().add(permisos);
                rolUsuarioId = em.merge(rolUsuarioId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Permisos permisos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Permisos persistentPermisos = em.find(Permisos.class, permisos.getIdpermisos());
            RolUsuario rolUsuarioIdOld = persistentPermisos.getRolUsuarioId();
            RolUsuario rolUsuarioIdNew = permisos.getRolUsuarioId();
            if (rolUsuarioIdNew != null) {
                rolUsuarioIdNew = em.getReference(rolUsuarioIdNew.getClass(), rolUsuarioIdNew.getId());
                permisos.setRolUsuarioId(rolUsuarioIdNew);
            }
            permisos = em.merge(permisos);
            if (rolUsuarioIdOld != null && !rolUsuarioIdOld.equals(rolUsuarioIdNew)) {
                rolUsuarioIdOld.getPermisosCollection().remove(permisos);
                rolUsuarioIdOld = em.merge(rolUsuarioIdOld);
            }
            if (rolUsuarioIdNew != null && !rolUsuarioIdNew.equals(rolUsuarioIdOld)) {
                rolUsuarioIdNew.getPermisosCollection().add(permisos);
                rolUsuarioIdNew = em.merge(rolUsuarioIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = permisos.getIdpermisos();
                if (findPermisos(id) == null) {
                    throw new NonexistentEntityException("The permisos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Permisos permisos;
            try {
                permisos = em.getReference(Permisos.class, id);
                permisos.getIdpermisos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The permisos with id " + id + " no longer exists.", enfe);
            }
            RolUsuario rolUsuarioId = permisos.getRolUsuarioId();
            if (rolUsuarioId != null) {
                rolUsuarioId.getPermisosCollection().remove(permisos);
                rolUsuarioId = em.merge(rolUsuarioId);
            }
            em.remove(permisos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Permisos> findPermisosEntities() {
        return findPermisosEntities(true, -1, -1);
    }

    public List<Permisos> findPermisosEntities(int maxResults, int firstResult) {
        return findPermisosEntities(false, maxResults, firstResult);
    }

    private List<Permisos> findPermisosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Permisos.class));
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

    public Permisos findPermisos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Permisos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPermisosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Permisos> rt = cq.from(Permisos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    //Consultas Prompias
    public List<Permisos> buscarPermisosRolId (int idPermisos) {
        EntityManager em = getEntityManager();
        List<Permisos> permisos = new ArrayList<>();
        try {
            em.getTransaction().begin();
            TypedQuery<Permisos> q = em.createNamedQuery("Permisos.finByRolIdPermisos", Permisos.class);
            q.setParameter("rolId", idPermisos);
            permisos = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error PermisosJpaController.buscarPermisosRolId(): "+e.getMessage());
        } finally {
            em.close();
        }
        return permisos;
    }
}
