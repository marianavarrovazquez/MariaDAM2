/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3_act8;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author maria
 */
public class act8 extends javax.swing.JFrame {

    int contador = 0;
    int w;
    int x;
    String infoTabla[][] = new String[4][4];
    
    /**
     * Creates new form act8
     */
    public act8() {
        initComponents();
      //Deshabilitamos la tabla antes de empezar a jugar
        jTable1.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBEmpezar = new javax.swing.JButton();
        jBSortir = new javax.swing.JButton();
        jTFPuntos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelPuntos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBEmpezar.setText("Empezar");
        jBEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEmpezarActionPerformed(evt);
            }
        });

        jBSortir.setText("Salir");
        jBSortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSortirActionPerformed(evt);
            }
        });

        jTFPuntos.setEditable(false);
        jTFPuntos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Puntos:");

        jLabel2.setText("Record: ");

        jLabel3.setText("puntos");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(50);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jTFPuntos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBSortir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBEmpezar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabelPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTFPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSortir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBEmpezar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSortirActionPerformed
        // TODO add your handling code here:
        
      //Sacamos por pantalla una ventana que diga los puntos que hemos hecho y cerramos la ventana del juego   
        JOptionPane.showConfirmDialog(null, "Puntos: " + contador, "El juego del año", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        dispose();
    }//GEN-LAST:event_jBSortirActionPerformed

    private void jBEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEmpezarActionPerformed
        // TODO add your handling code here:
        
      //Si en el boton pone Empezar 
        if(jBEmpezar.getText().equalsIgnoreCase("Empezar")) {
          //Llamamos a los mentodos donde rellenamos la tabla y el que asignamos la letra que tocara en cada casilla
            llenarInfo();
            llenarTabla();
            jTable1.setEnabled(true);
            jTFPuntos.setText(String.valueOf(0));
            jBEmpezar.setText("Reinicia Pantalla");
        } else {
        //Si en el boton pone Reiniciar Pantalla
            if(Integer.valueOf(jLabelPuntos.getText()) < contador) {
            //Si la etiqueta de arriba que guarda los puntos es menor que el contador
               //Cambiamos la etiqueta por el numero que guarda el contador
                jLabelPuntos.setText(String.valueOf(contador));
            }
          //Se deshabilita la tabla, cambiamos el texto del boton y ponemos a 0 todos los contadores
            jTable1.setEnabled(false);   
            jBEmpezar.setText("Empezar");
            contador = 0;
            w = 0;
            x = 0;
          //Llamamos a los mentodos donde rellenamos la tabla y el que asignamos la letra que tocara en cada casilla   
            llenarInfo();
            llenarTabla();
        }
    }//GEN-LAST:event_jBEmpezarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int fila = filaSeleccionada();
        int columna = columnaSeleccionada();
      //Si la casilla tiene ?  
        if(jTable1.getValueAt(fila, columna) == "?") {
            jTable1.setValueAt(infoTabla[fila][columna], fila, columna);
            if("O".equals(infoTabla[fila][columna])){
              //Si sale O incremento el contador y cambio la etiqueta de los puntos al numero que guarda el contador  
                contador++;
                if(Integer.valueOf(jTFPuntos.getText()) < contador) {
                    jTFPuntos.setText(String.valueOf(contador));
                }
            } else if("W".equals(infoTabla[fila][columna])) {
              //Si sale W multiplico por 2 el numero que guarda e contador y cambio la etiqueta de los puntos al numero que guarda el contador    
                if (contador != 0) {
                    contador = contador * 2;
                }
                if(Integer.valueOf(jTFPuntos.getText()) < contador) {
                    jTFPuntos.setText(String.valueOf(contador));
                }
            } else {
              //Si sale X comprobamos que el record no sea menor que el cotador
                //si es menor le cambiamos el resultado
                if(Integer.valueOf(jTFPuntos.getText()) < contador) {
                    jTFPuntos.setText(String.valueOf(contador));
                    if(Integer.valueOf(jLabelPuntos.getText()) < contador) {
                        jLabelPuntos.setText(String.valueOf(contador));
                    }
                }
              //Saco mensaje por ventana de los puntos y deshabilito la tabla 
                JOptionPane.showConfirmDialog(null,"Puntos: " + contador, "El juego del año", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                jTable1.setEnabled(false);
            }
        } else {
          //Si la casilla no es ? hacemos que salga una ventana con mensaje de error  
            JOptionPane.showConfirmDialog(null, "Error!! Esa casilla ya a sido descubierta", "El juego del año",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTable1MouseClicked
    
    private int filaSeleccionada() {
        return jTable1.getSelectedRow();
    }

    private int columnaSeleccionada() {
        return jTable1.getSelectedColumn();
    }

    private void llenarInfo() {
      //creamos un random i un contador para el random  
        Random random = new Random();
        int contRandom;
      //Creamos dos bucles de 4 posiciones cada uno  
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
              //Le asigno al contador un random del 0 al 3
                contRandom = random.nextInt(3);
                if(contRandom == 0){
                  //Si el contador es 0, en la posicion que toque segun i, j le asignamos la letra O  
                    infoTabla[i][j] = "O";
                } else if (contRandom == 1) {
                  //Si el contador es 1 y el contador de la x no es 2  
                    if(x != 2) {
                      //Le asignamos la letra X a la posicion que toque segun i, j y aumentamos el contador 
                        infoTabla[i][j] = "X";
                        x++;
                    } else {
                        infoTabla[i][j] = "O";
                    }
                } else {
                  //Si el contador no es 1 ni 0 y el contador de la w no es 3   
                    if(w != 3) {
                      //Le asignamos la letra W a la posicion que toque segun i, j y aumentamos el contador 
                        infoTabla[i][j] = "W";
                        w++;
                    } else {
                        infoTabla[i][j] = "O";
                    }
                }
            }
        }
    }

    private void llenarTabla() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                jTable1.setValueAt("?", i, j);
            }
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
            java.util.logging.Logger.getLogger(act8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(act8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(act8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(act8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new act8().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEmpezar;
    private javax.swing.JButton jBSortir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelPuntos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFPuntos;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
