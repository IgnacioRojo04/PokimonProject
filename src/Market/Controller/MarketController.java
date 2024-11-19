package Market.Controller;

import Market.Model.Repository.JDBC.MarketDAOJDBC;
import Market.View.MarketView;
import Player.Model.Entity.Player;
import Pókemon.Model.Entity.Pokemon;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador para gestionar el mercado de Pokémon en la aplicación. Permite mostrar
 * los Pokémon disponibles para compra, gestionar el proceso de compra y actualizar
 * la información visual en la interfaz de usuario para reflejar las opciones de compra
 * y las desiciones tomadas.
 * 
 * Los Pokémon en el mercado pertenecen a entrenadores que no son jugadores del usuario actuales ni líderes.
 * Estos Pokémon pueden ser comprados por el jugador para incorporarlos a su equipo a cambio de dinero.
 * 
 * @see Market.View.MarketView
 * @see Market.Model.Repository.JDBC.MarketDAOJDBC
 * 
 * @version 1.0
 * @since 2024-09-05
 * 
 * @author 
 * Rojo Juan Manuel
 * Retamales Lautaro
 * Rojo Ignacio
 */


public class MarketController {

    public MarketView marketView;
    public MarketDAOJDBC marketDao;
    
       /**
     * Constructor que inicializa la vista del mercado y el acceso a datos del mercado.
     * 
     * @param Player El jugador actual que accede al mercado.
     */
    

    public MarketController(Player Player) {
        this.marketView = new MarketView();
        this.marketDao = new MarketDAOJDBC(Player);
    }
    
        /**
     * Crea Pokémon aleatorios si el mercado está vacío, es decir, la primera vez que se inicia. Genera hasta 20 Pokémon
     * con propiedades aleatorias y los agrega a la lista del mercado a través del DAO.
     * Luego, llama al método para llenar la tabla de la vista con estos Pokémon.
     */

    public void createPokemon() {
        if (this.marketDao.pokemonList.size() == 0) {
            Pokemon pokemonNew = new Pokemon();
            for (int i = 0; i < 20; i++) {
                pokemonNew.setLevel((int) (1 + (Math.random() * 70)));
                pokemonNew.setRarity((int) (1 + (Math.random() * 5)));
                pokemonNew.setOwner((int) (1 + (Math.random() * 9)));
                pokemonNew.setIdPoke((int) (1 + (Math.random() * 150)));
                if(pokemonNew.getRarity() == 1 || pokemonNew.getRarity() == 2){
                    pokemonNew.setCost((pokemonNew.getLevel() * pokemonNew.getRarity())) ;
                }else{
                 pokemonNew.setCost((pokemonNew.getLevel() * pokemonNew.getRarity()) * (int) ((1 + (Math.random() * 2))) );   
                }
                System.out.println(pokemonNew.getOwner());
                this.marketDao.crear(pokemonNew);
            }
        }
        this.marketDao.listar();
        fillTable();
    }

       /**
     * Llena la tabla en la vista del mercado con la lista de Pokémon disponibles.
     * Elimina cualquier fila existente y agrega los datos de cada Pokémon en el mercado.
     */
    
    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) this.marketView.tMarket.getModel();

        model.setRowCount(0);
        this.marketView.cbMarket.removeAllItems();
        for (Pokemon pokemon : this.marketDao.pokemonList) {
            model.addRow(new Object[]{
                pokemon.getName(),
                pokemon.getRarity(),
                pokemon.getLevel(),
                pokemon.getCost(),
                pokemon.getOwner(),});
            this.marketView.cbMarket.addItem(pokemon.getName());
        }
    }

       /**
     * Muestra la cantidad de dinero actual del jugador en la vista del mercado.
     * 
     * @param money Cantidad de dinero actual del jugador.
     */
    
    public void showMoney(int money) {
        this.marketView.lblMoney.setText(money + "");
    }

        /**
     * Permite al jugador comprar un Pokémon del mercado. Añade el Pokémon comprado
     * al equipo del jugador, lo elimina del mercado y actualiza la lista y la base de datos
     * llamando a los metodos necesarios para ello.
     * 
     * @param pokemonTeam Lista de Pokémon que pertenecen al jugador.
     * @param player Objeto del jugador actual que realiza la compra.
     */
    
    public void buyPoke(List<Pokemon> pokemonTeam, Player player) {
        int indice = this.marketView.cbMarket.getSelectedIndex();
        Pokemon comprado = this.marketDao.pokemonList.get(indice);
        this.marketView.lblMoney.setText(player.getMoney() + "");
        comprado.setOwner(player.getId()); //pokemonTeam.get(1).getOwner()
        pokemonTeam.add(comprado);
        this.marketDao.pokemonList.remove(indice);
        DefaultTableModel model = (DefaultTableModel) this.marketView.tMarket.getModel();
        model.removeRow(indice);
        this.marketView.cbMarket.removeItem(this.marketView.cbMarket.getSelectedItem());
        this.marketDao.actualizar(comprado);
    }
}
