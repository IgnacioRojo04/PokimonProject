package main;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import main.MainView;

/**
 *
 * @author retam
 */
public class Home extends javax.swing.JPanel {

    private MainView mainView;
    

    /**
     * Creates new form Home
     */
    private Image fondo;


    public Home() {
        this.fondo = new ImageIcon("src/img/bgHome.jpg").getImage();
        initComponents();
       this.btnNewGame.setBounds(100, 100, 150, 30);   // Ajusta estas posiciones como quieras
       this.btnContinue.setBounds(100, 150, 150, 30);
      
        // Añadir los botones al Home
        add(btnNewGame);
        add(btnContinue);   
       
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo
        if (fondo != null) {
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNewGame = new javax.swing.JButton();
        btnContinue = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        btnNewGame.setText("Nuevo Juego");
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });
        add(btnNewGame, new java.awt.GridBagConstraints());

        btnContinue.setText("Continuar");
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });
        add(btnContinue, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
        
    }//GEN-LAST:event_btnNewGameActionPerformed

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnContinueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnContinue;
    public javax.swing.JButton btnNewGame;
    // End of variables declaration//GEN-END:variables
}
