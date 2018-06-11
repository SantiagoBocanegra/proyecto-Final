/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import MODELO.Empleado;
import MODELO.Permisos;
import MODELO.Usuario;
import MODELO_CONTROLADOR.procesosSegundario;
import MODELO_CONTROLADOR.MC_Empleado;
import MODELO_CONTROLADOR.MC_Usuario;
import MODELO_CONTROLADOR.funciones;
import java.util.ArrayList;
import java.util.Date;
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
    Permisos permiso;
    int id;
    procesosSegundario pro;
    
    public ventanaVerUsuario(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        id = 0;
        rbId.setSelected(true);
        pro = new procesosSegundario();
        rbEstadoA.setVisible(false);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaUsuario = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        rbNombreEmpleado = new javax.swing.JRadioButton();
        rbId = new javax.swing.JRadioButton();
        rbNombreUsuario = new javax.swing.JRadioButton();
        rbEstado = new javax.swing.JRadioButton();
        btnBuscar = new javax.swing.JButton();
        entParametro = new javax.swing.JTextField();
        rbEstadoA = new javax.swing.JRadioButton();
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

        rbNombreEmpleado.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbNombreEmpleado);
        rbNombreEmpleado.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbNombreEmpleado.setText("Nombre Empleado");
        rbNombreEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbNombreEmpleadoMouseClicked(evt);
            }
        });
        jPanel9.add(rbNombreEmpleado);
        rbNombreEmpleado.setBounds(210, 10, 170, 30);

        rbId.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbId);
        rbId.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbId.setText("Id");
        rbId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbIdMouseClicked(evt);
            }
        });
        jPanel9.add(rbId);
        rbId.setBounds(160, 10, 50, 30);

        rbNombreUsuario.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbNombreUsuario);
        rbNombreUsuario.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbNombreUsuario.setText("Usuario");
        rbNombreUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbNombreUsuarioMouseClicked(evt);
            }
        });
        jPanel9.add(rbNombreUsuario);
        rbNombreUsuario.setBounds(380, 10, 90, 30);

        rbEstado.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbEstado);
        rbEstado.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbEstado.setText("Estado");
        rbEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbEstadoMouseClicked(evt);
            }
        });
        jPanel9.add(rbEstado);
        rbEstado.setBounds(470, 10, 80, 30);

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
        jPanel9.add(btnBuscar);
        btnBuscar.setBounds(660, 20, 60, 60);

        entParametro.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        entParametro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        entParametro.setToolTipText("");
        entParametro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                entParametroKeyReleased(evt);
            }
        });
        jPanel9.add(entParametro);
        entParametro.setBounds(40, 40, 610, 30);

        rbEstadoA.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbEstadoA.setText("Activo");
        jPanel9.add(rbEstadoA);
        rbEstadoA.setBounds(550, 40, 73, 30);

        jPanel7.add(jPanel9);
        jPanel9.setBounds(5, 5, 747, 90);

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setLayout(null);

        btnVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ver65x65.png"))); // NOI18N
        btnVer.setMnemonic('V');
        btnVer.setToolTipText("Ver Informacion Del Usuario");
        btnVer.setBorderPainted(false);
        btnVer.setContentAreaFilled(false);
        btnVer.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ver70x70.png"))); // NOI18N
        btnVer.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ver70x70.png"))); // NOI18N
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        jPanel10.add(btnVer);
        btnVer.setBounds(5, 150, 70, 70);

        btnVerTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/todo65x65.png"))); // NOI18N
        btnVerTodo.setMnemonic('T');
        btnVerTodo.setToolTipText("Ver Todos Los Usuarios");
        btnVerTodo.setBorderPainted(false);
        btnVerTodo.setContentAreaFilled(false);
        btnVerTodo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/todo70x70.png"))); // NOI18N
        btnVerTodo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/todo70x70.png"))); // NOI18N
        btnVerTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodoActionPerformed(evt);
            }
        });
        jPanel10.add(btnVerTodo);
        btnVerTodo.setBounds(5, 390, 70, 70);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/editar65x65.png"))); // NOI18N
        btnEditar.setMnemonic('E');
        btnEditar.setToolTipText("Editar Informacion Del Usuario");
        btnEditar.setContentAreaFilled(false);
        btnEditar.setDefaultCapable(false);
        btnEditar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/editar70x70.png"))); // NOI18N
        btnEditar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/editar70x70.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel10.add(btnEditar);
        btnEditar.setBounds(5, 310, 70, 70);

        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/insert65x65.png"))); // NOI18N
        btnInsertar.setMnemonic('I');
        btnInsertar.setToolTipText("Registrar Nuevo Usuario");
        btnInsertar.setBorderPainted(false);
        btnInsertar.setContentAreaFilled(false);
        btnInsertar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/insert70x70.png"))); // NOI18N
        btnInsertar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/insert70x70.png"))); // NOI18N
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        jPanel10.add(btnInsertar);
        btnInsertar.setBounds(5, 230, 70, 70);

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
        jPanel10.setBounds(757, 5, 80, 505);

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
        if (permiso != null && permiso.getIdpermisos() != null && permiso.getEditar()) {
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
        } else {
            JOptionPane.showMessageDialog(this, "EL Rol No Tiene Permiso Para Esta Opcion", "Error", 0, null);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if (permiso != null && permiso.getIdpermisos() != null && permiso.getInsertar()) {
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
        } else {
            JOptionPane.showMessageDialog(this, "EL Rol No Tiene Permiso Para Esta Opcion", "Error", 0, null);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void rbNombreEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbNombreEmpleadoMouseClicked
        limpiarTabla();
        entId.setText("Id");
        entParametro.setVisible(true);
        entParametro.requestFocus();
        entParametro.selectAll();
        entParametro.setVisible(true);
        rbEstadoA.setVisible(false);
    }//GEN-LAST:event_rbNombreEmpleadoMouseClicked

    private void rbIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbIdMouseClicked
        limpiarTabla();
        entId.setText("Id");
        entParametro.setVisible(true);
        entParametro.selectAll();
        entParametro.requestFocus();
        rbEstadoA.setVisible(false);
    }//GEN-LAST:event_rbIdMouseClicked

    private void rbNombreUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbNombreUsuarioMouseClicked
        limpiarTabla();
        entId.setText("Id");
        entParametro.setVisible(true);
        entParametro.selectAll();
        entParametro.requestFocus();
        rbEstadoA.setVisible(false);
    }//GEN-LAST:event_rbNombreUsuarioMouseClicked

    private void rbEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbEstadoMouseClicked
        limpiarTabla();
        entId.setText("Id");
        entParametro.setVisible(true);
        entParametro.setVisible(false);
        rbEstadoA.setSelected(true);
        rbEstadoA.setVisible(true);
    }//GEN-LAST:event_rbEstadoMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String parametro = entParametro.getText();
        List<Usuario> clientes = new ArrayList<>();
        if (parametro != null && !parametro.isEmpty() || rbEstado.isSelected()) {
            if (rbId.isSelected()) {
                MC_Usuario controlUsuario = new MC_Usuario();
                int idC = Integer.parseInt(parametro);
                Usuario cli = controlUsuario.buscarUsuario(idC);
                if (cli != null && cli.getId() != null) {
                    clientes.add(cli);
                }
            }
            if (rbNombreEmpleado.isSelected()) {
                MC_Usuario controlUsuario = new MC_Usuario();
                clientes = controlUsuario.buscarUsuarioNombreE(parametro);
            }
            if (rbNombreUsuario.isSelected()) {
                MC_Usuario controlUsuario = new MC_Usuario();
                clientes = controlUsuario.buscarUsuarioNombreU(parametro);
            }
            if (rbEstado.isSelected()) {
                MC_Usuario controlUsuario = new MC_Usuario();
                clientes = controlUsuario.buscarUsuarioEstado(rbEstadoA.isSelected());
            }
            mostrarElementos(clientes);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    public void mostrarElementos (List<Usuario> usuarios) {
        limpiarTabla();
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
    }
    private void entParametroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entParametroKeyReleased
        if (rbId.isSelected()) {
            funciones.validarDigito(evt);
        }
    }//GEN-LAST:event_entParametroKeyReleased

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
                ventanaVerUsuario dialog = new ventanaVerUsuario(new javax.swing.JDialog(), true);
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
    private javax.swing.JTextField entId;
    private javax.swing.JTextField entParametro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton rbEstado;
    private javax.swing.JRadioButton rbEstadoA;
    private javax.swing.JRadioButton rbId;
    private javax.swing.JRadioButton rbNombreEmpleado;
    private javax.swing.JRadioButton rbNombreUsuario;
    private javax.swing.JTable tablaUsuario;
    // End of variables declaration//GEN-END:variables
}
