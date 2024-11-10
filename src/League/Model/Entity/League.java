
package League.Model.Entity;
import Player.Model.Entity.Leader;
import Pókemon.Model.Entity.Pokemon;
import java.util.List;

// esto Habria que BORRARLO creo, por si acaso lo dejo aca pero lo borramo despues

public class League {
    
 Leader lider;  
 public List<Pokemon> pokemonLeagueList;   

    public League(Leader lider, List<Pokemon> pokemonLeagueList) {
        this.lider = lider;
        this.pokemonLeagueList = pokemonLeagueList;
    }

    public Leader getLider() {
        return lider;
    }

    public List<Pokemon> getPokemonLeagueList() {
        return pokemonLeagueList;
    }

    public void setLider(Leader lider) {
        this.lider = lider;
    }

    public void setPokemonLeagueList(List<Pokemon> pokemonLeagueList) {
        this.pokemonLeagueList = pokemonLeagueList;
    }
 
 
 
    
    
    
}
