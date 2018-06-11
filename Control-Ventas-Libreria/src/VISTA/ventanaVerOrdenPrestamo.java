/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import MODELO.Ordenprestamo;
import MODELO.Permisos;
import MODELO_CONTROLADOR.MC_OrdenPrestamo;
import MODELO_CONTROLADOR.funciones;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ayenni42
 */
public class ventanaVerOrdenPrestamo extends javax.swing.JDialog {

    /**
     * Creates new form ventanaVerOrdenPrestamo
     */
    private final String nombreTabla = "OrdenPrestamo";
    List<Ordenprestamo> ordenGrafica = new ArrayList<>();
    DefaultTableModel modelo;
    int numeroOrden;
    Permisos permiso;

    public ventanaVerOrdenPrestamo(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        numeroOrden = 0;
        this.setSize(868, 564);
        Desde.setVisible(false);
        Hasta.setVisible(false);
        entFi.setVisible(false);
        entFf.setVisible(false);
        rbNumeroOrden.setSelected(true);
        modelo = (DefaultTableModel) tablaNumeroOrdenPrestamo.getModel();
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
        jPopupMenu1 = new javax.swing.JPopupMenu();
        GraficaPrestamos = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaNumeroOrdenPrestamo = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        rbNumeroOrden = new javax.swing.JRadioButton();
        rbNombreC = new javax.swing.JRadioButton();
        rbNombreE = new javax.swing.JRadioButton();
        rbRangoFecha = new javax.swing.JRadioButton();
        entFi = new com.toedter.calendar.JDateChooser();
        entFf = new com.toedter.calendar.JDateChooser();
        btnBuscar = new javax.swing.JButton();
        Hasta = new javax.swing.JLabel();
        Desde = new javax.swing.JLabel();
        entParametro = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnVer = new javax.swing.JButton();
        btnVerTodo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        entNumeroOrden = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        GraficaPrestamos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        GraficaPrestamos.setMnemonic('G');
        GraficaPrestamos.setText("Grafica Prestamo");
        GraficaPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraficaPrestamosActionPerformed(evt);
            }
        });
        jPopupMenu1.add(GraficaPrestamos);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        jScrollPane1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tablaNumeroOrdenPrestamo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tablaNumeroOrdenPrestamo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Orden", "Numero Orden", "Nombre Empleado", "Nombre Cliente", "Fecha Entrega", "Estado Orden"
            }
        ));
        tablaNumeroOrdenPrestamo.setComponentPopupMenu(jPopupMenu1);
        tablaNumeroOrdenPrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaNumeroOrdenPrestamoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaNumeroOrdenPrestamo);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(5, 5, 736, 400);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(5, 100, 747, 410);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        rbNumeroOrden.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbNumeroOrden);
        rbNumeroOrden.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbNumeroOrden.setText("Numero Orden");
        rbNumeroOrden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbNumeroOrdenMouseClicked(evt);
            }
        });
        jPanel3.add(rbNumeroOrden);
        rbNumeroOrden.setBounds(50, 10, 140, 30);

        rbNombreC.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbNombreC);
        rbNombreC.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbNombreC.setText("Nombre C");
        rbNombreC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbNombreCMouseClicked(evt);
            }
        });
        jPanel3.add(rbNombreC);
        rbNombreC.setBounds(190, 10, 120, 30);

        rbNombreE.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbNombreE);
        rbNombreE.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbNombreE.setText("Nombre E");
        rbNombreE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbNombreEMouseClicked(evt);
            }
        });
        jPanel3.add(rbNombreE);
        rbNombreE.setBounds(310, 10, 110, 30);

        rbRangoFecha.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbRangoFecha);
        rbRangoFecha.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbRangoFecha.setText("Fecha De Orden Entrega");
        rbRangoFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbRangoFechaMouseClicked(evt);
            }
        });
        jPanel3.add(rbRangoFecha);
        rbRangoFecha.setBounds(420, 10, 210, 30);
        jPanel3.add(entFi);
        entFi.setBounds(170, 40, 200, 30);
        jPanel3.add(entFf);
        entFf.setBounds(430, 40, 180, 30);

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
        jPanel3.add(btnBuscar);
        btnBuscar.setBounds(660, 20, 60, 60);

        Hasta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Hasta.setText("Hasta");
        jPanel3.add(Hasta);
        Hasta.setBounds(380, 40, 50, 30);

        Desde.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Desde.setText("Desde");
        jPanel3.add(Desde);
        Desde.setBounds(110, 40, 50, 30);

        entParametro.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        entParametro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        entParametro.setToolTipText("");
        entParametro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                entParametroKeyReleased(evt);
            }
        });
        jPanel3.add(entParametro);
        entParametro.setBounds(40, 40, 610, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(5, 5, 747, 90);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        btnVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ver65x65.png"))); // NOI18N
        btnVer.setMnemonic('V');
        btnVer.setToolTipText("Ver Informacion De La Orden");
        btnVer.setBorderPainted(false);
        btnVer.setContentAreaFilled(false);
        btnVer.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ver70x70.png"))); // NOI18N
        btnVer.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ver70x70.png"))); // NOI18N
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        jPanel4.add(btnVer);
        btnVer.setBounds(5, 140, 70, 70);

        btnVerTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/todo65x65.png"))); // NOI18N
        btnVerTodo.setMnemonic('T');
        btnVerTodo.setToolTipText("Ver Todas Las Ordenes De Prestamo");
        btnVerTodo.setBorderPainted(false);
        btnVerTodo.setContentAreaFilled(false);
        btnVerTodo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/todo70x70.png"))); // NOI18N
        btnVerTodo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/todo70x70.png"))); // NOI18N
        btnVerTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodoActionPerformed(evt);
            }
        });
        jPanel4.add(btnVerTodo);
        btnVerTodo.setBounds(5, 380, 70, 70);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/editar65x65.png"))); // NOI18N
        btnEditar.setMnemonic('E');
        btnEditar.setToolTipText("Editar Orden De Prestamo");
        btnEditar.setBorderPainted(false);
        btnEditar.setContentAreaFilled(false);
        btnEditar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/editar70x70.png"))); // NOI18N
        btnEditar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/editar70x70.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel4.add(btnEditar);
        btnEditar.setBounds(5, 300, 70, 70);

        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/insert65x65.png"))); // NOI18N
        btnInsertar.setMnemonic('I');
        btnInsertar.setToolTipText("Resgistrar Nueva Orden");
        btnInsertar.setContentAreaFilled(false);
        btnInsertar.setDefaultCapable(false);
        btnInsertar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/insert70x70.png"))); // NOI18N
        btnInsertar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/insert70x70.png"))); // NOI18N
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        jPanel4.add(btnInsertar);
        btnInsertar.setBounds(5, 220, 70, 70);

        entNumeroOrden.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        entNumeroOrden.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        entNumeroOrden.setText("# Orden");
        jPanel4.add(entNumeroOrden);
        entNumeroOrden.setBounds(5, 40, 70, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("# Orden");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(5, 5, 70, 30);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(757, 5, 80, 505);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limpiarTabla() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(modelo.getRowCount() - 1);
        }
    }

    private void tablaNumeroOrdenPrestamoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaNumeroOrdenPrestamoMouseClicked
       numeroOrden = Integer.parseInt(modelo.getValueAt(tablaNumeroOrdenPrestamo.getSelectedRow(), 1).toString());
       entNumeroOrden.setText(String.valueOf(numeroOrden));
    }//GEN-LAST:event_tablaNumeroOrdenPrestamoMouseClicked

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        if (numeroOrden > 0) {
            ventanaOrdenPrestamo ventanaOrdenP = new ventanaOrdenPrestamo(new javax.swing.JDialog(), true);
            MC_OrdenPrestamo controlOrdenP = new MC_OrdenPrestamo();
            Ordenprestamo ordenPrestamoAux = controlOrdenP.buscarOrdenPrestamo(numeroOrden);
            ventanaOrdenP.btnBuscarCliente.setVisible(false);
            ventanaOrdenP.btnBuscarEmpleado.setVisible(false);
            ventanaOrdenP.btnGuardar.setVisible(false);
            ventanaOrdenP.btnEditar.setVisible(false);
            ventanaOrdenP.setOrdenPrestamo(ordenPrestamoAux);
            ventanaOrdenP.mostrarElementos(ordenPrestamoAux);
            ventanaOrdenP.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No Ha Seleccionado Nada", "Informacion", 1, null);
        }
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnVerTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodoActionPerformed
        limpiarTabla();
        numeroOrden = 0;
        entNumeroOrden.setText("# Orden");
        List<Ordenprestamo> OrdenPrestamo;
        MC_OrdenPrestamo controlOrdenP = new MC_OrdenPrestamo();
        OrdenPrestamo = controlOrdenP.buscarTodasOrdenesPrestamo();
        if (!OrdenPrestamo.isEmpty()) {
            for (Ordenprestamo ordenP : OrdenPrestamo) {
                int id = ordenP.getNumeroorden();
                SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
                String fechaOrden = "Sin Fecha";
                if (ordenP.getFechaorden() != null) {
                    fechaOrden = formato.format(ordenP.getFechaorden());
                }
                String nombreEmpleado = "Sin Nombre";
                if (ordenP.getEmpleadoId().getNombre() != null && !ordenP.getEmpleadoId().getNombre().isEmpty()) {
                    nombreEmpleado = ordenP.getEmpleadoId().getNombre();
                }
                String nombreCliente = "Sin Nombre ";
                if (ordenP.getClienteId().getNombre() != null && !ordenP.getClienteId().getNombre().isEmpty()) {
                    nombreCliente = ordenP.getClienteId().getNombre();
                }
                String fechaEntrega = "Sin Fecha Entrega";
                if (ordenP.getFechaentrega() != null) {
                    fechaEntrega = formato.format(ordenP.getFechaentrega());
                }
                String estadoOrden = "0";
                if (ordenP.getEstadoorden() != null && !ordenP.getEstadoorden().isEmpty()) {
                    estadoOrden = ordenP.getEstadoorden();
                }
                modelo.addRow(new Object[]{fechaOrden, id, nombreEmpleado, nombreCliente, fechaEntrega, estadoOrden});
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Se Encontraron Ordenes De Prestamo", "Informacion", 1, null);
        }
    }//GEN-LAST:event_btnVerTodoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (permiso != null && permiso.getIdpermisos() != null && permiso.getEditar()) {
            if (numeroOrden > 0) {
                ventanaOrdenPrestamo ventanaOrdenP = new ventanaOrdenPrestamo(new javax.swing.JDialog(), true);
                limpiarTabla();
                MC_OrdenPrestamo controlOrdenP = new MC_OrdenPrestamo();
                Ordenprestamo ordenPrestamoAux = controlOrdenP.buscarOrdenPrestamo(numeroOrden);
                numeroOrden = 0;
                entNumeroOrden.setText("# Orden");
                ventanaOrdenP.btnGuardar.setVisible(false);
                ventanaOrdenP.setOrdenPrestamo(ordenPrestamoAux);
                ventanaOrdenP.mostrarElementos(ordenPrestamoAux);
                ventanaOrdenP.setVisible(true);
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
            ventanaOrdenPrestamo ventanaOrdenP = new ventanaOrdenPrestamo(new javax.swing.JDialog(), true);
            ventanaOrdenP.btnEditar.setVisible(false);
            limpiarTabla();
            numeroOrden = 0;
            entNumeroOrden.setText("# Orden");
            ventanaOrdenP.numeroOrden();
            ventanaOrdenP.setVisible(true);
            btnVerTodoActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(this, "EL Rol No Tiene Permiso Para Esta Opcion", "Error", 0, null);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void rbNumeroOrdenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbNumeroOrdenMouseClicked
        limpiarTabla();
        entNumeroOrden.setText("# Orden");
        Desde.setVisible(false);
        Hasta.setVisible(false);
        entFi.setVisible(false);
        entFf.setVisible(false);
        entParametro.requestFocus();
        entParametro.selectAll();
        entParametro.setVisible(true);
    }//GEN-LAST:event_rbNumeroOrdenMouseClicked

    private void rbNombreCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbNombreCMouseClicked
        limpiarTabla();
        entNumeroOrden.setText("# Orden");
        Desde.setVisible(false);
        Hasta.setVisible(false);
        entFi.setVisible(false);
        entFf.setVisible(false);
        entParametro.requestFocus();
        entParametro.selectAll();
        entParametro.setVisible(true);
    }//GEN-LAST:event_rbNombreCMouseClicked

    private void rbNombreEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbNombreEMouseClicked
        limpiarTabla();
        entNumeroOrden.setText("# Orden");
        Desde.setVisible(false);
        Hasta.setVisible(false);
        entFi.setVisible(false);
        entFf.setVisible(false);
        entParametro.requestFocus();
        entParametro.selectAll();
        entParametro.setVisible(true);
    }//GEN-LAST:event_rbNombreEMouseClicked

    private void rbRangoFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbRangoFechaMouseClicked
        limpiarTabla();
        entNumeroOrden.setText("# Orden");
        entParametro.setVisible(false);
        Desde.setVisible(true);
        Hasta.setVisible(true);
        entFi.setVisible(true);
        entFi.requestFocus();
        entFf.setVisible(true);
    }//GEN-LAST:event_rbRangoFechaMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String parametro = entParametro.getText();
        Date fechaI = entFi.getDate();
        Date feachaF = entFf.getDate();
        List<Ordenprestamo> Ordenprestamos = new ArrayList<>();
        if (parametro != null && !parametro.isEmpty() || rbRangoFecha.isSelected()) {
            if (rbNumeroOrden.isSelected()) {
                MC_OrdenPrestamo controlCliente = new MC_OrdenPrestamo();
                int idC = Integer.parseInt(parametro);
                Ordenprestamo cli = controlCliente.buscarOrdenPrestamo(idC);
                if (cli != null && cli.getNumeroorden() != null) {
                    Ordenprestamos.add(cli);
                }
            }
            if (rbNombreC.isSelected()) {
                MC_OrdenPrestamo controlCliente = new MC_OrdenPrestamo();
                Ordenprestamos = controlCliente.buscarOrdenprestamoNombreC(parametro);
            }
            if (rbNombreE.isSelected()) {
                MC_OrdenPrestamo controlCliente = new MC_OrdenPrestamo();
                Ordenprestamos = controlCliente.buscarOrdenprestamoNombreE(parametro);
            }
            if (rbRangoFecha.isSelected()) {
                MC_OrdenPrestamo controlCliente = new MC_OrdenPrestamo();
                Ordenprestamos = controlCliente.buscarOrdenprestamoRangoFecha(fechaI, feachaF);
            }
            ordenGrafica = Ordenprestamos;
            mostrarElementos(Ordenprestamos);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    public void mostrarElementos(List<Ordenprestamo> OrdenPrestamo) {
        if (!OrdenPrestamo.isEmpty()) {
            for (Ordenprestamo ordenP : OrdenPrestamo) {
                int id = ordenP.getNumeroorden();
                SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
                String fechaOrden = "Sin Fecha";
                if (ordenP.getFechaorden() != null) {
                    fechaOrden = formato.format(ordenP.getFechaorden());
                }
                String nombreEmpleado = "Sin Nombre";
                if (ordenP.getEmpleadoId().getNombre() != null && !ordenP.getEmpleadoId().getNombre().isEmpty()) {
                    nombreEmpleado = ordenP.getEmpleadoId().getNombre();
                }
                String nombreCliente = "Sin Nombre ";
                if (ordenP.getClienteId().getNombre() != null && !ordenP.getClienteId().getNombre().isEmpty()) {
                    nombreCliente = ordenP.getClienteId().getNombre();
                }
                String fechaEntrega = "Sin Fecha Entrega";
                if (ordenP.getFechaentrega() != null) {
                    fechaEntrega = formato.format(ordenP.getFechaentrega());
                }
                String estadoOrden = "0";
                if (ordenP.getEstadoorden() != null && !ordenP.getEstadoorden().isEmpty()) {
                    estadoOrden = ordenP.getEstadoorden();
                }
                modelo.addRow(new Object[]{fechaOrden, id, nombreEmpleado, nombreCliente, fechaEntrega, estadoOrden});
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Se Encontraron Ordenes De Prestamo", "Informacion", 1, null);
        }
    }
    private void entParametroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entParametroKeyReleased
        if (rbNumeroOrden.isSelected()) {
            funciones.validarDigito(evt);
        }
    }//GEN-LAST:event_entParametroKeyReleased

    private void GraficaPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraficaPrestamosActionPerformed
        if (!ordenGrafica.isEmpty()) {
            List<Ordenprestamo> aux = ordenprestamoOrdenadaFecha(ordenGrafica);
            ventanaVerGraficas grafica = new ventanaVerGraficas(new javax.swing.JDialog(), true);
            grafica.graficaOrdenPrestamo(aux);
            grafica.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No Hay Elementos", "Error", 0, null);
        }
    }//GEN-LAST:event_GraficaPrestamosActionPerformed

    public List<Ordenprestamo> ordenprestamoOrdenadaFecha(List<Ordenprestamo> lista) {
        List<Ordenprestamo> nuevaList = new ArrayList<>();
        Map<Date, Ordenprestamo> mapOrden = new HashMap<Date, Ordenprestamo>();
        for (Ordenprestamo orden : lista) {
            mapOrden.put(orden.getFechaorden(), orden);
        }
        for (Map.Entry<Date, Ordenprestamo> o : mapOrden.entrySet()) {
            Ordenprestamo aux = o.getValue();
//            aux.setCantidadtotal(0);
//            aux.setPreciototal(0);
            for (Ordenprestamo orden : lista) {
                if (orden.getFechaorden().equals(aux.getFechaorden())) {
                    aux.setCantidadtotal(aux.getCantidadtotal() + orden.getCantidadtotal());
                }
            }
            nuevaList.add(aux);
        }
        return nuevaList;
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
            java.util.logging.Logger.getLogger(ventanaVerOrdenPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaVerOrdenPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaVerOrdenPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaVerOrdenPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventanaVerOrdenPrestamo dialog = new ventanaVerOrdenPrestamo(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel Desde;
    private javax.swing.JMenuItem GraficaPrestamos;
    private javax.swing.JLabel Hasta;
    private javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnInsertar;
    public javax.swing.JButton btnVer;
    public javax.swing.JButton btnVerTodo;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser entFf;
    private com.toedter.calendar.JDateChooser entFi;
    private javax.swing.JTextField entNumeroOrden;
    private javax.swing.JTextField entParametro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbNombreC;
    private javax.swing.JRadioButton rbNombreE;
    private javax.swing.JRadioButton rbNumeroOrden;
    private javax.swing.JRadioButton rbRangoFecha;
    private javax.swing.JTable tablaNumeroOrdenPrestamo;
    // End of variables declaration//GEN-END:variables
}
