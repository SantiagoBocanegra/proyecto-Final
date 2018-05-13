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
import MODELO.Ordencompra;
import MODELO.Ordenitem;
import MODELO.OrdenitemPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ayenni42
 */
public class OrdenitemJpaController implements Serializable {

    public OrdenitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ordenitem ordenitem) throws PreexistingEntityException, Exception {
        if (ordenitem.getOrdenitemPK() == null) {
            ordenitem.setOrdenitemPK(new OrdenitemPK());
        }
        ordenitem.getOrdenitemPK().setLibroIsbn(ordenitem.getLibro().getIsbn());
        ordenitem.getOrdenitemPK().setOrdencompraNumeroorden(ordenitem.getOrdencompra().getNumeroorden());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro libro = ordenitem.getLibro();
            if (libro != null) {
                libro = em.getReference(libro.getClass(), libro.getIsbn());
                ordenitem.setLibro(libro);
            }
            Ordencompra ordencompra = ordenitem.getOrdencompra();
            if (ordencompra != null) {
                ordencompra = em.getReference(ordencompra.getClass(), ordencompra.getNumeroorden());
                ordenitem.setOrdencompra(ordencompra);
            }
            em.persist(ordenitem);
            if (libro != null) {
                libro.getOrdenitemCollection().add(ordenitem);
                libro = em.merge(libro);
            }
            if (ordencompra != null) {
                ordencompra.getOrdenitemCollection().add(ordenitem);
                ordencompra = em.merge(ordencompra);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrdenitem(ordenitem.getOrdenitemPK()) != null) {
                throw new PreexistingEntityException("Ordenitem " + ordenitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ordenitem ordenitem) throws NonexistentEntityException, Exception {
        ordenitem.getOrdenitemPK().setLibroIsbn(ordenitem.getLibro().getIsbn());
        ordenitem.getOrdenitemPK().setOrdencompraNumeroorden(ordenitem.getOrdencompra().getNumeroorden());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordenitem persistentOrdenitem = em.find(Ordenitem.class, ordenitem.getOrdenitemPK());
            Libro libroOld = persistentOrdenitem.getLibro();
            Libro libroNew = ordenitem.getLibro();
            Ordencompra ordencompraOld = persistentOrdenitem.getOrdencompra();
            Ordencompra ordencompraNew = ordenitem.getOrdencompra();
            if (libroNew != null) {
                libroNew = em.getReference(libroNew.getClass(), libroNew.getIsbn());
                ordenitem.setLibro(libroNew);
            }
            if (ordencompraNew != null) {
                ordencompraNew = em.getReference(ordencompraNew.getClass(), ordencompraNew.getNumeroorden());
                ordenitem.setOrdencompra(ordencompraNew);
            }
            ordenitem = em.merge(ordenitem);
            if (libroOld != null && !libroOld.equals(libroNew)) {
                libroOld.getOrdenitemCollection().remove(ordenitem);
                libroOld = em.merge(libroOld);
            }
            if (libroNew != null && !libroNew.equals(libroOld)) {
                libroNew.getOrdenitemCollection().add(ordenitem);
                libroNew = em.merge(libroNew);
            }
            if (ordencompraOld != null && !ordencompraOld.equals(ordencompraNew)) {
                ordencompraOld.getOrdenitemCollection().remove(ordenitem);
                ordencompraOld = em.merge(ordencompraOld);
            }
            if (ordencompraNew != null && !ordencompraNew.equals(ordencompraOld)) {
                ordencompraNew.getOrdenitemCollection().add(ordenitem);
                ordencompraNew = em.merge(ordencompraNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                OrdenitemPK id = ordenitem.getOrdenitemPK();
                if (findOrdenitem(id) == null) {
                    throw new NonexistentEntityException("The ordenitem with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(OrdenitemPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordenitem ordenitem;
            try {
                ordenitem = em.getReference(Ordenitem.class, id);
                ordenitem.getOrdenitemPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordenitem with id " + id + " no longer exists.", enfe);
            }
            Libro libro = ordenitem.getLibro();
            if (libro != null) {
                libro.getOrdenitemCollection().remove(ordenitem);
                libro = em.merge(libro);
            }
            Ordencompra ordencompra = ordenitem.getOrdencompra();
            if (ordencompra != null) {
                ordencompra.getOrdenitemCollection().remove(ordenitem);
                ordencompra = em.merge(ordencompra);
            }
            em.remove(ordenitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ordenitem> findOrdenitemEntities() {
        return findOrdenitemEntities(true, -1, -1);
    }

    public List<Ordenitem> findOrdenitemEntities(int maxResults, int firstResult) {
        return findOrdenitemEntities(false, maxResults, firstResult);
    }

    private List<Ordenitem> findOrdenitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ordenitem.class));
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

    public Ordenitem findOrdenitem(OrdenitemPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ordenitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdenitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ordenitem> rt = cq.from(Ordenitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
