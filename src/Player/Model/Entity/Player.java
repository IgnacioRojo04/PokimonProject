

package Player.Model.Entity;
//import Player.Model.Entity.Character;

import Character.Character;


public class Player extends Character{

    public Player(String name){
        super(name, 12);
    }
    public Player(){
         super("prueba", 150);
    }
    
    @Override
    public void sell() {
    }

    @Override
    public void buy() {
    }
}
    
