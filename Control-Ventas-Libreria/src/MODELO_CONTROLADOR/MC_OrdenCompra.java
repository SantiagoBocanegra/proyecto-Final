/*
METODOS PARA CONTROLAR LA BASE DE DATOS 
FUNCIONES DE LA CLASE MC_OrdenCompra   
    1-INSERTAR NUEVA ORDEN DE COMPRA
    2-EDITAR ORDEN DE COMPRA
    3-BUSCAR ORDEN DE COMPRA POR NUMERO  DE ORDEN 
    3.1-BUSCAR  TODAS LAS ORDENES DE COMPRA
 */
package MODELO_CONTROLADOR;

import CONTROLADOR.OrdencompraJpaController;
import MODELO.Ordencompra;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class MC_OrdenCompra {

    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private EntityTransaction emt = null;

    public MC_OrdenCompra() {
        emf = Persistence.createEntityManagerFactory("Control-Ventas-LibreriaPU");
        em = emf.createEntityManager();
        emt = em.getTransaction();
    }

    //FUNCION NUMERO 1
    public boolean nuevaOrdenCompra(Ordencompra ordenCompra) {
        OrdencompraJpaController servicio = new OrdencompraJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.create(ordenCompra);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Guardar La Orden De Compra\n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenCompra.nuevaOrdenCompra(): " + e.getMessage());
        } 
        return estado;
    }

    //FUNCION NUMERO 2
    public boolean editarOrdenCompra(Ordencompra ordenCompra) {
        OrdencompraJpaController servicio = new OrdencompraJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.edit(ordenCompra);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Editar La Orden De Compra\n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenCompra.EditarOrdenCompra(): " + e.getMessage());
        }
        return estado;
    }

    //FUNCION NUMERO 3
    public Ordencompra buscarOrdenCompra(int numeroOrdenCompra) {
        OrdencompraJpaController servicio = new OrdencompraJpaController(emf);
        Ordencompra ordenCompra = new Ordencompra();
        try {
            emt.begin();
            ordenCompra = servicio.findOrdencompra(numeroOrdenCompra);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar La Orden De Compra\n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenCompra.buscarOrdenCompra(): " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return ordenCompra;
    }

    //FUNCION NUMERO 3.1
    public List<Ordencompra> buscarTodasOrdenesCompra() {
        OrdencompraJpaController servicio = new OrdencompraJpaController(emf);
        List<Ordencompra> ordenesCompra = new ArrayList<>();
        try {
            emt.begin();
            ordenesCompra = servicio.findOrdencompraEntities();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar La Orden De Compra\n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenCompra.buscarTodasOrdenesCompra(): " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return ordenesCompra;
    }
    
    //FUNCION NUMERO 4
    public boolean borrarOrdenCompra(int numeroOrdenCompra) {
        OrdencompraJpaController servicio = new OrdencompraJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.destroy(numeroOrdenCompra);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            estado =  false;
            JOptionPane.showMessageDialog(null, "Error Al Borrar La Orden De Compra\n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenCompra.borrarOrdenCompra(): " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return estado;
    }
    
    public void close () {
        em.close();
        emf.close();
    }
}
