
package Pókemon.Controller;

import Player.Model.Entity.Player;
import Pókemon.Model.Entity.Pokemon;
import Pókemon.Model.Repository.JDBC.PokemonDAOJDBC;
import Pókemon.View.PokemonView;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador para la gestión de los Pokemones en la aplicación. 
 * Conecta la vista PokemonView con la capa de acceso a datos PokemonDAOJDBC,
 * y coordina las operaciones para llenar la tabla de Pokemones, mostrar el dinero del jugador,
 * vender un Pokemon y eliminar todos los Pokemones de un jugador.
 * 
 * @see Pókemon.View.PokemonView
 * @see Pókemon.Model.Repository.JDBC.PokemonDAOJDBC
 * @see Player.Model.Entity.Player
 * 
 * @version 1.0
 * @since 2024-09-05
 * 
 *  @authorS
 * Rojo Juan Manuel
 * Retamales Lautaro
 * Rojo Ignacio
 */

public class PokemonController {

    public PokemonView pokemonView;
     public PokemonDAOJDBC pokemonDao;

     
       /**
     * Constructor para inicializar el controlador con el jugador especificado.
     * 
     * @param player El jugador actual, utilizado para cargar datos y administrar el equipo.
     */
     
    public PokemonController(Player player) {
       // System.out.println(player);
        this.pokemonView = new PokemonView();
        this.pokemonDao = new PokemonDAOJDBC(player);
    }

     /**
     * Llena la tabla de la vista con los Pokemones del jugador actual. Este método 
     * llama al método listar de PokemonDAOJDBC para obtener todos los Pokemones 
     * disponibles, y luego agrega cada Pokemon del equipo del jugador a la tabla.
     * 
     * @param player El jugador cuyo equipo se mostrará en la tabla.
     */
    
    public void fillTable(Player player ) {
        this.pokemonDao.listar();
        DefaultTableModel model = (DefaultTableModel) pokemonView.tPokePlayer.getModel();
        model.setRowCount(0);
        this.pokemonView.cbPokeName.removeAllItems();
        for (Pokemon pokemon : player.getTeamPokemon()) {
            model.addRow(new Object[]{
                pokemon.getName(),
                pokemon.getRarity(),
                pokemon.getLevel(),
                pokemon.getCost(),});
            this.pokemonView.cbPokeName.addItem(pokemon.getName());
        }
        
    }
    public void savePlayer(Player player){
        
    }

       /**
     * Muestra el dinero actual del jugador en la vista.
     * 
     * @param money La cantidad de dinero del jugador.
     */
    
    public void showMoney(int money) {
        this.pokemonView.lblMoney.setText(money + "");
    }

      /**
     * Vende un Pokemon seleccionado del equipo del jugador. Elimina el Pokemon
     * de la lista del jugador, actualiza la tabla de la vista y lo elimina 
     * de la base de datos a través de PokemonDAOJDBC.
     * 
     * @param teamPokemon La lista de Pokemones del equipo del jugador.
     */
    
    public void SellPokemon(List<Pokemon> teamPokemon) {
        int indice = this.pokemonView.cbPokeName.getSelectedIndex();
        Pokemon vendido = teamPokemon.get(indice);

        teamPokemon.remove(indice);
        DefaultTableModel model = (DefaultTableModel) this.pokemonView.tPokePlayer.getModel();
        model.removeRow(indice);
        this.pokemonView.cbPokeName.removeItem(this.pokemonView.cbPokeName.getSelectedItem());
        this.pokemonDao.eliminar(vendido.getId());
    }
    
     /**
     * Elimina todos los Pokemones del equipo del jugador. Este método recorre la lista
     * de Pokemones y elimina cada uno de ellos de la base de datos a través de PokemonDAOJDBC.
     * Generalmente usado cuando se borra con el jugador completo
     * 
     * @param teamPokemon La lista de Pokemones del equipo del jugador.
     */
    
    public void deletePlayer(List<Pokemon> teamPokemon){
        for (Pokemon p: teamPokemon){
            this.pokemonDao.eliminar(p.getId());
        }
    }
    
    

}
