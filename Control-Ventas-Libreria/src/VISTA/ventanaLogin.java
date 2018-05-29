/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import MODELO.Empleado;
import MODELO.Permisos;
import MODELO.RolUsuario;
import MODELO.Usuario;
import MODELO_CONTROLADOR.MC_Empleado;
import MODELO_CONTROLADOR.MC_Permisos;
import MODELO_CONTROLADOR.MC_RolUsuario;
import MODELO_CONTROLADOR.MC_Usuario;
import MODELO_CONTROLADOR.funciones;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ayenni42
 */
public class ventanaLogin extends javax.swing.JDialog {

    /**
     * Creates new form ventanaLogin
     */
    int id;
    DefaultTableModel modeloUsuario;
    DefaultTableModel modeloRol;
    Empleado empleado;
    Usuario usuarioSeleccionado;
    RolUsuario rolSeleccionado;
    List<Usuario> usuarios = new ArrayList<>();
    List<RolUsuario> roles = new ArrayList<>();
    ventanaMenu ventana;
    

    public ventanaLogin(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(461, 513);
        this.setTitle("Libreria ¡Yo Si Compro Libros!");
        this.setMaximumSize(new Dimension(461, 513));
        this.setMinimumSize(new Dimension(461, 513));

        id = 0;
        btnAceptar.setEnabled(false);
        entContraseña.setEditable(false);
        modeloRol = (DefaultTableModel) tablaRol.getModel();
        modeloUsuario = (DefaultTableModel) tablaUsuario.getModel();
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
        fotoUsuario = new com.bolivia.label.CLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        entCcEmpleado = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaUsuario = new javax.swing.JTable();
        entContraseña = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRol = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(null);

        fotoUsuario.setBackground(new java.awt.Color(102, 102, 102));
        fotoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/usuario.jpg"))); // NOI18N
        fotoUsuario.setText("");
        jPanel1.add(fotoUsuario);
        fotoUsuario.setBounds(125, 10, 190, 190);

        btnCancelar.setMnemonic('C');
        btnCancelar.setText("Cance");
        btnCancelar.setToolTipText("Cancelar Operacion");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(280, 380, 70, 70);

        btnAceptar.setMnemonic('A');
        btnAceptar.setText("Acepta");
        btnAceptar.setToolTipText("Ingresar Al Sistema");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar);
        btnAceptar.setBounds(360, 380, 70, 70);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Contraseña");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(11, 118, 90, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("CC Empleado");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(11, 5, 107, 30);

