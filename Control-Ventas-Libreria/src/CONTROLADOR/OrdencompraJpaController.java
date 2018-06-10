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
import MODELO.Ordencompra;
import MODELO.Ordenitem;
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
public class OrdencompraJpaController implements Serializable {

    public OrdencompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ordencompra ordencompra) {
        if (ordencompra.getOrdenitemCollection() == null) {
            ordencompra.setOrdenitemCollection(new ArrayList<Ordenitem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente clienteId = ordencompra.getClienteId();
            if (clienteId != null) {
                clienteId = em.getReference(clienteId.getClass(), clienteId.getId());
                ordencompra.setClienteId(clienteId);
            }
            Empleado empleadoId = ordencompra.getEmpleadoId();
            if (empleadoId != null) {
                empleadoId = em.getReference(empleadoId.getClass(), empleadoId.getId());
                ordencompra.setEmpleadoId(empleadoId);
            }
            Collection<Ordenitem> attachedOrdenitemCollection = new ArrayList<Ordenitem>();
            for (Ordenitem ordenitemCollectionOrdenitemToAttach : ordencompra.getOrdenitemCollection()) {
                ordenitemCollectionOrdenitemToAttach = em.getReference(ordenitemCollectionOrdenitemToAttach.getClass(), ordenitemCollectionOrdenitemToAttach.getOrdenitemPK());
                attachedOrdenitemCollection.add(ordenitemCollectionOrdenitemToAttach);
            }
            ordencompra.setOrdenitemCollection(attachedOrdenitemCollection);
            em.persist(ordencompra);
            if (clienteId != null) {
                clienteId.getOrdencompraCollection().add(ordencompra);
                clienteId = em.merge(clienteId);
            }
            if (empleadoId != null) {
                empleadoId.getOrdencompraCollection().add(ordencompra);
                empleadoId = em.merge(empleadoId);
            }
            for (Ordenitem ordenitemCollectionOrdenitem : ordencompra.getOrdenitemCollection()) {
                Ordencompra oldOrdencompraOfOrdenitemCollectionOrdenitem = ordenitemCollectionOrdenitem.getOrdencompra();
                ordenitemCollectionOrdenitem.setOrdencompra(ordencompra);
                ordenitemCollectionOrdenitem = em.merge(ordenitemCollectionOrdenitem);
                if (oldOrdencompraOfOrdenitemCollectionOrdenitem != null) {
                    oldOrdencompraOfOrdenitemCollectionOrdenitem.getOrdenitemCollection().remove(ordenitemCollectionOrdenitem);
                    oldOrdencompraOfOrdenitemCollectionOrdenitem = em.merge(oldOrdencompraOfOrdenitemCollectionOrdenitem);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ordencompra ordencompra) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordencompra persistentOrdencompra = em.find(Ordencompra.class, ordencompra.getNumeroorden());
            Cliente clienteIdOld = persistentOrdencompra.getClienteId();
            Cliente clienteIdNew = ordencompra.getClienteId();
            Empleado empleadoIdOld = persistentOrdencompra.getEmpleadoId();
            Empleado empleadoIdNew = ordencompra.getEmpleadoId();
            Collection<Ordenitem> ordenitemCollectionOld = persistentOrdencompra.getOrdenitemCollection();
            Collection<Ordenitem> ordenitemCollectionNew = ordencompra.getOrdenitemCollection();
            List<String> illegalOrphanMessages = null;
            for (Ordenitem ordenitemCollectionOldOrdenitem : ordenitemCollectionOld) {
                if (!ordenitemCollectionNew.contains(ordenitemCollectionOldOrdenitem)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ordenitem " + ordenitemCollectionOldOrdenitem + " since its ordencompra field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (clienteIdNew != null) {
                clienteIdNew = em.getReference(clienteIdNew.getClass(), clienteIdNew.getId());
                ordencompra.setClienteId(clienteIdNew);
            }
            if (empleadoIdNew != null) {
                empleadoIdNew = em.getReference(empleadoIdNew.getClass(), empleadoIdNew.getId());
                ordencompra.setEmpleadoId(empleadoIdNew);
            }
            Collection<Ordenitem> attachedOrdenitemCollectionNew = new ArrayList<Ordenitem>();
            for (Ordenitem ordenitemCollectionNewOrdenitemToAttach : ordenitemCollectionNew) {
                ordenitemCollectionNewOrdenitemToAttach = em.getReference(ordenitemCollectionNewOrdenitemToAttach.getClass(), ordenitemCollectionNewOrdenitemToAttach.getOrdenitemPK());
                attachedOrdenitemCollectionNew.add(ordenitemCollectionNewOrdenitemToAttach);
            }
            ordenitemCollectionNew = attachedOrdenitemCollectionNew;
            ordencompra.setOrdenitemCollection(ordenitemCollectionNew);
            ordencompra = em.merge(ordencompra);
            if (clienteIdOld != null && !clienteIdOld.equals(clienteIdNew)) {
                clienteIdOld.getOrdencompraCollection().remove(ordencompra);
                clienteIdOld = em.merge(clienteIdOld);
            }
            if (clienteIdNew != null && !clienteIdNew.equals(clienteIdOld)) {
                clienteIdNew.getOrdencompraCollection().add(ordencompra);
                clienteIdNew = em.merge(clienteIdNew);
            }
            if (empleadoIdOld != null && !empleadoIdOld.equals(empleadoIdNew)) {
                empleadoIdOld.getOrdencompraCollection().remove(ordencompra);
                empleadoIdOld = em.merge(empleadoIdOld);
            }
            if (empleadoIdNew != null && !empleadoIdNew.equals(empleadoIdOld)) {
                empleadoIdNew.getOrdencompraCollection().add(ordencompra);
                empleadoIdNew = em.merge(empleadoIdNew);
            }
            for (Ordenitem ordenitemCollectionNewOrdenitem : ordenitemCollectionNew) {
                if (!ordenitemCollectionOld.contains(ordenitemCollectionNewOrdenitem)) {
                    Ordencompra oldOrdencompraOfOrdenitemCollectionNewOrdenitem = ordenitemCollectionNewOrdenitem.getOrdencompra();
                    ordenitemCollectionNewOrdenitem.setOrdencompra(ordencompra);
                    ordenitemCollectionNewOrdenitem = em.merge(ordenitemCollectionNewOrdenitem);
                    if (oldOrdencompraOfOrdenitemCollectionNewOrdenitem != null && !oldOrdencompraOfOrdenitemCollectionNewOrdenitem.equals(ordencompra)) {
                        oldOrdencompraOfOrdenitemCollectionNewOrdenitem.getOrdenitemCollection().remove(ordenitemCollectionNewOrdenitem);
                        oldOrdencompraOfOrdenitemCollectionNewOrdenitem = em.merge(oldOrdencompraOfOrdenitemCollectionNewOrdenitem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ordencompra.getNumeroorden();
                if (findOrdencompra(id) == null) {
                    throw new NonexistentEntityException("The ordencompra with id " + id + " no longer exists.");
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
            Ordencompra ordencompra;
            try {
                ordencompra = em.getReference(Ordencompra.class, id);
                ordencompra.getNumeroorden();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordencompra with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Ordenitem> ordenitemCollectionOrphanCheck = ordencompra.getOrdenitemCollection();
            for (Ordenitem ordenitemCollectionOrphanCheckOrdenitem : ordenitemCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ordencompra (" + ordencompra + ") cannot be destroyed since the Ordenitem " + ordenitemCollectionOrphanCheckOrdenitem + " in its ordenitemCollection field has a non-nullable ordencompra field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cliente clienteId = ordencompra.getClienteId();
            if (clienteId != null) {
                clienteId.getOrdencompraCollection().remove(ordencompra);
                clienteId = em.merge(clienteId);
            }
            Empleado empleadoId = ordencompra.getEmpleadoId();
            if (empleadoId != null) {
                empleadoId.getOrdencompraCollection().remove(ordencompra);
                empleadoId = em.merge(empleadoId);
            }
            em.remove(ordencompra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ordencompra> findOrdencompraEntities() {
        return findOrdencompraEntities(true, -1, -1);
    }

    public List<Ordencompra> findOrdencompraEntities(int maxResults, int firstResult) {
        return findOrdencompraEntities(false, maxResults, firstResult);
    }

    private List<Ordencompra> findOrdencompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ordencompra.class));
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

    public Ordencompra findOrdencompra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ordencompra.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdencompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ordencompra> rt = cq.from(Ordencompra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Ordencompra> buscarOrdenCompraEmpleadoId (int empleadoId) {
        List<Ordencompra> ordenesCompra = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Ordencompra> q = em.createNamedQuery("Ordencompra.findByEmpleadoId", Ordencompra.class);
            q.setParameter("empleadoId", empleadoId);
            ordenesCompra = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error OrdencompraJpaController.buscarOrdenCompraEmpleadoId() "+e.getMessage());
        } finally {
            em.close();
        }
        return ordenesCompra;
    }
    
    public List<Ordencompra> buscarOrdencompraNombreE (String nombre) {
        List<Ordencompra> Ordencompras = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Ordencompra> q = em.createNamedQuery("Ordencompra.findByNombreELike", Ordencompra.class);
            q.setParameter("nombreE", nombre);
            Ordencompras = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error OrdencompraJpaController.buscarOrdencompraNombreE() "+e.getMessage());
        } finally {
            em.close();
        }
        return Ordencompras;
    }
    
    public List<Ordencompra> buscarOrdencompraNombreC (String nombre) {
        List<Ordencompra> Ordencompras = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Ordencompra> q = em.createNamedQuery("Ordencompra.findByNombreCLike", Ordencompra.class);
            q.setParameter("nombreC", nombre);
            Ordencompras = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error OrdencompraJpaController.buscarOrdencompraNombreA() "+e.getMessage() );
        } finally {
            em.close();
        }
        return Ordencompras;
    }
    public List<Ordencompra> buscarRangoFecha (Date fechaInicial, Date fechaFinal) {
        List<Ordencompra> Ordencompras = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Ordencompra> q = em.createNamedQuery("Ordencompra.findByRangoFechas", Ordencompra.class);
            q.setParameter("fechaordenI", fechaInicial,TemporalType.DATE);
            q.setParameter("fechaordenF", fechaFinal,TemporalType.DATE);
            Ordencompras = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Erro EmpleadoJpaController.buscarRangoFecha() "+e.getMessage());
        } finally {
            em.close();
        }
        return Ordencompras;
    }
    
}
