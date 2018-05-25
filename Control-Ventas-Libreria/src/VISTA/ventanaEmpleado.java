/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import MODELO.Empleado;
import MODELO_CONTROLADOR.MC_Empleado;
import MODELO_CONTROLADOR.funciones;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.Image;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ayenni42
 */
public class ventanaEmpleado extends javax.swing.JDialog {

    /**
     * Funciones de la clase obtenerElementos -> obtener los Elementos de la
     * caja de texto de la ventana y almacenarlo en la variable global
     * (empleado) de la clase mostrarElementos -> mostrar informacion del libro
     * en las cajas de texto de la ventana balidando si estan vacias.
     */
    private final String nombreTabla = "Empleado";
    //Almacenar imagen que se sube desde funciones.cargarImagen()
    FileInputStream fotoEmpleado;
    //Arreglo de byte almacenado en la base de datos
    byte fotoEntEmpleado[];
    //variable usada para almacenar la informacion obtenidad de las cajas de texto de la ventana
    Empleado empleado;
    //estadoFoto -> usada para saber si el usuario subio una foto desde  funciones.cargarImagen() 
    boolean estadoFoto;

    public ventanaEmpleado(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        estadoFoto = false;
        this.setSize(635, 578);
        entId.setBackground(Color.WHITE);
        JCalendar calendario = entFechaContrato.getJCalendar();
        calendario.setWeekOfYearVisible(false);
        calendario.setMaxDayCharacters(2);
        entFechaContrato.setDate(funciones.fecha());
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
        foto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        entId = new javax.swing.JTextField();
        entPrimerNombre = new javax.swing.JTextField();
        entSegundoNombre = new javax.swing.JTextField();
        entApellidoPaterno = new javax.swing.JTextField();
        entApellidoMaterno = new javax.swing.JTextField();
        entCedula = new javax.swing.JTextField();
        entDireccion = new javax.swing.JTextField();
        entTelefono = new javax.swing.JTextField();
        entCorreo = new javax.swing.JTextField();
        entCiudad = new javax.swing.JTextField();
        entPais = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        entFechaContrato = new com.toedter.calendar.JDateChooser();
        btnSubirFoto = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        entSalario = new javax.swing.JTextField();
        entCargo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        barraProgreso = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 255)));
        jPanel1.setLayout(null);

        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/fotoEmpleado.png"))); // NOI18N
        foto.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 255)));
        jPanel1.add(foto);
        foto.setBounds(5, 5, 200, 295);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("ID");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(320, 50, 19, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setText("Informacion Del Empleado");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(270, 5, 270, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Apellido Paterno");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(215, 155, 120, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Apellido Materno");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(215, 190, 130, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Segundo Nombre");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(215, 120, 126, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Cedula");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(290, 225, 60, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Direccion");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(285, 305, 80, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Pais");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(290, 270, 30, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Telefono");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(10, 340, 70, 30);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Correo");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(10, 410, 60, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Fecha Contrato");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(285, 340, 120, 30);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Ciudad");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(10, 305, 60, 30);

        entId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        entId.setEnabled(false);
        jPanel1.add(entId);
        entId.setBounds(350, 50, 150, 30);

        entPrimerNombre.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entPrimerNombre);
        entPrimerNombre.setBounds(350, 85, 250, 30);

        entSegundoNombre.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entSegundoNombre);
        entSegundoNombre.setBounds(350, 120, 250, 30);

        entApellidoPaterno.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entApellidoPaterno);
        entApellidoPaterno.setBounds(350, 155, 250, 30);

        entApellidoMaterno.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entApellidoMaterno);
        entApellidoMaterno.setBounds(350, 190, 250, 30);

        entCedula.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entCedula);
        entCedula.setBounds(350, 225, 250, 30);

        entDireccion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entDireccion);
        entDireccion.setBounds(355, 305, 245, 30);

        entTelefono.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entTelefono);
        entTelefono.setBounds(80, 340, 195, 30);

        entCorreo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entCorreo);
        entCorreo.setBounds(80, 410, 520, 30);

        entCiudad.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entCiudad);
        entCiudad.setBounds(80, 305, 200, 30);

        entPais.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entPais);
        entPais.setBounds(350, 270, 250, 30);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(285, 260, 320, 10);

        entFechaContrato.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(entFechaContrato);
        entFechaContrato.setBounds(405, 340, 190, 30);

        btnSubirFoto.setText("Subir");
        btnSubirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirFotoActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubirFoto);
        btnSubirFoto.setBounds(210, 230, 70, 70);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Salario");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(285, 375, 60, 30);

        entSalario.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entSalario);
        entSalario.setBounds(350, 375, 245, 30);

        entCargo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entCargo);
        entCargo.setBounds(80, 375, 200, 30);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Cargo");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(10, 375, 60, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Primer Nombre");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(215, 85, 120, 30);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(210, 20, 55, 2);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(540, 20, 65, 2);
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(210, 40, 395, 2);
        jPanel1.add(jSeparator5);
        jSeparator5.setBounds(210, 60, 100, 2);
        jPanel1.add(jSeparator6);
        jSeparator6.setBounds(510, 60, 95, 2);

        btnGuardar.setText("Guarda");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(530, 450, 70, 70);

        btnEditar.setText("Edit");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar);
        btnEditar.setBounds(455, 450, 70, 70);
        jPanel1.add(barraProgreso);
        barraProgreso.setBounds(10, 470, 440, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(4, 4, 610, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void obtenerElementos() {
        if (estadoFoto) {
            fotoEntEmpleado = funciones.jpg_bytes(fotoEmpleado);
            empleado.setFoto(fotoEntEmpleado);
            estadoFoto = false;
        }
        empleado.setNombre(entPrimerNombre.getText());
        empleado.setSegundoNombre(entSegundoNombre.getText());
        empleado.setApellidoPaterno(entApellidoPaterno.getText());
        empleado.setApellidoMaterno(entApellidoMaterno.getText());
        empleado.setCedula(entCedula.getText());
        empleado.setPais(entPais.getText());
        empleado.setCiudad(entCiudad.getText());
        empleado.setDireccion(entDireccion.getText());
        empleado.setTelefono(entTelefono.getText());
        empleado.setFechaContrato(entFechaContrato.getDate());
        empleado.setCargo(entCargo.getText());
        empleado.setCorreo(entCorreo.getText());
        if (!entSalario.getText().isEmpty()){
            empleado.setSalario(Integer.parseInt(entSalario.getText()));
        }else {
            empleado.setSalario(0);
        }
    }

    public void limpiar() {
        foto.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/fotoEmpleado.png")));
        entId.setText(" ");
        entPrimerNombre.setText(" ");
        entSegundoNombre.setText(" ");
        entApellidoPaterno.setText(" ");
        entApellidoMaterno.setText(" ");
        entCargo.setText(" ");
        entCedula.setText(" ");
        entCiudad.setText(" ");
        entCorreo.setText(" ");
        entDireccion.setText(" ");
        entFechaContrato.setDate(null);
        entPais.setText("");
        entSalario.setText(" ");
        entTelefono.setText(" ");
    }

    public void mostrarElementos(Empleado cliente) {
        if (cliente != null) {
            entId.setText(String.valueOf(cliente.getId()));
            if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
                entPrimerNombre.setText("Sin Priemer Nombre");
            } else {
                entPrimerNombre.setText(cliente.getNombre());
            }
            if (cliente.getSegundoNombre() == null || cliente.getSegundoNombre().isEmpty()) {
                entSegundoNombre.setText("Sin Segundo Nombre");
            } else {
                entSegundoNombre.setText(cliente.getSegundoNombre());
            }
            if (cliente.getApellidoPaterno() == null || cliente.getApellidoPaterno().isEmpty()) {
                entApellidoPaterno.setText("Sin Apellido Paterno");
            } else {
                entApellidoPaterno.setText(cliente.getApellidoPaterno());
            }
            if (cliente.getApellidoMaterno() == null || cliente.getApellidoMaterno().isEmpty()) {
                entApellidoMaterno.setText("Sin Apellido Materno");
            } else {
                entApellidoMaterno.setText(cliente.getApellidoMaterno());
            }
            if (cliente.getCedula() == null || cliente.getCedula().isEmpty()) {
                entCedula.setText("Sin cedula");
            } else {
                entCedula.setText(cliente.getCedula());
            }
            if (cliente.getPais() == null || cliente.getPais().isEmpty()) {
                entPais.setText("Sin Pais");
            } else {
                entPais.setText(cliente.getPais());
            }
            if (cliente.getCiudad() == null || cliente.getCiudad().isEmpty()) {
                entCiudad.setText("Sin Ciudad");
            } else {
                entCiudad.setText(cliente.getCiudad());
            }
            if (cliente.getCorreo() == null || cliente.getCorreo().isEmpty()) {
                entCorreo.setText("Sin Correo");
            } else {
                entCorreo.setText(cliente.getCorreo());
            }
            if (cliente.getTelefono() == null || cliente.getTelefono().isEmpty()) {
                entTelefono.setText("Sin Telefono");
            } else {
                entTelefono.setText(cliente.getTelefono());
            }
            if (cliente.getDireccion() == null || cliente.getDireccion().isEmpty()) {
                entDireccion.setText("Sin Direccion");
            } else {
                entDireccion.setText(cliente.getDireccion());
            }
            if (cliente.getFechaContrato() != null) {
                entFechaContrato.setDate(cliente.getFechaContrato());
            }
            if (cliente.getSalario() < 0) {
                entSalario.setText("0");
            } else {
                entSalario.setText(String.valueOf(cliente.getSalario()));
            }
            if (cliente.getFoto() != null && cliente.getFoto().length > 0) {
                foto.setIcon(new ImageIcon(funciones.byte_jpg(cliente.getFoto()).getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT)));
            }
            if (cliente.getCargo() == null || cliente.getCargo().isEmpty()) {
                entCargo.setText("Sin Cargo");
            } else {
                entCargo.setText(cliente.getCargo());
            }
        }  else {
            JOptionPane.showMessageDialog(this, "No Se Encontro Ningun Empleado", "Informacion", 1, null);
        }
    }

    private void btnSubirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirFotoActionPerformed
        fotoEmpleado = funciones.cargarImagen(foto);
        estadoFoto = true;
    }//GEN-LAST:event_btnSubirFotoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        MC_Empleado control = new MC_Empleado();
        empleado = new Empleado();
        obtenerElementos();
        if (JOptionPane.showConfirmDialog(this, "Guardar Empleado", "Alerta", 1, 2, null) == 0) {
            if (control.nuevoEmmpleado(empleado)) {
                foto.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/fotoEmpleado.png")));
                JOptionPane.showMessageDialog(this, "Empleado Guardado Con Exito", "Informacion", 1, null);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        MC_Empleado control = new MC_Empleado();
        obtenerElementos();

        if (JOptionPane.showConfirmDialog(this, "Editar Empleado", "Alerta", 1, 2, null) == 0) {
            if (control.editarEmpleado(empleado)) {
                JOptionPane.showMessageDialog(this, "Empleado Editado Con Exito", "Informacion", 1, null);
                foto.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/fotoEmpleado.png")));
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public FileInputStream getFotoEmpleado() {
        return fotoEmpleado;
    }

    public void setFotoEmpleado(FileInputStream fotoEmpleado) {
        this.fotoEmpleado = fotoEmpleado;
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
            java.util.logging.Logger.getLogger(ventanaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventanaEmpleado dialog = new ventanaEmpleado(new javax.swing.JDialog(), true);
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
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSubirFoto;
    private javax.swing.JTextField entApellidoMaterno;
    private javax.swing.JTextField entApellidoPaterno;
    private javax.swing.JTextField entCargo;
    private javax.swing.JTextField entCedula;
    private javax.swing.JTextField entCiudad;
    private javax.swing.JTextField entCorreo;
    private javax.swing.JTextField entDireccion;
    public com.toedter.calendar.JDateChooser entFechaContrato;
    private javax.swing.JTextField entId;
    private javax.swing.JTextField entPais;
    private javax.swing.JTextField entPrimerNombre;
    private javax.swing.JTextField entSalario;
    private javax.swing.JTextField entSegundoNombre;
    private javax.swing.JTextField entTelefono;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    // End of variables declaration//GEN-END:variables
}
