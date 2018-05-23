/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import MODELO.Empleado;
import MODELO.RolUsuario;
import MODELO.Usuario;
import MODELO_CONTROLADOR.MC_RolUsuario;
import MODELO_CONTROLADOR.MC_Usuario;
import MODELO_CONTROLADOR.funciones;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Funciones De La Clase ventanaUuario obtenerElementosVentana -> obtener los
 * String de las caja de texto de la ventana mostrarElementos -> poner
 * informacion de usuario en las cajas de texto de la ventana
 */
public class ventanaUsuario extends javax.swing.JDialog {

    //Informacion Obtenida De Un Empleado Desde Otra Ventana
    private Empleado empleado;
    /**
     * variable para identificar errores al momento de obtener los elementos de
     * la caja de texto 0 = no hay errores en los datos 1 = campos obligatoros
     * vacios 2 = confirmacion de contraseña incorrecta
     */
    private int caso = 0;
    //Variable usada para guardar la informacion obtenidad de las cajas de texto de la ventana 
    private Usuario usuario;
    //lista de roles que el usuario a creado
    private List<RolUsuario> rolesUsuario;
    // nombreTabla -> identifica  a la tabla usuario para validar permisos
    private final String nombreTabla = "Usuario";
    private int idRol;
    DefaultTableModel modelo;

    public ventanaUsuario(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        idRol = 0;
        modelo = (DefaultTableModel) tablaRol.getModel();
        entPimerNombre.setEditable(false);
        entApellidoPaterno.setEditable(false);;
        entCedula.setEditable(false);
        entEstadoUsuario.setSelected(true);
        this.setSize(620, 500);
    }

