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
import java.util.Date;
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
    
    //Funcion Numero 3.2
    public Empleado buscarEmpleadoCc (String empleadoCc) {
        EmpleadoJpaController control = new EmpleadoJpaController(emf);
        Empleado empleado = new Empleado();
        try {
            emt.begin();
            empleado = control.buscarEmpleadoCc(empleadoCc);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Empleado "+e.getMessage(), "Error", 0, null);
            System.out.println("Error MC_Empleado.buscarEmpleadoCc(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return empleado;
    }
    
    //Funciones Numero 3.3
    public List<Empleado> buscarEmpleadoCargo (String cargo) {
        EmpleadoJpaController control = new EmpleadoJpaController(emf);
        List<Empleado> empleados = new ArrayList<>();
        try {
            emt.begin();
            empleados = control.buscarEmpladoCargo(cargo);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Empleado "+e.getMessage(), "Error", 0, null);
            System.out.println("Error MC_Empleado.buscarEmpleadoCargo(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return empleados;
    }
    
    // FUNCION NUMERO 3.4
    public List<Empleado> buscarEmpleadoNombre (String nombre) {
        EmpleadoJpaController servicio = new EmpleadoJpaController(emf);
        List<Empleado> clientes  = new ArrayList<>();
        try {
            emt.begin();
            clientes = servicio.buscarEmpleadoNombre(nombre);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Empleado "+e.getMessage(), "Error", 0, null);
            System.out.println("Error MC_Empleado.buscarEmpleadoCargo(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return clientes;
    }
    
    // FUNCION NUMERO 3.5
    public List<Empleado> buscarEmpleadoApellidoP (String apellido) {
        EmpleadoJpaController servicio = new EmpleadoJpaController(emf);
        List<Empleado> clientes  = new ArrayList<>();
        try {
            emt.begin();
            clientes = servicio.buscarEmpleadoApellido(apellido);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Empleado "+e.getMessage(), "Error", 0, null);
            System.out.println("Error MC_Empleado.buscarEmpleadoCargo(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return clientes;
    }
    
    // FUNCION NUMERO 3.6
    public List<Empleado> buscarEmpleadoRangoFecha (Date fi, Date ff) {
        EmpleadoJpaController servicio = new EmpleadoJpaController(emf);
        List<Empleado> clientes  = new ArrayList<>();
        try {
            emt.begin();
            clientes = servicio.buscarRangoFecha(fi,ff);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Empleado "+e.getMessage(), "Error", 0, null);
            System.out.println("Error MC_Empleado.buscarEmpleadoCargo(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return clientes;
    }
}
