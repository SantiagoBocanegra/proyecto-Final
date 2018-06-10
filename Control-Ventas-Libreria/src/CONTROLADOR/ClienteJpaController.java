/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import CONTROLADOR.exceptions.IllegalOrphanException;
import CONTROLADOR.exceptions.NonexistentEntityException;
import MODELO.Cliente;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import MODELO.Ordencompra;
import java.util.ArrayList;
import java.util.Collection;
import MODELO.Ordenprestamo;
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
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        if (cliente.getOrdencompraCollection() == null) {
            cliente.setOrdencompraCollection(new ArrayList<Ordencompra>());
        }
        if (cliente.getOrdenprestamoCollection() == null) {
            cliente.setOrdenprestamoCollection(new ArrayList<Ordenprestamo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Ordencompra> attachedOrdencompraCollection = new ArrayList<Ordencompra>();
            for (Ordencompra ordencompraCollectionOrdencompraToAttach : cliente.getOrdencompraCollection()) {
                ordencompraCollectionOrdencompraToAttach = em.getReference(ordencompraCollectionOrdencompraToAttach.getClass(), ordencompraCollectionOrdencompraToAttach.getNumeroorden());
                attachedOrdencompraCollection.add(ordencompraCollectionOrdencompraToAttach);
            }
            cliente.setOrdencompraCollection(attachedOrdencompraCollection);
            Collection<Ordenprestamo> attachedOrdenprestamoCollection = new ArrayList<Ordenprestamo>();
            for (Ordenprestamo ordenprestamoCollectionOrdenprestamoToAttach : cliente.getOrdenprestamoCollection()) {
                ordenprestamoCollectionOrdenprestamoToAttach = em.getReference(ordenprestamoCollectionOrdenprestamoToAttach.getClass(), ordenprestamoCollectionOrdenprestamoToAttach.getNumeroorden());
                attachedOrdenprestamoCollection.add(ordenprestamoCollectionOrdenprestamoToAttach);
            }
            cliente.setOrdenprestamoCollection(attachedOrdenprestamoCollection);
            em.persist(cliente);
            for (Ordencompra ordencompraCollectionOrdencompra : cliente.getOrdencompraCollection()) {
                Cliente oldClienteIdOfOrdencompraCollectionOrdencompra = ordencompraCollectionOrdencompra.getClienteId();
                ordencompraCollectionOrdencompra.setClienteId(cliente);
                ordencompraCollectionOrdencompra = em.merge(ordencompraCollectionOrdencompra);
                if (oldClienteIdOfOrdencompraCollectionOrdencompra != null) {
                    oldClienteIdOfOrdencompraCollectionOrdencompra.getOrdencompraCollection().remove(ordencompraCollectionOrdencompra);
                    oldClienteIdOfOrdencompraCollectionOrdencompra = em.merge(oldClienteIdOfOrdencompraCollectionOrdencompra);
                }
            }
            for (Ordenprestamo ordenprestamoCollectionOrdenprestamo : cliente.getOrdenprestamoCollection()) {
                Cliente oldClienteIdOfOrdenprestamoCollectionOrdenprestamo = ordenprestamoCollectionOrdenprestamo.getClienteId();
                ordenprestamoCollectionOrdenprestamo.setClienteId(cliente);
                ordenprestamoCollectionOrdenprestamo = em.merge(ordenprestamoCollectionOrdenprestamo);
                if (oldClienteIdOfOrdenprestamoCollectionOrdenprestamo != null) {
                    oldClienteIdOfOrdenprestamoCollectionOrdenprestamo.getOrdenprestamoCollection().remove(ordenprestamoCollectionOrdenprestamo);
                    oldClienteIdOfOrdenprestamoCollectionOrdenprestamo = em.merge(oldClienteIdOfOrdenprestamoCollectionOrdenprestamo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getId());
            Collection<Ordencompra> ordencompraCollectionOld = persistentCliente.getOrdencompraCollection();
            Collection<Ordencompra> ordencompraCollectionNew = cliente.getOrdencompraCollection();
            Collection<Ordenprestamo> ordenprestamoCollectionOld = persistentCliente.getOrdenprestamoCollection();
            Collection<Ordenprestamo> ordenprestamoCollectionNew = cliente.getOrdenprestamoCollection();
            List<String> illegalOrphanMessages = null;
            for (Ordencompra ordencompraCollectionOldOrdencompra : ordencompraCollectionOld) {
                if (!ordencompraCollectionNew.contains(ordencompraCollectionOldOrdencompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ordencompra " + ordencompraCollectionOldOrdencompra + " since its clienteId field is not nullable.");
                }
            }
            for (Ordenprestamo ordenprestamoCollectionOldOrdenprestamo : ordenprestamoCollectionOld) {
                if (!ordenprestamoCollectionNew.contains(ordenprestamoCollectionOldOrdenprestamo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ordenprestamo " + ordenprestamoCollectionOldOrdenprestamo + " since its clienteId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Ordencompra> attachedOrdencompraCollectionNew = new ArrayList<Ordencompra>();
            for (Ordencompra ordencompraCollectionNewOrdencompraToAttach : ordencompraCollectionNew) {
                ordencompraCollectionNewOrdencompraToAttach = em.getReference(ordencompraCollectionNewOrdencompraToAttach.getClass(), ordencompraCollectionNewOrdencompraToAttach.getNumeroorden());
                attachedOrdencompraCollectionNew.add(ordencompraCollectionNewOrdencompraToAttach);
            }
            ordencompraCollectionNew = attachedOrdencompraCollectionNew;
            cliente.setOrdencompraCollection(ordencompraCollectionNew);
            Collection<Ordenprestamo> attachedOrdenprestamoCollectionNew = new ArrayList<Ordenprestamo>();
            for (Ordenprestamo ordenprestamoCollectionNewOrdenprestamoToAttach : ordenprestamoCollectionNew) {
                ordenprestamoCollectionNewOrdenprestamoToAttach = em.getReference(ordenprestamoCollectionNewOrdenprestamoToAttach.getClass(), ordenprestamoCollectionNewOrdenprestamoToAttach.getNumeroorden());
                attachedOrdenprestamoCollectionNew.add(ordenprestamoCollectionNewOrdenprestamoToAttach);
            }
            ordenprestamoCollectionNew = attachedOrdenprestamoCollectionNew;
            cliente.setOrdenprestamoCollection(ordenprestamoCollectionNew);
            cliente = em.merge(cliente);
            for (Ordencompra ordencompraCollectionNewOrdencompra : ordencompraCollectionNew) {
                if (!ordencompraCollectionOld.contains(ordencompraCollectionNewOrdencompra)) {
                    Cliente oldClienteIdOfOrdencompraCollectionNewOrdencompra = ordencompraCollectionNewOrdencompra.getClienteId();
                    ordencompraCollectionNewOrdencompra.setClienteId(cliente);
                    ordencompraCollectionNewOrdencompra = em.merge(ordencompraCollectionNewOrdencompra);
                    if (oldClienteIdOfOrdencompraCollectionNewOrdencompra != null && !oldClienteIdOfOrdencompraCollectionNewOrdencompra.equals(cliente)) {
                        oldClienteIdOfOrdencompraCollectionNewOrdencompra.getOrdencompraCollection().remove(ordencompraCollectionNewOrdencompra);
                        oldClienteIdOfOrdencompraCollectionNewOrdencompra = em.merge(oldClienteIdOfOrdencompraCollectionNewOrdencompra);
                    }
                }
            }
            for (Ordenprestamo ordenprestamoCollectionNewOrdenprestamo : ordenprestamoCollectionNew) {
                if (!ordenprestamoCollectionOld.contains(ordenprestamoCollectionNewOrdenprestamo)) {
                    Cliente oldClienteIdOfOrdenprestamoCollectionNewOrdenprestamo = ordenprestamoCollectionNewOrdenprestamo.getClienteId();
                    ordenprestamoCollectionNewOrdenprestamo.setClienteId(cliente);
                    ordenprestamoCollectionNewOrdenprestamo = em.merge(ordenprestamoCollectionNewOrdenprestamo);
                    if (oldClienteIdOfOrdenprestamoCollectionNewOrdenprestamo != null && !oldClienteIdOfOrdenprestamoCollectionNewOrdenprestamo.equals(cliente)) {
                        oldClienteIdOfOrdenprestamoCollectionNewOrdenprestamo.getOrdenprestamoCollection().remove(ordenprestamoCollectionNewOrdenprestamo);
                        oldClienteIdOfOrdenprestamoCollectionNewOrdenprestamo = em.merge(oldClienteIdOfOrdenprestamoCollectionNewOrdenprestamo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cliente.getId();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Ordencompra> ordencompraCollectionOrphanCheck = cliente.getOrdencompraCollection();
            for (Ordencompra ordencompraCollectionOrphanCheckOrdencompra : ordencompraCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Ordencompra " + ordencompraCollectionOrphanCheckOrdencompra + " in its ordencompraCollection field has a non-nullable clienteId field.");
            }
            Collection<Ordenprestamo> ordenprestamoCollectionOrphanCheck = cliente.getOrdenprestamoCollection();
            for (Ordenprestamo ordenprestamoCollectionOrphanCheckOrdenprestamo : ordenprestamoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Ordenprestamo " + ordenprestamoCollectionOrphanCheckOrdenprestamo + " in its ordenprestamoCollection field has a non-nullable clienteId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Cliente> buscarClienteNombre (String nombre) {
        List<Cliente> clientes = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Cliente> q = em.createNamedQuery("Cliente.findByNombreLike", Cliente.class);
            q.setParameter("nombre", nombre);
            clientes = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error ClienteJpaController.buscarClienteNombre() "+e.getMessage());
        } finally {
            em.close();
        }
        return clientes;
    }
    
    public List<Cliente> buscarClienteApellido (String apellido) {
        List<Cliente> clientes = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Cliente> q = em.createNamedQuery("Cliente.findByApellidoMaternoLike", Cliente.class);
            q.setParameter("apellidoMaterno", apellido);
            clientes = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error ClienteJpaController.buscarClienteApellido() "+e.getMessage() );
        } finally {
            em.close();
        }
        return clientes;
    }
    
    public List<Cliente> buscarClienteCedula (String cedula) {
        List<Cliente> clientes = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Cliente> q = em.createNamedQuery("Cliente.findByCedula", Cliente.class);
            q.setParameter("cedula", cedula);
            clientes = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
        } finally {
            em.close();
        }
        return clientes;
    }
    
    public List<Cliente> buscarRangoFecha (Date fechaInicial, Date fechaFinal) {
        List<Cliente> clientes = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Cliente> q = em.createNamedQuery("Cliente.findByRangoFechas", Cliente.class);
            q.setParameter("fechaRegistroInicial", fechaInicial,TemporalType.DATE);
            q.setParameter("fechaRegistroFinal", fechaFinal,TemporalType.DATE);
            clientes = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
        } finally {
            em.close();
        }
        return clientes;
    }
}
