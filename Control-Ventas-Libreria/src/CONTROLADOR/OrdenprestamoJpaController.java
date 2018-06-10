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
import MODELO.Cliente;
import MODELO.Empleado;
import MODELO.Ordenitemprestamo;
import MODELO.Ordenprestamo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

/**
 *
 * @author ayenni42
 */
public class OrdenprestamoJpaController implements Serializable {

    public OrdenprestamoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ordenprestamo ordenprestamo) {
        if (ordenprestamo.getOrdenitemprestamoCollection() == null) {
            ordenprestamo.setOrdenitemprestamoCollection(new ArrayList<Ordenitemprestamo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente clienteId = ordenprestamo.getClienteId();
            if (clienteId != null) {
                clienteId = em.getReference(clienteId.getClass(), clienteId.getId());
                ordenprestamo.setClienteId(clienteId);
            }
            Empleado empleadoId = ordenprestamo.getEmpleadoId();
            if (empleadoId != null) {
                empleadoId = em.getReference(empleadoId.getClass(), empleadoId.getId());
                ordenprestamo.setEmpleadoId(empleadoId);
            }
            Collection<Ordenitemprestamo> attachedOrdenitemprestamoCollection = new ArrayList<Ordenitemprestamo>();
            for (Ordenitemprestamo ordenitemprestamoCollectionOrdenitemprestamoToAttach : ordenprestamo.getOrdenitemprestamoCollection()) {
                ordenitemprestamoCollectionOrdenitemprestamoToAttach = em.getReference(ordenitemprestamoCollectionOrdenitemprestamoToAttach.getClass(), ordenitemprestamoCollectionOrdenitemprestamoToAttach.getOrdenitemprestamoPK());
                attachedOrdenitemprestamoCollection.add(ordenitemprestamoCollectionOrdenitemprestamoToAttach);
            }
            ordenprestamo.setOrdenitemprestamoCollection(attachedOrdenitemprestamoCollection);
            em.persist(ordenprestamo);
            if (clienteId != null) {
                clienteId.getOrdenprestamoCollection().add(ordenprestamo);
                clienteId = em.merge(clienteId);
            }
            if (empleadoId != null) {
                empleadoId.getOrdenprestamoCollection().add(ordenprestamo);
                empleadoId = em.merge(empleadoId);
            }
            for (Ordenitemprestamo ordenitemprestamoCollectionOrdenitemprestamo : ordenprestamo.getOrdenitemprestamoCollection()) {
                Ordenprestamo oldOrdenprestamoOfOrdenitemprestamoCollectionOrdenitemprestamo = ordenitemprestamoCollectionOrdenitemprestamo.getOrdenprestamo();
                ordenitemprestamoCollectionOrdenitemprestamo.setOrdenprestamo(ordenprestamo);
                ordenitemprestamoCollectionOrdenitemprestamo = em.merge(ordenitemprestamoCollectionOrdenitemprestamo);
                if (oldOrdenprestamoOfOrdenitemprestamoCollectionOrdenitemprestamo != null) {
                    oldOrdenprestamoOfOrdenitemprestamoCollectionOrdenitemprestamo.getOrdenitemprestamoCollection().remove(ordenitemprestamoCollectionOrdenitemprestamo);
                    oldOrdenprestamoOfOrdenitemprestamoCollectionOrdenitemprestamo = em.merge(oldOrdenprestamoOfOrdenitemprestamoCollectionOrdenitemprestamo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ordenprestamo ordenprestamo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordenprestamo persistentOrdenprestamo = em.find(Ordenprestamo.class, ordenprestamo.getNumeroorden());
            Cliente clienteIdOld = persistentOrdenprestamo.getClienteId();
            Cliente clienteIdNew = ordenprestamo.getClienteId();
            Empleado empleadoIdOld = persistentOrdenprestamo.getEmpleadoId();
            Empleado empleadoIdNew = ordenprestamo.getEmpleadoId();
            Collection<Ordenitemprestamo> ordenitemprestamoCollectionOld = persistentOrdenprestamo.getOrdenitemprestamoCollection();
            Collection<Ordenitemprestamo> ordenitemprestamoCollectionNew = ordenprestamo.getOrdenitemprestamoCollection();
            List<String> illegalOrphanMessages = null;
            for (Ordenitemprestamo ordenitemprestamoCollectionOldOrdenitemprestamo : ordenitemprestamoCollectionOld) {
                if (!ordenitemprestamoCollectionNew.contains(ordenitemprestamoCollectionOldOrdenitemprestamo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ordenitemprestamo " + ordenitemprestamoCollectionOldOrdenitemprestamo + " since its ordenprestamo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (clienteIdNew != null) {
                clienteIdNew = em.getReference(clienteIdNew.getClass(), clienteIdNew.getId());
                ordenprestamo.setClienteId(clienteIdNew);
            }
            if (empleadoIdNew != null) {
                empleadoIdNew = em.getReference(empleadoIdNew.getClass(), empleadoIdNew.getId());
                ordenprestamo.setEmpleadoId(empleadoIdNew);
            }
            Collection<Ordenitemprestamo> attachedOrdenitemprestamoCollectionNew = new ArrayList<Ordenitemprestamo>();
            for (Ordenitemprestamo ordenitemprestamoCollectionNewOrdenitemprestamoToAttach : ordenitemprestamoCollectionNew) {
                ordenitemprestamoCollectionNewOrdenitemprestamoToAttach = em.getReference(ordenitemprestamoCollectionNewOrdenitemprestamoToAttach.getClass(), ordenitemprestamoCollectionNewOrdenitemprestamoToAttach.getOrdenitemprestamoPK());
                attachedOrdenitemprestamoCollectionNew.add(ordenitemprestamoCollectionNewOrdenitemprestamoToAttach);
            }
            ordenitemprestamoCollectionNew = attachedOrdenitemprestamoCollectionNew;
            ordenprestamo.setOrdenitemprestamoCollection(ordenitemprestamoCollectionNew);
            ordenprestamo = em.merge(ordenprestamo);
            if (clienteIdOld != null && !clienteIdOld.equals(clienteIdNew)) {
                clienteIdOld.getOrdenprestamoCollection().remove(ordenprestamo);
                clienteIdOld = em.merge(clienteIdOld);
            }
            if (clienteIdNew != null && !clienteIdNew.equals(clienteIdOld)) {
                clienteIdNew.getOrdenprestamoCollection().add(ordenprestamo);
                clienteIdNew = em.merge(clienteIdNew);
            }
            if (empleadoIdOld != null && !empleadoIdOld.equals(empleadoIdNew)) {
                empleadoIdOld.getOrdenprestamoCollection().remove(ordenprestamo);
                empleadoIdOld = em.merge(empleadoIdOld);
            }
            if (empleadoIdNew != null && !empleadoIdNew.equals(empleadoIdOld)) {
                empleadoIdNew.getOrdenprestamoCollection().add(ordenprestamo);
                empleadoIdNew = em.merge(empleadoIdNew);
            }
            for (Ordenitemprestamo ordenitemprestamoCollectionNewOrdenitemprestamo : ordenitemprestamoCollectionNew) {
                if (!ordenitemprestamoCollectionOld.contains(ordenitemprestamoCollectionNewOrdenitemprestamo)) {
                    Ordenprestamo oldOrdenprestamoOfOrdenitemprestamoCollectionNewOrdenitemprestamo = ordenitemprestamoCollectionNewOrdenitemprestamo.getOrdenprestamo();
                    ordenitemprestamoCollectionNewOrdenitemprestamo.setOrdenprestamo(ordenprestamo);
                    ordenitemprestamoCollectionNewOrdenitemprestamo = em.merge(ordenitemprestamoCollectionNewOrdenitemprestamo);
                    if (oldOrdenprestamoOfOrdenitemprestamoCollectionNewOrdenitemprestamo != null && !oldOrdenprestamoOfOrdenitemprestamoCollectionNewOrdenitemprestamo.equals(ordenprestamo)) {
                        oldOrdenprestamoOfOrdenitemprestamoCollectionNewOrdenitemprestamo.getOrdenitemprestamoCollection().remove(ordenitemprestamoCollectionNewOrdenitemprestamo);
                        oldOrdenprestamoOfOrdenitemprestamoCollectionNewOrdenitemprestamo = em.merge(oldOrdenprestamoOfOrdenitemprestamoCollectionNewOrdenitemprestamo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ordenprestamo.getNumeroorden();
                if (findOrdenprestamo(id) == null) {
                    throw new NonexistentEntityException("The ordenprestamo with id " + id + " no longer exists.");
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
            Ordenprestamo ordenprestamo;
            try {
                ordenprestamo = em.getReference(Ordenprestamo.class, id);
                ordenprestamo.getNumeroorden();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordenprestamo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Ordenitemprestamo> ordenitemprestamoCollectionOrphanCheck = ordenprestamo.getOrdenitemprestamoCollection();
            for (Ordenitemprestamo ordenitemprestamoCollectionOrphanCheckOrdenitemprestamo : ordenitemprestamoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ordenprestamo (" + ordenprestamo + ") cannot be destroyed since the Ordenitemprestamo " + ordenitemprestamoCollectionOrphanCheckOrdenitemprestamo + " in its ordenitemprestamoCollection field has a non-nullable ordenprestamo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cliente clienteId = ordenprestamo.getClienteId();
            if (clienteId != null) {
                clienteId.getOrdenprestamoCollection().remove(ordenprestamo);
                clienteId = em.merge(clienteId);
            }
            Empleado empleadoId = ordenprestamo.getEmpleadoId();
            if (empleadoId != null) {
                empleadoId.getOrdenprestamoCollection().remove(ordenprestamo);
                empleadoId = em.merge(empleadoId);
            }
            em.remove(ordenprestamo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ordenprestamo> findOrdenprestamoEntities() {
        return findOrdenprestamoEntities(true, -1, -1);
    }

    public List<Ordenprestamo> findOrdenprestamoEntities(int maxResults, int firstResult) {
        return findOrdenprestamoEntities(false, maxResults, firstResult);
    }

    private List<Ordenprestamo> findOrdenprestamoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ordenprestamo.class));
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

    public Ordenprestamo findOrdenprestamo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ordenprestamo.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdenprestamoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ordenprestamo> rt = cq.from(Ordenprestamo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    //consultas propias 
    public List<Ordenprestamo> buscarOrdenPrestamoFechaEntrega (Date fechaEntrega) {
        EntityManager em = getEntityManager();
        List<Ordenprestamo> ordenEntrega = new ArrayList<>();
        try {
            em.getTransaction().begin();
            TypedQuery<Ordenprestamo> q = em.createNamedQuery("Ordenprestamo.findByFechaentrega", Ordenprestamo.class);
            q.setParameter("fechaentrega", fechaEntrega);
            ordenEntrega = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error OrdenprestamoJpaController.buscarOrdenPrestamoFechaEntrega(): "+e.getMessage());
        }  finally {
            em.close();
        }
        return ordenEntrega;
    }
    
    public List<Ordenprestamo> buscarOrdenprestamoNombreE (String nombre) {
        List<Ordenprestamo> Ordenprestamos = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Ordenprestamo> q = em.createNamedQuery("Ordenprestamo.findByNombreELike", Ordenprestamo.class);
            q.setParameter("nombreE", nombre);
            Ordenprestamos = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error OrdenprestamoJpaController.buscarOrdenprestamoNombreE() "+e.getMessage());
        } finally {
            em.close();
        }
        return Ordenprestamos;
    }
    
    public List<Ordenprestamo> buscarOrdenprestamoNombreC (String nombre) {
        List<Ordenprestamo> Ordenprestamos = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Ordenprestamo> q = em.createNamedQuery("Ordenprestamo.findByNombreCLike", Ordenprestamo.class);
            q.setParameter("nombreC", nombre);
            Ordenprestamos = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error OrdenprestamoJpaController.buscarOrdenprestamoNombreA() "+e.getMessage() );
        } finally {
            em.close();
        }
        return Ordenprestamos;
    }
    public List<Ordenprestamo> buscarRangoFecha (Date fechaInicial, Date fechaFinal) {
        List<Ordenprestamo> Ordenprestamos = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Ordenprestamo> q = em.createNamedQuery("Ordenprestamo.findByRangoFechas", Ordenprestamo.class);
            q.setParameter("fechaentregaI", fechaInicial,TemporalType.DATE);
            q.setParameter("fechaentregaF", fechaFinal,TemporalType.DATE);
            Ordenprestamos = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Erro OrdenprestamoJpaController.buscarRangoFecha() "+e.getMessage());
        } finally {
            em.close();
        }
        return Ordenprestamos;
    }
}
