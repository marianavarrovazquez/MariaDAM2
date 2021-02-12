package m3_prova1;

import javax.swing.*;
import java.awt.*;

public class M3_Prova3 extends JFrame {
    JPanel panel;
    JButton label;
    JButton button;
    JButton label2;
    JButton label3;
    JButton label4;
    JButton btnNorth;
    JButton btnSouth;
    JButton btnEast;
    JButton btnWest;
    JButton btnCenter;
    
    M3_Prova3(String title) {
        super(title);
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
//        label = new JButton("Hello Swing!");
//        add(label);
//        
//        button = new JButton("Hello Swing2!");
//        add(button);
//        label3 = new JButton("Hello Swing3!");
//        add(label3);
//        label4 = new JButton("Hello Swing4!");
//        add(label4);
        
        btnNorth = new JButton("NORTH");
        add(btnNorth, BorderLayout.NORTH);
        
        btnSouth = new JButton("SOUTH");
        add(btnSouth, BorderLayout.SOUTH);
        
        btnEast = new JButton("EAST");
        add(btnEast, BorderLayout.EAST);
        
        btnWest = new JButton("WEST");
        add(btnWest, BorderLayout.WEST);
        
        btnCenter = new JButton("CENTER");
        add(btnCenter, BorderLayout.CENTER);
//        setSize(150,(int)(label4.getVerticalAlignment()+30));
        
        
    }
    
    public static void main(String[] args) {
        M3_Prova3 frame = new M3_Prova3("Hello");
        frame.setVisible(true);
    }
}
