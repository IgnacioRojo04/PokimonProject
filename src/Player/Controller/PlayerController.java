package Player.Controller;

import Player.Model.Entity.Player;
import Player.Model.Repository.JDBC.PlayerDAOJDBC;
import Player.View.PlayerView;
import Player.View.TablePlayerView;
import Pókemon.Model.Entity.Pokemon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PlayerController {

    public PlayerView playerView;
    public TablePlayerView tablePlayerView;
    public PlayerDAOJDBC playerDao;

    public PlayerController() {
        this.playerView = new PlayerView();
        this.tablePlayerView = new TablePlayerView();
        this.playerDao = new PlayerDAOJDBC();
    }

    public boolean createPlayer() {
        this.playerDao.listar();
        boolean repeat = false;
        for (Player player : this.playerDao.playerList) {
            if (player.getName().equals(this.playerView.tfName.getText())) {
                repeat = true;
            }
        }
        if (!repeat) {
            this.playerDao.player.setName(this.playerView.tfName.getText());
            this.playerDao.crear(this.playerDao.player);
        }
        return repeat;
    }

    public void deletePlayer() {
        int indice = this.tablePlayerView.cbPlayer.getSelectedIndex();
        this.playerDao.eliminar(this.playerDao.playerList.get(indice).getId());
        this.playerDao.playerList.remove(indice);
        DefaultTableModel model = (DefaultTableModel) this.tablePlayerView.tPlayer.getModel();
        model.removeRow(indice);
        this.tablePlayerView.cbPlayer.removeItem(this.tablePlayerView.cbPlayer.getSelectedItem());

    }

    public void setMoney(int price) {
        int currentMoney = this.playerDao.player.getMoney();
        this.playerDao.player.setMoney(currentMoney + price);
        this.playerDao.actualizar(this.playerDao.player);
    }

    public void ContinueGame() {

        DefaultTableModel model = (DefaultTableModel) tablePlayerView.tPlayer.getModel();
        model.setRowCount(0);
        tablePlayerView.cbPlayer.removeAllItems();
        this.playerDao.listar();
        System.out.println("asada");
        for (Player player : this.playerDao.playerList) {
            System.out.println(player.getName());
            model.addRow(new Object[]{
                player.getName(),
                player.getMoney(),});
            tablePlayerView.cbPlayer.addItem(player.getName());
        }
    }

    public void selectContinue() {
        int indice = this.tablePlayerView.cbPlayer.getSelectedIndex();
        System.out.println(this.playerDao.playerList.get(indice).getName());
        this.playerDao.player = this.playerDao.playerList.get(indice);
    }

}
