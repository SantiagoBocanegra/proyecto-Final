/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO_CONTROLADOR;


import javax.swing.JProgressBar;

/**
 *
 * @author ayenni42
 */
public class cargarBarra extends Thread {

    JProgressBar barraProgreso;
    int tiempoEjecucion = 100;

    public JProgressBar getBarraProgreso() {
        return barraProgreso;
    }

    public void setBarraProgreso(JProgressBar barraProgreso) {
        this.barraProgreso = barraProgreso;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion() {
        this.tiempoEjecucion = 40;
    }

    @Override
    public void run() {
        barraProgreso.setVisible(true);
        for (int i = 0; i<100; i++){
            barraProgreso.setValue(i);
            try {
                sleep(tiempoEjecucion);
            } catch (InterruptedException e){
                e.getMessage();
            }
        }
        barraProgreso.setVisible(false);
    }
}
