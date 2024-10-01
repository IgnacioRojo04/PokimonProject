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
import java.util.HashSet;

public class PlayerDAOJDBC implements DAO<Player> {

    private Connection cn = null;

    public PlayerDAOJDBC() {
        try {
            cn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/Pokemones?user=root&password=root");
            System.out.println("Conectado");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PlayerDAOJDBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Player> listar() {
        return null;
    }

    @Override
    public Player leer(int id) {
        return null;
    }

    @Override
    public void crear(Player t) {
        try {
            String insertStmtPlayer = "INSERT INTO entrenadores(ID, NOMBRE) VALUES(?,?)";
            String insertStmtPokeU = "INSERT INTO pokeUsables(ID, ID_POKE,NIVEL, PRECIO, ID_ENTRENADOR) VALUES(?,?,?,?,?);";
            PreparedStatement pstmtPokeU = cn.prepareStatement(insertStmtPokeU, Statement.RETURN_GENERATED_KEYS);

            pstmtPokeU.setInt(2, 1);
            pstmtPokeU.setInt(3, 10);
            pstmtPokeU.setInt(4, 10);
            pstmtPokeU.setInt(5, 20);

            ResultSet rsPoke = pstmtPokeU.getGeneratedKeys();
            int idPoke = 0;
            if (rsPoke.next()) {
                idPoke = rsPoke.getInt(1);
            }
            pstmtPokeU.setInt(1, idPoke);
            pstmtPokeU.executeUpdate();

            PreparedStatement pstmtPlayer = cn.prepareStatement(insertStmtPlayer, Statement.RETURN_GENERATED_KEYS);

            pstmtPlayer.setString(2, t.getName());
            ResultSet rsPlayer = pstmtPlayer.getGeneratedKeys();
            System.out.println(rsPlayer);
            int idPlayer = 0;
            if (rsPlayer.next()) {
                idPlayer = rsPlayer.getInt(1);
                t.setId(idPlayer);
                System.out.println("Player agregado con ID: " + t.getId());
            } else {
                System.out.println("No se generó un ID para el jugador.");
                }
            pstmtPlayer.setInt(1, idPlayer);
            System.out.println(idPlayer);

            pstmtPlayer.executeUpdate();
            System.out.println("player agregado");
        } catch (SQLException ex) {
            System.out.println("Error al insertar player: " + ex.getErrorCode());
            ex.printStackTrace();
        }
    }

    @Override
    public void actualizar(Player t) {
    }

    @Override
    public void eliminar(int id) {
        String deletePokeUsablesSQL = "DELETE FROM pokeusables WHERE ID_ENTRENADOR = ?";
        String deleteEntrenadorSQL = "DELETE FROM entrenadores WHERE ID = ?";

        try {
            try (PreparedStatement pstmtPokeUsables = cn.prepareStatement(deletePokeUsablesSQL)) {
                pstmtPokeUsables.setInt(1, id);
                pstmtPokeUsables.executeUpdate();
            }
            try (PreparedStatement pstmtEntrenador = cn.prepareStatement(deleteEntrenadorSQL)) {
                pstmtEntrenador.setInt(1, id);
                int rowsAffected = pstmtEntrenador.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Entrenador con ID " + id + " eliminado.");
                } else {
                    System.out.println("No se encontró un entrenador con el ID " + id);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el entrenador y sus pokeUsables: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
