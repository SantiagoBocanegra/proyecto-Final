/*
METODOS PARA CONTROLAR LA BASE DE DATOS
FUNCIONES QUE TIENE LA CLASE  
    1-INSERTAR NUEVO CLIENTE
    2-EDITAR CLIENTE
    3-BUSCAR CLEINTE POR ID
    3.1-BUSCAR TODOS LOS CLIENTES
 */
package MODELO_CONTROLADOR;

import CONTROLADOR.ClienteJpaController;
import MODELO.Cliente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class MC_Cliente {
    private EntityManagerFactory emf  = null;
    private EntityManager em = null;
    private EntityTransaction emt = null; 
    
    public MC_Cliente () {
        emf = Persistence.createEntityManagerFactory("Control-Ventas-LibreriaPU");
        em = emf.createEntityManager();
        emt = em.getTransaction();
    }
    
    // FUNCION NUMERO 1
    public boolean nuevoCliente (Cliente cliente) {
        ClienteJpaController servicio = new ClienteJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.create(cliente);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Ingresar El Cliente: "+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Cliente.nuevoCliente(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return estado;
    }
    
    // FUNCION NUMERO 2
    public boolean editarCliente (Cliente cliente) {
        ClienteJpaController servicio = new ClienteJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.edit(cliente);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Editar El Cliente: "+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Cliente.editarCliente(): "+e.getMessage());
        }finally {
            em.close();
            emf.close();
        }
        return estado;
    }
    
    // FUNCION NUMERO 3
    public Cliente buscarCliente (int idCliente) {
        ClienteJpaController servicio = new ClienteJpaController(emf);
        Cliente cliente = new Cliente();
        try {
            emt.begin();
            cliente = servicio.findCliente(idCliente);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Cliente: "+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Cliente.buscarCliente:  "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return cliente;
    }
    
    // FUNCION NUMERO 3.1
    public List<Cliente> buscarTodosClientes () {
        ClienteJpaController servicio = new ClienteJpaController(emf);
        List<Cliente> clientes  = new ArrayList<>();
        try {
            emt.begin();
            clientes = servicio.findClienteEntities();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Cliente: "+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Cliente.buscarTodosClientes(): "+e.getMessage() );
        } finally {
            em.close();
            emf.close();
        }
        return clientes;
    }
    
     // FUNCION NUMERO 3.2
    public List<Cliente> buscarClienteNombre (String nombre) {
        ClienteJpaController servicio = new ClienteJpaController(emf);
        List<Cliente> clientes  = new ArrayList<>();
        try {
            emt.begin();
            clientes = servicio.buscarClienteNombre(nombre);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Cliente: "+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Cliente.buscarClienteNombre(): "+e.getMessage() );
        } finally {
            em.close();
            emf.close();
        }
        return clientes;
    }
    
    // FUNCION NUMERO 3.3
    public List<Cliente> buscarClienteApellido (String apellido) {
        ClienteJpaController servicio = new ClienteJpaController(emf);
        List<Cliente> clientes  = new ArrayList<>();
        try {
            emt.begin();
            clientes = servicio.buscarClienteApellido(apellido);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Cliente: "+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Cliente.buscarClienteApellido(): "+e.getMessage() );
        } finally {
            em.close();
            emf.close();
        }
        return clientes;
    }
    
    // FUNCION NUMERO 3.4
    public List<Cliente> buscarClienteCedula (String cedula) {
        ClienteJpaController servicio = new ClienteJpaController(emf);
        List<Cliente> clientes  = new ArrayList<>();
        try {
            emt.begin();
            clientes = servicio.buscarClienteCedula(cedula);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Cliente: "+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Cliente.buscarClienteCedula(): "+e.getMessage() );
        } finally {
            em.close();
            emf.close();
        }
        return clientes;
    }
    
    // FUNCION NUMERO 3.2
    public List<Cliente> buscarClienteRangoFecha (Date fi, Date ff) {
        ClienteJpaController servicio = new ClienteJpaController(emf);
        List<Cliente> clientes  = new ArrayList<>();
        try {
            emt.begin();
            clientes = servicio.buscarRangoFecha(fi,ff);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Cliente: "+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Cliente.buscarClienteRangoFecha(): "+e.getMessage() );
        } finally {
            em.close();
            emf.close();
        }
        return clientes;
    }
}
