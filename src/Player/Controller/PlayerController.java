

package Player.Controller;


import Player.Model.Entity.Player;
import Player.Model.Repository.JDBC.PlayerDAOJDBC;
import Player.View.PlayerView;
import Player.View.TablePlayerView;
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
    public void createPlayer(){
     this.playerDao.player.setName(this.playerView.tfName.getText());
     this.playerDao.crear(this.playerDao.player);
    }
    public void deletePlayer(){
        this.playerDao.eliminar(this.playerDao.player.getId());
    }
        
    public void setMoney(int price){
       int currentMoney = this.playerDao.player.getMoney();
       this.playerDao.player.setMoney(currentMoney + price); 
    }  
    public void ContinueGame(){
        
        DefaultTableModel model = (DefaultTableModel) tablePlayerView.tPlayer.getModel();
        model.setRowCount(0);
        tablePlayerView.cbPlayer.removeAllItems();
         this.playerDao.listar();
        for (Player player : this.playerDao.playerList) {
            System.out.println(player.getName());
            model.addRow(new Object[]{
                player.getName(),
                player.getMoney(),
                });
            tablePlayerView.cbPlayer.addItem(player.getName());
        }
    }


}

