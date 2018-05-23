/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO_CONTROLADOR;

import CONTROLADOR.PermisosJpaController;
import MODELO.Permisos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author ayenni42
 */
public class MC_Permisos {
    private EntityManager em = null;
    private EntityManagerFactory emf = null;
    private EntityTransaction emt = null;

    public MC_Permisos() {
        emf = Persistence.createEntityManagerFactory("Control-Ventas-LibreriaPU");
        em = emf.createEntityManager();
        emt = em.getTransaction();
    }
    
    public boolean nuevoPermiso (Permisos permisos) {
        PermisosJpaController control = new PermisosJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            control.create(permisos);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Guardar El Permiso: "+e.getMessage(), "Error", 0, null);
            System.out.println("Error MC_Permisos.nuevoPermiso(): "+e.getMessage());
        }
        return estado;
    }
    
    public boolean editarPermiso(Permisos permisos) {
        PermisosJpaController control = new PermisosJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            control.edit(permisos);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Editar El Permiso: "+e.getMessage(), "Error", 0, null);
            System.out.println("Error MC_Permisos.EditarPermiso(): "+e.getMessage());
        }
        return estado;
    }
    
    public List<Permisos> buscarTodosPermisos () {
        PermisosJpaController control = new PermisosJpaController(emf);
        List<Permisos> permisos = null;
        try {
            emt.begin();
            permisos = control.findPermisosEntities();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar Los Permisos: "+e.getMessage(), "Error", 0, null);
            System.out.println("Error MC_Permisos.buscarTodosPermisos(): "+e.getMessage());
        }finally {
            em.close();
            emf.close();
        }
        return permisos;
    }
    
    public Permisos buscarPermiso (int idPermisos) {
        PermisosJpaController control = new PermisosJpaController(emf);
        Permisos permiso = null;
        try {
            emt.begin();
            permiso = control.findPermisos(idPermisos);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Permiso: "+e.getMessage(), "Error", 0, null);
            System.out.println("Error MC_Permisos.buscarPermiso(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return permiso;
    }
    
    public boolean borrarPermiso (int idPermiso) {
        PermisosJpaController control = new PermisosJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            control.destroy(idPermiso);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Borrar El Permiso: "+e.getMessage(), "Error", 0, null);
            System.out.println("Error MC_Permisos.borrarPermiso(): "+e.getMessage());
        }
        return estado;
    }
    
    public List<Permisos> buscarPermisosRolId ( int rolId ) {
        PermisosJpaController control = new PermisosJpaController(emf);
        List<Permisos> permisos = new ArrayList<>();
        try {
            emt.begin();
            permisos = control.buscarPermisosRolId(rolId);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar Los Permisos: "+e.getMessage(), "Error", 0, null);
            System.out.println("Error MC_Permisos.buscarPermisosRolId(): "+e.getMessage());
        }finally {
            em.close();
            emf.close();
        }
        return permisos;
    }
    
    public void close () {
        em.close();
        emf.close();
    }
}
