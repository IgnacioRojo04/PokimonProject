package Leader.Controller;

import java.sql.SQLException;
import Leader.View.LeaderView;
import Leader.Model.Entity.Leader;
import Leader.Model.Repository.LeaderRepository;
import Pókemon.Model.Entity.Pokemon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador para gestionar la Liga Pokémon, donde el jugador puede
 * enfrentarse a los líderes de gimnasio. Proporciona métodos para listar los
 * pokemones de los lideres, marcar a los líderes como derrotados al vencerlos y
 * obtener listas de líderes derrotados o no derrotados.
 *
 * @version 1.0
 * @since 2024-10-26
 */
public class LeaderController {

    private LeaderRepository leaderRepository;
    public LeaderView leagueView;

    public LeaderController(LeaderView leagueView) {
        this.leagueView = leagueView;
        // falta DAO
    }

    /**
     * Constructor de LeagueController. Inicializa la lista de líderes llamando
     * al método listar en LeaderDAOJDBC.
     *
     * @param leaderDAO Objeto LeaderDAOJDBC que permite obtener la lista de
     * líderes desde la base de datos.
     */
    public LeaderController() {
        leagueView = new LeaderView(); // Asegúrate de inicializar la vista
        this.leaderRepository = new LeaderRepository();
        // Usa DBConnection para obtener la conexión

    }

    // public LeagueController(LeaderDAOJDBC leaderDAO) {
    // Inicializa la lista de líderes llamando al método listar
    //       this.leadersList = leaderDAO.listarNombreLideres();
    //   }
    /**
     * Marca a un líder específico como derrotado, actualizando su estado en la
     * lista. Imprime un mensaje de confirmación al derrotar al líder.
     *
     * @param leaderId ID del líder que ha sido derrotado.
     */
    public void markLeaderAsDefeated(int leaderId) {
        for (Leader leader : this.leaderRepository.leaderList) {
            if (leader.getId() == leaderId) {
                leader.setDefeated(true);
                System.out.println("Felicidades haz derrotado al líder " + leader.getName() + ", ya fue marcado como derrotado, sigue con los demás lideres antes de que se recuperen.");
                break;
            }
        }
    }

    /**
     * Obtiene una lista de líderes que aún no han sido derrotados.
     *
     * @return Lista de objetos Leader que representan a los líderes no
     * derrotados.
     */
    public List<Leader> getNonDefeatedLeaders() {
        List<Leader> nonDefeatedLeaders = new ArrayList<>(); // Lista para almacenar los líderes no derrotados
        // Recorrer cada líder en la lista de líderes
        for (Leader leader : this.leaderRepository.leaderList) {
            // Si el líder no está derrotado, lo añadimos a la lista de no derrotados
            if (!leader.isDefeated()) {
                nonDefeatedLeaders.add(leader);
            }
        }
        return nonDefeatedLeaders; // Retornamos la lista de líderes no derrotados
    }

    /**
     * Obtiene una lista de líderes que han sido derrotados.
     *
     * @return Lista de objetos Leader que representan a los líderes derrotados.
     */
    public List<Leader> getDefeatedLeaders() {
        List<Leader> DefeatedLeaders = new ArrayList<>(); // Lista para almacenar los líderes no derrotados

        // Recorrer cada líder en la lista de líderes
        for (Leader leader : this.leaderRepository.leaderList) {
            // Si el líder no está derrotado, lo añadimos a la lista de no derrotados
            if (leader.isDefeated() == true) {
                DefeatedLeaders.add(leader);
            }
        }

        return DefeatedLeaders; // Retornamos la lista de líderes no derrotados
    }

