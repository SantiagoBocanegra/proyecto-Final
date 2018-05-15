/*
 funciones de esta clase
1 fecha -> retorna la fecha actual del sistema 
 */
package MODELO_CONTROLADOR;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author ayenni42
 */
public class funciones {
    //OBTENER LA FECHA ACTUAL 
    public static Date fecha() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyy/MM/dd");
        String fechaS = formatoFecha.format(fecha);
        try {
            fecha = formatoFecha.parse(fechaS);
        } catch (ParseException ex) {
            System.out.println("ERROR funciones.fecha: \n" + ex.getMessage());
        }
        return fecha;
    }
    
    // CONVERTIR UN VECTOR DE BYTEA A UNA IMAGEN
    public static Image byte_jpg(byte[] arreglo) {
        Image imagen = null;
        try {
            BufferedImage bufer = ImageIO.read(new ByteArrayInputStream(arreglo));
            ImageIcon imagenI = new ImageIcon(bufer);
            imagen = imagenI.getImage(); //getScaledInstance(100, 100,java.awt.Image.SCALE_SMOOTH);
        } catch (Exception e) {
            System.out.println("ERROR funciones.byte_jpg: \n" + e.getMessage());
        }
        return imagen;
    }
}
