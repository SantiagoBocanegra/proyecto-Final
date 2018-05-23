/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import CONTROLADOR.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import MODELO.Genero;
import MODELO.GeneroLibro;
import MODELO.Libro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author ayenni42
 */
public class GeneroLibroJpaController implements Serializable {

    public GeneroLibroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(GeneroLibro generoLibro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Genero id = generoLibro.getId();
            if (id != null) {
                id = em.getReference(id.getClass(), id.getId());
                generoLibro.setId(id);
            }
            Libro isbn = generoLibro.getIsbn();
            if (isbn != null) {
                isbn = em.getReference(isbn.getClass(), isbn.getIsbn());
                generoLibro.setIsbn(isbn);
            }
            em.persist(generoLibro);
            if (id != null) {
                id.getGeneroLibroCollection().add(generoLibro);
                id = em.merge(id);
            }
            if (isbn != null) {
                isbn.getGeneroLibroCollection().add(generoLibro);
                isbn = em.merge(isbn);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(GeneroLibro generoLibro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            GeneroLibro persistentGeneroLibro = em.find(GeneroLibro.class, generoLibro.getIdGenero());
            Genero idOld = persistentGeneroLibro.getId();
            Genero idNew = generoLibro.getId();
            Libro isbnOld = persistentGeneroLibro.getIsbn();
            Libro isbnNew = generoLibro.getIsbn();
            if (idNew != null) {
                idNew = em.getReference(idNew.getClass(), idNew.getId());
                generoLibro.setId(idNew);
            }
            if (isbnNew != null) {
                isbnNew = em.getReference(isbnNew.getClass(), isbnNew.getIsbn());
                generoLibro.setIsbn(isbnNew);
            }
            generoLibro = em.merge(generoLibro);
            if (idOld != null && !idOld.equals(idNew)) {
                idOld.getGeneroLibroCollection().remove(generoLibro);
                idOld = em.merge(idOld);
            }
            if (idNew != null && !idNew.equals(idOld)) {
                idNew.getGeneroLibroCollection().add(generoLibro);
                idNew = em.merge(idNew);
            }
            if (isbnOld != null && !isbnOld.equals(isbnNew)) {
                isbnOld.getGeneroLibroCollection().remove(generoLibro);
                isbnOld = em.merge(isbnOld);
            }
            if (isbnNew != null && !isbnNew.equals(isbnOld)) {
                isbnNew.getGeneroLibroCollection().add(generoLibro);
                isbnNew = em.merge(isbnNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = generoLibro.getIdGenero();
                if (findGeneroLibro(id) == null) {
                    throw new NonexistentEntityException("The generoLibro with id " + id + " no longer exists.");
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
            GeneroLibro generoLibro;
            try {
                generoLibro = em.getReference(GeneroLibro.class, id);
                generoLibro.getIdGenero();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The generoLibro with id " + id + " no longer exists.", enfe);
            }
            Genero idGenero = generoLibro.getId();
            if (idGenero != null) {
                idGenero.getGeneroLibroCollection().remove(generoLibro);
                idGenero = em.merge(idGenero);
            }
            Libro isbn = generoLibro.getIsbn();
            if (isbn != null) {
                isbn.getGeneroLibroCollection().remove(generoLibro);
                isbn = em.merge(isbn);
            }
            em.remove(generoLibro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<GeneroLibro> findGeneroLibroEntities() {
        return findGeneroLibroEntities(true, -1, -1);
    }

    public List<GeneroLibro> findGeneroLibroEntities(int maxResults, int firstResult) {
        return findGeneroLibroEntities(false, maxResults, firstResult);
    }

    private List<GeneroLibro> findGeneroLibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(GeneroLibro.class));
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

    public GeneroLibro findGeneroLibro(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(GeneroLibro.class, id);
        } finally {
            em.close();
        }
    }

    public int getGeneroLibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<GeneroLibro> rt = cq.from(GeneroLibro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<GeneroLibro> buscarGeneroLibroIsbn (int libroIsbn) {
        EntityManager  em = getEntityManager();
        List<GeneroLibro> generosLibro = new ArrayList<>();
        try {
            em.getTransaction().begin();
            TypedQuery<GeneroLibro> q = em.createNamedQuery("GeneroLibro.finByLibroIsbn", GeneroLibro.class);
            q.setParameter("libroIsbn", libroIsbn);
            generosLibro = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error GeneroLibroJpaController.buscarGeneroLibroIsbn(): "+e.getMessage());
        } finally {
            em.close();
        }
        return generosLibro;
    }
    
}
