/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import Gym.Controller.GymController;
import Gym.View.GymView;
import Market.Controller.MarketController;
import Market.View.MarketView;
import Player.Controller.PlayerController;
import Player.Model.Entity.Player;
import Player.View.PlayerView;
import Pókemon.Controller.PokemonController;
import Pókemon.Model.Entity.Pokemon;
import Pókemon.View.PokemonView;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author retam
 */
public class MainView extends javax.swing.JFrame {

    private PlayerController playerController = new PlayerController();
    private MarketController marketController = new MarketController();
    private PokemonController pokemonController = new PokemonController();
    private GymController gymController = new GymController();
    private Home homeView = new Home();
    private Menu menu = new Menu();
    private CardLayout layout;
    private GymView gymView = new GymView(); // -> agregar el controller.
    private List<Pokemon> teamPokemon = this.pokemonController.pokemonView.teamPokemon;

    public MainView() {
        initComponents();
        
        container_add();
        showPlayerView(this.teamPokemon, this.pokemonController);
        showMenuPanel(this.playerController);
        showMarketView();
        backMarket();
        showPokemonView();
        backPoke();
        backGym();
        showGym();
        buyMarket();
        sellPoke();
    }

    public void container_add() {
        container.setLayout(new CardLayout());
        container.add(this.homeView, "Home");
        container.add(this.playerController.playerView, "Player");
        container.add(this.menu, "Menu");
        container.add(this.marketController.marketView, "Market");
        container.add(this.pokemonController.pokemonView, "Pokemon");

        container.add(this.gymView, "Gym");

        setContentPane(container);
        this.layout = (CardLayout) container.getLayout();
        layout.show(container, "Home");
    }

    public void showPlayerView(List<Pokemon> pokemonList, PokemonController pokemonController) {
        this.homeView.btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(container, "Player");
            }
        });
    }

    public void showMenuPanel(PlayerController playerController) {
        this.playerController.playerView.bCreatePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerController.createPlayer(playerController.playerView.player);
                layout.show(container, "Menu");
            }
        });
    }

    public void showMarketView() {
        this.menu.btnMarket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marketController.fillTable();
                marketController.showMoney(playerController.playerView.player.getMoney());
                layout.show(container, "Market");
            }
        });
    }

    public void showGym() {
        this.menu.btnGym.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gymController.fillTable(pokemonController.pokemonView.teamPokemon);
                layout.show(container, "Gym");
            }
        });
    }

    public void backMarket() {
        this.marketController.marketView.btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(container, "Menu");
            }
        });
    }

    public void showPokemonView() {
        this.menu.btnPoke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pokemonController.fillTable();
                pokemonController.showMoney(playerController.playerView.player.getMoney());
                layout.show(container, "Pokemon");
            }
        });
    }

    public void backPoke() {
        this.pokemonController.pokemonView.btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(container, "Menu");
            }
        });
    }

    public void backGym() {
        this.gymView.btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(container, "Menu");
            }
        });
    }

    public void buyMarket() {
        this.marketController.marketView.btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titleJd = "No podes comprar: ";
                if (marketController.marketView.listPokemon.size() > 0) {
                    int moneyPlayer = playerController.playerView.player.getMoney();
                    int indice = marketController.marketView.cbMarket.getSelectedIndex();
                    int pokemonCost = marketController.marketView.listPokemon.get(indice).getCost();
                    for (Pokemon p : teamPokemon) {
                        System.out.println(p.getName());
                    }
                    if (teamPokemon.size() < 6 && moneyPlayer - pokemonCost >= 0) {
                        playerController.setMoney(-pokemonCost);
                        marketController.buyPoke(teamPokemon, moneyPlayer);
                        marketController.showMoney(playerController.playerView.player.getMoney());

                    } else {

                        if (teamPokemon.size() >= 6) {
                            titleJd += "Equipo lleno. ";
                        }
                        if (moneyPlayer - pokemonCost < 0) {
                            titleJd += "Sin Dinero. ";
                        }
                        if (marketController.marketView.listPokemon.size() <= 0) {
                            titleJd += "No hay pokemon para comprar. ";
                        }
                        marketController.marketView.jdExeption.setTitle(titleJd);
                        marketController.marketView.jdExeption.setSize(400, 300);
                        marketController.marketView.jdExeption.setModal(true);

                        marketController.marketView.jdExeption.setVisible(true);

                    }
                } else {
                    titleJd += "No hay pokemon para comprar. ";
                    marketController.marketView.jdExeption.setTitle(titleJd);
                    marketController.marketView.jdExeption.setSize(400, 300);
                    marketController.marketView.jdExeption.setModal(true);

                    marketController.marketView.jdExeption.setVisible(true);
                }
            }
        });
    }

    public void sellPoke() {
        this.pokemonController.pokemonView.btnSellPoke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (teamPokemon.size() > 0) {
                    int indice = pokemonController.pokemonView.cbPokeName.getSelectedIndex();
                    playerController.setMoney(pokemonController.pokemonView.teamPokemon.get(indice).getCost());
                    pokemonController.showMoney(playerController.playerView.player.getMoney());
                    pokemonController.SellPokemon();
                }
                else{
                    String titleJd = "No hay pokemon para vender";
                    marketController.marketView.jdExeption.setTitle(titleJd);
                    marketController.marketView.jdExeption.setSize(400, 300);
                    marketController.marketView.jdExeption.setModal(true);

                    marketController.marketView.jdExeption.setVisible(true);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main");

        container.setBorder(new javax.swing.border.MatteBorder(null));
        container.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1058, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    // End of variables declaration//GEN-END:variables
}
