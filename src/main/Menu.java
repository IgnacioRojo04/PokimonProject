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
        
        this.btnLiga.setOpaque(false);
        this.btnLiga.setContentAreaFilled(false);
        this.btnLiga.setBorderPainted(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPoke = new javax.swing.JLabel();
        lblMarket = new javax.swing.JLabel();
        lblMain = new javax.swing.JLabel();
        lblGym = new javax.swing.JLabel();
        btnPoke = new javax.swing.JButton();
        btnMarket = new javax.swing.JButton();
        btnGym = new javax.swing.JButton();
        lblArrow1 = new javax.swing.JLabel();
        lblArrow2 = new javax.swing.JLabel();
        lblArrow = new javax.swing.JLabel();
        lblLiga = new javax.swing.JLabel();
        btnLiga = new javax.swing.JButton();
        lblArrow3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPoke.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblPoke.setText("Pokemones");
        add(lblPoke, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        lblMarket.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblMarket.setText("Mercado");
        add(lblMarket, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 210, 49));

        lblMain.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMain.setText("Haz click en alguna de las opciones para viajar !!");
        add(lblMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 340, 40));

        lblGym.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblGym.setText("Gym");
        add(lblGym, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 120, 60));

        btnPoke.setOpaque(true);
        add(btnPoke, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 450, 200));

        btnMarket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarketActionPerformed(evt);
            }
        });
        add(btnMarket, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 270, 200));
        add(btnGym, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 160, 110));

        lblArrow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow-little-removebg-preview.png"))); // NOI18N
        add(lblArrow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        lblArrow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow-little-removebg-preview.png"))); // NOI18N
        add(lblArrow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, -1));

        lblArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow-little-removebg-preview.png"))); // NOI18N
        add(lblArrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, -1, -1));

        lblLiga.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblLiga.setText("Liga Pokemon");
        add(lblLiga, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 340, 50));

        btnLiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigaActionPerformed(evt);
            }
        });
        add(btnLiga, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 370, 70));

        lblArrow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow-little-removebg-preview.png"))); // NOI18N
        add(lblArrow3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 300, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void btnMarketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMarketActionPerformed

    private void btnLigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLigaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGym;
    public javax.swing.JButton btnLiga;
    public javax.swing.JButton btnMarket;
    public javax.swing.JButton btnPoke;
    private javax.swing.JLabel lblArrow;
    private javax.swing.JLabel lblArrow1;
    private javax.swing.JLabel lblArrow2;
    private javax.swing.JLabel lblArrow3;
    private javax.swing.JLabel lblGym;
    private javax.swing.JLabel lblLiga;
    private javax.swing.JLabel lblMain;
    private javax.swing.JLabel lblMarket;
    private javax.swing.JLabel lblPoke;
    // End of variables declaration//GEN-END:variables
}
