
package Player.Model.Entity;

import Pókemon.Model.Entity.Pokemon;
import java.util.ArrayList;
import java.util.List;


public class Leader extends Character{
    
    private boolean defeated;

    public boolean isDefeated() {
        return defeated;
    }

    public void setDefeated(boolean defeated) {
        this.defeated = defeated;
    }

    

    public Leader() {
    }
    
     public Leader( String name) {
        super(name) ;   
    }
    
    public Leader(String name, List<Pokemon> teamPokemon, int money, boolean defeated) {
        super(name, money);
        this.teamPokemon = new ArrayList<>();
        this.defeated = false;
        
    }
    
    

  

    public void setTeamPokemon(List<Pokemon> teamPokemon) {
        this.teamPokemon = teamPokemon;
    }
    

    @Override
    public void sell() {
    }

    @Override
    public void buy() {
    }
    
    public void mostrarEquipo() {
        System.out.println("Equipo de " + getName() + ":");
        for (Pokemon pokemon : getTeamPokemon()) {
            System.out.println(pokemon);
        }
    }

    @Override
    public String toString() {
        return "Leader{" + '}';
    }
    
    

  
    
}
