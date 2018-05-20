/*
METODOS PARA CONTROLAR LA BASE DE DATOS 
FUNCIONES DE LA CLASE MC_Usuario    
    1-INSERTAR NUEVO USUARIO
    2-EDITAR USUARIO
    3-BUSCAR USUARIO POR ID
    3.1-BUSCAR  TODOS LOS USUARIOS
*/
package MODELO_CONTROLADOR;

import CONTROLADOR.UsuarioJpaController;
import MODELO.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class MC_Usuario {
    private EntityManager em = null;
    private EntityManagerFactory emf = null;
    private EntityTransaction emt = null;
    
    public MC_Usuario () {
        emf = Persistence.createEntityManagerFactory("Control-Ventas-LibreriaPU");
        em = emf.createEntityManager();
        emt = em.getTransaction();
    }
    
    //FUNCION NUMERO 1
    public boolean nuevoUsuario (Usuario usuario) {
        UsuarioJpaController servicio = new UsuarioJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.create(usuario);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Guardar El Usuario: \n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Usuario.nuevoUsuario(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        } 
        return estado;
    } 
    
    //FUNCION NUMERO 2
    public boolean ediatrUsuario (Usuario usuario) {
        UsuarioJpaController servicio = new UsuarioJpaController(emf);
        boolean estado = true;
        try {
            emt.begin();
            servicio.edit(usuario);
            emt.commit();
        } catch (Exception e) {
            estado = false;
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Editar El Usuario: \n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Usuario.editarUsuario(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        } 
        return estado;
    }
    
    //FUNCION NUMERO 3
    public Usuario buscarUsuario (int idUsuario) {
        UsuarioJpaController servicio = new UsuarioJpaController(emf);
        Usuario usuario = new Usuario();
        try {
            emt.begin();
            usuario = servicio.findUsuario(idUsuario);
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Usuario: \n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Usuario.buscarUsuario(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        } 
        return usuario;
    }
    
    //FUNCION NUMERO 3.1
    public List<Usuario> buscarTodosUsuario () {
        UsuarioJpaController servicio = new UsuarioJpaController(emf);
        List<Usuario> usuarios = new ArrayList<>();
        try {
            emt.begin();
            usuarios = servicio.findUsuarioEntities();
            emt.commit();
        } catch (Exception e) {
            emt.rollback();
            JOptionPane.showMessageDialog(null, "Error Al Buscar El Usuario: \n"+e.getMessage(), "Error", 0, null);
            System.err.print("ERROR MC_Usuario.buscarTodosUsuario(): "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        } 
        return usuarios;
    }
}
