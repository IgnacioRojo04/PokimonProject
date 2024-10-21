/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gym.Controller;

import Gym.View.GymView;
import Pókemon.Model.Entity.Pokemon;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class GymController {
    
    public GymView gymView;
    
    public GymController() {
        this.gymView = new GymView();
    }
    
    public void repaintTable(List<Pokemon> teamPokemon) {
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
    }
    
    public void fillTable(List<Pokemon> teamPokemon) {
        // base de datos que returnea  a los pokemones 
        teamPokemon.add(new Pokemon("vulva Saur"));
        teamPokemon.add(new Pokemon("chad al mander"));
        teamPokemon.add(new Pokemon("squirt el"));
        this.repaintTable(teamPokemon);
        
    }
    
    public void trainPokemon(List<Pokemon> teamPokemon) {
        int indice = this.gymView.cbGym.getSelectedIndex();
        Pokemon pokeTrain = teamPokemon.get(indice);
        pokeTrain.setLevel(pokeTrain.getLevel() + 1);
        this.repaintTable(teamPokemon);
        this.gymView.cbGym.setSelectedIndex(indice);
    }
}
