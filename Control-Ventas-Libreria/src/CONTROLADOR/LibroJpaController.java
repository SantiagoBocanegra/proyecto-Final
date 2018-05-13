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
import MODELO.Genero;
import MODELO.Libro;
import java.util.ArrayList;
import java.util.Collection;
import MODELO.Ordenitem;
import MODELO.Ordenitemprestamo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ayenni42
 */
public class LibroJpaController implements Serializable {

    public LibroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Libro libro) {
        if (libro.getGeneroCollection() == null) {
            libro.setGeneroCollection(new ArrayList<Genero>());
        }
        if (libro.getOrdenitemCollection() == null) {
            libro.setOrdenitemCollection(new ArrayList<Ordenitem>());
        }
        if (libro.getOrdenitemprestamoCollection() == null) {
            libro.setOrdenitemprestamoCollection(new ArrayList<Ordenitemprestamo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Genero> attachedGeneroCollection = new ArrayList<Genero>();
            for (Genero generoCollectionGeneroToAttach : libro.getGeneroCollection()) {
                generoCollectionGeneroToAttach = em.getReference(generoCollectionGeneroToAttach.getClass(), generoCollectionGeneroToAttach.getId());
                attachedGeneroCollection.add(generoCollectionGeneroToAttach);
            }
            libro.setGeneroCollection(attachedGeneroCollection);
            Collection<Ordenitem> attachedOrdenitemCollection = new ArrayList<Ordenitem>();
            for (Ordenitem ordenitemCollectionOrdenitemToAttach : libro.getOrdenitemCollection()) {
                ordenitemCollectionOrdenitemToAttach = em.getReference(ordenitemCollectionOrdenitemToAttach.getClass(), ordenitemCollectionOrdenitemToAttach.getOrdenitemPK());
                attachedOrdenitemCollection.add(ordenitemCollectionOrdenitemToAttach);
            }
            libro.setOrdenitemCollection(attachedOrdenitemCollection);
            Collection<Ordenitemprestamo> attachedOrdenitemprestamoCollection = new ArrayList<Ordenitemprestamo>();
            for (Ordenitemprestamo ordenitemprestamoCollectionOrdenitemprestamoToAttach : libro.getOrdenitemprestamoCollection()) {
                ordenitemprestamoCollectionOrdenitemprestamoToAttach = em.getReference(ordenitemprestamoCollectionOrdenitemprestamoToAttach.getClass(), ordenitemprestamoCollectionOrdenitemprestamoToAttach.getOrdenitemprestamoPK());
                attachedOrdenitemprestamoCollection.add(ordenitemprestamoCollectionOrdenitemprestamoToAttach);
            }
            libro.setOrdenitemprestamoCollection(attachedOrdenitemprestamoCollection);
            em.persist(libro);
            for (Genero generoCollectionGenero : libro.getGeneroCollection()) {
                generoCollectionGenero.getLibroCollection().add(libro);
                generoCollectionGenero = em.merge(generoCollectionGenero);
            }
            for (Ordenitem ordenitemCollectionOrdenitem : libro.getOrdenitemCollection()) {
                Libro oldLibroOfOrdenitemCollectionOrdenitem = ordenitemCollectionOrdenitem.getLibro();
                ordenitemCollectionOrdenitem.setLibro(libro);
                ordenitemCollectionOrdenitem = em.merge(ordenitemCollectionOrdenitem);
                if (oldLibroOfOrdenitemCollectionOrdenitem != null) {
                    oldLibroOfOrdenitemCollectionOrdenitem.getOrdenitemCollection().remove(ordenitemCollectionOrdenitem);
                    oldLibroOfOrdenitemCollectionOrdenitem = em.merge(oldLibroOfOrdenitemCollectionOrdenitem);
                }
            }
            for (Ordenitemprestamo ordenitemprestamoCollectionOrdenitemprestamo : libro.getOrdenitemprestamoCollection()) {
                Libro oldLibroOfOrdenitemprestamoCollectionOrdenitemprestamo = ordenitemprestamoCollectionOrdenitemprestamo.getLibro();
                ordenitemprestamoCollectionOrdenitemprestamo.setLibro(libro);
                ordenitemprestamoCollectionOrdenitemprestamo = em.merge(ordenitemprestamoCollectionOrdenitemprestamo);
                if (oldLibroOfOrdenitemprestamoCollectionOrdenitemprestamo != null) {
                    oldLibroOfOrdenitemprestamoCollectionOrdenitemprestamo.getOrdenitemprestamoCollection().remove(ordenitemprestamoCollectionOrdenitemprestamo);
                    oldLibroOfOrdenitemprestamoCollectionOrdenitemprestamo = em.merge(oldLibroOfOrdenitemprestamoCollectionOrdenitemprestamo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Libro libro) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro persistentLibro = em.find(Libro.class, libro.getIsbn());
            Collection<Genero> generoCollectionOld = persistentLibro.getGeneroCollection();
            Collection<Genero> generoCollectionNew = libro.getGeneroCollection();
            Collection<Ordenitem> ordenitemCollectionOld = persistentLibro.getOrdenitemCollection();
            Collection<Ordenitem> ordenitemCollectionNew = libro.getOrdenitemCollection();
            Collection<Ordenitemprestamo> ordenitemprestamoCollectionOld = persistentLibro.getOrdenitemprestamoCollection();
            Collection<Ordenitemprestamo> ordenitemprestamoCollectionNew = libro.getOrdenitemprestamoCollection();
            List<String> illegalOrphanMessages = null;
            for (Ordenitem ordenitemCollectionOldOrdenitem : ordenitemCollectionOld) {
                if (!ordenitemCollectionNew.contains(ordenitemCollectionOldOrdenitem)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ordenitem " + ordenitemCollectionOldOrdenitem + " since its libro field is not nullable.");
                }
            }
            for (Ordenitemprestamo ordenitemprestamoCollectionOldOrdenitemprestamo : ordenitemprestamoCollectionOld) {
                if (!ordenitemprestamoCollectionNew.contains(ordenitemprestamoCollectionOldOrdenitemprestamo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ordenitemprestamo " + ordenitemprestamoCollectionOldOrdenitemprestamo + " since its libro field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Genero> attachedGeneroCollectionNew = new ArrayList<Genero>();
            for (Genero generoCollectionNewGeneroToAttach : generoCollectionNew) {
                generoCollectionNewGeneroToAttach = em.getReference(generoCollectionNewGeneroToAttach.getClass(), generoCollectionNewGeneroToAttach.getId());
                attachedGeneroCollectionNew.add(generoCollectionNewGeneroToAttach);
            }
            generoCollectionNew = attachedGeneroCollectionNew;
            libro.setGeneroCollection(generoCollectionNew);
            Collection<Ordenitem> attachedOrdenitemCollectionNew = new ArrayList<Ordenitem>();
            for (Ordenitem ordenitemCollectionNewOrdenitemToAttach : ordenitemCollectionNew) {
                ordenitemCollectionNewOrdenitemToAttach = em.getReference(ordenitemCollectionNewOrdenitemToAttach.getClass(), ordenitemCollectionNewOrdenitemToAttach.getOrdenitemPK());
                attachedOrdenitemCollectionNew.add(ordenitemCollectionNewOrdenitemToAttach);
            }
            ordenitemCollectionNew = attachedOrdenitemCollectionNew;
            libro.setOrdenitemCollection(ordenitemCollectionNew);
            Collection<Ordenitemprestamo> attachedOrdenitemprestamoCollectionNew = new ArrayList<Ordenitemprestamo>();
            for (Ordenitemprestamo ordenitemprestamoCollectionNewOrdenitemprestamoToAttach : ordenitemprestamoCollectionNew) {
                ordenitemprestamoCollectionNewOrdenitemprestamoToAttach = em.getReference(ordenitemprestamoCollectionNewOrdenitemprestamoToAttach.getClass(), ordenitemprestamoCollectionNewOrdenitemprestamoToAttach.getOrdenitemprestamoPK());
                attachedOrdenitemprestamoCollectionNew.add(ordenitemprestamoCollectionNewOrdenitemprestamoToAttach);
            }
            ordenitemprestamoCollectionNew = attachedOrdenitemprestamoCollectionNew;
            libro.setOrdenitemprestamoCollection(ordenitemprestamoCollectionNew);
            libro = em.merge(libro);
            for (Genero generoCollectionOldGenero : generoCollectionOld) {
                if (!generoCollectionNew.contains(generoCollectionOldGenero)) {
                    generoCollectionOldGenero.getLibroCollection().remove(libro);
                    generoCollectionOldGenero = em.merge(generoCollectionOldGenero);
                }
            }
            for (Genero generoCollectionNewGenero : generoCollectionNew) {
                if (!generoCollectionOld.contains(generoCollectionNewGenero)) {
                    generoCollectionNewGenero.getLibroCollection().add(libro);
                    generoCollectionNewGenero = em.merge(generoCollectionNewGenero);
                }
            }
            for (Ordenitem ordenitemCollectionNewOrdenitem : ordenitemCollectionNew) {
                if (!ordenitemCollectionOld.contains(ordenitemCollectionNewOrdenitem)) {
                    Libro oldLibroOfOrdenitemCollectionNewOrdenitem = ordenitemCollectionNewOrdenitem.getLibro();
                    ordenitemCollectionNewOrdenitem.setLibro(libro);
                    ordenitemCollectionNewOrdenitem = em.merge(ordenitemCollectionNewOrdenitem);
                    if (oldLibroOfOrdenitemCollectionNewOrdenitem != null && !oldLibroOfOrdenitemCollectionNewOrdenitem.equals(libro)) {
                        oldLibroOfOrdenitemCollectionNewOrdenitem.getOrdenitemCollection().remove(ordenitemCollectionNewOrdenitem);
                        oldLibroOfOrdenitemCollectionNewOrdenitem = em.merge(oldLibroOfOrdenitemCollectionNewOrdenitem);
                    }
                }
            }
            for (Ordenitemprestamo ordenitemprestamoCollectionNewOrdenitemprestamo : ordenitemprestamoCollectionNew) {
                if (!ordenitemprestamoCollectionOld.contains(ordenitemprestamoCollectionNewOrdenitemprestamo)) {
                    Libro oldLibroOfOrdenitemprestamoCollectionNewOrdenitemprestamo = ordenitemprestamoCollectionNewOrdenitemprestamo.getLibro();
                    ordenitemprestamoCollectionNewOrdenitemprestamo.setLibro(libro);
                    ordenitemprestamoCollectionNewOrdenitemprestamo = em.merge(ordenitemprestamoCollectionNewOrdenitemprestamo);
                    if (oldLibroOfOrdenitemprestamoCollectionNewOrdenitemprestamo != null && !oldLibroOfOrdenitemprestamoCollectionNewOrdenitemprestamo.equals(libro)) {
                        oldLibroOfOrdenitemprestamoCollectionNewOrdenitemprestamo.getOrdenitemprestamoCollection().remove(ordenitemprestamoCollectionNewOrdenitemprestamo);
                        oldLibroOfOrdenitemprestamoCollectionNewOrdenitemprestamo = em.merge(oldLibroOfOrdenitemprestamoCollectionNewOrdenitemprestamo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = libro.getIsbn();
                if (findLibro(id) == null) {
                    throw new NonexistentEntityException("The libro with id " + id + " no longer exists.");
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
            Libro libro;
            try {
                libro = em.getReference(Libro.class, id);
                libro.getIsbn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The libro with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Ordenitem> ordenitemCollectionOrphanCheck = libro.getOrdenitemCollection();
            for (Ordenitem ordenitemCollectionOrphanCheckOrdenitem : ordenitemCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Libro (" + libro + ") cannot be destroyed since the Ordenitem " + ordenitemCollectionOrphanCheckOrdenitem + " in its ordenitemCollection field has a non-nullable libro field.");
            }
            Collection<Ordenitemprestamo> ordenitemprestamoCollectionOrphanCheck = libro.getOrdenitemprestamoCollection();
            for (Ordenitemprestamo ordenitemprestamoCollectionOrphanCheckOrdenitemprestamo : ordenitemprestamoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Libro (" + libro + ") cannot be destroyed since the Ordenitemprestamo " + ordenitemprestamoCollectionOrphanCheckOrdenitemprestamo + " in its ordenitemprestamoCollection field has a non-nullable libro field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Genero> generoCollection = libro.getGeneroCollection();
            for (Genero generoCollectionGenero : generoCollection) {
                generoCollectionGenero.getLibroCollection().remove(libro);
                generoCollectionGenero = em.merge(generoCollectionGenero);
            }
            em.remove(libro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Libro> findLibroEntities() {
        return findLibroEntities(true, -1, -1);
    }

    public List<Libro> findLibroEntities(int maxResults, int firstResult) {
        return findLibroEntities(false, maxResults, firstResult);
    }

    private List<Libro> findLibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Libro.class));
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

    public Libro findLibro(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libro.class, id);
        } finally {
            em.close();
        }
    }

    public int getLibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Libro> rt = cq.from(Libro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
