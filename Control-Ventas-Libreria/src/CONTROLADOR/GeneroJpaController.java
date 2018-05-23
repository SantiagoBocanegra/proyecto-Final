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
import MODELO.GeneroLibro;
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
        if (genero.getGeneroLibroCollection() == null) {
            genero.setGeneroLibroCollection(new ArrayList<GeneroLibro>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<GeneroLibro> attachedGeneroLibroCollection = new ArrayList<GeneroLibro>();
            for (GeneroLibro generoLibroCollectionGeneroLibroToAttach : genero.getGeneroLibroCollection()) {
                generoLibroCollectionGeneroLibroToAttach = em.getReference(generoLibroCollectionGeneroLibroToAttach.getClass(), generoLibroCollectionGeneroLibroToAttach.getIdGenero());
                attachedGeneroLibroCollection.add(generoLibroCollectionGeneroLibroToAttach);
            }
            genero.setGeneroLibroCollection(attachedGeneroLibroCollection);
            em.persist(genero);
            for (GeneroLibro generoLibroCollectionGeneroLibro : genero.getGeneroLibroCollection()) {
                Genero oldIdOfGeneroLibroCollectionGeneroLibro = generoLibroCollectionGeneroLibro.getId();
                generoLibroCollectionGeneroLibro.setId(genero);
                generoLibroCollectionGeneroLibro = em.merge(generoLibroCollectionGeneroLibro);
                if (oldIdOfGeneroLibroCollectionGeneroLibro != null) {
                    oldIdOfGeneroLibroCollectionGeneroLibro.getGeneroLibroCollection().remove(generoLibroCollectionGeneroLibro);
                    oldIdOfGeneroLibroCollectionGeneroLibro = em.merge(oldIdOfGeneroLibroCollectionGeneroLibro);
                }
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
            Collection<GeneroLibro> generoLibroCollectionOld = persistentGenero.getGeneroLibroCollection();
            Collection<GeneroLibro> generoLibroCollectionNew = genero.getGeneroLibroCollection();
            Collection<GeneroLibro> attachedGeneroLibroCollectionNew = new ArrayList<GeneroLibro>();
            for (GeneroLibro generoLibroCollectionNewGeneroLibroToAttach : generoLibroCollectionNew) {
                generoLibroCollectionNewGeneroLibroToAttach = em.getReference(generoLibroCollectionNewGeneroLibroToAttach.getClass(), generoLibroCollectionNewGeneroLibroToAttach.getIdGenero());
                attachedGeneroLibroCollectionNew.add(generoLibroCollectionNewGeneroLibroToAttach);
            }
            generoLibroCollectionNew = attachedGeneroLibroCollectionNew;
            genero.setGeneroLibroCollection(generoLibroCollectionNew);
            genero = em.merge(genero);
            for (GeneroLibro generoLibroCollectionOldGeneroLibro : generoLibroCollectionOld) {
                if (!generoLibroCollectionNew.contains(generoLibroCollectionOldGeneroLibro)) {
                    generoLibroCollectionOldGeneroLibro.setId(null);
                    generoLibroCollectionOldGeneroLibro = em.merge(generoLibroCollectionOldGeneroLibro);
                }
            }
            for (GeneroLibro generoLibroCollectionNewGeneroLibro : generoLibroCollectionNew) {
                if (!generoLibroCollectionOld.contains(generoLibroCollectionNewGeneroLibro)) {
                    Genero oldIdOfGeneroLibroCollectionNewGeneroLibro = generoLibroCollectionNewGeneroLibro.getId();
                    generoLibroCollectionNewGeneroLibro.setId(genero);
                    generoLibroCollectionNewGeneroLibro = em.merge(generoLibroCollectionNewGeneroLibro);
                    if (oldIdOfGeneroLibroCollectionNewGeneroLibro != null && !oldIdOfGeneroLibroCollectionNewGeneroLibro.equals(genero)) {
                        oldIdOfGeneroLibroCollectionNewGeneroLibro.getGeneroLibroCollection().remove(generoLibroCollectionNewGeneroLibro);
                        oldIdOfGeneroLibroCollectionNewGeneroLibro = em.merge(oldIdOfGeneroLibroCollectionNewGeneroLibro);
                    }
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
            Collection<GeneroLibro> generoLibroCollection = genero.getGeneroLibroCollection();
            for (GeneroLibro generoLibroCollectionGeneroLibro : generoLibroCollection) {
                generoLibroCollectionGeneroLibro.setId(null);
                generoLibroCollectionGeneroLibro = em.merge(generoLibroCollectionGeneroLibro);
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
