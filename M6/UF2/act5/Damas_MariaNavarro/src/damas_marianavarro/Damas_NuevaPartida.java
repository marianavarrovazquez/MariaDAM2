/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package damas_marianavarro;


import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author maria
 */
public class Damas_NuevaPartida extends javax.swing.JFrame {

    boolean jugaX = true;
    boolean jugaO = false;
    int filaOrigen = -1;
    int columnaOrigen = -1;
    int filaDestino = -1;
    int columnaDestino = -1;
    
    static Session session;
    static Partida partida;
    static Moviment moviment;

    public Damas_NuevaPartida() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taula = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        taula.setBackground(new java.awt.Color(240, 240, 240));
        taula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        taula.setFont(new java.awt.Font("Arial", 0, 28)); // NOI18N
        taula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"   X", null, "   X", null, "   X", null, "   X", null},
                {null, "   X", null, "   X", null, "   X", null, "   X"},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {"   O", null, "   O", "", "   O", null, "   O", null},
                {null, "   O", null, "   O", null, "   O", null, "   O"}
            },
            new String [] {
                "", "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        taula.setFocusable(false);
        taula.setGridColor(new java.awt.Color(0, 0, 0));
        taula.setRowHeight(50);
        taula.setSelectionBackground(new java.awt.Color(0, 0, 0));
        taula.setSelectionForeground(new java.awt.Color(0, 0, 0));
        taula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taulaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(taula);

        jButton1.setText("Sortir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
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
            if(jugaX && EsX(fila, columna)){
                ActualitzaNouOrigen(fila,columna);
            } else if(jugaO && EsO(fila, columna)){
                ActualitzaNouOrigen(fila,columna);
            } else {
                mostraError();
            }
        } else {
            if(movimentValid(fila, columna)){
                if(esBuit(fila, columna)||OcupatContrari(fila, columna)){
                    mou(fila,columna);
                } else if(OcupatPropi(fila,columna)){
                    ActualitzaNouOrigen(fila,columna);
                }
            } else {
                mostraErrorMoviment();
            }
        }
    }//GEN-LAST:event_taulaMouseClicked

    private int obtenirFilaClicada() {
        return taula.getSelectedRow();
    }

    private int obtenirColumnaClicada() {
        return taula.getSelectedColumn();
    }

    public boolean noHiHaOrigen(){
        boolean nOrigen = false;
        if(filaOrigen == -1 || columnaOrigen == -1){
            nOrigen = true;
        }
        return nOrigen;
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
        JOptionPane.showMessageDialog(null, "Error!!", "Juego damas", 
                JOptionPane.ERROR_MESSAGE);
        filaOrigen = -1;
        columnaOrigen = -1;
    }

    public boolean movimentValid(int fila, int columna) {
        boolean esMovimentValid = false;
        filaDestino = fila;
        columnaDestino = columna;
        int calculaFila =  filaDestino - filaOrigen;
        int calculaColumna = columnaDestino - columnaOrigen;
        
        if(jugaO && (calculaFila == -1) && 
                ((calculaColumna == 1) || (calculaColumna ==  -1))){
            esMovimentValid = true;
        } else if (jugaX && (calculaFila == 1) && 
                ((calculaColumna == 1) || (calculaColumna ==  -1))) {
            esMovimentValid = true;
        }
        return esMovimentValid;
    }

    public boolean esBuit(int fila, int columna) {
        boolean buit = false;
        if(taula.getValueAt(fila, columna) == null){
            buit = true;
        }
        return buit;
    }

    public boolean OcupatContrari(int fila, int columna) {
        boolean isOcupatContrari = false;
        if((jugaX == true && EsO(fila, columna) == true)
                || (jugaO == true && EsX(fila, columna) == true)){
            isOcupatContrari = true;
        }
    
        return isOcupatContrari;
    }

    public void mou(int fila, int columna) {
        int checker = 0;
        
        taula.setValueAt(null, filaOrigen, columnaOrigen);
        if (jugaO) {
            taula.setValueAt("O", fila, columna);
            filaOrigen = -1;
            columnaOrigen = -1;
            if(checker == 0) {
                checker = 1;
                jugaO = false;
                jugaX = true;
            }
        } else {
            taula.setValueAt("X", fila, columna);
            filaOrigen = -1;
            columnaOrigen = -1;
            if(checker == 0) {
                checker = 1;
                jugaO = true;
                jugaX = false;
            }
            checker = 0;
        }
    }

    public boolean OcupatPropi(int fila, int columna) {
        boolean isOcupatPropi = false;
        if((jugaX == true && EsX(fila, columna) == true) || (jugaO == true && EsO(fila, columna) == true)){
            isOcupatPropi  = true;
        }
        
        return isOcupatPropi;
    }

    public void mostraErrorMoviment() {
        JOptionPane.showMessageDialog(null, "error al moure la fitxa", "Juego damas", JOptionPane.ERROR_MESSAGE);
        filaOrigen = -1;
        columnaOrigen = -1;
    }

    public void ganador(int fila, int columna) {
        if(EsX(fila, columna) && fila == 7) {
            jugaX = false; 
            jugaO = false;
            JOptionPane.showMessageDialog(null, "Guanya la X", "Damas", 
                JOptionPane.OK_OPTION);
            Damas_P1 damas = new Damas_P1();
            damas.setVisible(true);
            dispose();
            nuevaPartida("X");
        } else if (EsO(fila, columna) && fila == 0) {
            jugaX = false; 
            jugaO = false;
            JOptionPane.showMessageDialog(null, "Guanya la O", "Damas", 
                JOptionPane.OK_OPTION);
            Damas_P1 damas = new Damas_P1();
            damas.setVisible(true);
            dispose();
            nuevaPartida("O");
        }
    }
    
    private void nuevaPartida(String ganador) {
        partida.setGanador(ganador);
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(partida);
            session.getTransaction().commit();
        
        } catch (HibernateException e) {
            System.out.println(" a " + e);
        } finally {
            session.close();
        }
    }
    
    public static void Nmovimiento(int columnaOrigen, int columnaDestino, 
            int filaOrigen, int filaDestino) {
        
        moviment = new Moviment(partida, columnaOrigen, columnaDestino, filaOrigen, filaDestino);
    
        
        moviment.setPartida(partida);
        moviment.setColumnaOrigen(columnaOrigen);
        moviment.setColumnaDestino(columnaDestino);
        moviment.setFilaOrigen(filaOrigen);
        moviment.setFilaDestino(filaDestino);
        
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(moviment);
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println(" hola ian " + e);
        } finally {
            session.close();
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable taula;
    // End of variables declaration//GEN-END:variables

}
