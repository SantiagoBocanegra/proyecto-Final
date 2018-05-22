/*
                                            funciones de la clase VentanaCliente
obtenerElementosVentana -> obtiene los elementos de los campos de la ventana y devuelve un objeto cliente
mostrarDatosVentana -> recibe un objeto cliente y llena los campos de la ventana
 */
package VISTA;

import MODELO.Cliente;
import MODELO_CONTROLADOR.MC_Cliente;
import MODELO_CONTROLADOR.funciones;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author ayenni42
 */
public class ventanaCliente extends javax.swing.JDialog {

    /**
     * Creates new form ventanaCliente
     */
    private final String nombreTabla = "Cliente";
    private Cliente cliente;

    public ventanaCliente(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        entId.setEditable(false);
        JCalendar calendario = entFecha.getJCalendar();
        calendario.setWeekOfYearVisible(false);
        calendario.setMaxDayCharacters(2);
        entFecha.setDate(funciones.fecha());
        barraProgreso.setVisible(false);
    }

    public void obtenerElementosVentana() {
        cliente.setNombre(entPrimerNombre.getText());
        cliente.setSegundoNombre(entSegundoNombre.getText());
        cliente.setApellidoPaterno(entApellidoPaterno.getText());
        cliente.setApellidoMaterno(entApellidoMaterno.getText());
        cliente.setCedula(entCedula.getText());
        cliente.setPais(entPais.getText());
        cliente.setCiudad(entCiudad.getText());
        cliente.setDireccion(entDireccion.getText());
        cliente.setTelefono(entTelefono.getText());
        cliente.setCorreo(entCorreo.getText());
        cliente.setFechaRegistro(entFecha.getDate());
    }

    public void mostrarDatosVentana(Cliente cliente) {
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
            if  (cliente.getFechaRegistro() != null ) {
                entFecha.setDate(cliente.getFechaRegistro());
            }
            if (cliente.getDireccion() == null || cliente.getDireccion().isEmpty()) {
                entDireccion.setText("Sin Direccion");
            } else {
                entDireccion.setText(cliente.getDireccion());
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Se Encontro Ningun Cliente", "Informacion", 1, null);
        }
    }
    
    public void limpiar() {
        entId.setText(" ");
        entPrimerNombre.setText(" ");
        entSegundoNombre.setText(" ");
        entApellidoPaterno.setText(" ");
        entApellidoMaterno.setText(" ");
        entCedula.setText(" ");
        entCiudad.setText(" ");
        entCorreo.setText(" ");
        entDireccion.setText(" ");
        entFecha.setDate(null);
        entPais.setText("");
        entTelefono.setText(" ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        entFecha = new com.toedter.calendar.JDateChooser();
        barraProgreso = new javax.swing.JProgressBar();
        btnGuargar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        jLabel7.setFont(new java.awt.Font("Bodoni MT Black", 0, 14)); // NOI18N
        jLabel7.setText("SEGUNDO NOMBRE");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 255)));
        jPanel1.setLayout(null);

        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 255)));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(4, 4, 165, 215);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Id");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(230, 13, 15, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Primer Nombre");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(174, 48, 113, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Apellido Paterno");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(174, 118, 120, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Apellido Materno");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(174, 152, 140, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Segundo Nombre");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(174, 83, 126, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Cedula");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(174, 187, 50, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Direccion");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(250, 227, 69, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Pais");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 227, 30, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Telefono");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(250, 262, 100, 30);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Correo");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(10, 297, 50, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Fecha Registro");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(10, 332, 107, 30);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Ciudad");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(10, 262, 51, 30);

        entId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        entId.setEnabled(false);
        jPanel1.add(entId);
        entId.setBounds(260, 13, 150, 30);

        entPrimerNombre.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entPrimerNombre);
        entPrimerNombre.setBounds(310, 48, 250, 30);

        entSegundoNombre.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entSegundoNombre);
        entSegundoNombre.setBounds(310, 82, 250, 30);

        entApellidoPaterno.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entApellidoPaterno);
        entApellidoPaterno.setBounds(310, 118, 250, 30);

        entApellidoMaterno.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entApellidoMaterno);
        entApellidoMaterno.setBounds(310, 152, 250, 30);

        entCedula.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entCedula);
        entCedula.setBounds(235, 187, 200, 30);

        entDireccion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entDireccion);
        entDireccion.setBounds(325, 227, 235, 30);

        entTelefono.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entTelefono);
        entTelefono.setBounds(325, 262, 235, 30);

        entCorreo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entCorreo);
        entCorreo.setBounds(65, 297, 495, 30);

        entCiudad.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entCiudad);
        entCiudad.setBounds(65, 262, 180, 30);

        entPais.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entPais);
        entPais.setBounds(65, 227, 180, 30);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(4, 222, 565, 10);

        entFecha.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(entFecha);
        entFecha.setBounds(120, 332, 200, 30);
        jPanel1.add(barraProgreso);
        barraProgreso.setBounds(10, 372, 400, 30);

        btnGuargar.setText("GUAR");
        btnGuargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuargarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuargar);
        btnGuargar.setBounds(495, 332, 70, 70);

        btnEditar.setText("EDIT");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar);
        btnEditar.setBounds(420, 332, 70, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuargarActionPerformed
        cliente = new Cliente();
        obtenerElementosVentana();
        if (JOptionPane.showConfirmDialog(this, "Guardar Cliente", "Alerta", 1, 2, null) == 0) {
            MC_Cliente control = new MC_Cliente();
            if (control.nuevoCliente(cliente)) {
                JOptionPane.showMessageDialog(this, "Cliente Guardado Con Exito", "Informacion", 1, null);
                limpiar();
            }
        }
    }//GEN-LAST:event_btnGuargarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        obtenerElementosVentana();

        if (JOptionPane.showConfirmDialog(this, "Editar Cliente", "Alerta", 1, 2, null) == 0) {
            MC_Cliente control = new MC_Cliente();
            if (control.editarCliente(cliente)) {
                JOptionPane.showMessageDialog(this, "Cliente Editado Con Exito", "Informacion", 1, null);
                limpiar();
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
            java.util.logging.Logger.getLogger(ventanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventanaCliente dialog = new ventanaCliente(new javax.swing.JDialog(), true);
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
    public javax.swing.JButton btnGuargar;
    private javax.swing.JTextField entApellidoMaterno;
    private javax.swing.JTextField entApellidoPaterno;
    private javax.swing.JTextField entCedula;
    private javax.swing.JTextField entCiudad;
    private javax.swing.JTextField entCorreo;
    private javax.swing.JTextField entDireccion;
    public com.toedter.calendar.JDateChooser entFecha;
    private javax.swing.JTextField entId;
    private javax.swing.JTextField entPais;
    private javax.swing.JTextField entPrimerNombre;
    private javax.swing.JTextField entSegundoNombre;
    private javax.swing.JTextField entTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    // End of variables declaration//GEN-END:variables
}
