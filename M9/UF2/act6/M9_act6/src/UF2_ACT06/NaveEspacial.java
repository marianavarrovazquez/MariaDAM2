/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UF2_ACT06;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;


/**
 *
 * @author Maria e Ivan
 */
public class NaveEspacial extends javax.swing.JFrame {
    public NaveEspacial() {
        initComponents();
        }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGap(0, 300, Short.MAX_VALUE));
        pack();
        }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                    }
                }
            }
        catch (Exception ex) {
            java.util.logging.Logger.getLogger(NaveEspacial.class.getName()).log(
                java.util.logging.Level.SEVERE, null, ex);
            }       
        NaveEspacial f = new NaveEspacial();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Naus Espaials");
        f.setContentPane(new PanelNau());
        f.setSize(500, 550);
        f.setVisible(true);
        }
    }


class PanelNau extends JPanel implements Runnable, KeyListener{
    private int numNaus=3;    
    Nau[] nau;
    Nau naveMov;
    
    public PanelNau(){        
        nau = new Nau[numNaus];
        for (int i=0;i<nau.length;i++) {
            Random rand = new Random();
            int velocitat=(rand.nextInt(3)+5)*10;
            int posX=rand.nextInt(100)+30;
            int posY=rand.nextInt(100)+30;
            int dX=rand.nextInt(3)+1;
            int dY=rand.nextInt(3)+1;
            String nomNau = Integer.toString(i);
            nau[i]= new Nau(nomNau,posX,posY,dX,dY,velocitat);
            }
        naveMov = new Nau("Navesita",200,440,0,0,100);
        Thread n = new Thread(this);
        n.start();   
        addKeyListener(this);
        setFocusable(true);
        }

    public void run() {
        System.out.println("Inici fil repintar");
        while(true) {
            try { Thread.sleep(100);} catch(Exception e) {} // espero 0,1 segons
            System.out.println("Repintant");
            repaint();            
            }                   
        }

    public synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0; i<nau.length;++i) {
            nau[i].pinta(g);
        }
        naveMov.pinta(g);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int teclaPulsada = ke.getKeyCode();
        
        if(teclaPulsada == 37){
            naveMov.izquierda();
        } else if (teclaPulsada == 39){
            naveMov.derecha();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        naveMov.parar();
    }


class Nau extends Thread {
    private String nomNau;
    private int x,y;
    private int dsx,dsy,v;
    private int tx = 10;
    private int ty = 10;

    private String img = "/images/nau.jpg";
    private Image image;

    public Nau(String nomNau, int x, int y, int dsx, int dsy, int v ) {
        this.nomNau = nomNau;
        this.x=x;
        this.y=y;
        this.dsx=dsx;
        this.dsy=dsy;
        this.v=v;
        if(nomNau.equals("Navesita")){
            image = new ImageIcon(Nau.class.getResource("millennium_falcon.png")).getImage();
        }else {
            image = new ImageIcon(Nau.class.getResource("X-wing.png")).getImage();
        }
        
        Thread t = new Thread(this);
        t.start();
        }
    
    public int velocitat (){
        return v;
        }
    
    public synchronized void moure (){
        x=x + dsx;
        y=y + dsy;
        // si arriva als marges ...
        if ( x>= 440 - tx || x<= tx) dsx = - dsx;
        if ( y >= 400 - ty || y<=ty ) dsy = - dsy;
        }
    
    public synchronized void pinta (Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(this.image, x, y, null);
    }

    public void run() {
        while (true) {
            System.out.println("Movent nau " + this.nomNau);
            try { Thread.sleep(this.v); } catch (Exception e) {}
            moure();
            }
        }

        private void izquierda() {
            if(!(x <= 0 - tx)) {
                this.dsx = -10;
            }
        }

        private void derecha() {
            if(!(x >= 440 - tx)) {
                this.dsx = 10;
            }
        }

        private void parar() {
            this.dsx = 0;
        }
    }
}

