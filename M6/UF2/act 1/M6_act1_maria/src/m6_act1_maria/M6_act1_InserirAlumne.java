/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6_act1_maria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author maria
 */
public class M6_act1_InserirAlumne extends javax.swing.JFrame {
    M6_act1_maria connect  = new M6_act1_maria();
    Connection conection;
    
    /**
     * Creates new form M6_ac1_InserirAlumne
     */
    public M6_act1_InserirAlumne() throws SQLException, ClassNotFoundException {
        initComponents();
        this.conection = connect.conexioJDBC();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        LNom = new javax.swing.JLabel();
        LDni = new javax.swing.JLabel();
        LDataN = new javax.swing.JLabel();
        LSexe = new javax.swing.JLabel();
        LAPostal = new javax.swing.JLabel();
        LCPostal = new javax.swing.JLabel();
        tfNom = new javax.swing.JTextField();
        tfDni = new javax.swing.JTextField();
        tfDataN = new javax.swing.JTextField();
        tfAPostal = new javax.swing.JTextField();
        tfSexe = new javax.swing.JTextField();
        tfCPostal = new javax.swing.JTextField();
        BInsereix = new javax.swing.JButton();
        BTornar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(238, 190, 190));

        LNom.setText("Nom: ");

        LDni.setText("Dni:");

        LDataN.setText("Data de naixement:");

        LSexe.setText("Sexe:");

        LAPostal.setText("Adreça postal:");

        LCPostal.setText("Codi postal:");

        tfNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomActionPerformed(evt);
            }
        });

        tfDataN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDataNActionPerformed(evt);
            }
        });

        BInsereix.setText("Insereix");
        BInsereix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInsereixActionPerformed(evt);
            }
        });

        BTornar.setText("Tornar");
        BTornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTornarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LNom)
                    .addComponent(LDni)
                    .addComponent(LDataN))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LAPostal)
                        .addComponent(LSexe)
                        .addComponent(LCPostal))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTornar)
                        .addGap(15, 15, 15)))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BInsereix, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfSexe, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(tfNom)
                    .addComponent(tfDni)
                    .addComponent(tfAPostal)
                    .addComponent(tfDataN)
                    .addComponent(tfCPostal, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tfNom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(LNom))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LDni)
                                                .addGap(6, 6, 6))
                                            .addComponent(tfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(LDataN)
                                        .addGap(1, 1, 1))
                                    .addComponent(tfDataN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LAPostal)
                                .addGap(2, 2, 2))
                            .addComponent(tfAPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfSexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LSexe)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LCPostal)
                    .addComponent(tfCPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTornar)
                    .addComponent(BInsereix))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfDataNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDataNActionPerformed

    private void tfNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomActionPerformed

    private void BTornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTornarActionPerformed
        // TODO add your handling code here:
        M6_act1_Menu menu = new M6_act1_Menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_BTornarActionPerformed

    private void BInsereixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInsereixActionPerformed
        // TODO add your handling code here:
        if(!tfNom.getText().equals("") && !tfDni.getText().equals("") && !tfDataN.getText().equals("")  && !tfSexe.getText().equals("") && !tfAPostal.getText().equals("")
                && !tfCPostal.getText().equals("")) {
            try {
                Statement comando=conection.createStatement();
                ResultSet comparar = comando.executeQuery("SELECT codiPostal FROM població WHERE codiPostal = " + tfCPostal.getText());

                if(comparar.next()){
                    comando.execute("INSERT INTO alumnes VALUES ('" + tfNom.getText() + "','" + tfDni.getText() + "','" + tfDataN.getText() + "','" 
                         + tfAPostal.getText() + "','" + tfSexe.getText() + "'," + tfCPostal.getText() + ")");
                } else {
                    JOptionPane.showMessageDialog(null, "Aquest codi postal no correspon a cap població");
                }
                
                JOptionPane.showMessageDialog(null, "Alumne creat!"); 
            } catch (Exception e) {
                 Logger.getLogger(M6_act1_InserirAlumne.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
           JOptionPane.showMessageDialog(null, "Falten camps per omplir");
        }     
        buidar();
        
    }//GEN-LAST:event_BInsereixActionPerformed

    public void buidar(){
        tfNom.setText("");
        tfDni.setText("");
        tfDataN.setText("");
        tfAPostal.setText("");
        tfSexe.setText("");
        tfCPostal.setText("");       
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
            java.util.logging.Logger.getLogger(M6_act1_InserirAlumne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(M6_act1_InserirAlumne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(M6_act1_InserirAlumne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(M6_act1_InserirAlumne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new M6_act1_InserirAlumne().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(M6_act1_InserirAlumne.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(M6_act1_InserirAlumne.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BInsereix;
    private javax.swing.JButton BTornar;
    private javax.swing.JLabel LAPostal;
    private javax.swing.JLabel LCPostal;
    private javax.swing.JLabel LDataN;
    private javax.swing.JLabel LDni;
    private javax.swing.JLabel LNom;
    private javax.swing.JLabel LSexe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField tfAPostal;
    private javax.swing.JTextField tfCPostal;
    private javax.swing.JTextField tfDataN;
    private javax.swing.JTextField tfDni;
    private javax.swing.JTextField tfNom;
    private javax.swing.JTextField tfSexe;
    // End of variables declaration//GEN-END:variables
}
