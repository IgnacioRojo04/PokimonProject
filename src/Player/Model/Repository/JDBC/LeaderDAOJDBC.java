package Player.Model.Repository.JDBC;

import Interface.DAO;
import Player.Model.Entity.Leader;
import Pókemon.Model.Entity.Pokemon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

public class LeaderDAOJDBC implements DAO<Leader> {

    public Leader leader;
    public List<Leader> leaderList;
    private Connection conexion = null;
    // public List<Pokemon> pokemonLideres;

    public void connectar() {
        try {
            DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/pokemones?user=root&password=root");
            System.out.println("Conectado dao leader");
        } catch (SQLException ex) {
            System.out.println("NO CONECTO DAO leader");
            java.util.logging.Logger.getLogger(PlayerDAOJDBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public LeaderDAOJDBC(Connection connection) {
        this.conexion = connection;
    }

    public LeaderDAOJDBC(Leader leader) {
        this.leader = leader;
        connectar();
        this.leaderList = new ArrayList<>();
    }

    public void listar() {
        this.leaderList.clear();
        String sqlSelect = """
            SELECT pl.ID_LIDER, l.NOMBRE AS leader_name, l.DIFICULTAD, 
                   pl.ID_POKEMON, pl.IMPORTANCIA, p.NOMBRE AS pokemon_name
            FROM pokemoneslideres pl
            JOIN lideres l ON pl.ID_LIDER = l.ID_LIDER
            JOIN pokemones p ON pl.ID_POKEMON = p.ID_POKEMON
            ORDER BY pl.ID_LIDER, pl.IMPORTANCIA;
            """;

        try (PreparedStatement stmt = conexion.prepareStatement(sqlSelect);
             ResultSet rs = stmt.executeQuery()) {

            // Usamos un Map para agrupar los Pokémon por líder
            Map<Integer, Leader> leaderMap = new HashMap<>();

            while (rs.next()) {
                int leaderId = rs.getInt("ID_LIDER");
                String leaderName = rs.getString("leader_name");
                int difficulty = rs.getInt("DIFICULTAD");

                // Obtenemos o creamos el líder
                Leader leader = leaderMap.get(leaderId);
                if (leader == null) {
                    leader = new Leader();
                    leader.setId(leaderId);
                    leader.setName(leaderName);
                    leader.setDificultad(difficulty);
                    leader.setTeamPokemon(new ArrayList<>());  // Inicializar la lista de Pokémon
                    leaderMap.put(leaderId, leader);
                }

                // Crear un objeto Pokemon y asignar sus valores
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt("ID_POKEMON"));
                pokemon.setName(rs.getString("pokemon_name"));
                pokemon.setImportance(rs.getInt("IMPORTANCIA"));

                // Añadir el Pokémon al equipo del líder
                leader.getTeamPokemon().add(pokemon);
            }

            // Añadir todos los líderes al leaderList
            leaderList.addAll(leaderMap.values());

            System.out.println("Líderes y sus pokemones listados correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Leader> getLeaderList() {
        return leaderList;
    }

    @Override
    public void crear(Leader t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(Leader t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int number) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