    /**
     * Realiza una batalla entre el equipo del jugador y el equipo de un líder
     * específico. Suma el nivel de cada Pokémon en ambos equipos y multiplica
     * el total por la suma de sus rarezas. Si el valor del equipo del jugador
     * es mayor que el del líder, el jugador gana la batalla y el líder es
     * marcado como derrotado.
     *
     * @param playerTeam Lista de Pokémon que pertenecen al equipo del jugador.
     * @param leader El líder contra el que el jugador se enfrentará en la
     * batalla.
     * @return true si el jugador gana la batalla, false si pierde.
     */
    public boolean battleLeader(List<Pokemon> playerTeam, Leader leader) {

        List<Pokemon> leaderTeam = leader.getTeamPokemon();

        // Calcular el poder de batalla del equipo del jugador
        int playerLevelSum = 0;
        int playerRaritySum = 0;
        for (Pokemon pokemon : playerTeam) {
            playerLevelSum += pokemon.getLevel();
            playerRaritySum += pokemon.getRarity();
        }
        int playerPower = playerLevelSum * playerRaritySum;

        // Calcular el poder de batalla del equipo del líder
        int leaderLevelSum = 0;
        int leaderRaritySum = 0;
        for (Pokemon pokemon : leaderTeam) {
            leaderLevelSum += pokemon.getLevel();
            leaderRaritySum += pokemon.getRarity();
        }
        int leaderPower = leaderLevelSum * leaderRaritySum;

        // Comparar el poder de batalla del jugador con el del líder
        if (playerPower > leaderPower) {
            markLeaderAsDefeated(leader.getId());
            System.out.println("¡Has ganado la batalla contra el líder " + leader.getName() + "!");
            return true; // El jugador gana la batalla
        } else {
            System.out.println("Has perdido la batalla contra el líder " + leader.getName() + ". ¡Sigue entrenando!");
            return false; // El jugador pierde la batalla
        }
    }

    public Leader getLeader(int index) {
        if (index >= 0 && index < this.leaderRepository.leaderList.size()) {
            return this.leaderRepository.leaderList.get(index);
        } else {
            // Retorna null o lanza una excepción en caso de que el índice no sea válido
            return null;
        }
    }

    public void setLeaderDAO(LeaderRepository leaderDAO) {
        this.leaderRepository = leaderDAO;
    }

    public boolean cargarDatosLigaEnTabla(boolean bol) {
        //List<Leader> leaders = leaderDAO.listarLideresConEquipo(); // Método que retorna una lista de líderes con sus equipos de pokemones

        // Configuración de columnas para el JTable
        if (bol) {
            this.leaderRepository.listarNombreLideres();
            for (Leader l : this.leaderRepository.leaderList) {
                for (Pokemon p : this.leaderRepository.listarPokemonesDeLideres()) {
                    if (p.getOwner() == l.getId()) {
                        l.teamPokemon.add(p);
                    }

                }
            }

            DefaultTableModel model = (DefaultTableModel) this.leagueView.tLeague.getModel();
            DefaultTableModel modelDefeated = (DefaultTableModel) this.leagueView.tDefeated.getModel();
            DefaultTableModel modelAlive = (DefaultTableModel) this.leagueView.tAlive.getModel();
            this.leagueView.cbLeaders.removeAllItems();
//         this.leagueView.tLeague.removeAll();
//         this.leagueView.tAlive.removeAll();
//         this.leagueView.tDefeated.removeAll();
            // Recorrer la lista de líderes y agregar filas al modelo de la tabla
            for (Leader leader : this.leaderRepository.leaderList) {
                for (Pokemon pokemon : leader.teamPokemon) {
                    System.out.println(leader.teamPokemon);
                    // Cada fila contendrá el nombre del líder, nombre del pokemon y dificultad del líder
                    Object[] row = new Object[]{
                        leader.getName(),
                        pokemon.getName(),
                        leader.getDifficulty()
                    };

                    model.addRow(row);

                }
                if (leader.isDefeated()) {
                    Object[] row = new Object[]{
                        leader.getName(),};
                    modelDefeated.addRow(row);
                } else {
                    Object[] row = new Object[]{
                        leader.getName(),};
                    modelAlive.addRow(row);
                }
                this.leagueView.cbLeaders.addItem(leader.getName());
            }
        }
        return false;
    }

}