        entCcEmpleado.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        entCcEmpleado.setToolTipText("Preccione Enter Para Seguir A El Siguiente Campo");
        entCcEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        entCcEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                entCcEmpleadoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                entCcEmpleadoKeyTyped(evt);
            }
        });
        jPanel2.add(entCcEmpleado);
        entCcEmpleado.setBounds(122, 5, 289, 30);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Usuarios Del Empleado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setLayout(null);

        tablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre Usuario", "Estado", "Elegir"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaUsuario);
        if (tablaUsuario.getColumnModel().getColumnCount() > 0) {
            tablaUsuario.getColumnModel().getColumn(0).setMaxWidth(40);
            tablaUsuario.getColumnModel().getColumn(2).setMaxWidth(50);
            tablaUsuario.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(5, 20, 390, 45);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(10, 40, 400, 70);

        entContraseña.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        entContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                entContraseñaKeyPressed(evt);
            }
        });
        jPanel2.add(entContraseña);
        entContraseña.setBounds(101, 118, 310, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 210, 420, 160);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Roles", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        tablaRol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre Rol", "Elegir"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaRol);
        if (tablaRol.getColumnModel().getColumnCount() > 0) {
            tablaRol.getColumnModel().getColumn(0).setMaxWidth(40);
            tablaRol.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(5, 20, 250, 45);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 380, 260, 70);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(2, 2, 440, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.out.println("tamaño: " + this.getSize());
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void entCcEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entCcEmpleadoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String cedulaEmpleado = entCcEmpleado.getText();
            if (cedulaEmpleado != null && !cedulaEmpleado.isEmpty()) {

                MC_Empleado controlEmpleado = new MC_Empleado();
                empleado = controlEmpleado.buscarEmpleadoCc(cedulaEmpleado);

                if (empleado.getCedula() != null && !empleado.getCedula().isEmpty()) {

                    if (empleado.getFoto() != null) {
                        Image foto = funciones.byte_jpg(empleado.getFoto()).getScaledInstance(fotoUsuario.getWidth(), fotoUsuario.getHeight(), Image.SCALE_DEFAULT);
                        fotoUsuario.setIcon(new ImageIcon(foto));
                    }

                    int idEmpleado = empleado.getId();
                    MC_Usuario controlUsuario = new MC_Usuario();
                    usuarios = controlUsuario.buscarUsuarioEmpleadoId(idEmpleado);
                    mostrarUsuarios(usuarios);
                    entCcEmpleado.setEditable(false);
                    entCcEmpleado.requestFocus(false);
                } else {
                    entCcEmpleado.selectAll();
                    entCcEmpleado.requestFocus();
                    JOptionPane.showMessageDialog(this, "No Se Encontro Ningun Empleado Con La Cedula " + cedulaEmpleado, "Informacion", 1, null);
                }
            }
        }
    }//GEN-LAST:event_entCcEmpleadoKeyPressed

    private void tablaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuarioMouseClicked
        if (modeloUsuario.getValueAt(tablaUsuario.getSelectedRow(), 2).equals(true)) {
            id = Integer.parseInt(modeloUsuario.getValueAt(tablaUsuario.getSelectedRow(), 0).toString());
            desmarcarFilas(id, modeloUsuario, 3);
            entContraseña.setEditable(true);
            entContraseña.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario No Esta Activo", "Informacion", 1, null);
            modeloUsuario.setValueAt(false, tablaUsuario.getSelectedRow(), 3);
        }
    }//GEN-LAST:event_tablaUsuarioMouseClicked

    private void entContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entContraseñaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String contraseña = entContraseña.getText();
            if (contraseña != null && !contraseña.isEmpty() && id != 0) {
                buscarUsuarioSeleccion(id);
                if (usuarioSeleccionado.getContraseña().equals(funciones.getHash(contraseña))) {
                    entContraseña.requestFocus(false);
                    entContraseña.setEditable(false);
                    MC_RolUsuario controlRol = new MC_RolUsuario();
                    roles = controlRol.buscarRolUsuarioId(usuarioSeleccionado.getId());
                    mostrarRole(roles);
                } else {
                    JOptionPane.showMessageDialog(this, "Contraseña Incorrecta", "Advertecia", 2, null);
                    entContraseña.requestFocus();
                    entContraseña.selectAll();
                }
            }
        }
    }//GEN-LAST:event_entContraseñaKeyPressed

    private void tablaRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRolMouseClicked
        id = Integer.parseInt(modeloRol.getValueAt(tablaRol.getSelectedRow(), 0).toString());
        desmarcarFilas(id, modeloRol, 2);
        btnAceptar.setEnabled(true);
        btnAceptar.requestFocus();
    }//GEN-LAST:event_tablaRolMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Image imagen = funciones.byte_jpg(empleado.getFoto()).getScaledInstance(ventana.fotoUsuario.getWidth(), ventana.fotoUsuario.getHeight(), Image.SCALE_SMOOTH);
        buscarRolSeleccion(id);
        MC_Permisos controlPermisos = new MC_Permisos();
        List<Permisos> permisos = controlPermisos.buscarPermisosRolId(rolSeleccionado.getId());
        ventana.fotoUsuario.setIcon(new ImageIcon(imagen));
        ventana.setRol(rolSeleccionado);
        ventana.setPermisosRol(permisos);
        ventana.PerfilUsuario.setToolTipText("Rol Activo: "+rolSeleccionado.getNombrerol());
        ventana.Desconectar.setEnabled(true);
        ventana.Conectar.setEnabled(false);
        this.setVisible(false);
        //ventana.setVisible(true);
        
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void entCcEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entCcEmpleadoKeyTyped
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
        }else {
            funciones.validarDigito(evt);
        }
    }//GEN-LAST:event_entCcEmpleadoKeyTyped

    public void buscarUsuarioSeleccion(int id) {
        if (!usuarios.isEmpty()) {
            for (Usuario usuario : usuarios) {
                if (usuario.getId() == id) {
                    usuarioSeleccionado = usuario;
                }
            }
        }
    }
    
    public void buscarRolSeleccion(int id) {
        if (!roles.isEmpty()) {
            for (RolUsuario usuario : roles) {
                if (usuario.getId() == id) {
                    rolSeleccionado = usuario;
                }
            }
        }
    }

    private void mostrarUsuarios(List<Usuario> usuarios) {
        if (!usuarios.isEmpty()) {
            for (Usuario usuario : usuarios) {
                int idUsuario = usuario.getId();
                String nombreU = usuario.getUsuario();
                boolean estado = usuario.getEstado();
                boolean elegir = false;
                modeloUsuario.addRow(new Object[]{idUsuario, nombreU, estado, elegir});
            }
        } else {
            JOptionPane.showMessageDialog(this, "Empleado No tiene Usuario", "Informacion", 1, null);
        }
    }

    public void mostrarRole(List<RolUsuario> roles) {
        if (!roles.isEmpty()) {
            for (RolUsuario rol : roles) {
                int idRol = rol.getId();
                String nombreR = rol.getNombrerol();
                boolean elegir = false;
                modeloRol.addRow(new Object[]{idRol, nombreR, elegir});
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuario No tiene Rol", "Informacion", 1, null);
        }
    }

    private void desmarcarFilas(int id, DefaultTableModel modelo, int columna) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (Integer.parseInt(modelo.getValueAt(i, 0).toString()) != id) {
                modelo.setValueAt(false, i, columna);
            }
        }
    }

    public ventanaMenu getVentana() {
        return ventana;
    }

    public void setVentana(ventanaMenu ventana) {
        this.ventana = ventana;
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
            java.util.logging.Logger.getLogger(ventanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventanaLogin dialog = new ventanaLogin(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField entCcEmpleado;
    private javax.swing.JPasswordField entContraseña;
    private com.bolivia.label.CLabel fotoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaRol;
    private javax.swing.JTable tablaUsuario;
    // End of variables declaration//GEN-END:variables
}
