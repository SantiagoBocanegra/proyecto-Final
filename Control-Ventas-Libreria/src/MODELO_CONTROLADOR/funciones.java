/*
 funciones de esta clase
1 fecha -> retorna la fecha actual del sistema 
 */
package MODELO_CONTROLADOR;

import MODELO.Libro;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
