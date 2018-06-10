/*
METODOS PARA CONTROLAR LA BASE DE DATOS 
FUNCIONES DE LA CLASE MC_OrdenPrestamo    
    1-INSERTAR NUEVA ORDEN DE PRESTAMO
    2-EDITAR ORDEN DE PRESTAMO
    3-BUSCAR ORDEN DE PRESTAMO POR NUMERO DE ORDEN
    3.1-BUSCAR  TODAS LAS ORDENES DE PRESTAMO
    3.2-Buscar ordenes de prestamo por fecha de entrega
 */
package MODELO_CONTROLADOR;

import CONTROLADOR.OrdenprestamoJpaController;
import MODELO.Ordenprestamo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class MC_OrdenPrestamo {

    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private EntityTransaction emt = null;

    public MC_OrdenPrestamo() {
        emf = Persistence.createEntityManagerFactory("Control-Ventas-LibreriaPU");
        em = emf.createEntityManager();
        emt = em.getTransaction();
    }

    //FUNCION NUMERO 1
    public boolean nuevaOrdenPrestamo(Ordenprestamo ordenPrestamo) {
        OrdenprestamoJpaController servicio = new OrdenprestamoJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.create(ordenPrestamo);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Eror Al Guardar La Orden De Prestamo: \n" + e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenPrestamo.nuevaOrdenPrestamo(): " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return estado;
    }

    //FUNCION NUMERO 2
    public boolean editarOrdenPrestamo(Ordenprestamo ordenPrestamo) {
        OrdenprestamoJpaController servicio = new OrdenprestamoJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.edit(ordenPrestamo);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Eror Al Editar La Orden De Prestamo: \n" + e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenPrestamo.editarOrdenPrestamo(): " + e.getMessage());
        }
        return estado;
    }

    //FUNCION NUMERO 3
    public Ordenprestamo buscarOrdenPrestamo(int numeroOrdenPrestamo) {
        OrdenprestamoJpaController servicio = new OrdenprestamoJpaController(emf);
        Ordenprestamo ordenPrestamo = new Ordenprestamo();
        try {
            emt.begin();
            ordenPrestamo = servicio.findOrdenprestamo(numeroOrdenPrestamo);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Eror Al Buscar La Orden De Prestamo: \n" + e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenPrestamo.buscarOrdenPrestamo(): " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return ordenPrestamo;
    }

    //FUNCION NUMERO 3.1
    public List<Ordenprestamo> buscarTodasOrdenesPrestamo() {
        OrdenprestamoJpaController servicio = new OrdenprestamoJpaController(emf);
        List<Ordenprestamo> ordenesPrestamo = new ArrayList<>();
        try {
            emt.begin();
            ordenesPrestamo = servicio.findOrdenprestamoEntities();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Eror Al Buscar La Orden De Prestamo: \n" + e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenPrestamo.buscarTodasOrdenesPrestamo(): " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return ordenesPrestamo;
    }

    // FUNCION NUMERO 3.2
    public List<Ordenprestamo> buscarOrdenprestamoNombreE (String nombre) {
        OrdenprestamoJpaController servicio = new OrdenprestamoJpaController(emf);
        List<Ordenprestamo> Ordenprestamos  = new ArrayList<>();
        try {
            emt.begin();
            Ordenprestamos = servicio.buscarOrdenprestamoNombreE(nombre);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar La Orden De Compra\n" + e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenCompra.buscarOrdenprestamoNombreE(): " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return Ordenprestamos;
    }
    
    // FUNCION NUMERO 3.3
    public List<Ordenprestamo> buscarOrdenprestamoNombreC (String nombre) {
        OrdenprestamoJpaController servicio = new OrdenprestamoJpaController(emf);
        List<Ordenprestamo> Ordenprestamos  = new ArrayList<>();
        try {
            emt.begin();
            Ordenprestamos = servicio.buscarOrdenprestamoNombreC(nombre);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar La Orden De Compra\n" + e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenCompra.buscarOrdenprestamoNombreC(): " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return Ordenprestamos;
    }
    
    // FUNCION NUMERO 3.4
    public List<Ordenprestamo> buscarOrdenprestamoRangoFecha (Date fi, Date ff) {
        OrdenprestamoJpaController servicio = new OrdenprestamoJpaController(emf);
        List<Ordenprestamo> Ordenprestamos  = new ArrayList<>();
        try {
            emt.begin();
            Ordenprestamos = servicio.buscarRangoFecha(fi,ff);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar La Orden De Compra\n" + e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenCompra.buscarOrdenprestamoRangoFecha(): " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return Ordenprestamos;
    }

    public List<Ordenprestamo> buscarOrdenPrestamoFechaEntrega(Date fechaEntrega) {
        OrdenprestamoJpaController servicio = new OrdenprestamoJpaController(emf);
        List<Ordenprestamo> ordenPrestamo = new ArrayList<>();
        try {
            emt.begin();
            ordenPrestamo = servicio.buscarOrdenPrestamoFechaEntrega(fechaEntrega);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Eror Al Buscar La Orden De Prestamo: \n" + e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenPrestamo.buscarOrdenesPrestamoFechaEntrega(): " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return ordenPrestamo;
    }

    public void close() {
        em.close();
        emf.close();
    }
}
