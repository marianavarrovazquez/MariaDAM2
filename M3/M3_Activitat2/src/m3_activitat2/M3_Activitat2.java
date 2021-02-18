/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3_activitat2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author maria
 */
public class M3_Activitat2 extends JFrame implements ActionListener{
    JButton bFc;
    JButton bCf;
    JButton bBorrar;
    JLabel l;
    JTextField f;
    JTextField c;
    
    //constructor
    public M3_Activitat2() {
        l = new JLabel("Conversor");
        f = new JTextField(10);
        c = new JTextField(10);
        bFc = new JButton("Pasar de F a C");
        bCf = new JButton("Pasar de C a F");
        bBorrar = new JButton("Borrar");
        
        setLayout(new FlowLayout());
        
        //register the buttonFrame object as the listener for the JBtton
        bFc.addActionListener(this);
        bCf.addActionListener(this);
        bBorrar.addActionListener(this);
        
        add(l);
        add(f);
        add(c);
        add(bFc);        
        add(bCf);
        add(bBorrar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //listener method required by the interface
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getActionCommand().equals("Pasar de F a C")) {
           int far = Integer.parseInt(f.getText());
           int cel = (far - 32) * 5/9;
           c.setText(String.valueOf(cel));
       }
       if(ae.getActionCommand().equals("Pasar de C a F")) {
           int cel = Integer.parseInt(c.getText());
           int far = (cel * 9-5) + 32;
           f.setText(String.valueOf(far));
       }
       if(ae.getActionCommand().equals("Borrar")) {
           f.setText("");
           c.setText("");
       }
    }
    
    public static void main(String[] args) {
        M3_Activitat2 act2 = new M3_Activitat2();
        act2.setSize(200, 300);
        act2.setVisible(true);
    }
}
