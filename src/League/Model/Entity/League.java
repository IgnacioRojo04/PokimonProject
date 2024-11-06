
package League.Model.Entity;

import Lideres.Model.Entity.Lideres;
import Pókemon.Model.Entity.Pokemon;
import java.util.List;


public class League {
    
 Lideres lider;  
 public List<Pokemon> pokemonLeagueList;   

    public League(Lideres lider, List<Pokemon> pokemonLeagueList) {
        this.lider = lider;
        this.pokemonLeagueList = pokemonLeagueList;
    }

    public Lideres getLider() {
        return lider;
    }

    public List<Pokemon> getPokemonLeagueList() {
        return pokemonLeagueList;
    }

    public void setLider(Lideres lider) {
        this.lider = lider;
    }

    public void setPokemonLeagueList(List<Pokemon> pokemonLeagueList) {
        this.pokemonLeagueList = pokemonLeagueList;
    }
 
 
 
    
    
    
}
