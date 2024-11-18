package Player.Controller;

import Player.Model.Entity.Player;
import Player.Model.Repository.JDBC.PlayerDAOJDBC;
import Player.View.PlayerView;
import Player.View.TablePlayerView;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador para la gestión de jugadores en la aplicación. Conecta la vista
 * PlayerView con la capa de acceso a datos PlayerDAOJDBC y coordina las operaciones
 * relacionadas con la creación, eliminación, actualización y selección de jugadores.
 * 
 * @see Player.View.PlayerView
 * @see Player.Model.Repository.JDBC.PlayerDAOJDBC
 * 
 * @version 1.0
 * @since 2024-09-05
 * 
 * @author 
 * Rojo Juan Manuel
 * Retamales Lautaro
 * Rojo Ignacio
 */

public class PlayerController {

    public PlayerView playerView;
    public TablePlayerView tablePlayerView;
    public PlayerDAOJDBC playerDao;

      /**
     * Constructor que inicializa la vista y el acceso a datos de los jugadores.
     */
    
    public PlayerController() {
        this.playerView = new PlayerView();
        this.tablePlayerView = new TablePlayerView();
        this.playerDao = new PlayerDAOJDBC();
    }

     /**
     * Crea un nuevo jugador si no está repetido en la lista. Primero revisa si el
     * nombre ingresado ya existe en la lista de jugadores; si es único, crea el
     * jugador a través del DAO.
     * 
     * @return {@code true} si el jugador ya existe, {@code false} si el jugador se creó exitosamente.
     */
    
    public boolean createPlayer() {
        this.playerDao.listar();
        boolean repeat = false;
        for (Player player : this.playerDao.playerList) {
            if (player.getName().equals(this.playerView.tfName.getText())) {
                repeat = true;
            }
        }
        if (!repeat) {
            this.playerDao.player.setName(this.playerView.tfName.getText());
            this.playerDao.crear(this.playerDao.player);
        }
        return repeat;
    }

      /**
     * Elimina un jugador seleccionado en la interfaz. Obtiene el índice seleccionado
     * en la vista, elimina el jugador de la base de datos a través del DAO, y actualiza
     * la tabla en la vista y la lista de jugadores disponibles.
     */
    
    public void deletePlayer() {
        int indice = this.tablePlayerView.cbPlayer.getSelectedIndex();
        this.playerDao.eliminar(this.playerDao.playerList.get(indice).getId());
        this.playerDao.playerList.remove(indice);
        DefaultTableModel model = (DefaultTableModel) this.tablePlayerView.tPlayer.getModel();
        model.removeRow(indice);
        this.tablePlayerView.cbPlayer.removeItem(this.tablePlayerView.cbPlayer.getSelectedItem());

    }

     /**
     * Actualiza el dinero del jugador. Suma o resta una cantidad al dinero actual
     * del jugador y lo guarda en la base de datos a través del DAO.
     * 
     * @param price Cantidad de dinero a agregar (puede ser negativa si es un gasto).
     */
    
    public void setMoney(int price) {
        int currentMoney = this.playerDao.player.getMoney();
        this.playerDao.player.setMoney(currentMoney + price);
        this.playerDao.actualizar(this.playerDao.player);
    }

     /**
     * Permite continuar con el juego usando jugadores previamente creados.
     * Refresca la tabla de jugadores en la vista y permite al usuario seleccionar
     * un jugador guardado con las caracteristicas anteriores como equipo pokemon y dinero actual.
     */
    
    public void ContinueGame() {

        DefaultTableModel model = (DefaultTableModel) tablePlayerView.tPlayer.getModel();
        model.setRowCount(0);
        tablePlayerView.cbPlayer.removeAllItems();
        this.playerDao.listar();
        for (Player player : this.playerDao.playerList) {
            System.out.println(player.getName());
            model.addRow(new Object[]{
                player.getName(),
                player.getMoney(),});
            tablePlayerView.cbPlayer.addItem(player.getName());
        }
    }

      /**
     * Selecciona un jugador existente para continuar el juego. Carga el jugador 
     * seleccionado desde la lista y lo establece como el jugador actual.
     */
    
    public void selectContinue() {
        int indice = this.tablePlayerView.cbPlayer.getSelectedIndex();
        this.playerDao.player = this.playerDao.playerList.get(indice);
    }

}
