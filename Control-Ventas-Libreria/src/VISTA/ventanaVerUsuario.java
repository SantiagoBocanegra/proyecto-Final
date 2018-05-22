/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import MODELO.Empleado;
import MODELO.Usuario;
import MODELO_CONTROLADOR.MC_Empleado;
import MODELO_CONTROLADOR.MC_Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ayenni42
 */
public class ventanaVerUsuario extends javax.swing.JDialog {

    /**
     * Creates new form ventanaVerUsuario
     */
    private final String nombreTabla = "Usuario";
    DefaultTableModel modelo;
    int id;

    public ventanaVerUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        id = 0;
        modelo = (DefaultTableModel) tablaUsuario.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaUsuario = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnVer = new javax.swing.JButton();
        btnVerTodo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        entId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel7.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(null);

        jScrollPane4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tablaUsuario.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Usuario", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false
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
        jScrollPane4.setViewportView(tablaUsuario);
        if (tablaUsuario.getColumnModel().getColumnCount() > 0) {
            tablaUsuario.getColumnModel().getColumn(0).setMaxWidth(40);
            tablaUsuario.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        jPanel8.add(jScrollPane4);
        jScrollPane4.setBounds(5, 5, 736, 400);

        jPanel7.add(jPanel8);
        jPanel8.setBounds(5, 100, 747, 410);

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(null);
        jPanel7.add(jPanel9);
        jPanel9.setBounds(5, 5, 830, 90);

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setLayout(null);

        btnVer.setText("Ver");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        jPanel10.add(btnVer);
        btnVer.setBounds(5, 110, 70, 70);

        btnVerTodo.setText("Ver To");
        btnVerTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodoActionPerformed(evt);
            }
        });
        jPanel10.add(btnVerTodo);
        btnVerTodo.setBounds(5, 335, 70, 70);

        btnEditar.setText("Edit");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel10.add(btnEditar);
        btnEditar.setBounds(5, 260, 70, 70);

        btnInsertar.setText("Insert");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        jPanel10.add(btnInsertar);
        btnInsertar.setBounds(5, 185, 70, 70);

        entId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        entId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        entId.setText("Id");
        jPanel10.add(entId);
        entId.setBounds(5, 75, 70, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Id");
        jPanel10.add(jLabel1);
        jLabel1.setBounds(30, 20, 30, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Usuario");
        jPanel10.add(jLabel2);
        jLabel2.setBounds(19, 35, 50, 30);

        jPanel7.add(jPanel10);
        jPanel10.setBounds(757, 100, 80, 410);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limpiarTabla() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(modelo.getRowCount() - 1);
        }
    }
    private void tablaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuarioMouseClicked
        id = Integer.parseInt(modelo.getValueAt(tablaUsuario.getSelectedRow(), 0).toString());
        entId.setText(String.valueOf(id));
    }//GEN-LAST:event_tablaUsuarioMouseClicked

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        if (id > 0) {
            ventanaUsuario ventanaUsu = new ventanaUsuario(new javax.swing.JDialog(), true);
            MC_Usuario controlUsu = new MC_Usuario();
            Usuario usuarioAux = controlUsu.buscarUsuario(id);
            ventanaUsu.btnGuardar.setVisible(false);
            ventanaUsu.btnEditar.setVisible(false);
            ventanaUsu.setUsuario(usuarioAux);
            ventanaUsu.mostrarElementos(usuarioAux);
            ventanaUsu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No Ha Seleccionado Nada", "Informacion", 1, null);
        }
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnVerTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodoActionPerformed
        limpiarTabla();
        id = 0;
        entId.setText("Id");
        List<Usuario> usuarios;
        MC_Usuario controlUsuario = new MC_Usuario();
        usuarios = controlUsuario.buscarTodosUsuario();
        if (!usuarios.isEmpty()) {
            for (Usuario usuario : usuarios) {
                int id = usuario.getId();
                String primerNombre = "Sin Nombre";
                if (usuario.getEmpleadoId().getNombre() != null && !usuario.getEmpleadoId().getNombre().isEmpty()) {
                    primerNombre = usuario.getEmpleadoId().getNombre();
                }
                String ApellidoMaterno = "Sin Apellido";
                if (usuario.getEmpleadoId().getApellidoMaterno() != null && !usuario.getEmpleadoId().getApellidoMaterno().isEmpty()) {
                    ApellidoMaterno = usuario.getEmpleadoId().getApellidoMaterno();
                }
                String usuarioEmpleado = "Sin Usuario";
                if (usuario.getUsuario() != null && !usuario.getUsuario().isEmpty()) {
                    usuarioEmpleado = usuario.getUsuario();
                }
                boolean estado = usuario.getEstado();

                modelo.addRow(new Object[]{id, primerNombre, ApellidoMaterno, usuarioEmpleado, estado});
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Se Encontraron Empleados", "Informacion", 1, null);
        }
    }//GEN-LAST:event_btnVerTodoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (id > 0) {
            ventanaUsuario ventanaUsu = new ventanaUsuario(new javax.swing.JDialog(), true);
            MC_Usuario controlUsu = new MC_Usuario();
            Usuario usuarioAux = controlUsu.buscarUsuario(id);
            ventanaUsu.btnGuardar.setVisible(false);
            ventanaUsu.setUsuario(usuarioAux);
            ventanaUsu.mostrarElementos(usuarioAux);
            ventanaUsu.setVisible(true);
            btnVerTodoActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(this, "No Ha Seleccionado Nada", "Informacion", 1, null);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        int idEmpleado = Integer.parseInt(JOptionPane.showInputDialog(this, "Id De Empleado"));
        MC_Empleado controlEmpleado = new MC_Empleado();
        Empleado empleado = controlEmpleado.buscarEmpleado(idEmpleado);
        if (empleado.getId() != null && empleado.getId() > 0) {
            ventanaUsuario ventanaUsuario = new ventanaUsuario(new javax.swing.JDialog(), true);
            ventanaUsuario.btnEditar.setVisible(false);
            limpiarTabla();
            id = 0;
            entId.setText("Id");
            String nombre = "Sin Nombre";
            String apellido = "Sin Apellido";
            if (empleado.getNombre() != null && !empleado.getNombre().isEmpty()) {
                nombre = empleado.getNombre();
            }
            if (empleado.getApellidoPaterno() != null && !empleado.getApellidoPaterno().isEmpty()) {
                apellido = empleado.getApellidoPaterno();
            }
            ventanaUsuario.mostrarEmpleado(empleado);
            ventanaUsuario.entUsuario.setText(nombre + apellido);
            ventanaUsuario.setVisible(true);
            btnVerTodoActionPerformed(evt);
        }

    }//GEN-LAST:event_btnInsertarActionPerformed

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
            java.util.logging.Logger.getLogger(ventanaVerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaVerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaVerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaVerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventanaVerUsuario dialog = new ventanaVerUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnVer;
    private javax.swing.JButton btnVerTodo;
    private javax.swing.JTextField entId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaEmpleado;
    private javax.swing.JTable tablaEmpleado1;
    private javax.swing.JTable tablaEmpleado2;
    private javax.swing.JTable tablaUsuario;
    // End of variables declaration//GEN-END:variables
}
