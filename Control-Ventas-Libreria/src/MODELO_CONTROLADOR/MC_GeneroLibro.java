/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO_CONTROLADOR;

import CONTROLADOR.GeneroLibroJpaController;
import MODELO.GeneroLibro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author ayenni42
 */
public class MC_GeneroLibro {
    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private EntityTransaction emt = null;
    
    public MC_GeneroLibro () {
        emf = Persistence.createEntityManagerFactory("Control-Ventas-LibreriaPU");
        em = emf.createEntityManager();
        emt = em.getTransaction();
    }
    
    public boolean nuevoGeneroLibro (GeneroLibro generoLibro) {
         GeneroLibroJpaController servicio =  new GeneroLibroJpaController(emf);
         boolean estado = true;
         try {
             emt.begin();
             servicio.create(generoLibro);
             emt.commit();
         } catch (Exception e) {
             estado = false;
             emt.rollback();
             System.out.println("Error MC_GeneroLibro.nuevoGeneroLibro(): "+e.getMessage());
         } 
         return estado;
    }
    
    public boolean editarGeneroLibro (GeneroLibro generoLibro) {
        GeneroLibroJpaController servicio = new  GeneroLibroJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.edit(generoLibro);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            System.out.println("Error MC_GeneroLibro.editarGeneroLibro(): "+e.getMessage());
        } 
        return estado;
    }
    
    public List<GeneroLibro> buscarGeneroLibroIsbn (int libroIsbn) {
        GeneroLibroJpaController servicio = new GeneroLibroJpaController(emf);
        List<GeneroLibro> generosLibro = new ArrayList<>();
        try {
            emt.begin();
            generosLibro = servicio.buscarGeneroLibroIsbn(libroIsbn);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            System.out.println("Error MC_GeneroLibro.buscarGeneroLibroIsbn(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return generosLibro;
    }
    
    public void close () {
        em.close();
        emf.close();
    }
}
