/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO_CONTROLADOR;

import MODELO.Ordenprestamo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ayenni42
 */
public class procesosSegundario extends Thread {

    private Calendar fechaActual;
    private List<Ordenprestamo> ordenesPrestamo = new ArrayList<>();
    private int tiempo;

    public procesosSegundario() {
        //fechaActual = Calendar.getInstance();
        tiempo = 86400000; //24 horas
        this.isDaemon();
    }

    public void ordenPrestamoVencidas(Date fecha) {
        MC_OrdenPrestamo controlOrdenP = new MC_OrdenPrestamo();
        ordenesPrestamo = controlOrdenP.buscarOrdenPrestamoFechaEntrega(fecha);
        String ordenesVencidas = "";
        for (Ordenprestamo orden : ordenesPrestamo) {
            SimpleDateFormat formato = new SimpleDateFormat("yyy/MM/dd");
            String fechaEntrega = formato.format(orden.getFechaentrega());
            String numeroOrden = String.valueOf(orden.getNumeroorden());
            String idCliente = String.valueOf(orden.getClienteId().getId());
            String nombre = "Sin Nombre";
            if (orden.getClienteId().getNombre() != null && !orden.getClienteId().getNombre().isEmpty()) {
                nombre = orden.getClienteId().getNombre();
            }
            ordenesVencidas = "Numero Orden: " + numeroOrden
                    + " Id Cliente: " + idCliente
                    + " Nombre Cliente: " + nombre
                    + " Fecha: " + fechaEntrega
                    + ".\n"
                    + ordenesVencidas;
        }
        if (!ordenesPrestamo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ordenes De Prestamo Vencidas: \n" + ordenesVencidas, "Notificacion", 1, null);
        }
    }

    public void multasOrdenVencidas(int cantidadLibros, int valorMulta) {
        if (ordenesPrestamo != null && !ordenesPrestamo.isEmpty()) {
            MC_OrdenPrestamo controlOrden = new MC_OrdenPrestamo();
            for (Ordenprestamo ordenes : ordenesPrestamo) {
                int multa = cantidadLibros * valorMulta + ordenes.getMulta();
                ordenes.setMulta(multa);
                controlOrden.editarOrdenPrestamo(ordenes);

                alertaMensajeCliente(ordenes);
            }
            controlOrden.close();
        }
    }

    public void alertaMensajeCliente(Ordenprestamo orden) {
        if (orden.getClienteId() != null && orden.getClienteId().getCorreo() != null && !orden.getClienteId().getCorreo().isEmpty()) {
            String asunto = "Notificacion De Retraso Numero De Orden: " + orden.getNumeroorden();
            String mensajeEnviar = "Señor Usuario Usted Ha Cido Multado Por Demora En Entrega De Los Libros\n"
                    + "Valor De Multa : " + orden.getMulta();
            String correo = orden.getClienteId().getCorreo();
            if (!correo.equals("Sin Correo")) {
                Mail mensaje = new Mail();
                mensaje.enviarEmail("bocanegrasantiago18@gmail.com", "santiagobocanegra1998", correo, asunto, mensajeEnviar, false);
            }
        }
    }

    public Calendar getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Calendar fechaActual) {
        this.fechaActual = fechaActual;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        Date ultimaFechaEvaluada = funciones.sumarRestaFecha(0, 0, 1);
        while (true) {

            fechaActual = Calendar.getInstance();
            Date fechaEvaluar = fechaActual.getTime();
            if (ultimaFechaEvaluada.compareTo(fechaEvaluar) != 0) {

                ordenPrestamoVencidas(fechaEvaluar);

                int cantidad = ordenesPrestamo.size() - 1;
                multasOrdenVencidas(cantidad, 12000);

                ultimaFechaEvaluada = fechaEvaluar;
            }

            try {
                sleep(tiempo);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
    }
}
