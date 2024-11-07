
package Player.Model.Entity;

import Pókemon.Model.Entity.Pokemon;
import java.util.ArrayList;
import java.util.List;


public class Leader extends Character{

    public int dificultad;

    public Leader() {
    }
    
    public Leader(String name, List<Pokemon> teamPokemon, int money, int dificultad) {
        super(name, money);
        this.teamPokemon = new ArrayList<>();
        this.dificultad = dificultad;
        
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
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
        return "Líder: " + getName() + " (Dificultad: " + dificultad + ")";
    }

  
    
}
