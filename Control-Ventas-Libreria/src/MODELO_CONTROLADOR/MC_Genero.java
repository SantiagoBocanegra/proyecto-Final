/*
METODOS PARA CONTROLAR LA BASE DE DATOS 
FUNCIONES DE LA CLASE MC_Genero    
    1-INSERTAR NUEVO GENERO
    2-EDITAR GENERO
    3-BUSCAR GENERO POR ID
    3.1-BUSCAR  TODOS LOS GENEROS
*/
package MODELO_CONTROLADOR;

import CONTROLADOR.GeneroJpaController;
import MODELO.Genero;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MC_Genero {
     private EntityManagerFactory emf = null;
     private EntityManager em = null;
     private EntityTransaction emt = null;
     
     public MC_Genero () {
         emf = Persistence.createEntityManagerFactory("Control-Ventas-LibreriaPU");
         em = emf.createEntityManager();
         emt = em.getTransaction();
     }
     
     //FUNCION NUMERO 1
     public boolean nuevoGenero (Genero genero) {
         GeneroJpaController servicio = new GeneroJpaController(emf);
         boolean estado = true;
         try {
             emt.begin();
             servicio.create(genero);
             emt.commit();
         } catch (Exception e) {
             estado = false;
             emt.rollback();
             System.err.print("ERROR MC_Genero.nuevoGenero(): "+e.getMessage());
         } finally {
             em.close();
             emf.close();
         }
         return estado;
     }
     
     //FUNCION NUMERO 2
     public boolean editarGenero (Genero genero) {
         GeneroJpaController servicio = new GeneroJpaController(emf);
         boolean estado = true;
         try {
             emt.begin();
             servicio.edit(genero);
             emt.commit();
         } catch (Exception e) {
             estado = false;
             emt.rollback();
             System.err.print("ERROR MC_Genero.editarGenero(): "+e.getMessage());
         } finally {
             em.close();
             emf.close();
         }
         return estado;
     }
     
     //FUNCION NUMERO 3
     public Genero buscarGenero (int idGenero) {
         GeneroJpaController servicio = new GeneroJpaController(emf);
         Genero genero = new Genero();
         try {
             emt.begin();
             genero = servicio.findGenero(idGenero);
             emt.commit();
         } catch (Exception e) {
             emt.rollback();
             System.err.print("ERROR MC_Genero.buscarGenero(): "+e.getMessage());
         } finally {
             em.close();
             emf.close();
         }
         return genero;
     }
     
     //FUNCION NUMERO 3.1
     public List<Genero> buscarTodosGeneros () {
         GeneroJpaController servicio = new GeneroJpaController(emf);
         List<Genero> generos = new  ArrayList<>();
         try {
             emt.begin();
             generos = servicio.findGeneroEntities();
             emt.commit();
         } catch (Exception e) {
             emt.rollback();
             System.err.print("ERROR MC_Genero.buscarTodosGeneros(): "+e.getMessage());
         } finally {
             em.close();
             emf.close();
         }
         return generos;
     }
}
