/*
METODOS PARA CONTROLAR LA BASE DE DATOS 
FUNCIONES DE LA CLASE MC_Permisos    
    1-INSERTAR NUEVO PERMISO
    2-EDITAR PERMISO
    3-BUSCAR PERMISOS
    3.1-BUSCAR  TODOS LOS PERMISOS
*/
package MODELO_CONTROLADOR;

import CONTROLADOR.PermisoJpaController;
import MODELO.Permiso;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MC_Permiso {
    
    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private EntityTransaction emt = null;
    
    public MC_Permiso () {
        emf = Persistence.createEntityManagerFactory("Control-Ventas-LibreriaPU");
        em = emf.createEntityManager();
        emt = em.getTransaction();
    }
    
    //FUNCION NUMERO 1
    public boolean nuevoPermiso (Permiso permiso) {
        PermisoJpaController servicio = new PermisoJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.create(permiso);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            System.err.print("ERROR MC_Permiso.nuevoPermiso(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        } 
        return estado; 
    }
    
    //FUNCION NUMERO 2
    public boolean editarPermiso (Permiso permiso) {
        PermisoJpaController servicio = new PermisoJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.edit(permiso);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            System.err.print("ERROR MC_Permiso.editarPermiso(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        } 
        return estado; 
    }
    
    //FUNCION NUMERO 3
    public Permiso buscarPermiso (int  idPermiso) {
        PermisoJpaController servicio = new PermisoJpaController(emf);
        Permiso permiso = new Permiso();
        try {
            emt.begin();
            permiso = servicio.findPermiso(idPermiso);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.err.print("ERROR MC_Permiso.buscarPermiso(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        } 
        return permiso; 
    }
    
    //FUNCION NUMERO 3.1
    public List<Permiso> buscarTodosPermiso () {
        PermisoJpaController servicio = new PermisoJpaController(emf);
        List<Permiso> permisos = new ArrayList<>();
        try {
            emt.begin();
            permisos = servicio.findPermisoEntities();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.err.print("ERROR MC_Permiso.buscarTodosPermisos(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        } 
        return permisos; 
    }
}
