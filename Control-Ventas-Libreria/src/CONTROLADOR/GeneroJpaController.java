/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import CONTROLADOR.exceptions.NonexistentEntityException;
import MODELO.Genero;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import MODELO.Libro;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ayenni42
 */
public class GeneroJpaController implements Serializable {

    public GeneroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Genero genero) {
        if (genero.getLibroCollection() == null) {
            genero.setLibroCollection(new ArrayList<Libro>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Libro> attachedLibroCollection = new ArrayList<Libro>();
            for (Libro libroCollectionLibroToAttach : genero.getLibroCollection()) {
                libroCollectionLibroToAttach = em.getReference(libroCollectionLibroToAttach.getClass(), libroCollectionLibroToAttach.getIsbn());
                attachedLibroCollection.add(libroCollectionLibroToAttach);
            }
            genero.setLibroCollection(attachedLibroCollection);
            em.persist(genero);
            for (Libro libroCollectionLibro : genero.getLibroCollection()) {
                libroCollectionLibro.getGeneroCollection().add(genero);
                libroCollectionLibro = em.merge(libroCollectionLibro);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Genero genero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Genero persistentGenero = em.find(Genero.class, genero.getId());
            Collection<Libro> libroCollectionOld = persistentGenero.getLibroCollection();
            Collection<Libro> libroCollectionNew = genero.getLibroCollection();
            Collection<Libro> attachedLibroCollectionNew = new ArrayList<Libro>();
            for (Libro libroCollectionNewLibroToAttach : libroCollectionNew) {
                libroCollectionNewLibroToAttach = em.getReference(libroCollectionNewLibroToAttach.getClass(), libroCollectionNewLibroToAttach.getIsbn());
                attachedLibroCollectionNew.add(libroCollectionNewLibroToAttach);
            }
            libroCollectionNew = attachedLibroCollectionNew;
            genero.setLibroCollection(libroCollectionNew);
            genero = em.merge(genero);
            for (Libro libroCollectionOldLibro : libroCollectionOld) {
                if (!libroCollectionNew.contains(libroCollectionOldLibro)) {
                    libroCollectionOldLibro.getGeneroCollection().remove(genero);
                    libroCollectionOldLibro = em.merge(libroCollectionOldLibro);
                }
            }
            for (Libro libroCollectionNewLibro : libroCollectionNew) {
                if (!libroCollectionOld.contains(libroCollectionNewLibro)) {
                    libroCollectionNewLibro.getGeneroCollection().add(genero);
                    libroCollectionNewLibro = em.merge(libroCollectionNewLibro);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = genero.getId();
                if (findGenero(id) == null) {
                    throw new NonexistentEntityException("The genero with id " + id + " no longer exists.");
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
            Genero genero;
            try {
                genero = em.getReference(Genero.class, id);
                genero.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The genero with id " + id + " no longer exists.", enfe);
            }
            Collection<Libro> libroCollection = genero.getLibroCollection();
            for (Libro libroCollectionLibro : libroCollection) {
                libroCollectionLibro.getGeneroCollection().remove(genero);
                libroCollectionLibro = em.merge(libroCollectionLibro);
            }
            em.remove(genero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Genero> findGeneroEntities() {
        return findGeneroEntities(true, -1, -1);
    }

    public List<Genero> findGeneroEntities(int maxResults, int firstResult) {
        return findGeneroEntities(false, maxResults, firstResult);
    }

    private List<Genero> findGeneroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Genero.class));
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

    public Genero findGenero(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Genero.class, id);
        } finally {
            em.close();
        }
    }

    public int getGeneroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Genero> rt = cq.from(Genero.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
