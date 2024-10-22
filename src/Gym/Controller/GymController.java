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

    private void repaintView(List<Pokemon> teamPokemon, Player player) {
        DefaultTableModel model = (DefaultTableModel) this.gymView.tGym.getModel();
        model.setRowCount(0);
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
        this.gymView.lblMoney.setText(player.getMoney() + "");
    }

    public void fillTable(List<Pokemon> teamPokemon, Player player) {
        // base de datos que returnea  a los pokemones 
        teamPokemon.add(new Pokemon("vulva Saur"));
        teamPokemon.add(new Pokemon("chad al mander"));
        teamPokemon.add(new Pokemon("squirt el"));
        this.repaintView(teamPokemon, player);

    }

    public void trainPokemon(List<Pokemon> teamPokemon, Player player) {
        int indice = this.gymView.cbGym.getSelectedIndex();
        Pokemon pokeTrain = teamPokemon.get(indice);
        pokeTrain.setLevel(pokeTrain.getLevel() + 1);
        this.repaintView(teamPokemon, player);
        this.gymView.cbGym.setSelectedIndex(indice);
    }

    public Pokemon catchPokemon(List<Pokemon> teamPokemon, Player player) {
        Pokemon pokemonNew = new Pokemon("nombre", (int) (Math.random() * 3), (int) (Math.random() * 2), player.getId(), (int) (Math.random() * 18));
        int ifCatchPokemon = (int) (Math.random() * 1.4); // Probabilidad de que captures el pokemon es de  menos del 30%
         repaintView(teamPokemon, player); // esto es para que aparezca que se desconto el dinero.
        if (ifCatchPokemon == 1) {
            teamPokemon.add(pokemonNew);
            repaintView(teamPokemon, player); // Necesito repintar dos veces para que aparezca el pokemon en la tabla.
            return pokemonNew;
        }
        return null;
    }
}
