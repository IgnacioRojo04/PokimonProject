/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Player.View;

import Interface.DAO;
import Player.Controller.PlayerController;
import Player.Model.Entity.Player;
import Player.Model.Repository.JDBC.PlayerDAOJDBC;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import main.MainView;



/**
 *
 * @author retam
 */
public class PlayerView extends javax.swing.JPanel {
    

   

    public PlayerView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bCreatePlayer = new javax.swing.JButton();
        tfName = new javax.swing.JTextField();
        bDeletePlayer = new javax.swing.JButton();

        setToolTipText("");
        setName(""); // NOI18N

        bCreatePlayer.setText("Crear player");
        bCreatePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCreatePlayerActionPerformed(evt);
            }
        });

        tfName.setText("Nombre");

        bDeletePlayer.setText("Eliminar Player");
        bDeletePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeletePlayerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bDeletePlayer)
                            .addComponent(bCreatePlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bCreatePlayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bDeletePlayer)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bCreatePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreatePlayerActionPerformed

    }//GEN-LAST:event_bCreatePlayerActionPerformed

    private void bDeletePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeletePlayerActionPerformed
        
    }//GEN-LAST:event_bDeletePlayerActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bCreatePlayer;
    private javax.swing.JButton bDeletePlayer;
    public javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
