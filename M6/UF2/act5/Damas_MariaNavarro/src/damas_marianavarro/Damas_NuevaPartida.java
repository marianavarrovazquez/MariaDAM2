package damas_marianavarro;

import entity.Movimiento;
import entity.Partida;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author maria
 */

public class Damas_NuevaPartida extends javax.swing.JFrame {

    boolean jugaX = false;
    boolean jugaO = true;
    int filaOrigen = -1;
    int columnaOrigen = -1;
    int filaValida = -1;
    int columnaValida = -1;
    
    static Session sesion;
    static Partida partida;
    static Movimiento moviment;

    public Damas_NuevaPartida() {
        initComponents();
        partida = new Partida("");
        nPartida("/");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taula = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton1.setText("Salir");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        taula.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        taula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"X", null, "X", null, "X", null, "X", null},
                {null, "X", null, "X", null, "X", null, "X"},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {"O", null, "O", null, "O", null, "O", null},
                {null, "O", null, "O", null, "O", null, "O"}
            },
            new String [] {
                "", "", "", "", "", "", "", ""
            }
        ));
        taula.setRowHeight(50);
        taula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taulaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(taula);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton3.setText("Menú");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void taulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taulaMouseClicked
        // TODO add your handling code here:
        int fila = obtenirFilaClicada();
        int columna = obtenirColumnaClicada();
        
        if(noHiHaOrigen()) {
            if (jugaX && EsX(fila, columna)) {
                ActualitzaNouOrigen(fila, columna);
            } else if (jugaO && EsO(fila, columna)) { 
                ActualitzaNouOrigen(fila, columna);
            } else {
                mostraError();
            }
        } else {
            if (movimentValid(fila, columna)) {
                if (esBuit(fila, columna) || OcupatContrari(fila, columna)) {
                    mou(fila, columna);
                    ganador(fila, columna);
                } else if (OcupatPropi(fila, columna)) {
                    ActualitzaNouOrigen(fila, columna);
                } 
            } else {
                    mostraErrorMoviment();
            }
        }
    }//GEN-LAST:event_taulaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Damas_P1 damas = new Damas_P1();
        damas.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private int obtenirFilaClicada() {
        return taula.getSelectedRow();
    }

    private int obtenirColumnaClicada() {
        return taula.getSelectedColumn();
    }

    public boolean noHiHaOrigen(){
        boolean noHayOrigen = false;
        if(filaOrigen == -1 && columnaOrigen == -1){
            noHayOrigen = true;
        }
        return noHayOrigen;
    }

    private boolean EsX(int fila, int columna) {
        boolean x = false;
        if(taula.getValueAt(fila, columna) == "X") {
            x = true;
        }
        return x;
    }

    private boolean EsO(int fila, int columna) {
        boolean o = false;
        if(taula.getValueAt(fila, columna) == "O") {
            o = true;
        }
        return o;
    }

    public void ActualitzaNouOrigen(int fila, int columna){
        filaOrigen = fila;
        columnaOrigen = columna;
    }

    public void mostraError(){
        JOptionPane.showMessageDialog(null, "Error!!", "Damas", JOptionPane.ERROR_MESSAGE);
        filaOrigen = -1;
        columnaOrigen = -1;
    }

    public boolean movimentValid(int fila, int columna) {
        boolean valido = false;
        filaValida = fila;
        columnaValida = columna;
        int calculaF =  filaValida - filaOrigen;
        int calculaC = columnaValida - columnaOrigen;
        
        if(jugaO && (calculaF == -1) && ((calculaC == 1) || (calculaC ==  -1))){
            valido = true;
        } else if (jugaX && (calculaF == 1) && ((calculaC == 1) || (calculaC ==  -1))) {
            valido = true;
        }
        return valido;
    }

    public boolean esBuit(int fila, int columna) {
        boolean buit = false;
        if(taula.getValueAt(fila, columna) == null){
            buit = true;
        }
        return buit;
    }

    public boolean OcupatContrari(int fila, int columna) {
        boolean contrari = false;
        if((jugaX == true && EsO(fila, columna) == true) || (jugaO == true && EsX(fila, columna) == true)){
            contrari = true;
        }
        return contrari;
    }

    public void mou(int fila, int columna) {
        int contador = 0;
        
        nMovimiento(filaOrigen, fila, columnaOrigen, columna);
        
        taula.setValueAt(null, filaOrigen, columnaOrigen);
        if (jugaO) {
            taula.setValueAt("O", fila, columna);
            filaOrigen = -1;
            columnaOrigen = -1;
            if(contador == 0) {
                contador = 1;
                jugaO = false;
                jugaX = true;
            }
        } else {
            taula.setValueAt("X", fila, columna);
            filaOrigen = -1;
            columnaOrigen = -1;
            if(contador == 0) {
                contador = 1;
                jugaO = true;
                jugaX = false;
            }
            contador = 0;
        }
    }

    public boolean OcupatPropi(int fila, int columna) {
        boolean ocupado = false;
        if((jugaX == true && EsX(fila, columna) == true) || (jugaO == true && EsO(fila, columna) == true)){
            ocupado  = true;
        }
        return ocupado;
    }

    public void mostraErrorMoviment() {
        JOptionPane.showMessageDialog(null, "Error al moure la fitxa", "Damas", JOptionPane.ERROR_MESSAGE);
        filaOrigen = -1;
        columnaOrigen = -1;
    }

    public void ganador(int fila, int columna) {
        if(EsX(fila, columna) && fila == 7) {
            jugaX = false; 
            jugaO = false;
            
            //muestra que ha ganado la X
            JOptionPane.showMessageDialog(null, "Gana X", "Damas", JOptionPane.OK_OPTION);
            
            //Vuelve a la pantalla menu
            Damas_P1 damasMenu = new Damas_P1();
            damasMenu.setVisible(true);
            dispose();
            
            //Que vaya a el metodo nPartida X
            nPartida("X");
            
        } else if (EsO(fila, columna) && fila == 0) {
            jugaO = false;
            jugaX = false;
            
            //Muestra un mensaje de que ha ganado la O
            JOptionPane.showMessageDialog(null, "Gana O", "Damas", JOptionPane.OK_OPTION);
            
            //Vuelve a la pantalla menu
            Damas_P1 damasMenu = new Damas_P1();
            damasMenu.setVisible(true);
            dispose();
            
            //Que vaya a el metodo nPartida O
            nPartida("O");
        }
    }
    
    private void nPartida(String ganador) {
        partida.setGanador(ganador);
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.saveOrUpdate(partida);
            sesion.getTransaction().commit();
        } catch(HibernateException he) {
            System.out.println("Error guardar ganador " + he);
        } finally {
            sesion.close();
        }
    }
    
    public static void nMovimiento(int columnaOrigen, int columnaValida, int filaOrigen, int filaValida) { 
        moviment = new Movimiento(partida, columnaOrigen, columnaValida, filaOrigen, filaValida);
        moviment.setPartida(partida);
        
        try {
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(moviment);
            sesion.getTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            sesion.close();
        }
        
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
            java.util.logging.Logger.getLogger(Damas_NuevaPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Damas_NuevaPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Damas_NuevaPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Damas_NuevaPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Damas_NuevaPartida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable taula;
    // End of variables declaration//GEN-END:variables

}
