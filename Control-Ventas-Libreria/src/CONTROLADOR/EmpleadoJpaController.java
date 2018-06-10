/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import CONTROLADOR.exceptions.IllegalOrphanException;
import CONTROLADOR.exceptions.NonexistentEntityException;
import MODELO.Empleado;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import MODELO.Ordencompra;
import java.util.ArrayList;
import java.util.Collection;
import MODELO.Ordenprestamo;
import MODELO.Usuario;
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
public class EmpleadoJpaController implements Serializable {

    public EmpleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleado empleado) {
        if (empleado.getOrdencompraCollection() == null) {
            empleado.setOrdencompraCollection(new ArrayList<Ordencompra>());
        }
        if (empleado.getOrdenprestamoCollection() == null) {
            empleado.setOrdenprestamoCollection(new ArrayList<Ordenprestamo>());
        }
        if (empleado.getUsuarioCollection() == null) {
            empleado.setUsuarioCollection(new ArrayList<Usuario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Ordencompra> attachedOrdencompraCollection = new ArrayList<Ordencompra>();
            for (Ordencompra ordencompraCollectionOrdencompraToAttach : empleado.getOrdencompraCollection()) {
                ordencompraCollectionOrdencompraToAttach = em.getReference(ordencompraCollectionOrdencompraToAttach.getClass(), ordencompraCollectionOrdencompraToAttach.getNumeroorden());
                attachedOrdencompraCollection.add(ordencompraCollectionOrdencompraToAttach);
            }
            empleado.setOrdencompraCollection(attachedOrdencompraCollection);
            Collection<Ordenprestamo> attachedOrdenprestamoCollection = new ArrayList<Ordenprestamo>();
            for (Ordenprestamo ordenprestamoCollectionOrdenprestamoToAttach : empleado.getOrdenprestamoCollection()) {
                ordenprestamoCollectionOrdenprestamoToAttach = em.getReference(ordenprestamoCollectionOrdenprestamoToAttach.getClass(), ordenprestamoCollectionOrdenprestamoToAttach.getNumeroorden());
                attachedOrdenprestamoCollection.add(ordenprestamoCollectionOrdenprestamoToAttach);
            }
            empleado.setOrdenprestamoCollection(attachedOrdenprestamoCollection);
            Collection<Usuario> attachedUsuarioCollection = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionUsuarioToAttach : empleado.getUsuarioCollection()) {
                usuarioCollectionUsuarioToAttach = em.getReference(usuarioCollectionUsuarioToAttach.getClass(), usuarioCollectionUsuarioToAttach.getId());
                attachedUsuarioCollection.add(usuarioCollectionUsuarioToAttach);
            }
            empleado.setUsuarioCollection(attachedUsuarioCollection);
            em.persist(empleado);
            for (Ordencompra ordencompraCollectionOrdencompra : empleado.getOrdencompraCollection()) {
                Empleado oldEmpleadoIdOfOrdencompraCollectionOrdencompra = ordencompraCollectionOrdencompra.getEmpleadoId();
                ordencompraCollectionOrdencompra.setEmpleadoId(empleado);
                ordencompraCollectionOrdencompra = em.merge(ordencompraCollectionOrdencompra);
                if (oldEmpleadoIdOfOrdencompraCollectionOrdencompra != null) {
                    oldEmpleadoIdOfOrdencompraCollectionOrdencompra.getOrdencompraCollection().remove(ordencompraCollectionOrdencompra);
                    oldEmpleadoIdOfOrdencompraCollectionOrdencompra = em.merge(oldEmpleadoIdOfOrdencompraCollectionOrdencompra);
                }
            }
            for (Ordenprestamo ordenprestamoCollectionOrdenprestamo : empleado.getOrdenprestamoCollection()) {
                Empleado oldEmpleadoIdOfOrdenprestamoCollectionOrdenprestamo = ordenprestamoCollectionOrdenprestamo.getEmpleadoId();
                ordenprestamoCollectionOrdenprestamo.setEmpleadoId(empleado);
                ordenprestamoCollectionOrdenprestamo = em.merge(ordenprestamoCollectionOrdenprestamo);
                if (oldEmpleadoIdOfOrdenprestamoCollectionOrdenprestamo != null) {
                    oldEmpleadoIdOfOrdenprestamoCollectionOrdenprestamo.getOrdenprestamoCollection().remove(ordenprestamoCollectionOrdenprestamo);
                    oldEmpleadoIdOfOrdenprestamoCollectionOrdenprestamo = em.merge(oldEmpleadoIdOfOrdenprestamoCollectionOrdenprestamo);
                }
            }
            for (Usuario usuarioCollectionUsuario : empleado.getUsuarioCollection()) {
                Empleado oldEmpleadoIdOfUsuarioCollectionUsuario = usuarioCollectionUsuario.getEmpleadoId();
                usuarioCollectionUsuario.setEmpleadoId(empleado);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
                if (oldEmpleadoIdOfUsuarioCollectionUsuario != null) {
                    oldEmpleadoIdOfUsuarioCollectionUsuario.getUsuarioCollection().remove(usuarioCollectionUsuario);
                    oldEmpleadoIdOfUsuarioCollectionUsuario = em.merge(oldEmpleadoIdOfUsuarioCollectionUsuario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleado empleado) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado persistentEmpleado = em.find(Empleado.class, empleado.getId());
            Collection<Ordencompra> ordencompraCollectionOld = persistentEmpleado.getOrdencompraCollection();
            Collection<Ordencompra> ordencompraCollectionNew = empleado.getOrdencompraCollection();
            Collection<Ordenprestamo> ordenprestamoCollectionOld = persistentEmpleado.getOrdenprestamoCollection();
            Collection<Ordenprestamo> ordenprestamoCollectionNew = empleado.getOrdenprestamoCollection();
            Collection<Usuario> usuarioCollectionOld = persistentEmpleado.getUsuarioCollection();
            Collection<Usuario> usuarioCollectionNew = empleado.getUsuarioCollection();
            List<String> illegalOrphanMessages = null;
            for (Ordencompra ordencompraCollectionOldOrdencompra : ordencompraCollectionOld) {
                if (!ordencompraCollectionNew.contains(ordencompraCollectionOldOrdencompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ordencompra " + ordencompraCollectionOldOrdencompra + " since its empleadoId field is not nullable.");
                }
            }
            for (Ordenprestamo ordenprestamoCollectionOldOrdenprestamo : ordenprestamoCollectionOld) {
                if (!ordenprestamoCollectionNew.contains(ordenprestamoCollectionOldOrdenprestamo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ordenprestamo " + ordenprestamoCollectionOldOrdenprestamo + " since its empleadoId field is not nullable.");
                }
            }
            for (Usuario usuarioCollectionOldUsuario : usuarioCollectionOld) {
                if (!usuarioCollectionNew.contains(usuarioCollectionOldUsuario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Usuario " + usuarioCollectionOldUsuario + " since its empleadoId field is not nullable.");
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
            empleado.setOrdencompraCollection(ordencompraCollectionNew);
            Collection<Ordenprestamo> attachedOrdenprestamoCollectionNew = new ArrayList<Ordenprestamo>();
            for (Ordenprestamo ordenprestamoCollectionNewOrdenprestamoToAttach : ordenprestamoCollectionNew) {
                ordenprestamoCollectionNewOrdenprestamoToAttach = em.getReference(ordenprestamoCollectionNewOrdenprestamoToAttach.getClass(), ordenprestamoCollectionNewOrdenprestamoToAttach.getNumeroorden());
                attachedOrdenprestamoCollectionNew.add(ordenprestamoCollectionNewOrdenprestamoToAttach);
            }
            ordenprestamoCollectionNew = attachedOrdenprestamoCollectionNew;
            empleado.setOrdenprestamoCollection(ordenprestamoCollectionNew);
            Collection<Usuario> attachedUsuarioCollectionNew = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionNewUsuarioToAttach : usuarioCollectionNew) {
                usuarioCollectionNewUsuarioToAttach = em.getReference(usuarioCollectionNewUsuarioToAttach.getClass(), usuarioCollectionNewUsuarioToAttach.getId());
                attachedUsuarioCollectionNew.add(usuarioCollectionNewUsuarioToAttach);
            }
            usuarioCollectionNew = attachedUsuarioCollectionNew;
            empleado.setUsuarioCollection(usuarioCollectionNew);
            empleado = em.merge(empleado);
            for (Ordencompra ordencompraCollectionNewOrdencompra : ordencompraCollectionNew) {
                if (!ordencompraCollectionOld.contains(ordencompraCollectionNewOrdencompra)) {
                    Empleado oldEmpleadoIdOfOrdencompraCollectionNewOrdencompra = ordencompraCollectionNewOrdencompra.getEmpleadoId();
                    ordencompraCollectionNewOrdencompra.setEmpleadoId(empleado);
                    ordencompraCollectionNewOrdencompra = em.merge(ordencompraCollectionNewOrdencompra);
                    if (oldEmpleadoIdOfOrdencompraCollectionNewOrdencompra != null && !oldEmpleadoIdOfOrdencompraCollectionNewOrdencompra.equals(empleado)) {
                        oldEmpleadoIdOfOrdencompraCollectionNewOrdencompra.getOrdencompraCollection().remove(ordencompraCollectionNewOrdencompra);
                        oldEmpleadoIdOfOrdencompraCollectionNewOrdencompra = em.merge(oldEmpleadoIdOfOrdencompraCollectionNewOrdencompra);
                    }
                }
            }
            for (Ordenprestamo ordenprestamoCollectionNewOrdenprestamo : ordenprestamoCollectionNew) {
                if (!ordenprestamoCollectionOld.contains(ordenprestamoCollectionNewOrdenprestamo)) {
                    Empleado oldEmpleadoIdOfOrdenprestamoCollectionNewOrdenprestamo = ordenprestamoCollectionNewOrdenprestamo.getEmpleadoId();
                    ordenprestamoCollectionNewOrdenprestamo.setEmpleadoId(empleado);
                    ordenprestamoCollectionNewOrdenprestamo = em.merge(ordenprestamoCollectionNewOrdenprestamo);
                    if (oldEmpleadoIdOfOrdenprestamoCollectionNewOrdenprestamo != null && !oldEmpleadoIdOfOrdenprestamoCollectionNewOrdenprestamo.equals(empleado)) {
                        oldEmpleadoIdOfOrdenprestamoCollectionNewOrdenprestamo.getOrdenprestamoCollection().remove(ordenprestamoCollectionNewOrdenprestamo);
                        oldEmpleadoIdOfOrdenprestamoCollectionNewOrdenprestamo = em.merge(oldEmpleadoIdOfOrdenprestamoCollectionNewOrdenprestamo);
                    }
                }
            }
            for (Usuario usuarioCollectionNewUsuario : usuarioCollectionNew) {
                if (!usuarioCollectionOld.contains(usuarioCollectionNewUsuario)) {
                    Empleado oldEmpleadoIdOfUsuarioCollectionNewUsuario = usuarioCollectionNewUsuario.getEmpleadoId();
                    usuarioCollectionNewUsuario.setEmpleadoId(empleado);
                    usuarioCollectionNewUsuario = em.merge(usuarioCollectionNewUsuario);
                    if (oldEmpleadoIdOfUsuarioCollectionNewUsuario != null && !oldEmpleadoIdOfUsuarioCollectionNewUsuario.equals(empleado)) {
                        oldEmpleadoIdOfUsuarioCollectionNewUsuario.getUsuarioCollection().remove(usuarioCollectionNewUsuario);
                        oldEmpleadoIdOfUsuarioCollectionNewUsuario = em.merge(oldEmpleadoIdOfUsuarioCollectionNewUsuario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empleado.getId();
                if (findEmpleado(id) == null) {
                    throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.");
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
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Ordencompra> ordencompraCollectionOrphanCheck = empleado.getOrdencompraCollection();
            for (Ordencompra ordencompraCollectionOrphanCheckOrdencompra : ordencompraCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empleado (" + empleado + ") cannot be destroyed since the Ordencompra " + ordencompraCollectionOrphanCheckOrdencompra + " in its ordencompraCollection field has a non-nullable empleadoId field.");
            }
            Collection<Ordenprestamo> ordenprestamoCollectionOrphanCheck = empleado.getOrdenprestamoCollection();
            for (Ordenprestamo ordenprestamoCollectionOrphanCheckOrdenprestamo : ordenprestamoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empleado (" + empleado + ") cannot be destroyed since the Ordenprestamo " + ordenprestamoCollectionOrphanCheckOrdenprestamo + " in its ordenprestamoCollection field has a non-nullable empleadoId field.");
            }
            Collection<Usuario> usuarioCollectionOrphanCheck = empleado.getUsuarioCollection();
            for (Usuario usuarioCollectionOrphanCheckUsuario : usuarioCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empleado (" + empleado + ") cannot be destroyed since the Usuario " + usuarioCollectionOrphanCheckUsuario + " in its usuarioCollection field has a non-nullable empleadoId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleado> findEmpleadoEntities() {
        return findEmpleadoEntities(true, -1, -1);
    }

    public List<Empleado> findEmpleadoEntities(int maxResults, int firstResult) {
        return findEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
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

    public Empleado findEmpleado(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleado> rt = cq.from(Empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    //consultas propias
    public Empleado buscarEmpleadoCc(String empleadoCc) {
        EntityManager em = getEntityManager();
        Empleado empleado = new Empleado();
        try {
            em.getTransaction().begin();
            TypedQuery<Empleado> q = em.createNamedQuery("Empleado.findByCedula", Empleado.class);
            q.setParameter("cedula", empleadoCc);
            empleado = q.getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error EmpleadoJpaController.buscarEmpleadoCc(): " + e.getMessage());
        } finally {
            em.close();
        }
        return empleado;
    }

    public List<Empleado> buscarEmpladoCargo(String cargo) {
        List<Empleado> empleados = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Empleado> q = em.createNamedQuery("Empleado.findByAllCargo", Empleado.class);
            q.setParameter("cargo", cargo);
            empleados = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error EmpleadoJpaController.buscarEmpladoCargo(): " + e.getMessage());
        } finally {
            em.close();
        }
        return empleados;
    }
    
    public List<Empleado> buscarEmpleadoNombre (String nombre) {
        List<Empleado> clientes = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Empleado> q = em.createNamedQuery("Empleado.findByNombreLike", Empleado.class);
            q.setParameter("nombre", nombre);
            clientes = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error EmpleadoJpaController.buscarEmpleadoNombre() "+e.getMessage());
        } finally {
            em.close();
        }
        return clientes;
    }
    
    public List<Empleado> buscarEmpleadoApellido (String apellido) {
        List<Empleado> clientes = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Empleado> q = em.createNamedQuery("Empleado.findByApellidoMaternoLike", Empleado.class);
            q.setParameter("apellidoPaterno", apellido);
            clientes = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error EmpleadoJpaController.buscarEmpleadoApellido() "+e.getMessage() );
        } finally {
            em.close();
        }
        return clientes;
    }
    public List<Empleado> buscarRangoFecha (Date fechaInicial, Date fechaFinal) {
        List<Empleado> clientes = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Empleado> q = em.createNamedQuery("Empleado.findByRangoFechas", Empleado.class);
            q.setParameter("fechaContratoI", fechaInicial,TemporalType.DATE);
            q.setParameter("fechaContratoF", fechaFinal,TemporalType.DATE);
            clientes = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Erro EmpleadoJpaController.buscarRangoFecha() "+e.getMessage());
        } finally {
            em.close();
        }
        return clientes;
    }
}
