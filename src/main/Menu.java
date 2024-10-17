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

        lblGym.setText("Gym");

        lblArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow-little-removebg-preview.png"))); // NOI18N

        btnPoke.setOpaque(true);

        btnMarket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarketActionPerformed(evt);
            }
        });

        lblPoke.setText("Pokemones");

        lblMain.setText("Haz click en alguna de las opciones para viajar !!");

        lblMarket.setText("Mercado");

        lblArrow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow-little-removebg-preview.png"))); // NOI18N

        lblArrow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow-little-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(lblPoke))
                    .addComponent(btnPoke, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(lblArrow2))))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblArrow1))
                    .addComponent(btnMarket, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblMarket)))
                .addGap(560, 560, 560)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblArrow))
                    .addComponent(btnGym, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblGym))))
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(lblMain))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(lblPoke))
                    .addComponent(btnPoke, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(lblArrow2)))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblArrow1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnMarket, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(lblMarket))))
                    .addComponent(lblArrow)
                    .addComponent(btnGym, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblGym)))
                .addGap(40, 40, 40)
                .addComponent(lblMain))
        );
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
