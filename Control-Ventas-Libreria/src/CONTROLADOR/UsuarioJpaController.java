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
import MODELO.Empleado;
import MODELO.RolUsuario;
import MODELO.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author ayenni42
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getRolUsuarioCollection() == null) {
            usuario.setRolUsuarioCollection(new ArrayList<RolUsuario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado empleadoId = usuario.getEmpleadoId();
            if (empleadoId != null) {
                empleadoId = em.getReference(empleadoId.getClass(), empleadoId.getId());
                usuario.setEmpleadoId(empleadoId);
            }
            Collection<RolUsuario> attachedRolUsuarioCollection = new ArrayList<RolUsuario>();
            for (RolUsuario rolUsuarioCollectionRolUsuarioToAttach : usuario.getRolUsuarioCollection()) {
                rolUsuarioCollectionRolUsuarioToAttach = em.getReference(rolUsuarioCollectionRolUsuarioToAttach.getClass(), rolUsuarioCollectionRolUsuarioToAttach.getId());
                attachedRolUsuarioCollection.add(rolUsuarioCollectionRolUsuarioToAttach);
            }
            usuario.setRolUsuarioCollection(attachedRolUsuarioCollection);
            em.persist(usuario);
            if (empleadoId != null) {
                empleadoId.getUsuarioCollection().add(usuario);
                empleadoId = em.merge(empleadoId);
            }
            for (RolUsuario rolUsuarioCollectionRolUsuario : usuario.getRolUsuarioCollection()) {
                Usuario oldUsuarioIdOfRolUsuarioCollectionRolUsuario = rolUsuarioCollectionRolUsuario.getUsuarioId();
                rolUsuarioCollectionRolUsuario.setUsuarioId(usuario);
                rolUsuarioCollectionRolUsuario = em.merge(rolUsuarioCollectionRolUsuario);
                if (oldUsuarioIdOfRolUsuarioCollectionRolUsuario != null) {
                    oldUsuarioIdOfRolUsuarioCollectionRolUsuario.getRolUsuarioCollection().remove(rolUsuarioCollectionRolUsuario);
                    oldUsuarioIdOfRolUsuarioCollectionRolUsuario = em.merge(oldUsuarioIdOfRolUsuarioCollectionRolUsuario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getId());
            Empleado empleadoIdOld = persistentUsuario.getEmpleadoId();
            Empleado empleadoIdNew = usuario.getEmpleadoId();
            Collection<RolUsuario> rolUsuarioCollectionOld = persistentUsuario.getRolUsuarioCollection();
            Collection<RolUsuario> rolUsuarioCollectionNew = usuario.getRolUsuarioCollection();
            List<String> illegalOrphanMessages = null;
            for (RolUsuario rolUsuarioCollectionOldRolUsuario : rolUsuarioCollectionOld) {
                if (!rolUsuarioCollectionNew.contains(rolUsuarioCollectionOldRolUsuario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain RolUsuario " + rolUsuarioCollectionOldRolUsuario + " since its usuarioId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (empleadoIdNew != null) {
                empleadoIdNew = em.getReference(empleadoIdNew.getClass(), empleadoIdNew.getId());
                usuario.setEmpleadoId(empleadoIdNew);
            }
            Collection<RolUsuario> attachedRolUsuarioCollectionNew = new ArrayList<RolUsuario>();
            for (RolUsuario rolUsuarioCollectionNewRolUsuarioToAttach : rolUsuarioCollectionNew) {
                rolUsuarioCollectionNewRolUsuarioToAttach = em.getReference(rolUsuarioCollectionNewRolUsuarioToAttach.getClass(), rolUsuarioCollectionNewRolUsuarioToAttach.getId());
                attachedRolUsuarioCollectionNew.add(rolUsuarioCollectionNewRolUsuarioToAttach);
            }
            rolUsuarioCollectionNew = attachedRolUsuarioCollectionNew;
            usuario.setRolUsuarioCollection(rolUsuarioCollectionNew);
            usuario = em.merge(usuario);
            if (empleadoIdOld != null && !empleadoIdOld.equals(empleadoIdNew)) {
                empleadoIdOld.getUsuarioCollection().remove(usuario);
                empleadoIdOld = em.merge(empleadoIdOld);
            }
            if (empleadoIdNew != null && !empleadoIdNew.equals(empleadoIdOld)) {
                empleadoIdNew.getUsuarioCollection().add(usuario);
                empleadoIdNew = em.merge(empleadoIdNew);
            }
            for (RolUsuario rolUsuarioCollectionNewRolUsuario : rolUsuarioCollectionNew) {
                if (!rolUsuarioCollectionOld.contains(rolUsuarioCollectionNewRolUsuario)) {
                    Usuario oldUsuarioIdOfRolUsuarioCollectionNewRolUsuario = rolUsuarioCollectionNewRolUsuario.getUsuarioId();
                    rolUsuarioCollectionNewRolUsuario.setUsuarioId(usuario);
                    rolUsuarioCollectionNewRolUsuario = em.merge(rolUsuarioCollectionNewRolUsuario);
                    if (oldUsuarioIdOfRolUsuarioCollectionNewRolUsuario != null && !oldUsuarioIdOfRolUsuarioCollectionNewRolUsuario.equals(usuario)) {
                        oldUsuarioIdOfRolUsuarioCollectionNewRolUsuario.getRolUsuarioCollection().remove(rolUsuarioCollectionNewRolUsuario);
                        oldUsuarioIdOfRolUsuarioCollectionNewRolUsuario = em.merge(oldUsuarioIdOfRolUsuarioCollectionNewRolUsuario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getId();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<RolUsuario> rolUsuarioCollectionOrphanCheck = usuario.getRolUsuarioCollection();
            for (RolUsuario rolUsuarioCollectionOrphanCheckRolUsuario : rolUsuarioCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the RolUsuario " + rolUsuarioCollectionOrphanCheckRolUsuario + " in its rolUsuarioCollection field has a non-nullable usuarioId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empleado empleadoId = usuario.getEmpleadoId();
            if (empleadoId != null) {
                empleadoId.getUsuarioCollection().remove(usuario);
                empleadoId = em.merge(empleadoId);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    //consultas propias
    public List<Usuario> buscarUsuarioEmpledoId (int id) {
        List<Usuario> empleados = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Usuario> q = em.createNamedQuery("Usuario.findByEmpleadoId", Usuario.class);
            q.setParameter("empleadoId", id);
            empleados = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error UsuarioJpaController.buscarUsuarioEmpledoId(): "+e.getMessage());
        } finally {
            em.close();
        }
        return empleados;
    }
    
    public List<Usuario> buscarUsuarioNombreE (String nombre) {
        List<Usuario> Usuarios = new ArrayList<>();
        EntityManager em = getEntityManager();
         EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Usuario> q = em.createNamedQuery("Usuario.findByNombreELike", Usuario.class);
            q.setParameter("nombre", nombre);
            Usuarios = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error UsuarioJpaController.buscarUsuarioNombreE() "+e.getMessage() );
        } finally {
            em.close();
        }
        return Usuarios;
    }
    
    public List<Usuario> buscarUsuarioNombreU (String nombre) {
        List<Usuario> Usuarios = new ArrayList<>();
        EntityManager em = getEntityManager();
         EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Usuario> q = em.createNamedQuery("Usuario.findByNombreUsuarioLike", Usuario.class);
            q.setParameter("usuario", nombre);
            Usuarios = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error UsuarioJpaController.buscarUsuarioNombreU() "+e.getMessage() );
        } finally {
            em.close();
        }
        return Usuarios;
    }
    
    public List<Usuario> buscarUsuarioEstado (boolean estado) {
        List<Usuario> Usuarios = new ArrayList<>();
        EntityManager em = getEntityManager();
         EntityTransaction emt = em.getTransaction();
        try {
            emt.begin();
            TypedQuery<Usuario> q = em.createNamedQuery("Usuario.findByEstado", Usuario.class);
            q.setParameter("estado", estado);
            Usuarios = q.getResultList();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error UsuarioJpaController.buscarUsuarioEstado() "+e.getMessage() );
        } finally {
            em.close();
        }
        return Usuarios;
    }
}
