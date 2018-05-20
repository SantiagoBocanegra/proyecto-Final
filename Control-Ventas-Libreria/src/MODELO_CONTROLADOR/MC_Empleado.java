/*
METODOS PARA CONTROLAR LA BASE DE DATOS 
FUNCIONES DE LA CLASE MC_Empleado    
    1-INSERTAR NUEVO EMPLEADO
    2-EDITAR EMPLEADO
    3-BUSCAR EMPLEADO POR ID
    3.1-BUSCAR  TODOS LOS EMPLEADOS
*/
package MODELO_CONTROLADOR;

import CONTROLADOR.EmpleadoJpaController;
import MODELO.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class MC_Empleado {
    
    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private EntityTransaction emt = null;
    
    public MC_Empleado () {
        emf = Persistence.createEntityManagerFactory("Control-Ventas-LibreriaPU");
        em = emf.createEntityManager();
        emt = em.getTransaction();
    }
    
    // FUNCION NUMERO 1
    public boolean nuevoEmmpleado (Empleado empleado) {
        EmpleadoJpaController servicio = new EmpleadoJpaController(emf);
        boolean estado =  true;
        try {
            emt.begin();
            servicio.create(empleado);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Guardar El Empleado: "+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Empleado.nuevoEmpleado(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        } 
        return estado; 
    }
    
    //FUNCION NUMERO 2
    public boolean editarEmpleado (Empleado empleado) {
        EmpleadoJpaController servicio = new EmpleadoJpaController(emf);
        boolean estado =  true;
        try {
            emt.begin();
            servicio.edit(empleado);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Editar El Empleado: "+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Empleado.editarEmpleado(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        } 
        return estado; 
    }
    
     //FUNCION NUMERO 3
    public Empleado buscarEmpleado (int isbnEmpleado) {
        EmpleadoJpaController servicio = new EmpleadoJpaController(emf);
        Empleado empleado = new Empleado();
        try {
            emt.begin();
            empleado = servicio.findEmpleado(isbnEmpleado);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Buscar El Empleado: "+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Empleado.nombreFuncion(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        } 
        return empleado; 
    }
    
     //FUNCION NUMERO 3.1
    public List<Empleado> buscarTodosEmpleados () {
        EmpleadoJpaController servicio = new EmpleadoJpaController(emf);
        List<Empleado> empleados = new ArrayList<>();
        try {
            emt.begin();
            empleados = servicio.findEmpleadoEntities();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Buscar El Empleado: "+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Empleado.buscarTodosEmpleados(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        } 
        return empleados; 
    }
}
