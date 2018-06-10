/*
METODOS PARA CONTROLAR LA BASE DE DATOS 
FUNCIONES DE LA CLASE MC_RolUsuario    
    1-INSERTAR NUEVO ROL DE USUARIO
    2-EDITAR ROL DE USUARIO
    3-BUSCAR ROL DE USUARIO
    3.1-BUSCAR  TODOS LOS ROLES DE USUARIOS
    4 Borrar un rol 
*/
package MODELO_CONTROLADOR;

import CONTROLADOR.RolUsuarioJpaController;
import MODELO.RolUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class MC_RolUsuario {
    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private EntityTransaction emt = null;
    
    public MC_RolUsuario () {
        emf = Persistence.createEntityManagerFactory("Control-Ventas-LibreriaPU");
        em = emf.createEntityManager();
        emt = em.getTransaction();
    }
    
    //FUNCION NUMERO 1
    public boolean nuevoRolUsuario (RolUsuario rolUsuario) {
        RolUsuarioJpaController servicio = new RolUsuarioJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.create(rolUsuario);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Guardar El Rol: \n"+e.getMessage(), "Error", 0,null);
            System.err.print("ERROR MC_RolUsuario.nuevoRolUsuario(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return estado;
    }
    
    //FUNCION NUMERO 2
    public boolean editarRolUsuario (RolUsuario rolUsuario) {
        RolUsuarioJpaController servicio = new RolUsuarioJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.edit(rolUsuario);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Editar El Rol: \n"+e.getMessage(), "Error", 0,null);
            System.err.print("ERROR MC_RolUsuario.editarRolUsuario(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return estado;
    }
    
    //FUNCION NUMERO 3
    public RolUsuario buscarRolUsuario ( int  idRolUsuario) {
        RolUsuarioJpaController servicio = new RolUsuarioJpaController(emf);
        RolUsuario rolUsuario = new RolUsuario();
        try {
            emt.begin();
            rolUsuario = servicio.findRolUsuario(idRolUsuario);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Rol: \n"+e.getMessage(), "Error", 0,null);
            System.err.print("ERROR MC_RolUsuario.buscarRolUsuario(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return rolUsuario;
    }
    
    //FUNCION NUMERO 3.1
    public List<RolUsuario> buscarTodosRolUsuario () {
        RolUsuarioJpaController servicio = new RolUsuarioJpaController(emf);
        List<RolUsuario> rolesUsuario = new ArrayList<>();
        try {
            emt.begin();
            rolesUsuario = servicio.findRolUsuarioEntities();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Rol: \n"+e.getMessage(), "Error", 0,null);
            System.err.print("ERROR MC_RolUsuario.buscarTodosRolUsuario(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return rolesUsuario;
    }
    
     //FUNCION NUMERO 3.2
    public List<RolUsuario> buscarRolUsuarioNombreUsuario (String nombre) {
        RolUsuarioJpaController servicio = new RolUsuarioJpaController(emf);
        List<RolUsuario> rolesUsuario = new ArrayList<>();
        try {
            emt.begin();
            rolesUsuario = servicio.buscarRolUsuarioNombreUsuario(nombre);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Rol: \n"+e.getMessage(), "Error", 0,null);
            System.err.print("ERROR MC_RolUsuario.buscarRolUsuarioNombreUsuario(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return rolesUsuario;
    }
    //FUNCION NUMERO 3.3
    public List<RolUsuario> buscarRolUsuarioNombreRol (String nombre) {
        RolUsuarioJpaController servicio = new RolUsuarioJpaController(emf);
        List<RolUsuario> rolesUsuario = new ArrayList<>();
        try {
            emt.begin();
            rolesUsuario = servicio.buscarRolUsuarioNombreRol(nombre);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Rol: \n"+e.getMessage(), "Error", 0,null);
            System.err.print("ERROR MC_RolUsuario.buscarRolUsuarioNombreRol(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return rolesUsuario;
    }
    
    //Funcion numero 4
    public boolean  borrarRolUsuario ( int idRol) {
        RolUsuarioJpaController servicio = new RolUsuarioJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.destroy(idRol);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            estado = false;
            JOptionPane.showMessageDialog(null, "Error Al Borrar El Rol: \n"+e.getMessage(), "Error", 0,null);
            System.err.print("ERROR MC_RolUsuario.borrarRolUsuario(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return estado;
    }
    
    //Funcion numero 5
    public List<RolUsuario>  buscarRolUsuarioId ( int idUsuario) {
        RolUsuarioJpaController servicio = new RolUsuarioJpaController(emf);
        List<RolUsuario> rolesUsuario = new ArrayList<>();
        try {
            emt.begin();
            rolesUsuario = servicio.buscarRolUsuarioId(idUsuario);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Rol: \n"+e.getMessage(), "Error", 0,null);
            System.err.print("ERROR MC_RolUsuario.buscarRolUsuarioId(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return rolesUsuario;
    }
}
