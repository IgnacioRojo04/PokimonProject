package Player.Model.Repository.JDBC;

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

public class LeaderDAOJDBC {

    public Leader leader;
    public List<Leader> leaderList;
    public static Connection conexion = null;
    public List<Pokemon> leaderPokemonList;

    public void connectar() {
        try {
            conexion =  DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/pokemones?user=root&password=root");
            System.out.println("Conectado dao leader");
        } catch (SQLException ex) {
            System.out.println("NO CONECTO DAO leader");
            java.util.logging.Logger.getLogger(PlayerDAOJDBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public LeaderDAOJDBC() {
         this.leader = leader;
        connectar();
        this.leaderList = new ArrayList<>();
    }
    
    // Si no se utiliza, ELIMINAR
    public LeaderDAOJDBC(Leader leader) {
        this.leader = leader;
        connectar();
        this.leaderList = new ArrayList<>();
    }

    //hace un map y lista, todos los lideres con su team
    public void listarLeaderTeams() {
        this.leaderList.clear();
        String sqlSelect = """
            SELECT e.ID AS id_entrenador, e.NOMBRE AS leader_name, 
                   pu.ID_POKE AS id_pokemon, pu.NIVEL, pu.RAREZA, p.NOMBRE AS pokemon_name
            FROM entrenadores e
            JOIN pokeusables pu ON e.ID = pu.ID_ENTRENADOR
            JOIN pokemones p ON pu.ID_POKE = p.ID
            WHERE e.ID BETWEEN 10 AND 19
            ORDER BY e.ID, pu.RAREZA DESC;
            """;

        try (PreparedStatement stmt = conexion.prepareStatement(sqlSelect); ResultSet rs = stmt.executeQuery()) {

            Map<Integer, Leader> leaderMap = new HashMap<>();

            while (rs.next()) {
                int leaderId = rs.getInt("id_entrenador");
                String leaderName = rs.getString("leader_name");

                // Obtener o crear el líder en el Map
                Leader leader = leaderMap.get(leaderId);
                if (leader == null) {
                    leader = new Leader();
                    leader.setId(leaderId);
                    leader.setName(leaderName);
                    leader.setTeamPokemon(new ArrayList<>());  // Inicializar la lista de Pokémon
                    leader.setMoney(999);
                    leader.setDefeated(false);
                    leaderMap.put(leaderId, leader);
                }

                // Crear el objeto Pokemon y asignar sus valores
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt("id_pokemon"));
                pokemon.setName(rs.getString("pokemon_name"));
                pokemon.setLevel(rs.getInt("NIVEL"));
                pokemon.setRarity(rs.getInt("RAREZA"));

                // Añadir el Pokémon al equipo del líder
                leader.getTeamPokemon().add(pokemon);
            }

            // Añadir todos los líderes a la lista leaderList
            leaderList.addAll(leaderMap.values());

            System.out.println("Líderes y sus pokemones listados correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Leader> listarLideresConEquipo() {
        List<Leader> leadersList = new ArrayList<>();  // Cambiamos leaderList a una lista local
        String sqlSelect = """
        SELECT e.ID AS id_entrenador, e.NOMBRE AS leader_name, 
               pu.ID_POKE AS id_pokemon, pu.NIVEL, pu.RAREZA, p.NOMBRE AS pokemon_name
        FROM entrenadores e
        JOIN pokeusables pu ON e.ID = pu.ID_ENTRENADOR
        JOIN pokemones p ON pu.ID_POKE = p.ID
        WHERE e.ID BETWEEN 10 AND 19
        ORDER BY e.ID, pu.RAREZA DESC;
        """;

        try (PreparedStatement stmt = conexion.prepareStatement(sqlSelect); ResultSet rs = stmt.executeQuery()) {

            Map<Integer, Leader> leaderMap = new HashMap<>();

            while (rs.next()) {
                int leaderId = rs.getInt("id_entrenador");
                String leaderName = rs.getString("leader_name");

                // Obtener o crear el líder en el Map
                Leader leaders = leaderMap.get(leaderId);
                if (leaders == null) {
                    leaders = new Leader();
                    leaders.setId(leaderId);
                    leaders.setName(leaderName);
                    leaders.setTeamPokemon(new ArrayList<>());  // Inicializar la lista de Pokémon
                    leaders.setMoney(999);
                    leaders.setDefeated(false);
                    leaderMap.put(leaderId, leaders);
                }

                // Crear el objeto Pokemon y asignar sus valores
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt("id_pokemon"));
                pokemon.setName(rs.getString("pokemon_name"));
                pokemon.setLevel(rs.getInt("NIVEL"));
                pokemon.setRarity(rs.getInt("RAREZA"));

                // Añadir el Pokémon al equipo del líder
                leaders.getTeamPokemon().add(pokemon);
            }

            // Añadir todos los líderes a la lista leaderList
            leadersList.addAll(leaderMap.values());

            System.out.println("Líderes y sus pokemones listados correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return leadersList;  // Retornar la lista de líderes
    }

    //hace una lista con todos los pokemones de los lideres, con su id de entrenador
    public void listarPokemonesDeLideres() {
        this.leaderPokemonList.clear();

        // Consulta SQL para obtener los Pokémon de los líderes (entrenadores con ID entre 10 y 19)
        String sqlSelect = """
            SELECT pu.ID_POKE AS id_pokemon, pu.NIVEL, pu.RAREZA, p.NOMBRE AS pokemon_name, 
                   e.NOMBRE AS leader_name
            FROM pokeusables pu
            JOIN pokemones p ON pu.ID_POKE = p.ID
            JOIN entrenadores e ON pu.ID_ENTRENADOR = e.ID
            WHERE pu.ID_ENTRENADOR BETWEEN 10 AND 19
            ORDER BY pu.ID_ENTRENADOR, pu.RAREZA DESC;
            """;

        try (PreparedStatement stmt = conexion.prepareStatement(sqlSelect); ResultSet rs = stmt.executeQuery()) {

            // Iterar sobre los resultados y construir los objetos Pokémon
            while (rs.next()) {
                // Crear una nueva instancia de Pokemon
                Pokemon pokemon = new Pokemon();

                // Asignar valores de la consulta al objeto Pokemon
                pokemon.setId(rs.getInt("id_pokemon"));
                pokemon.setName(rs.getString("pokemon_name"));
                pokemon.setLevel(rs.getInt("NIVEL"));
                pokemon.setRarity(rs.getInt("RAREZA"));
                pokemon.setEntrenador(rs.getString("leader_name"));  // Nombre del líder como entrenador

                // Añadir el Pokémon a la lista
                leaderPokemonList.add(pokemon);
            }

            System.out.println("Pokémon de los líderes listados correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //hace y devuelva un lista con el nombre de los lideres
    public List<Leader> listarNombreLideres() {
        List<Leader> leadersList = new ArrayList<>();

        // Consulta SQL para obtener todos los líderes de la base de datos (ID entre 10 y 19)
        String sqlSelect = """
        SELECT ID, NOMBRE
        FROM entrenadores
        WHERE ID BETWEEN 10 AND 19;
        """;

        try (PreparedStatement stmt = conexion.prepareStatement(sqlSelect); ResultSet rs = stmt.executeQuery()) {

            // Recorrer los resultados y crear objetos Leader
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NOMBRE");

                // Crear un objeto Leader y añadirlo a la lista
                Leader leader = new Leader(name);
                leadersList.add(leader);
            }

            System.out.println("Líderes listados correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return leadersList;
    }

    public List<Pokemon> getLeaderTeams() {
        return leaderPokemonList;
    }

    public List<Leader> getLeaderList() {
        return leaderList;
    }

}
