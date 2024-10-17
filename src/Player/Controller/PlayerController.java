
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
    public void createPlayer(Player player){
      this.playerView.createPlayer();
     this.playerDao.crear(player);
    }
      


}
