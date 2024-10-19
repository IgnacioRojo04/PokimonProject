
package Player.Controller;

import Player.Model.Entity.Player;
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
      this.playerView.createPlayer();
     this.playerDao.crear(this.playerView.player);
    }

        
    public void setMoney(int price){
       int currentMoney = this.playerView.player.getMoney();
        System.out.println(currentMoney);
        System.out.println(price);
       this.playerView.player.setMoney(currentMoney + price); 
    }  


}
