/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import MODELO.Genero;
import MODELO.Permisos;
import MODELO_CONTROLADOR.MC_Genero;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ayenni42
 */
public class ventanaverGenero extends javax.swing.JDialog {

    /**
     * Creates new form ventanaverGenero
     */
    private final String nombreTabla = "Genero";
    private int id;
    DefaultTableModel modelo;
    List<Genero> Generos = new ArrayList<>();
    Permisos permiso;

    public ventanaverGenero(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        id = 0;
        this.setSize(597, 460);
        modelo = (DefaultTableModel) tablaGenero.getModel();
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGenero = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnVer = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnVerTodo = new javax.swing.JButton();
        entId = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablaGenero.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tablaGenero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Descripcion", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaGenero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaGeneroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaGenero);
        if (tablaGenero.getColumnModel().getColumnCount() > 0) {
            tablaGenero.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(5, 5, 450, 280);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(5, 60, 460, 290);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel1.setText("Generos");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 170, 40);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        btnVer.setMnemonic('V');
        btnVer.setText("Ver");
        btnVer.setToolTipText("Ver Informacion De Un Genero");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        jPanel3.add(btnVer);
        btnVer.setBounds(5, 40, 70, 70);

        btnInsertar.setMnemonic('I');
        btnInsertar.setText("Inser");
        btnInsertar.setToolTipText("Registrar Nuevo Genero");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        jPanel3.add(btnInsertar);
        btnInsertar.setBounds(5, 115, 70, 70);

        btnEditar.setMnemonic('E');
        btnEditar.setText("Edit");
        btnEditar.setToolTipText("Editar Informacion Del Genero ");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEditar);
        btnEditar.setBounds(5, 190, 70, 70);

        btnVerTodo.setMnemonic('T');
        btnVerTodo.setText("Ver To");
        btnVerTodo.setToolTipText("Ver Todos Los Generos");
        btnVerTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodoActionPerformed(evt);
            }
        });
        jPanel3.add(btnVerTodo);
        btnVerTodo.setBounds(5, 265, 70, 70);

        entId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        entId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        entId.setText("Id");
        jPanel3.add(entId);
        entId.setBounds(5, 5, 70, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(470, 60, 80, 340);

        btnAgregar.setMnemonic('A');
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Agregar Generos Al Libro");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);
        btnAgregar.setBounds(5, 355, 460, 40);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(180, 35, 365, 2);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(5, 5, 555, 405);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        if (id > 0) {
            ventanaGenero ventanaGenero = new ventanaGenero(new javax.swing.JDialog(), true);
            MC_Genero controlGenero = new MC_Genero();
            Genero generoAux = controlGenero.buscarGenero(id);
            controlGenero.close();
            id = 0;
            entId.setText("Id");
            if (generoAux.getId() != null && generoAux.getId() > 0) {
                ventanaGenero.btnEditar.setEnabled(false);
                ventanaGenero.btnGuardar.setEnabled(false);
                ventanaGenero.entFechaCrecion.setEnabled(false);
                ventanaGenero.setGenero(generoAux);
                ventanaGenero.mostrarElementos(generoAux);
                ventanaGenero.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No Se Ha Encontrado Nada", "Informacion", 1, null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Ha Seleccionado Nada", "Informacion", 1, null);
        }
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (permiso != null && permiso.getIdpermisos() != null && permiso.getInsertar()) {
            if (id > 0) {
                limpiarTabla();
                ventanaGenero ventanaGenero = new ventanaGenero(new javax.swing.JDialog(), true);
                MC_Genero controlGenero = new MC_Genero();
                Genero generoAux = controlGenero.buscarGenero(id);
                controlGenero.close();
                id = 0;
                entId.setText("Id");
                if (generoAux.getId() != null && generoAux.getId() > 0) {
                    ventanaGenero.btnGuardar.setVisible(false);
                    ventanaGenero.entFechaCrecion.setEnabled(false);
                    ventanaGenero.setGenero(generoAux);
                    ventanaGenero.mostrarElementos(generoAux);
                    ventanaGenero.setVisible(true);
                    btnVerTodoActionPerformed(evt);
                } else {
                    JOptionPane.showMessageDialog(this, "No Se Ha Encontrado Nada", "Informacion", 1, null);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No Ha Seleccionado Nada", "Informacion", 1, null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "EL Rol No Tiene Permiso Para Esta Opcion", "Error", 0, null);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnVerTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodoActionPerformed
        MC_Genero controlGenero = new MC_Genero();
        id = 0;
        limpiarTabla();
        entId.setText("Id");
        List<Genero> generos = controlGenero.buscarTodosGeneros();
        if (!generos.isEmpty()) {
            for (Genero genero : generos) {
                int idGenero = genero.getId();
                String primerNombre = "Sin Nombre";
                if (genero.getNombre() != null && !genero.getNombre().isEmpty()) {
                    primerNombre = genero.getNombre();
                }
                String descripcion = "Sin Descripcion";
                if (genero.getDescripcion() != null && !genero.getDescripcion().isEmpty()) {
                    descripcion = genero.getDescripcion();
                }
                modelo.addRow(new Object[]{idGenero, primerNombre, descripcion});
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Se Encontraron Empleados", "Informacion", 1, null);
        }
    }//GEN-LAST:event_btnVerTodoActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if (permiso != null && permiso.getIdpermisos() != null && permiso.getInsertar()) {
            ventanaGenero ventanaGenero = new ventanaGenero(new javax.swing.JDialog(), true);
            limpiarTabla();
            id = 0;
            entId.setText("Id");
            ventanaGenero.btnEditar.setEnabled(false);
            ventanaGenero.setVisible(true);
            btnVerTodoActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(this, "EL Rol No Tiene Permiso Para Esta Opcion", "Error", 0, null);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void tablaGeneroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGeneroMouseClicked
        id = Integer.parseInt(modelo.getValueAt(tablaGenero.getSelectedRow(), 0).toString());
        entId.setText(String.valueOf(id));
    }//GEN-LAST:event_tablaGeneroMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        MC_Genero controlGenero = new MC_Genero();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            boolean seleccion = (boolean) modelo.getValueAt(i, 3);
            if (seleccion) {
                int idS = Integer.parseInt(modelo.getValueAt(i, 0).toString());
                Genero generoAux = controlGenero.buscarGenero(idS);
                Generos.add(generoAux);
            }
        }
        controlGenero.close();
        this.setVisible(false);
    }//GEN-LAST:event_btnAgregarActionPerformed

    public void limpiarTabla() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(modelo.getRowCount() - 1);
        }
    }

    public List<Genero> getIdGenero() {
        return Generos;
    }

    public void setIdGenero(List<Genero> Genero) {
        this.Generos = Genero;
    }

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
            java.util.logging.Logger.getLogger(ventanaverGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaverGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaverGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaverGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventanaverGenero dialog = new ventanaverGenero(new javax.swing.JDialog(), true);
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
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnInsertar;
    public javax.swing.JButton btnVer;
    public javax.swing.JButton btnVerTodo;
    private javax.swing.JTextField entId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaGenero;
    // End of variables declaration//GEN-END:variables
}
