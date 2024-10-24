/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gym.Controller;

import Gym.View.GymView;
import Player.Model.Entity.Player;
import Pókemon.Model.Entity.Pokemon;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class GymController {

    public GymView gymView;

    public GymController() {
        this.gymView = new GymView();
    }

    public void repaintView(List<Pokemon> teamPokemon) {
        DefaultTableModel model = (DefaultTableModel) this.gymView.tGym.getModel();
        model.setRowCount(0);
        this.gymView.cbGym.removeAllItems();
        this.gymView.cbGym.removeAllItems();
        for (Pokemon pokemon : teamPokemon) {
            System.out.println(pokemon.getName() + "hola");
            model.addRow(new Object[]{
                pokemon.getName(),
                pokemon.getRarity(),
                pokemon.getLevel(),
                pokemon.getCost(),});
            this.gymView.cbGym.addItem(pokemon.getName());
        }
    }

    public Pokemon trainPokemon(List<Pokemon> teamPokemon, Player player) {
        int indice = this.gymView.cbGym.getSelectedIndex();
        Pokemon pokeTrain = teamPokemon.get(indice);
        System.out.println(indice);
        pokeTrain.setLevel(pokeTrain.getLevel() + (int) (Math.random() * 10));
        if (pokeTrain.getLevel() > 100) pokeTrain.setLevel(100);
        pokeTrain.setCost(pokeTrain.getLevel() * pokeTrain.getRarity());
        this.repaintView(teamPokemon);
        this.gymView.cbGym.setSelectedIndex(indice);
        return pokeTrain;
    }
    public void showMoney(Player player){
        this.gymView.lblMoney.setText(player.getMoney() + "");
    }
    public Pokemon catchPokemon(List<Pokemon> teamPokemon, Player player) {

        int ifCatchPokemon = (int) (Math.random() * 1.4); // Probabilidad de que captures el pokemon es de  menos del 30%}
        if (ifCatchPokemon == 1) {
            Pokemon pokemonNew = new Pokemon();
            pokemonNew.setLevel((int) (1 + (Math.random() * 70)));
            pokemonNew.setRarity((int) (1 + (Math.random() * 5)));
            pokemonNew.setOwner((int) (1 + (Math.random() * 19)));
            pokemonNew.setIdPoke((int) (1 + (Math.random() * 150)));
            pokemonNew.setCost((pokemonNew.getLevel() * pokemonNew.getRarity()));
            return pokemonNew;
        }
        return null;
    }
}
