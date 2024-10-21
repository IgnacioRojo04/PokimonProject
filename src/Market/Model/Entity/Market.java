
package Market.Model.Entity;

import Pókemon.Model.Entity.Pokemon;
import java.util.List;

public class Market {
    
   List<Pokemon> pokemonList; 

    public Market(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public Market() {
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }


    
    
    
}
