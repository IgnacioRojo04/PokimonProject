/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pókemon.Controller;

import Player.Model.Entity.Player;
import Pókemon.Model.Entity.Pokemon;
import Pókemon.Model.Repository.JDBC.PokemonDAOJDBC;
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

    public PokemonController(Player player) {
        this.pokemonView = new PokemonView();
            this.pokemonDao = new PokemonDAOJDBC(player);
    }

    public void fillTable(List<Pokemon> teamPokemon) {
        this.pokemonDao.listar();
        DefaultTableModel model = (DefaultTableModel) pokemonView.tPokePlayer.getModel();
        System.out.println(model + " :model");
        model.setRowCount(0);
        this.pokemonView.cbPokeName.removeAllItems();
        for (Pokemon pokemon : teamPokemon) {
            model.addRow(new Object[]{
                pokemon.getName(),
                pokemon.getRarity(),
                pokemon.getLevel(),
                pokemon.getCost(),});
            this.pokemonView.cbPokeName.addItem(pokemon.getName());
        }
        
    }

    public void showMoney(int money) {
        this.pokemonView.lblMoney.setText(money + "");
    }

    public void SellPokemon(List<Pokemon> teamPokemon) {
        int indice = this.pokemonView.cbPokeName.getSelectedIndex();
        Pokemon vendido = teamPokemon.get(indice);
        teamPokemon.remove(indice);
        DefaultTableModel model = (DefaultTableModel) this.pokemonView.tPokePlayer.getModel();
        model.removeRow(indice);
        this.pokemonView.cbPokeName.removeItem(this.pokemonView.cbPokeName.getSelectedItem());
        //deleteDao(vendido);
    }

}
