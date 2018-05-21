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
import MODELO.Libro;
import MODELO.Ordenitemprestamo;
import MODELO.OrdenitemprestamoPK;
import MODELO.Ordenprestamo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author ayenni42
 */
public class OrdenitemprestamoJpaController implements Serializable {

    public OrdenitemprestamoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ordenitemprestamo ordenitemprestamo) throws PreexistingEntityException, Exception {
        if (ordenitemprestamo.getOrdenitemprestamoPK() == null) {
            ordenitemprestamo.setOrdenitemprestamoPK(new OrdenitemprestamoPK());
        }
        ordenitemprestamo.getOrdenitemprestamoPK().setOrdenprestamoNumeroorden(ordenitemprestamo.getOrdenprestamo().getNumeroorden());
        ordenitemprestamo.getOrdenitemprestamoPK().setLibroIsbn(ordenitemprestamo.getLibro().getIsbn());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro libro = ordenitemprestamo.getLibro();
            if (libro != null) {
                libro = em.getReference(libro.getClass(), libro.getIsbn());
                ordenitemprestamo.setLibro(libro);
            }
            Ordenprestamo ordenprestamo = ordenitemprestamo.getOrdenprestamo();
            if (ordenprestamo != null) {
                ordenprestamo = em.getReference(ordenprestamo.getClass(), ordenprestamo.getNumeroorden());
                ordenitemprestamo.setOrdenprestamo(ordenprestamo);
            }
            em.persist(ordenitemprestamo);
            if (libro != null) {
                libro.getOrdenitemprestamoCollection().add(ordenitemprestamo);
                libro = em.merge(libro);
            }
            if (ordenprestamo != null) {
                ordenprestamo.getOrdenitemprestamoCollection().add(ordenitemprestamo);
                ordenprestamo = em.merge(ordenprestamo);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrdenitemprestamo(ordenitemprestamo.getOrdenitemprestamoPK()) != null) {
                throw new PreexistingEntityException("Ordenitemprestamo " + ordenitemprestamo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ordenitemprestamo ordenitemprestamo) throws NonexistentEntityException, Exception {
        ordenitemprestamo.getOrdenitemprestamoPK().setOrdenprestamoNumeroorden(ordenitemprestamo.getOrdenprestamo().getNumeroorden());
        ordenitemprestamo.getOrdenitemprestamoPK().setLibroIsbn(ordenitemprestamo.getLibro().getIsbn());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordenitemprestamo persistentOrdenitemprestamo = em.find(Ordenitemprestamo.class, ordenitemprestamo.getOrdenitemprestamoPK());
            Libro libroOld = persistentOrdenitemprestamo.getLibro();
            Libro libroNew = ordenitemprestamo.getLibro();
            Ordenprestamo ordenprestamoOld = persistentOrdenitemprestamo.getOrdenprestamo();
            Ordenprestamo ordenprestamoNew = ordenitemprestamo.getOrdenprestamo();
            if (libroNew != null) {
                libroNew = em.getReference(libroNew.getClass(), libroNew.getIsbn());
                ordenitemprestamo.setLibro(libroNew);
            }
            if (ordenprestamoNew != null) {
                ordenprestamoNew = em.getReference(ordenprestamoNew.getClass(), ordenprestamoNew.getNumeroorden());
                ordenitemprestamo.setOrdenprestamo(ordenprestamoNew);
            }
            ordenitemprestamo = em.merge(ordenitemprestamo);
            if (libroOld != null && !libroOld.equals(libroNew)) {
                libroOld.getOrdenitemprestamoCollection().remove(ordenitemprestamo);
                libroOld = em.merge(libroOld);
            }
            if (libroNew != null && !libroNew.equals(libroOld)) {
                libroNew.getOrdenitemprestamoCollection().add(ordenitemprestamo);
                libroNew = em.merge(libroNew);
            }
            if (ordenprestamoOld != null && !ordenprestamoOld.equals(ordenprestamoNew)) {
                ordenprestamoOld.getOrdenitemprestamoCollection().remove(ordenitemprestamo);
                ordenprestamoOld = em.merge(ordenprestamoOld);
            }
            if (ordenprestamoNew != null && !ordenprestamoNew.equals(ordenprestamoOld)) {
                ordenprestamoNew.getOrdenitemprestamoCollection().add(ordenitemprestamo);
                ordenprestamoNew = em.merge(ordenprestamoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                OrdenitemprestamoPK id = ordenitemprestamo.getOrdenitemprestamoPK();
                if (findOrdenitemprestamo(id) == null) {
                    throw new NonexistentEntityException("The ordenitemprestamo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(OrdenitemprestamoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordenitemprestamo ordenitemprestamo;
            try {
                ordenitemprestamo = em.getReference(Ordenitemprestamo.class, id);
                ordenitemprestamo.getOrdenitemprestamoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordenitemprestamo with id " + id + " no longer exists.", enfe);
            }
            Libro libro = ordenitemprestamo.getLibro();
            if (libro != null) {
                libro.getOrdenitemprestamoCollection().remove(ordenitemprestamo);
                libro = em.merge(libro);
            }
            Ordenprestamo ordenprestamo = ordenitemprestamo.getOrdenprestamo();
            if (ordenprestamo != null) {
                ordenprestamo.getOrdenitemprestamoCollection().remove(ordenitemprestamo);
                ordenprestamo = em.merge(ordenprestamo);
            }
            em.remove(ordenitemprestamo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ordenitemprestamo> findOrdenitemprestamoEntities() {
        return findOrdenitemprestamoEntities(true, -1, -1);
    }

    public List<Ordenitemprestamo> findOrdenitemprestamoEntities(int maxResults, int firstResult) {
        return findOrdenitemprestamoEntities(false, maxResults, firstResult);
    }

    private List<Ordenitemprestamo> findOrdenitemprestamoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ordenitemprestamo.class));
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

    public Ordenitemprestamo findOrdenitemprestamo(OrdenitemprestamoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ordenitemprestamo.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdenitemprestamoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ordenitemprestamo> rt = cq.from(Ordenitemprestamo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    //Busquedas Propias
    public List<Ordenitemprestamo> buscarOrdenItemNumeroOrden(int numeroOrden){
        List<Ordenitemprestamo> ordenItem = null;
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            TypedQuery<Ordenitemprestamo>  q = em.createNamedQuery("Ordenitemprestamo.findByOrdenprestamoNumeroorden", Ordenitemprestamo.class);
            q.setParameter("ordenprestamoNumeroorden", numeroOrden);
            ordenItem = q.getResultList();
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            System.out.println("ERROR ordenitemprestamoJpaController.buscarOrdenItemNumeroOrden: "+e.getMessage());
        }finally{
            em.close();
        }
        return ordenItem;
    }
}
