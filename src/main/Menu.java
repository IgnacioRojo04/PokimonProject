package main;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Menu extends javax.swing.JPanel {

    public Image fondo;

    public Menu() {
        this.fondo = new ImageIcon("src/img/fondoMenu.jpg").getImage();
        initComponents();
       transparentButton();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo
        if (fondo != null) {
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void transparentButton() {

        this.btnGym.setOpaque(false);
        this.btnGym.setContentAreaFilled(false);
        this.btnGym.setBorderPainted(false);

        this.btnPoke.setOpaque(false);
        this.btnPoke.setContentAreaFilled(false);
        this.btnPoke.setBorderPainted(false);
        
        this.btnMarket.setOpaque(false);
        this.btnMarket.setContentAreaFilled(false);
        this.btnMarket.setBorderPainted(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGym = new javax.swing.JLabel();
        lblArrow = new javax.swing.JLabel();
        btnPoke = new javax.swing.JButton();
        btnMarket = new javax.swing.JButton();
        btnGym = new javax.swing.JButton();
        lblPoke = new javax.swing.JLabel();
        lblMain = new javax.swing.JLabel();
        lblMarket = new javax.swing.JLabel();
        lblArrow1 = new javax.swing.JLabel();
        lblArrow2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGym.setText("Gym");
        add(lblGym, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 320, -1, -1));

        lblArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow-little-removebg-preview.png"))); // NOI18N
        add(lblArrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 270, -1, -1));

        btnPoke.setOpaque(true);
        add(btnPoke, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 230, 180));

        btnMarket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarketActionPerformed(evt);
            }
        });
        add(btnMarket, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 170, 150));
        add(btnGym, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, 160, 110));

        lblPoke.setText("Pokemones");
        add(lblPoke, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        lblMain.setText("Haz click en alguna de las opciones para viajar !!");
        add(lblMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, -1, -1));

        lblMarket.setText("Mercado");
        add(lblMarket, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));

        lblArrow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow-little-removebg-preview.png"))); // NOI18N
        add(lblArrow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        lblArrow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow-little-removebg-preview.png"))); // NOI18N
        add(lblArrow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnMarketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMarketActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGym;
    public javax.swing.JButton btnMarket;
    public javax.swing.JButton btnPoke;
    private javax.swing.JLabel lblArrow;
    private javax.swing.JLabel lblArrow1;
    private javax.swing.JLabel lblArrow2;
    private javax.swing.JLabel lblGym;
    private javax.swing.JLabel lblMain;
    private javax.swing.JLabel lblMarket;
    private javax.swing.JLabel lblPoke;
    // End of variables declaration//GEN-END:variables
}
