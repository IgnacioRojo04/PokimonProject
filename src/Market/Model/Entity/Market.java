
package Market.Model.Entity;

import Pókemon.Model.Entity.Pokemon;
import java.util.ArrayList;
import java.util.List;

public class Market {
    
   public List<Pokemon> pokemonList; 

    public Market() {
        this.pokemonList = new ArrayList<>();
    }

 
    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }


    
    
    
}
