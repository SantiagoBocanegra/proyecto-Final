/*
METODOS PARA CONTROLAR LA BASE DE DATOS 
FUNCIONES DE LA CLASE MC_Libro  
    1-INSERTAR NUEVO LIBRO
    2-EDITAR LIBRO
    3-BUSCAR LIBRO POR ISBN
    3.1-BUSCAR  TODOS LOS LIBROS
*/
package MODELO_CONTROLADOR;

import CONTROLADOR.LibroJpaController;
import MODELO.Libro;
import java.util.ArrayList; 
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class MC_Libro {
    
    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private EntityTransaction emt = null;
    
    public MC_Libro (){
        emf = Persistence.createEntityManagerFactory("Control-Ventas-LibreriaPU");
        em = emf.createEntityManager();
        emt = em.getTransaction();
    }
    
    // FUNCION NUMERO 1
    public boolean nuevoLibro (Libro libro) {
        LibroJpaController servicio = new LibroJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.create(libro);
            emt.commit();
        }catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Guardar El Libro: \n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Libro.insertarLibro(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return estado;
    }
    
    // FUNCION NUMERO 2
    public boolean editarLibro (Libro libro) {
        LibroJpaController servicio = new LibroJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.edit(libro);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Editar El Libro: \n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Libro.editarLibro(): "+e.getMessage());
        }
        return estado;
    }
    
    // FUNCION NUMERO 3
    public Libro buscarLibro (int isbnLibro) {
        LibroJpaController servicio = new LibroJpaController(emf);
        Libro libro = new Libro();
        try {
            emt.begin();
            libro = servicio.findLibro(isbnLibro);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Libro: \n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Libro.buscarLibro(): "+e.getMessage());
        }finally {
            em.close();
            emf.close();
        }
        return libro;
    }
    
    // FUNCION NUMERO 3.1
    public List<Libro> buscarTodosLibros () {
       LibroJpaController servicio = new LibroJpaController(emf);
        List<Libro> libros = new ArrayList<>();
        try{
            emt.begin();
            libros = servicio.findLibroEntities();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Libro: \n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR: MC_Libro.buscarTodosLibros(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return libros;
    }
    
    // FUNCION NUMERO 3.2
    public List<Libro> buscarLibroTitulo (String titulo) {
       LibroJpaController servicio = new LibroJpaController(emf);
        List<Libro> Libros  = new ArrayList<>();
        try {
            emt.begin();
            Libros = servicio.buscarLibroTitulo(titulo);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Libro: \n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR: MC_Libro.buscarLibroTitulo(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return Libros;
    }
    
    // FUNCION NUMERO 3.3
    public List<Libro> buscarEmpleadoAutor (String autor) {
       LibroJpaController servicio = new LibroJpaController(emf);
        List<Libro> Libros  = new ArrayList<>();
        try {
            emt.begin();
            Libros = servicio.buscarLibroAutor(autor);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Libro: \n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR: MC_Libro.buscarEmpleadoAutor(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return Libros;
    }
    
    // FUNCION NUMERO 3.4
    public List<Libro> buscarLibroRangoPrecio (int pi, int pf) {
       LibroJpaController servicio = new LibroJpaController(emf);
        List<Libro> Libros  = new ArrayList<>();
        try {
            emt.begin();
            Libros = servicio.buscarRangoPrecio(pi,pf);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Libro: \n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR: MC_Libro.buscarLibroRangoPrecio (): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return Libros;
    }
    
    public void close () {
        em.close();
        emf.close();
    }
}
