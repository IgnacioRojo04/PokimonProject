/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pókemon.Controller;

import Pókemon.Model.Entity.Pokemon;
import Pókemon.Model.RepositoryJDBC.PokemonDAOJDBC;
import Pókemon.View.PokemonView;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author retam
 */
public class PokemonController {
    public PokemonView pokemonView;
    public PokemonDAOJDBC pokemonDao;
    
    public PokemonController(){
        this.pokemonView = new PokemonView();
        this.pokemonDao = new PokemonDAOJDBC();
    }
    public void fillTable(List<Pokemon> pokemonList) {
        // aca estaria el metodo en la controlladora que llama a getAll, de esta forma
        pokemonList.add(new Pokemon("pika"));
        pokemonList.add(new Pokemon("charmander"));
        pokemonList.add(new Pokemon("Squirtle"));
        DefaultTableModel model = (DefaultTableModel) pokemonView.tPoke.getModel();

        model.setRowCount(0);
        for (Pokemon pokemon : pokemonList) {
            model.addRow(new Object[]{
                pokemon.getName(),
                pokemon.getLevel(),
                pokemon.getRarity(),
                pokemon.getOwner(),
            });
            this.pokemonView.cbPokeName.addItem(pokemon.getName()); 
        }
    }
    public void SellPokemon(){
        
    }
    
}
