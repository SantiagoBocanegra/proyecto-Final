/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO_CONTROLADOR;

import MODELO.Libro;

/**
 *
 * @author ayenni42
 */
public class funciones {
    
    public static void main (String[] arg) {
        MC_Libro controlador = new MC_Libro();
        Libro libro = new Libro(1,null,"nuevo libro","sipnosis del libro nuvo","sin autor","sin editorial",null,"fisico",100.000);
        System.out.print("nuevo libro: "+controlador.nuevoLibro(libro));
    } 
}
