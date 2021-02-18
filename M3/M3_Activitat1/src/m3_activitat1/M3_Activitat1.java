/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3_activitat1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author maria
 */
public class M3_Activitat1 extends JFrame implements ActionListener{
    JButton bChange;
    JButton bChange2;
    JButton bChange3;
    JButton bChange4;
    
    //constructor
    public M3_Activitat1() {
        bChange = new JButton("Vermell");
        bChange2 = new JButton("Verd");
        bChange3 = new JButton("Blau");
        bChange4 = new JButton("Gris");
        setLayout(new FlowLayout());
        
        //register the buttonFrame object as the listener for the JBtton
        bChange.addActionListener(this);
        bChange2.addActionListener(this);
        bChange3.addActionListener(this);
        bChange4.addActionListener(this);
        
        bChange.setBackground(Color.red);
        bChange2.setBackground(Color.green);
        bChange3.setBackground(Color.blue);
        bChange4.setBackground(Color.gray);
        
        add(bChange);        
        add(bChange2);
        add(bChange3);        
        add(bChange4);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //listener method required by the interface
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getActionCommand().equals("Vermell")) {
            getContentPane().setBackground(Color.red);        
            repaint();
        } else if(ae.getActionCommand().equals("Verd")) {
            getContentPane().setBackground(Color.green);        
            repaint();
        } else if(ae.getActionCommand().equals("Blau")) {
            getContentPane().setBackground(Color.blue);        
            repaint();
        } else if(ae.getActionCommand().equals("Gris")) {
            getContentPane().setBackground(Color.gray);        
            repaint();
        }
            
        
        
    }
    
    public static void main(String[] args) {
        M3_Activitat1 act1 = new M3_Activitat1();
        act1.setSize(300, 200);
        act1.setVisible(true);
    }   
}
