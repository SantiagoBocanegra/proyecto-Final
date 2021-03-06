/*
METODOS PARA CONTROLAR LA BASE DE DATOS 
FUNCIONES DE LA CLASE MC_OrdenItemPrestamo    
    1-INSERTAR NUEVA ORDEN ITEM PRESTAMO
    2-EDITAR ORDEN ITEM PRESTAMO
    3-BUSCAR ORDEN ITEM DE PRESTAMO POR OrdenItemPrestamoPK
    3.1-BUSCAR  TODAS LAS ORDENES DE ITEM DE PRESTAMO 
*/
package MODELO_CONTROLADOR;

import CONTROLADOR.OrdenitemprestamoJpaController;
import MODELO.Ordenitemprestamo;
import MODELO.OrdenitemprestamoPK;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class MC_OrdenItemPrestamo {
    
    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private EntityTransaction emt = null;
    
    public MC_OrdenItemPrestamo () {
        emf = Persistence.createEntityManagerFactory("Control-Ventas-LibreriaPU");
        em = emf.createEntityManager();
        emt = em.getTransaction();
    }
    
    //FUNCION NUMERO 1
    public boolean nuevaOrdenItemPrestamo (Ordenitemprestamo ordenItemPrestamo) {
        OrdenitemprestamoJpaController servicio = new OrdenitemprestamoJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.create(ordenItemPrestamo);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Eror Al Guardar El item Orden De Prestamo: \n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenItemPrestamo.nuevaOrdenItemPrestamo(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return estado;
    }
    
    //FUNCION NUMERO 2
    public boolean editarOrdenItemPrestamo (Ordenitemprestamo ordenItemPrestamo) {
        OrdenitemprestamoJpaController servicio = new OrdenitemprestamoJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.edit(ordenItemPrestamo);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Eror Al Editar El item Orden De Prestamo: \n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenItemPrestamo.editarOrdenItemPrestamo(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return estado;
    }
    
    //FUNCION NUMERO 3
    public Ordenitemprestamo busacarOrdenItemPrestamo (OrdenitemprestamoPK ordenItemPrestamoPK) {
        OrdenitemprestamoJpaController servicio = new OrdenitemprestamoJpaController(emf);
        Ordenitemprestamo ordenItemPrestamo = new Ordenitemprestamo();
        try {
            emt.begin();
            ordenItemPrestamo = servicio.findOrdenitemprestamo(ordenItemPrestamoPK);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Eror Al Buscar El item Orden De Prestamo: \n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenItemPrestamo.buscarOrdenItemPrestamo(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return ordenItemPrestamo;
    }
    
    //FUNCION NUMERO 3.1
    public List<Ordenitemprestamo> buscarTodasOrdenesItemPrestamo () {
        OrdenitemprestamoJpaController servicio = new OrdenitemprestamoJpaController(emf);
        List<Ordenitemprestamo> ordenesItemPrestamo = new ArrayList<>();
        try {
            emt.begin();
            ordenesItemPrestamo = servicio.findOrdenitemprestamoEntities();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Eror Al Buscar El item Orden De Prestamo: \n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenItemPrestamo.buscarTodasOrdenesItemPrestamo(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return ordenesItemPrestamo;
    }
    
    //Funcione numero 4
    public List<Ordenitemprestamo> buscarOrdenItemNumeroOrden (int itemNumeroOrden) {
        List<Ordenitemprestamo> ordenItem = new ArrayList<>();
        OrdenitemprestamoJpaController controlador = new OrdenitemprestamoJpaController(emf);
        try {
            emt.begin();
            ordenItem = controlador.buscarOrdenItemNumeroOrden(itemNumeroOrden);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error MC_Ordenitemprestamo.buscarOrdenItemNumeroOrden(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return ordenItem;
    }
}
