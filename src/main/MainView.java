package main;

import Gym.Controller.GymController;
import Market.Controller.MarketController;
import Player.Controller.PlayerController;
import Pókemon.Controller.PokemonController;
import Pókemon.Model.Entity.Pokemon;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;

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

    public MainView() {
        initComponents();
        container_add();
        showPlayerView(this.playerController.playerDao.player.getTeamPokemon());
        showMenuPanel(this.playerController);
        showMarketView();
        backMarket();
        showPokemonView();
        backPoke();
        backGym();
        showGym();
        buyMarket();
        sellPoke();
        trainPokemon();
        catchPokemon();
        upgradeMarket();
        deleteRarity();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Evita el cierre inmediato

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Aquí puedes llamar a tu método
                marketController.marketDao.reiniciarTablaBD();
                // Finalmente, cierra el JFrame
                // dispose(); // O usa System.exit(0) si quieres salir de la aplicación
                System.exit(0);
            }
        });

    }

    public void container_add() {
        container.setLayout(new CardLayout());
        container.add(this.homeView, "Home");
        container.add(this.playerController.playerView, "Player");
        container.add(this.menu, "Menu");
        container.add(this.marketController.marketView, "Market");
        container.add(this.pokemonController.pokemonView, "Pokemon");
        container.add(this.gymController.gymView, "Gym");
        setContentPane(container);
        this.layout = (CardLayout) container.getLayout();
        layout.show(container, "Home");
    }

    public void showPlayerView(List<Pokemon> pokemonList) {
        this.homeView.btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerController.createPlayer();
                layout.show(container, "Player");
            }
        });
    }

    public void showMenuPanel(PlayerController playerController) {
        this.playerController.playerView.bCreatePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerController.createPlayer();
                layout.show(container, "Menu");
            }
        });
    }

    public void showMarketView() {
        this.menu.btnMarket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marketController.createPokemon();
                marketController.showMoney(playerController.playerDao.player.getMoney());
                layout.show(container, "Market");
            }
        });
    }

    public void showGym() {
        this.menu.btnGym.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gymController.gymView.lblMoney.setText(playerController.playerDao.player.getMoney() + "");
                gymController.fillTable(playerController.playerDao.player.getTeamPokemon(), playerController.playerDao.player);
                layout.show(container, "Gym");
            }
        });
    }

    public void showPokemonView() {
        this.menu.btnPoke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pokemonController.fillTable(playerController.playerDao.player.getTeamPokemon());
                pokemonController.showMoney(playerController.playerDao.player.getMoney());
                layout.show(container, "Pokemon");
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

    public void backPoke() {
        this.pokemonController.pokemonView.btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(container, "Menu");
            }
        });
    }

    public void backGym() {
        this.gymController.gymView.btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("back");
                layout.show(container, "Menu");
            }
        });
    }

    public void buyMarket() {
        this.marketController.marketView.btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titleJd = " ";
                if (marketController.marketDao.pokemonList.size() > 0) {
                    int moneyPlayer = playerController.playerDao.player.getMoney();
                    int indice = marketController.marketView.cbMarket.getSelectedIndex();
                    int pokemonCost = marketController.marketDao.pokemonList.get(indice).getCost();
                    if (playerController.playerDao.player.getTeamPokemon().size() < 6 && moneyPlayer - pokemonCost >= 0) {
                        playerController.setMoney(-pokemonCost);
                        marketController.buyPoke(playerController.playerDao.player.getTeamPokemon(), playerController.playerDao.player);
                        marketController.showMoney(playerController.playerDao.player.getMoney());
                    } else {

                        if (playerController.playerDao.player.getTeamPokemon().size() >= 6) {
                            titleJd += "Equipo lleno. ";
                        }
                        if (moneyPlayer - pokemonCost < 0) {
                            titleJd += "Sin Dinero. ";
                        }
                        if (marketController.marketDao.pokemonList.size() <= 0) {
                            titleJd += "No hay pokemon para comprar. ";
                        }
                        jdExeption.setTitle("No podes comprar:");
                        lblDialog.setText(titleJd);
                        jdExeption.setSize(400, 100);
                        jdExeption.setModal(true);
                        jdExeption.setVisible(true);
                    }
                } else {
                    titleJd += "No hay pokemon para comprar. ";
                    jdExeption.setTitle("No podes comprar:");
                    lblDialog.setText(titleJd);
                    jdExeption.setSize(400, 100);
                    jdExeption.setModal(true);
                    jdExeption.setVisible(true);
                }
            }
        });
    }

    public void sellPoke() {
        this.pokemonController.pokemonView.btnSellPoke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerController.playerDao.player.getTeamPokemon().size() > 0) {
                    int indice = pokemonController.pokemonView.cbPokeName.getSelectedIndex();
                    playerController.setMoney(playerController.playerDao.player.getTeamPokemon().get(indice).getCost());
                    pokemonController.showMoney(playerController.playerDao.player.getMoney());
                    pokemonController.SellPokemon(playerController.playerDao.player.getTeamPokemon());
                } else {
                    jdExeption.setTitle("No podes vender:");
                    lblDialog.setText("No hay pokemon para vender");
                    jdExeption.setSize(400, 100);
                    jdExeption.setModal(true);

                    jdExeption.setVisible(true);
                }
            }
        });
    }

    public void trainPokemon() {
        this.gymController.gymView.btnTrain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerController.playerDao.player.getMoney() >= 5) {
                    System.out.println(playerController.playerDao.player.getMoney());
                    playerController.setMoney(-5);
                    gymController.trainPokemon(playerController.playerDao.player.getTeamPokemon(), playerController.playerDao.player);
                } else {
                    jdExeption.setTitle("No podes Entrenar");
                    lblDialog.setText("No Tienes Dinero.");
                    jdExeption.setSize(400, 100);
                    jdExeption.setModal(true);
                    jdExeption.setVisible(true);
                }
            }
        });
    }

    public void catchPokemon() {
        this.gymController.gymView.btnCatch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerController.playerDao.player.getMoney() >= 5) {
                    playerController.setMoney(-5);
                    Pokemon pokemonNew = gymController.catchPokemon(playerController.playerDao.player.getTeamPokemon(), playerController.playerDao.player);
                    if (pokemonNew != null) {
                        jdExeption.setTitle("¡Captura exitosa!:");
                        lblDialog.setText("El pokemon ahora es parte de tu equipo.");
                        jdExeption.setSize(400, 100);
                        jdExeption.setModal(true);
                        jdExeption.setVisible(true);
                    } else {
                        jdExeption.setTitle("No pudiste capturar:");
                        lblDialog.setText("El pokemon se fue.");
                        jdExeption.setSize(400, 100);
                        jdExeption.setModal(true);
                        jdExeption.setVisible(true);
                    }
                } else {
                    jdExeption.setTitle("No podes Capturar");
                    lblDialog.setText("No Tienes Dinero.");
                    jdExeption.setSize(400, 100);
                    jdExeption.setModal(true);
                    jdExeption.setVisible(true);
                }
            }
        });
    }

    public void upgradeMarket() {
        this.marketController.marketView.btnUpgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerController.playerDao.player.getMoney() >= 10) {
                    playerController.setMoney(-10);
                    marketController.marketDao.pokemonList.clear();
                    marketController.marketDao.reiniciarTablaBD();
                    marketController.createPokemon();
                    marketController.showMoney(playerController.playerDao.player.getMoney());
                } else {
                    jdExeption.setTitle("No podes actualizar:");
                    lblDialog.setText("No Tienes Dinero.");
                    jdExeption.setSize(400, 100);
                    jdExeption.setModal(true);
                    jdExeption.setVisible(true);
                }
            }
        });
    }

    public void deleteRarity() {
        this.marketController.marketView.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (true) {

                    int rarity = (int) (marketController.marketView.cbRarity.getSelectedIndex());
                    rarity += 1;
                    marketController.marketDao.eliminar(rarity);
                    marketController.marketDao.listar();
                    marketController.fillTable();
                } else {
                    jdExeption.setTitle("No podes eliminar:");
                    lblDialog.setText("No existe la rareza.");
                    jdExeption.setSize(400, 100);
                    jdExeption.setModal(true);
                    jdExeption.setVisible(true);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdExeption = new javax.swing.JDialog();
        lblDialog = new javax.swing.JLabel();
        container = new javax.swing.JPanel();

        javax.swing.GroupLayout jdExeptionLayout = new javax.swing.GroupLayout(jdExeption.getContentPane());
        jdExeption.getContentPane().setLayout(jdExeptionLayout);
        jdExeptionLayout.setHorizontalGroup(
            jdExeptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDialog, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jdExeptionLayout.setVerticalGroup(
            jdExeptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdExeptionLayout.createSequentialGroup()
                .addComponent(lblDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 259, Short.MAX_VALUE))
        );

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
    public javax.swing.JDialog jdExeption;
    public javax.swing.JLabel lblDialog;
    // End of variables declaration//GEN-END:variables
}
