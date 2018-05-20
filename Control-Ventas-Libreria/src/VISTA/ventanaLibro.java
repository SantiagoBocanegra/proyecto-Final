/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import MODELO.Libro;
import MODELO_CONTROLADOR.MC_Libro;
import MODELO_CONTROLADOR.funciones;
import com.toedter.calendar.JCalendar;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ayenni42
 */
public class ventanaLibro extends javax.swing.JDialog {

    /**
     * Funciones de la clase obtenerElementos -> obtener los Elementos de la
     * caja de texto de la ventana y almacenarlo en la variable global (libro)
     * de la clase mostrarElementos -> mostrar informacion del libro en las
     * cajas de texto de la ventana balidando si estan vacias.
     */
    //Almacernar la imagen que se carga desde el metodo funciones.cargarImagen()
    FileInputStream portadaLibro;
    //Arreglo de byte que se alamcena en la base de datos
    byte portadaLibroByte[];
    //Comprobar que una imagen se cargo desde funciones.cargarImagen()
    boolean estadoPortada;
    //Alamacenar informacion del libro otbtenida en las cajas de texto 
    Libro libro;
    //Comprobar que el usuario si aya ingresado el isbn del libro 
    int caso = 0;

    public ventanaLibro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(610, 527);
        estadoPortada = false;
        JCalendar calendario = entFechaPublicacion.getJCalendar();
        calendario.setWeekOfYearVisible(false);
        calendario.setMaxDayCharacters(2);
        barraProgreso.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        portada = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        entIsbn = new javax.swing.JTextField();
        entTitulo = new javax.swing.JTextField();
        entAutor = new javax.swing.JTextField();
        entEditorial = new javax.swing.JTextField();
        entCantidadInventario = new javax.swing.JTextField();
        entPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        entSipnosis = new javax.swing.JTextArea();
        entFechaPublicacion = new com.toedter.calendar.JDateChooser();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSubir = new javax.swing.JButton();
        barraProgreso = new javax.swing.JProgressBar();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        entGeneros = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 255)));
        jPanel1.setLayout(null);

        portada.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 255)));
        jPanel1.add(portada);
        portada.setBounds(4, 4, 217, 327);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Informacion De Libro");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(290, 4, 220, 30);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(225, 20, 60, 2);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(505, 20, 75, 2);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(220, 35, 360, 2);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Precio");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(390, 370, 60, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Isbn");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(300, 45, 31, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Titulo");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(230, 80, 50, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Sipnosis");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(380, 150, 70, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Autor");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(305, 115, 50, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Editorial");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 336, 70, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Fecha Publicacion");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(290, 336, 140, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Cantidad En Inventario");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 371, 170, 30);

        entIsbn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entIsbn);
        entIsbn.setBounds(335, 45, 150, 30);

        entTitulo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entTitulo);
        entTitulo.setBounds(285, 80, 295, 30);

        entAutor.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entAutor);
        entAutor.setBounds(360, 115, 220, 30);

        entEditorial.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entEditorial);
        entEditorial.setBounds(85, 336, 200, 30);

        entCantidadInventario.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entCantidadInventario);
        entCantidadInventario.setBounds(185, 371, 200, 30);

        entPrecio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entPrecio);
        entPrecio.setBounds(445, 371, 130, 30);

        entSipnosis.setColumns(20);
        entSipnosis.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        entSipnosis.setRows(5);
        jScrollPane1.setViewportView(entSipnosis);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(230, 190, 350, 140);

        entFechaPublicacion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(entFechaPublicacion);
        entFechaPublicacion.setBounds(430, 336, 145, 30);

        btnGuardar.setText("Guar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(505, 406, 70, 70);

        btnEditar.setText("Edit");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar);
        btnEditar.setBounds(425, 406, 70, 70);

        btnSubir.setText("Subir");
        btnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubir);
        btnSubir.setBounds(230, 115, 70, 70);
        jPanel1.add(barraProgreso);
        barraProgreso.setBounds(10, 440, 410, 30);
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(305, 165, 65, 2);
        jPanel1.add(jSeparator5);
        jSeparator5.setBounds(445, 165, 135, 2);

        entGeneros.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entGeneros);
        entGeneros.setBounds(85, 406, 300, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Generos");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 406, 70, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(4, 4, 585, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirActionPerformed
        portadaLibro = funciones.cargarImagen(portada);
        estadoPortada = true;
    }//GEN-LAST:event_btnSubirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        libro = new Libro();
        obtenerElementos();

        switch (caso) {
            case 0:
                if (JOptionPane.showConfirmDialog(this, "Guardar Libro", "Escudo", 1, 3, null) == 0) {
                    MC_Libro control = new MC_Libro();
                    if (control.nuevoLibro(libro)) {
                        JOptionPane.showMessageDialog(this, "Libro Guardado", "Informacion", 1, null);
                    }
                }
                break;
            case 1:
                JOptionPane.showMessageDialog(this, "Isbn Obligatorio ", "Error", 0, null);
                caso = 0;
                break;
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        obtenerElementos();
        if (JOptionPane.showConfirmDialog(this, "Editar Libro", "Escudo", 1, 3, null) == 0) {
            MC_Libro control = new MC_Libro();
            if (control.nuevoLibro(libro)) {
                JOptionPane.showMessageDialog(this, "Libro Editado", "Informacion", 1, null);
            }
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    public void obtenerElementos() {
        if (entIsbn.getText() == null || entIsbn.getText().isEmpty() ) {
            caso = 1;
        } else {
            libro.setIsbn(Integer.parseInt(entIsbn.getText()));
        }
        if (estadoPortada) {
            portadaLibroByte = funciones.jpg_bytes(portadaLibro);
            libro.setPortada(portadaLibroByte);
            estadoPortada = false;
        }
        libro.setTitulo(entTitulo.getText());
        libro.setSipnosis(entSipnosis.getText());
        libro.setAutor(entAutor.getText());
        libro.setEditorial(entEditorial.getText());
        libro.setFechaPublicacion(entFechaPublicacion.getDate());
        libro.setEstadolibro(entCantidadInventario.getText());
        if (!entPrecio.getText().isEmpty() && entPrecio.getText() != null) {
            libro.setPrecio(Integer.parseInt(entPrecio.getText()));
        } else {
            libro.setPrecio(0);
        }
    }

    public void mostrarElementos(Libro libro) {
        if (libro != null) {
            entIsbn.setText(String.valueOf(libro.getIsbn()));
            if (libro.getPortada() != null && libro.getPortada().length > 0) {
                portadaLibroByte = libro.getPortada();
                portada.setIcon(new ImageIcon(funciones.byte_jpg(portadaLibroByte)));
            }
            if (libro.getTitulo() == null || libro.getTitulo().isEmpty()) {
                entTitulo.setText("Sin Nombre");
            } else {
                entTitulo.setText(libro.getTitulo());
            }
            if (libro.getSipnosis() == null || libro.getSipnosis().isEmpty() ) {
                entSipnosis.setText("Sin Sipnosis");
            } else {
                entSipnosis.setText(libro.getSipnosis());
            }
            if (libro.getAutor() == null || libro.getAutor().isEmpty()) {
                entAutor.setText("Sin Autor");
            } else {
                entAutor.setText(libro.getAutor());
            }
            if (libro.getEditorial() == null || libro.getEditorial().isEmpty()) {
                entEditorial.setText("Sin Editorial");
            } else {
                entEditorial.setText(libro.getEditorial());
            }
            if (libro.getFechaPublicacion() != null) {
                entFechaPublicacion.setDate(libro.getFechaPublicacion());
            }
            if (libro.getEstadolibro() == null || libro.getEstadolibro().isEmpty()) {
                entCantidadInventario.setText("0");
            } else {
                entCantidadInventario.setText(libro.getEstadolibro());
            }
            if (libro.getPrecio() < 0) {
                entPrecio.setText("0");
            } else {
                entPrecio.setText(String.valueOf(libro.getPrecio()));
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se Encontro Ningun Libro", "Informacion", 1, null);
        }
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventanaLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventanaLibro dialog = new ventanaLibro(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSubir;
    private javax.swing.JTextField entAutor;
    private javax.swing.JTextField entCantidadInventario;
    private javax.swing.JTextField entEditorial;
    private com.toedter.calendar.JDateChooser entFechaPublicacion;
    private javax.swing.JTextField entGeneros;
    private javax.swing.JTextField entIsbn;
    private javax.swing.JTextField entPrecio;
    private javax.swing.JTextArea entSipnosis;
    private javax.swing.JTextField entTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel portada;
    // End of variables declaration//GEN-END:variables
}
