
package Player.Model.Repository.JDBC;

import Interface.DAO;
import Player.Model.Entity.Player;
import java.sql.Statement;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;

public class PlayerDAOJDBC implements DAO<Player> {

    public Player player;
    public List<Player> playerList;
    private Connection conexion = null;

    public PlayerDAOJDBC() {
        this.connectar();
        this.playerList = new ArrayList<>();
        this.player = new Player();
    }

    public void connectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/pokemones?user=root&password=root");
            System.out.println("Conectado dao player");
        } catch (SQLException ex) {
            System.out.println("NO CONECTO DAO PAYER");
            java.util.logging.Logger.getLogger(PlayerDAOJDBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Override
    public void listar() {
        try {
            String sqlSelect = "SELECT ID, NOMBRE, DINERO  FROM entrenadores WHERE ID >= 20";
            PreparedStatement stmtSelect = conexion.prepareStatement(sqlSelect);
            ResultSet rs = stmtSelect.executeQuery();
            while (rs.next()) {
                Player player = new Player();
                
                player.setId(rs.getInt("ID"));
                player.setName(rs.getString("NOMBRE"));
                System.out.println("PLAYER NAME:" + player.getName());
                player.setMoney(rs.getInt("DINERO"));  
                
                System.out.println("DIMERO PLAYER" + player.getMoney());
                
                this.playerList.add(player);
            }

            System.out.println("Players listados correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void crear(Player player) {
        try {
            String insertStmtPlayer = "INSERT INTO entrenadores(NOMBRE, DINERO) VALUES(?, 100)";
            PreparedStatement pstmtPlayer = conexion.prepareStatement(insertStmtPlayer, Statement.RETURN_GENERATED_KEYS);
            pstmtPlayer.setString(1, player.getName());
            pstmtPlayer.executeUpdate();
            ResultSet rsPlayer = pstmtPlayer.getGeneratedKeys();
            System.out.println("Método crear llamado");
            if (rsPlayer.next()) {
                player.setId(rsPlayer.getInt(1));
                System.out.println("Player agregado con ID: " + player.getId());
            } else {
                System.out.println("No se generó un ID para el jugador.");
            }
            String insertStmtPokeU = "INSERT INTO pokeUsables(ID_POKE,NIVEL, PRECIO, ID_ENTRENADOR) VALUES(?,?,?,?);";
            PreparedStatement pstmtPokeU = conexion.prepareStatement(insertStmtPokeU, Statement.RETURN_GENERATED_KEYS);
            pstmtPokeU.setInt(1, 1);
            pstmtPokeU.setInt(2, 10);
            pstmtPokeU.setInt(3, 10);
            pstmtPokeU.setInt(4, player.getId());
            pstmtPokeU.executeUpdate();
            ResultSet rsPoke = pstmtPokeU.getGeneratedKeys();
            if (rsPoke.next()) {
                rsPoke.getInt(1);
            } else {
                System.out.println("No se generó un ID para el Pokemón");
            }
            this.player = player;
        } catch (SQLException ex) {
            System.out.println("Error al insertar player: " + ex.getErrorCode());
        }
    }

    @Override
    public void actualizar(Player player) {
        try{
            String sqlUpdate = "UPDATE entrenadores SET DINERO = ? WHERE ID = ?";
            PreparedStatement stmtUpdate = conexion.prepareStatement(sqlUpdate);
            stmtUpdate.setInt(1, player.getMoney());
            stmtUpdate.setInt(2, player.getId()); 
            int filasActualizadas = stmtUpdate.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("El Pokémon fue comprado por el jugador (ID_ENTRENADOR = 20).");
            } else {
                System.out.println("No se encontró ningún registro con ese ID_POKEUSABLE.");
            }
        }catch(SQLException sqlEx){
            sqlEx.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String deletePokeUsablesSQL = "DELETE FROM pokeusables WHERE ID_ENTRENADOR >= ?";
        String deleteEntrenadorSQL = "DELETE FROM entrenadores WHERE ID >= ?";

        try {
            try (PreparedStatement pstmtPokeUsables = conexion.prepareStatement(deletePokeUsablesSQL)) {
                pstmtPokeUsables.setInt(1, id);
                pstmtPokeUsables.executeUpdate();
            }
            try (PreparedStatement pstmtEntrenador = conexion.prepareStatement(deleteEntrenadorSQL)) {
                pstmtEntrenador.setInt(1, id);
                int rowsAffected = pstmtEntrenador.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Player eliminado con ID: " + id);
                } else {
                    System.out.println("No se encontró un entrenador con el ID " + id);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el entrenador y sus pokeUsables: " + e.getMessage());
        }
    }
}
