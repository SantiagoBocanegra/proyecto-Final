/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import MODELO_CONTROLADOR.Mail;
import javax.swing.JOptionPane;

/**
 *
 * @author ayenni42
 */
public class ventanaMail extends javax.swing.JDialog {

    String de = "bocanegrasantiago18@gmail.com";
    String contraseña = "santiagobocanegra1998";
    String para = " ";
    String asunto = " ";
    String mensaje = " ";
    int caso;

    public ventanaMail(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        entDe.setEditable(false);
        entDe.setText(de);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        entAsunto = new javax.swing.JTextField();
        entDe = new javax.swing.JTextField();
        entPara = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        entMensaje = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        btnMail = new javax.swing.JButton();
        btnCambiarCuenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("De:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 5, 25, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Mensaje");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(220, 130, 70, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Para:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(5, 40, 40, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Asunto");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(220, 70, 60, 30);

        entAsunto.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entAsunto);
        entAsunto.setBounds(10, 100, 490, 30);

        entDe.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entDe);
        entDe.setBounds(50, 5, 380, 30);

        entPara.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(entPara);
        entPara.setBounds(50, 40, 450, 30);

        entMensaje.setColumns(20);
        entMensaje.setRows(5);
        jScrollPane1.setViewportView(entMensaje);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 160, 490, 195);

        btnCancelar.setText("Cance");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(340, 360, 70, 70);

        btnMail.setText("Envi");
        btnMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMailActionPerformed(evt);
            }
        });
        jPanel1.add(btnMail);
        btnMail.setBounds(420, 360, 70, 70);

        btnCambiarCuenta.setText("C");
        jPanel1.add(btnCambiarCuenta);
        btnCambiarCuenta.setBounds(445, 5, 40, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(5, 5, 510, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void obtenerElementos() {
        de = entDe.getText();
        para = entPara.getText();
        asunto = entAsunto.getText();
        mensaje = entMensaje.getText();
        if (de.isEmpty() || para.isEmpty() || asunto.isEmpty() || mensaje.isEmpty() || contraseña.isEmpty()) {
            caso = 1;
        }
    }
    
    private void btnMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMailActionPerformed
        Mail enviar = new Mail();
        obtenerElementos();
        switch (caso) {
            case 0:
                enviar.enviarEmail(de, contraseña, para, asunto, mensaje, true);
                this.setVisible(false);
                break;
            case 1:
                JOptionPane.showMessageDialog(this, "No se Pueden Dejar Espacios En blanco", "Error", 0, null);
                break;
        }
    }//GEN-LAST:event_btnMailActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
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
            java.util.logging.Logger.getLogger(ventanaMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventanaMail dialog = new ventanaMail(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnCambiarCuenta;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnMail;
    private javax.swing.JTextField entAsunto;
    private javax.swing.JTextField entDe;
    private javax.swing.JTextArea entMensaje;
    public javax.swing.JTextField entPara;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
