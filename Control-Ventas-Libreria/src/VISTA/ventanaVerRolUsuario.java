/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import MODELO.Permisos;
import MODELO.RolUsuario;
import MODELO_CONTROLADOR.MC_RolUsuario;
import MODELO_CONTROLADOR.funciones;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ayenni42
 */
public class ventanaVerRolUsuario extends javax.swing.JDialog {

    /**
     * Creates new form ventanaVerRolUsuario
     */
    private final String nombreTabla = "Rol";
    DefaultTableModel modelo;
    Permisos permiso;
    int id;

    public ventanaVerRolUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        id = 0;
        modelo = (DefaultTableModel) tablaRol.getModel();
        permiso = funciones.permisosRol(9, "Rol");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaRol = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnVer = new javax.swing.JButton();
        btnVerTodo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        entNumeroOrden = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(null);

        jScrollPane3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tablaRol.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tablaRol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre Usuario", "Rol", "Fecha Creacion"
            }
        ));
        tablaRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRolMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaRol);

        jPanel6.add(jScrollPane3);
        jScrollPane3.setBounds(5, 5, 736, 400);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(5, 100, 747, 410);

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(null);
        jPanel5.add(jPanel7);
        jPanel7.setBounds(5, 5, 830, 90);

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(null);

        btnVer.setText("Ver");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        jPanel8.add(btnVer);
        btnVer.setBounds(5, 110, 70, 70);

        btnVerTodo.setText("Ver To");
        btnVerTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodoActionPerformed(evt);
            }
        });
        jPanel8.add(btnVerTodo);
        btnVerTodo.setBounds(5, 335, 70, 70);

        btnEditar.setText("Edit");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel8.add(btnEditar);
        btnEditar.setBounds(5, 260, 70, 70);

        btnInsertar.setText("Insert");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        jPanel8.add(btnInsertar);
        btnInsertar.setBounds(5, 185, 70, 70);

        entNumeroOrden.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        entNumeroOrden.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        entNumeroOrden.setText("Id ");
        jPanel8.add(entNumeroOrden);
        entNumeroOrden.setBounds(5, 40, 70, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Id Rol");
        jPanel8.add(jLabel1);
        jLabel1.setBounds(5, 5, 70, 30);

        jPanel5.add(jPanel8);
        jPanel8.setBounds(757, 100, 80, 410);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limpiarTabla() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(modelo.getRowCount() - 1);
        }
    }
    private void tablaRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRolMouseClicked
        id = Integer.parseInt(modelo.getValueAt(tablaRol.getSelectedRow(), 0).toString());
        entNumeroOrden.setText(String.valueOf(id));
    }//GEN-LAST:event_tablaRolMouseClicked

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        if (id > 0) {
            ventanaRoles ventanaRol = new ventanaRoles(new javax.swing.JDialog(), true);
            MC_RolUsuario controlRol = new MC_RolUsuario();
            RolUsuario RolAux = controlRol.buscarRolUsuario(id);
            ventanaRol.btnGuardar.setVisible(false);
            ventanaRol.btnEditar.setVisible(false);
            ventanaRol.setRolUsuario(RolAux);
            ventanaRol.mostrarElementos(RolAux);
            ventanaRol.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No Ha Seleccionado Nada", "Informacion", 1, null);
        }
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnVerTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodoActionPerformed
        limpiarTabla();
        this.id = 0;
        entNumeroOrden.setText("Id");
        List<RolUsuario> RolUsuario;
        MC_RolUsuario controlRol = new MC_RolUsuario();
        RolUsuario = controlRol.buscarTodosRolUsuario();
        if (RolUsuario != null && !RolUsuario.isEmpty()) {
            for (RolUsuario rol : RolUsuario) {
                int idRol = rol.getId();
                SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");

                String nombreUsuario = "Sin Nombre";
                if (rol.getUsuarioId().getUsuario() != null && !rol.getUsuarioId().getUsuario().isEmpty()) {
                    nombreUsuario = rol.getUsuarioId().getUsuario();
                }
                String tipoRol = "Sin Nombre ";
                if (rol.getNombrerol() != null && !rol.getNombrerol().isEmpty()) {
                    tipoRol = rol.getNombrerol();
                }

                String fechaCreacion = "Sin Fecha";
                if (rol.getFechacreacion() != null) {
                    fechaCreacion = formato.format(rol.getFechacreacion());
                }
                modelo.addRow(new Object[]{idRol, nombreUsuario, tipoRol, fechaCreacion});
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Se Encontraron Roles", "Informacion", 1, null);
        }
    }//GEN-LAST:event_btnVerTodoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (permiso.getIdpermisos() != null && permiso.getEditar()) {
            if (id > 0) {
                ventanaRoles ventanaRol = new ventanaRoles(new javax.swing.JDialog(), true);
                limpiarTabla();
                MC_RolUsuario controlRol = new MC_RolUsuario();
                RolUsuario RolUsuarioAux = controlRol.buscarRolUsuario(id);
                id = 0;
                entNumeroOrden.setText("Id");
                ventanaRol.entFechaRegistro.setEnabled(false);
                ventanaRol.btnGuardar.setVisible(false);
                ventanaRol.setRolUsuario(RolUsuarioAux);
                ventanaRol.mostrarElementos(RolUsuarioAux);
                ventanaRol.setVisible(true);
                btnVerTodoActionPerformed(evt);
            } else {
                JOptionPane.showMessageDialog(this, "No Ha Seleccionado Nada", "Informacion", 1, null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "EL Rol No Tiene Permiso Para Esta Opcion", "Error", 0, null);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if (permiso.getIdpermisos() != null && permiso.getInsertar()) {
            ventanaRoles ventanaRol = new ventanaRoles(new javax.swing.JDialog(), true);
            ventanaRol.btnEditar.setVisible(false);
            limpiarTabla();
            id = 0;
            entNumeroOrden.setText("Id");
            ventanaRol.setVisible(true);
            btnVerTodoActionPerformed(evt);
            btnVerTodoActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(this, "EL Rol No Tiene Permiso Para Esta Opcion", "Error", 0, null);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    public Permisos getPermiso() {
        return permiso;
    }

    public void setPermiso(Permisos permiso) {
        this.permiso = permiso;
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
            java.util.logging.Logger.getLogger(ventanaVerRolUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaVerRolUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaVerRolUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaVerRolUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventanaVerRolUsuario dialog = new ventanaVerRolUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField entNumeroOrden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaNumeroOrdenPrestamo;
    private javax.swing.JTable tablaNumeroOrdenPrestamo1;
    private javax.swing.JTable tablaRol;
    // End of variables declaration//GEN-END:variables
}
