/*
METODOS PARA CONTROLAR LA BASE DE DATOS 
FUNCIONES DE LA CLASE MC_OrdenItem    
    1-INSERTAR NUEVA ORDEN ITEM
    2-EDITAR ORDEN ITEM
    3-BUSCAR ORDEN ITEM POR OrdenItemPK
    3.1-BUSCAR  TODAS LAS ORDENES DE ITEM
*/
package MODELO_CONTROLADOR;

import CONTROLADOR.OrdenitemJpaController;
import MODELO.Ordenitem;
import MODELO.OrdenitemPK;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class MC_OrdenItem {
    
    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private EntityTransaction emt = null;
    
    public MC_OrdenItem () {
        emf = Persistence.createEntityManagerFactory("Control-Ventas-LibreriaPU");
        em = emf.createEntityManager();
        emt = em.getTransaction();
    }
    
    //FUNCION NUMERO 1
    public boolean nuevaOrdenItem (Ordenitem ordenItem) {
        OrdenitemJpaController servicio = new OrdenitemJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.create(ordenItem);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Guardar El Item De La Orden De Compra\n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenItem.nuevaOrdenItem(): "+e.getMessage());
        }
        return estado;
    }
    
     //FUNCION NUMERO 2
    public boolean editarOrdenItem (Ordenitem ordenItem) {
        OrdenitemJpaController servicio = new OrdenitemJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.edit(ordenItem);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Editar El Item De La Orden De Compra\n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenItem.editarOrdenItem(): "+e.getMessage());
        }  
        return estado;
    }
    
     //FUNCION NUMERO 3
    public Ordenitem buscarOrdenItem (OrdenitemPK ordenItemPK) {
        OrdenitemJpaController servicio = new OrdenitemJpaController(emf);
        Ordenitem ordenItem = new Ordenitem();
        try {
            emt.begin();
            ordenItem = servicio.findOrdenitem(ordenItemPK);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Item De La Orden De Compra\n"+e.getMessage(), "Error", 0, null);
            System.err.println("ERROR MC_OrdenItem.buscarOrdenItem(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        } 
        return ordenItem;
    }
    
     //FUNCION NUMERO 3.1
    public List<Ordenitem> buscarTodasOrdenItem () {
        OrdenitemJpaController servicio = new OrdenitemJpaController(emf);
        List<Ordenitem> ordenesItem = new ArrayList<>();
        try {
            emt.begin();
            ordenesItem = servicio.findOrdenitemEntities();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Item De La Orden De Compra\n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_OrdenItem.buscarTodasOrdenItem(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        } 
        return ordenesItem;
    }
    
    
    public void close () {
        em.close();
        emf.close();
    }
}
