/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3_prova1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maria
 */
public class M3_Prova4 extends JFrame implements ActionListener{
    JButton bChange;
    JButton bChange2;
    
    //constructor
    public M3_Prova4() {
        bChange = new JButton("Click Me!");
        bChange2 = new JButton("Click Me 2!");
        setLayout(new FlowLayout());
        
        //register the buttonFrame object as the listener for the JBtton
        bChange.addActionListener(this);
        bChange2.addActionListener(this);
        
        add(bChange);        
        add(bChange2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //listener method required by the interface
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        try {
            Thread.sleep(10000);
            System.out.println("Prueba 4");
            getContentPane().setBackground(Color.yellow);        
            repaint();
        } catch (InterruptedException ex) {
            Logger.getLogger(M3_Prova4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args) {
        M3_Prova4 prova4 = new M3_Prova4();
        prova4.setSize(300, 150);
        prova4.setVisible(true);
    }   
}
