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
import java.util.ArrayList;
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

    public ventanaVerRolUsuario(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        id = 0;
        rbId.setSelected(true);
        modelo = (DefaultTableModel) tablaRol.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaRol = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        rbId = new javax.swing.JRadioButton();
        btnBuscar = new javax.swing.JButton();
        entParametro = new javax.swing.JTextField();
        rbNombre = new javax.swing.JRadioButton();
        rbRol = new javax.swing.JRadioButton();
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

        rbId.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbId);
        rbId.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbId.setText("Id");
        rbId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbIdMouseClicked(evt);
            }
        });
        jPanel7.add(rbId);
        rbId.setBounds(230, 10, 50, 30);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar55x55.png"))); // NOI18N
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar60x60.png"))); // NOI18N
        btnBuscar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar60x60.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel7.add(btnBuscar);
        btnBuscar.setBounds(660, 20, 60, 60);

        entParametro.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        entParametro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        entParametro.setToolTipText("");
        entParametro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                entParametroKeyReleased(evt);
            }
        });
        jPanel7.add(entParametro);
        entParametro.setBounds(40, 40, 610, 30);

        rbNombre.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbNombre);
        rbNombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbNombre.setText("Nombre Usuario");
        rbNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbNombreMouseClicked(evt);
            }
        });
        jPanel7.add(rbNombre);
        rbNombre.setBounds(280, 10, 150, 30);

        rbRol.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbRol);
        rbRol.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbRol.setText("Rol");
        rbRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbRolMouseClicked(evt);
            }
        });
        jPanel7.add(rbRol);
        rbRol.setBounds(430, 10, 60, 30);

        jPanel5.add(jPanel7);
        jPanel7.setBounds(5, 5, 747, 90);

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(null);

        btnVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ver65x65.png"))); // NOI18N
        btnVer.setMnemonic('V');
        btnVer.setToolTipText("Ver Informacion Del Rol ");
        btnVer.setBorderPainted(false);
        btnVer.setContentAreaFilled(false);
        btnVer.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ver70x70.png"))); // NOI18N
        btnVer.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ver70x70.png"))); // NOI18N
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        jPanel8.add(btnVer);
        btnVer.setBounds(5, 150, 70, 70);

        btnVerTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/todo65x65.png"))); // NOI18N
        btnVerTodo.setMnemonic('T');
        btnVerTodo.setToolTipText("Ver Todos Los Rol");
        btnVerTodo.setBorderPainted(false);
        btnVerTodo.setContentAreaFilled(false);
        btnVerTodo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/todo70x70.png"))); // NOI18N
        btnVerTodo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/todo70x70.png"))); // NOI18N
        btnVerTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodoActionPerformed(evt);
            }
        });
        jPanel8.add(btnVerTodo);
        btnVerTodo.setBounds(5, 390, 70, 70);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/editar65x65.png"))); // NOI18N
        btnEditar.setMnemonic('E');
        btnEditar.setToolTipText("Editar Informacion Del Rol");
        btnEditar.setContentAreaFilled(false);
        btnEditar.setDefaultCapable(false);
        btnEditar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/editar70x70.png"))); // NOI18N
        btnEditar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/editar70x70.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel8.add(btnEditar);
        btnEditar.setBounds(5, 310, 70, 70);

        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/insert65x65.png"))); // NOI18N
        btnInsertar.setMnemonic('I');
        btnInsertar.setToolTipText("Registrar Nuevo Rol");
        btnInsertar.setBorderPainted(false);
        btnInsertar.setContentAreaFilled(false);
        btnInsertar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/insert70x70.png"))); // NOI18N
        btnInsertar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/insert70x70.png"))); // NOI18N
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        jPanel8.add(btnInsertar);
        btnInsertar.setBounds(5, 230, 70, 70);

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
        jPanel8.setBounds(757, 5, 80, 505);

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

    public void buscarRolActivo(List<RolUsuario> rol) {
        if (permiso != null && permiso.getIdpermisos() != null && !permiso.getNombreTabla().isEmpty()) {
            for (int i = 0; i < rol.size(); i++) {
                int idRol = rol.get(i).getId();
                int idPermisoRol = permiso.getRolUsuarioId().getId();
                if (idRol == idPermisoRol) {
                    rol.remove(i);
                }
            }
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
            buscarRolActivo(RolUsuario);
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
        if (permiso != null && permiso.getIdpermisos() != null && permiso.getEditar()) {
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
        if (permiso != null && permiso.getIdpermisos() != null && permiso.getInsertar()) {
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

    private void rbIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbIdMouseClicked
        limpiarTabla();
        entNumeroOrden.setText("# Orden");
        entParametro.requestFocus();
        entParametro.selectAll();
    }//GEN-LAST:event_rbIdMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String parametro = entParametro.getText();
        List<RolUsuario> clientes = new ArrayList<>();
        if (parametro != null && !parametro.isEmpty()) {
            if (rbId.isSelected()) {
                MC_RolUsuario controlRolUsuario = new MC_RolUsuario();
                int idC = Integer.parseInt(parametro);
                RolUsuario cli = controlRolUsuario.buscarRolUsuario(idC);
                if (cli != null && cli.getId() != null) {
                    clientes.add(cli);
                }
            }
            if (rbNombre.isSelected()) {
                MC_RolUsuario controlRolUsuario = new MC_RolUsuario();
                clientes = controlRolUsuario.buscarRolUsuarioNombreUsuario(parametro);
            }
            if (rbRol.isSelected()) {
                MC_RolUsuario controlRolUsuario = new MC_RolUsuario();
                clientes = controlRolUsuario.buscarRolUsuarioNombreRol(parametro);
            }
            mostrarElementos(clientes);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    public void mostrarElementos(List<RolUsuario> RolUsuario) {
        limpiarTabla();
        if (RolUsuario != null && !RolUsuario.isEmpty()) {
            buscarRolActivo(RolUsuario);
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
    }
    private void entParametroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entParametroKeyReleased
        if (rbId.isSelected()) {
            funciones.validarDigito(evt);
        }
    }//GEN-LAST:event_entParametroKeyReleased

    private void rbNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbNombreMouseClicked
        limpiarTabla();
        entNumeroOrden.setText("# Orden");
        entParametro.requestFocus();
        entParametro.selectAll();
    }//GEN-LAST:event_rbNombreMouseClicked

    private void rbRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbRolMouseClicked
        limpiarTabla();
        entNumeroOrden.setText("# Orden");
        entParametro.requestFocus();
        entParametro.selectAll();
    }//GEN-LAST:event_rbRolMouseClicked

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
                ventanaVerRolUsuario dialog = new ventanaVerRolUsuario(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnInsertar;
    public javax.swing.JButton btnVer;
    public javax.swing.JButton btnVerTodo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField entNumeroOrden;
    private javax.swing.JTextField entParametro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rbId;
    private javax.swing.JRadioButton rbNombre;
    private javax.swing.JRadioButton rbRol;
    private javax.swing.JTable tablaRol;
    // End of variables declaration//GEN-END:variables
}
