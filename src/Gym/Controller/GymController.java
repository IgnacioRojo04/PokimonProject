/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gym.Controller;

import Gym.View.GymView;
import Pókemon.Model.Entity.Pokemon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class GymController {

    public GymView gymView;

    public GymController() {
        this.gymView = new GymView();
    }

    public void fillTable(List<Pokemon> teamPokemon) {
        teamPokemon.add(new Pokemon("pika2"));
        teamPokemon.add(new Pokemon("charmander2"));
        teamPokemon.add(new Pokemon("Squirtle2"));
        DefaultTableModel model = (DefaultTableModel) this.gymView.tGym.getModel();

        model.setRowCount(0);
        for (Pokemon pokemon : teamPokemon) {
            model.addRow(new Object[]{
                pokemon.getName(),
                pokemon.getRarity(),
                pokemon.getLevel(),
                pokemon.getCost(),});
            this.gymView.cbGym.addItem(pokemon.getName());
        }
    }
}
