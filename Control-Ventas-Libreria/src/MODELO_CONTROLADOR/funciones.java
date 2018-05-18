
package MODELO_CONTROLADOR;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *                              funciones de esta clase
 * 1 fecha -> retorna la fecha actual del sistema 
 * 2 jpg_bytes -> Convertir una imagen en un arreglo de bytes
 * 3 bytes -> jpg -> Convertir un arreglo de bytes en imagen 
 * 4 cargarImagen -> Cargar una imagen de el pc
 * 5 sumarRestarFecha -> sumar o restar dias de la fecha actual
 */
public class funciones {
    
    //Funciones Numero 1
    public static Date fecha() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyy/MM/dd");
        String fechaS = formatoFecha.format(fecha);
        try {
            fecha = formatoFecha.parse(fechaS);
        } catch (ParseException ex) {
            System.out.println("ERROR funciones.fecha: " + ex.getMessage());
        }
        return fecha;
    }
    
    //Funciones Numero 2
    public static byte[] jpg_bytes(FileInputStream imagen) {
        byte[] arreglo = null;
        try {
            arreglo = new byte[imagen.available()];
            imagen.read(arreglo);
            imagen.close();
        } catch (Exception e) {
            System.out.print("ERROR funciones.jpg_bytes:  " + e.getMessage());
        }
        return arreglo;
    }
    
    //Funciones Numero 3
    public static Image byte_jpg(byte[] arreglo) {
        Image imagen = null;
        try {
            BufferedImage bufer = ImageIO.read(new ByteArrayInputStream(arreglo));
            ImageIcon imagenI = new ImageIcon(bufer);
            imagen = imagenI.getImage(); 
        } catch (Exception e) {
            System.out.println("ERROR funciones.byte_jpg: " + e.getMessage());
        }
        return imagen;
    }
    
    //Funciones Numero 4
    public static  FileInputStream cargarImagen (JLabel cuadro) {
        FileInputStream imagenCargada = null;
        JFileChooser seleccionar = new JFileChooser();
        seleccionar.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = seleccionar.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                imagenCargada = new FileInputStream(seleccionar.getSelectedFile());
                Image icon = ImageIO.read(seleccionar.getSelectedFile()).getScaledInstance(cuadro.getWidth(), cuadro.getHeight(), Image.SCALE_DEFAULT);
                cuadro.setIcon(new ImageIcon(icon));
                cuadro.updateUI();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,"ERROR funciones.cargarImagen: \n" + e.getMessage(),"Error",0,null);
            }
        }
        return imagenCargada;
    }
    
    //Funciones numero 5
    public static Date sumarRestaFecha( int año, int mes, int dia) {
        Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, dia);
            cal.add(Calendar.MONTH, mes);
            cal.add(Calendar.YEAR, año);
        return cal.getTime();
    }
}
