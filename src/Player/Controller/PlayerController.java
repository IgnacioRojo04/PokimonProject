
package Player.Controller;


import Player.Model.Repository.JDBC.PlayerDAOJDBC;
import Player.View.PlayerView;

public class PlayerController {

    public PlayerView playerView;
    public PlayerDAOJDBC playerDao;

    public PlayerController() {
        this.playerView = new PlayerView();
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


}
