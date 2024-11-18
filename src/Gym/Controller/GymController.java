
package Gym.Controller;

import Gym.View.GymView;
import Player.Model.Entity.Player;
import Pókemon.Model.Entity.Pokemon;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador para gestionar las funcionalidades del gimnasio en la aplicación.
 * Permite entrenar y capturar Pokémon, además de mostrar el dinero actual del jugador
 * 
 * 
 * @see Gym.View.GymView
 * @see Player.Model.Entity.Player
 * @see Pókemon.Model.Entity.Pokemon
 * 
 * @version 1.0
 * @since 2024-09-05
 * 
 * @author 
 * Rojo Juan Manuel
 * Retamales Lautaro
 * Rojo Ignacio
 */

public class GymController {

    public GymView gymView;
    
       /**
     * Constructor que inicializa la vista del gimnasio.
     */

    public GymController() {
        this.gymView = new GymView();
    }
    
      /**
     * Actualiza la vista del gimnasio, eliminando las filas actuales en la tabla y 
     * volviendo a llenarla con la lista de Pokémon del equipo del Player.
     * 
     * @param teamPokemon Lista de Pokémon del equipo del jugador.
     */

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

        /**
     * Permite entrenar un Pokémon del equipo del jugador, aumentando su nivel 
     * de manera aleatoria hasta un máximo de 100. Actualiza también el costo del Pokémon
     * por el cambio em el nivel del mismo
     * 
     * @param teamPokemon Lista de Pokémon del equipo del jugador.
     * @param player Objeto del jugador actual.
     * @return El Pokémon entrenado con su nivel y costo actualizados.
     */
    
    public Pokemon trainPokemon(List<Pokemon> teamPokemon, Player player) {
        int indice = this.gymView.cbGym.getSelectedIndex();
        Pokemon pokeTrain = teamPokemon.get(indice);
        System.out.println(indice);
        pokeTrain.setLevel(pokeTrain.getLevel() + (int) ((Math.random() * 10) + 1));
        if (pokeTrain.getLevel() > 100) pokeTrain.setLevel(100);
        pokeTrain.setCost(pokeTrain.getLevel() * pokeTrain.getRarity());
        this.repaintView(teamPokemon);
        this.gymView.cbGym.setSelectedIndex(indice);
        return pokeTrain;
    }
    
      /**
     * Muestra la cantidad de dinero actual del jugador en la vista del gimnasio.
     * 
     * @param player Objeto del jugador actual.
     */
    
    public void showMoney(Player player){
        this.gymView.lblMoney.setText(player.getMoney() + "");
    }
    
     /**
     * Intenta capturar un nuevo Pokémon para el equipo del jugador. La captura tiene
     * una probabilidad de aproximadamente el 30%. Si se captura, se genera un nuevo
     * Pokémon con atributos aleatorios y se devuelve. Si no, retorna null.
     * 
     * @param teamPokemon Lista de Pokémon del equipo del jugador.
     * @param player Objeto del jugador actual.
     * @return El nuevo Pokémon capturado o null si no se captura.
     */
    
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
