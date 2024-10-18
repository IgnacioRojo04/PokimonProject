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
    public void fillTable() {
        // aca estaria el metodo en la controlladora que llama a getAll, de esta forma
        
        this.pokemonView.teamPokemon.add(new Pokemon("pika"));
        this.pokemonView.teamPokemon.add(new Pokemon("charmander"));
        this.pokemonView.teamPokemon.add(new Pokemon("Squirtle"));
        DefaultTableModel model = (DefaultTableModel) pokemonView.tPoke.getModel();

        model.setRowCount(0);
        for (Pokemon pokemon : this.pokemonView.teamPokemon) {
            model.addRow(new Object[]{
                pokemon.getName(),
                pokemon.getRarity(),
                pokemon.getLevel(),
                pokemon.getCost(),
            });
            this.pokemonView.cbPokeName.addItem(pokemon.getName()); 
        }
    }
    public void showMoney(int money) {
        this.pokemonView.lblMoney.setText(money + "");
    }
    
    public void SellPokemon(){
        int indice = this.pokemonView.cbPokeName.getSelectedIndex();
        Pokemon vendido = this.pokemonView.teamPokemon.get(indice);
        this.pokemonView.teamPokemon.remove(indice);
        DefaultTableModel model = (DefaultTableModel) this.pokemonView.tPoke.getModel();
        model.removeRow(indice);
        this.pokemonView.cbPokeName.removeItem(this.pokemonView.cbPokeName.getSelectedItem());
        //deleteDao(vendido);
    }
    
}