    public void limpiarTabla() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(modelo.getRowCount() - 1);
        }
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
        fotoEmpleado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRol = new javax.swing.JTable();
        entApellidoPaterno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        entCedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        entUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        entPimerNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        entEstadoUsuario = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        btnVer = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        entConfirmarContraseña = new javax.swing.JPasswordField();
        entContraseña = new javax.swing.JPasswordField();
        entIdRol = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuario");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 255)));
        jPanel1.setLayout(null);

        fotoEmpleado.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 255)));
        jPanel1.add(fotoEmpleado);
        fotoEmpleado.setBounds(4, 4, 165, 215);

        tablaRol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre Rol"
            }
        ));
        tablaRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaRol);
        if (tablaRol.getColumnModel().getColumnCount() > 0) {
            tablaRol.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(150, 319, 325, 45);

        entApellidoPaterno.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entApellidoPaterno);
        entApellidoPaterno.setBounds(295, 85, 285, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Estado Del Usuario");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 294, 150, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Apellido Paterno");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(170, 85, 120, 30);

        entCedula.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entCedula);
        entCedula.setBounds(295, 120, 285, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Cedula");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(205, 120, 60, 30);

        entUsuario.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entUsuario);
        entUsuario.setBounds(295, 180, 285, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Usuario");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(200, 180, 70, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Contraseña");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 224, 90, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Confirmar Contraseña");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 259, 170, 30);

        entPimerNombre.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entPimerNombre);
        entPimerNombre.setBounds(295, 50, 285, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Roles Del Usuario");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 329, 140, 30);

        entEstadoUsuario.setBackground(new java.awt.Color(204, 204, 204));
        entEstadoUsuario.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        entEstadoUsuario.setText("Activo");
        jPanel1.add(entEstadoUsuario);
        entEstadoUsuario.setBounds(180, 294, 80, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel10.setText("Informacion Del Empleado ");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(240, 15, 270, 30);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(173, 165, 420, 10);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Primer Nombre");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(170, 50, 120, 30);

        btnVer.setText("Ver");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        jPanel1.add(btnVer);
        btnVer.setBounds(530, 319, 50, 50);

        btnGuardar.setText("Guar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(515, 374, 70, 70);

        btnEditar.setText("Edit");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar);
        btnEditar.setBounds(440, 374, 70, 70);

        entConfirmarContraseña.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entConfirmarContraseña);
        entConfirmarContraseña.setBounds(180, 259, 400, 30);

        entContraseña.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entContraseña);
        entContraseña.setBounds(100, 224, 480, 30);

        entIdRol.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        entIdRol.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        entIdRol.setText("Id");
        jPanel1.add(entIdRol);
        entIdRol.setBounds(482, 335, 40, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Id Rol");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(480, 310, 50, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(3, 3, 599, 456);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        switch (caso) {
            case 0:
                MC_Usuario control = new MC_Usuario();
                usuario = new Usuario();
                obtenerElementosVentana();
                if (JOptionPane.showConfirmDialog(this, "Guardar Usuario", "Escudo", 1, 2, null) == 0) {
                    if (control.nuevoUsuario(usuario)) {
                        JOptionPane.showMessageDialog(this, "Registro De Usuario Exitoso ", "Informacion", 1, null);
                        this.setVisible(false);
                    }
                }
                break;
            case 1:
                JOptionPane.showMessageDialog(this, "Los Campos Usuario, Contraseña y  Confirmar Contraseña Son Obligatorios", "Error", 0, null);
                caso = 0;
                break;
            case 2:
                JOptionPane.showMessageDialog(this, "Confirmacion De Contraseña Incorrecta", "Error", 0, null);
                caso = 0;
                break;
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        switch (caso) {
            case 0:
                String contraseña = JOptionPane.showInputDialog(this, "Confirmar Contraseña");
                if (validarContraseña(contraseña, usuario)) {
                    MC_Usuario control = new MC_Usuario();
                    obtenerElementosVentana();
                    if (JOptionPane.showConfirmDialog(this, "Editar Usuario", "Escudo", 1, 2, null) == 0) {
                        if (control.ediatrUsuario(usuario)) {
                            JOptionPane.showMessageDialog(this, "Usuario Editado  Exitosamente ", "Informacion", 1, null);
                            this.setVisible(false);
                        }
                    }
                }
                break;
            case 1:
                JOptionPane.showMessageDialog(this, "Los Campos Usuario, Contraseña y  Confirmar Contraseña Son Obligatorios", "Error", 0, null);
                caso = 0;
                break;
            case 2:
                JOptionPane.showMessageDialog(this, "Confirmacion De Contraseña Incorrecta", "Error", 0, null);
                caso = 0;
                break;
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tablaRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRolMouseClicked
        idRol = Integer.parseInt(modelo.getValueAt(tablaRol.getSelectedRow(), 0).toString());
        entIdRol.setText(String.valueOf(idRol));
    }//GEN-LAST:event_tablaRolMouseClicked

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        idRol = 0;
        entIdRol.setText("Id");
    }//GEN-LAST:event_btnVerActionPerformed

    public void obtenerElementosVentana() {
        String Usuario = "";
        Usuario = entUsuario.getText();
        String contraseña = "";
        contraseña = entContraseña.getText();
        String confirmarContraseña = "";
        confirmarContraseña = entConfirmarContraseña.getText();
        boolean estadoUsuario = entEstadoUsuario.isSelected();
        if (!Usuario.isEmpty()) {
            usuario.setUsuario(Usuario);
        } else {
            caso = 1;
        }

        if (!confirmarContraseña.isEmpty() && !contraseña.isEmpty()) {
            if (!contraseña.equals(confirmarContraseña)) {
                usuario.setContraseña(funciones.getHash(contraseña));
            } else {
                caso = 2;
            }
        } else {
            caso = 1;
        }
        usuario.setEstado(estadoUsuario);
        usuario.setEmpleadoId(empleado);
    }

    public void mostrarEmpleado(Empleado emp) {
        empleado = new Empleado();
        empleado = emp;
        if (emp.getFoto() == null || emp.getFoto().length > 0) {
            Image imagen = funciones.byte_jpg(emp.getFoto()).getScaledInstance(fotoEmpleado.getWidth(), fotoEmpleado.getHeight(), Image.SCALE_DEFAULT);
            fotoEmpleado.setIcon(new ImageIcon(imagen));
        }
        if (emp.getNombre() == null || emp.getNombre().isEmpty()) {
            entPimerNombre.setText("Sin Nombre");
        } else {
            entPimerNombre.setText(emp.getNombre());
        }
        if (emp.getApellidoPaterno() == null || emp.getApellidoPaterno().isEmpty()) {
            entApellidoPaterno.setText("Sin Apellido Paterno");
        } else {
            entApellidoPaterno.setText(emp.getApellidoPaterno());
        }
        entCedula.setText(emp.getCedula());
    }

    public void mostrarElementos(Usuario usuario) {
        Empleado emp = usuario.getEmpleadoId();
        mostrarEmpleado(emp);
        entUsuario.setText(usuario.getUsuario());
        entContraseña.setText(usuario.getContraseña());
        entEstadoUsuario.setSelected(usuario.getEstado());

        MC_RolUsuario controlRol = new MC_RolUsuario();
        rolesUsuario = controlRol.buscarRolUsuarioId(usuario.getId());
        limpiarTabla();
        for (RolUsuario roles : rolesUsuario) {
            int id = roles.getId();
            String nombre = roles.getNombrerol();
            modelo.addRow(new Object[]{id, nombre});
        }
    }

    public boolean validarContraseña(String contraseña, Usuario usuario) {
        boolean validacion = true;
        if (contraseña != null && !contraseña.isEmpty()) {
            if (!usuario.getContraseña().equals(funciones.getHash(contraseña))) {
                JOptionPane.showMessageDialog(this, "Contraseña Incorrecta", "Error", 0, null);
                validacion = false;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Contraseña Incorrecta", "Error", 0, null);
            validacion = false;
        }
        return validacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<RolUsuario> getRolesUsuario() {
        return rolesUsuario;
    }

    public void setRolesUsuario(List<RolUsuario> rolesUsuario) {
        this.rolesUsuario = rolesUsuario;
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
            java.util.logging.Logger.getLogger(ventanaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventanaUsuario dialog = new ventanaUsuario(new javax.swing.JDialog(), true);
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
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVer;
    private javax.swing.JTextField entApellidoPaterno;
    private javax.swing.JTextField entCedula;
    private javax.swing.JPasswordField entConfirmarContraseña;
    private javax.swing.JPasswordField entContraseña;
    private javax.swing.JRadioButton entEstadoUsuario;
    private javax.swing.JTextField entIdRol;
    private javax.swing.JTextField entPimerNombre;
    public javax.swing.JTextField entUsuario;
    private javax.swing.JLabel fotoEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTable tablaRol;
    // End of variables declaration//GEN-END:variables
}
