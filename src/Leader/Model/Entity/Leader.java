
package Leader.Model.Entity;

import Character.Character;
import Pókemon.Model.Entity.Pokemon;
import java.util.ArrayList;
import java.util.List;


public class Leader extends Character{
    
    private boolean defeated;
    private int difficulty = this.getId();

    public boolean isDefeated() {
        return defeated;
    }

    public void setDefeated(boolean defeated) {
        this.defeated = defeated;
    }

    

    public Leader() {
    }
    
     public Leader(String name) {
        super(name) ;  
        this.difficulty = this.getId() - 9;
        // borar esot es solo prueba
        this.teamPokemon = new ArrayList<>();
 
    }
     public Leader(String name, int money, int id) {
        super(name, money, id);
        this.defeated = false;
        this.difficulty = this.getId() - 9;
    }
    
    public Leader(String name, List<Pokemon> teamPokemon, int money) {
        super(name, money);
        this.teamPokemon = new ArrayList<>();
        this.defeated = false;
        this.difficulty = this.getId() - 10;
        
    }

    public Leader(boolean defeated, int difficulty) {
        this.defeated = defeated;
        this.difficulty = this.getId() - 10;
    }

    public Leader(boolean defeated, int difficulty, String name, int money) {
        super(name, money);
        this.defeated = defeated;
        this.difficulty = this.getId() - 10;
    }

    public Leader(boolean defeated, int difficulty, String name) {
        super(name);
        this.defeated = defeated;
        this.difficulty = this.getId() - 10;
    }

    public int getDifficulty() {
        return difficulty;
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

        return "leader:" + name + this.defeated;
    }

    
    
    

  
    
}
