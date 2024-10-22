

package Player.Model.Entity;
//import Player.Model.Entity.Character;

public class Player extends Character{

    public Player(String name){
        super(name, 10);
    }
    public Player(){
         super("prueba", 1000);
    }
    
    @Override
    public void sell() {
    }

    @Override
    public void buy() {
    }
}
    
