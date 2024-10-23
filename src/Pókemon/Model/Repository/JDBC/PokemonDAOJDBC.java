package Pókemon.Model.Repository.JDBC;

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

import Interface.DAO;
import Pókemon.Model.Entity.Pokemon;
import java.util.Random;

public class PokemonDAOJDBC implements DAO<Pokemon> {

    private Player player;
    private Connection conexion = null;
    String URL = "jdbc:mariadb://localhost:3306/pokemones"; // Nombre de tu base de datos
    String USER = "root"; // Usuario de tu base de datos
    String PASS = "root"; // Contraseña de tu base de datos

    public PokemonDAOJDBC(Player player) {
        conectar();
        this.player = player;
    }

    public void conectar() {
        try {
            // Obtiene la conexión
            conexion = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace(); // Imprime el error para más detalles
        }
    }

    @Override
    public List<Pokemon> listar() {
        this.player.getTeamPokemon().clear();
        String sqlSelect = "SELECT pu.ID,  pu.ID_POKE, pu.RAREZA, pu.NIVEL, pu.PRECIO, pu.ID_ENTRENADOR, p.nombre AS pokemon_name, e.nombre AS entrenador_name "
                + "FROM pokeusables pu "
                + "JOIN pokemones p ON pu.ID_POKE = p.id "
                + "JOIN entrenadores e ON pu.ID_ENTRENADOR = e.id "
                + "WHERE pu.ID_ENTRENADOR = ?";
        try (PreparedStatement stmtSelect = conexion.prepareStatement(sqlSelect)) {

            stmtSelect.setInt(1, this.player.getId());

            // Ejecutar la consulta y obtener los resultados
            ResultSet rs = stmtSelect.executeQuery();

            // Recorrer los resultados
            while (rs.next()) {
                // Crear una nueva instancia de Pokemon
                Pokemon pokemon = new Pokemon();

                // Asignar los valores de las columnas a los atributos del objeto Pokemon
                pokemon.setId(rs.getInt("ID"));
                pokemon.setIdPoke(rs.getInt("ID_POKE"));                // Columna ID_POKE -> id del Pokemon
                pokemon.setRarity(rs.getInt("RAREZA"));             // Columna RAREZA -> rareza
                pokemon.setLevel(rs.getInt("NIVEL"));               // Columna NIVEL -> nivel
                pokemon.setCost(rs.getInt("PRECIO"));               // Columna PRECIO -> precio
                pokemon.setOwner(rs.getInt("ID_ENTRENADOR"));       // Columna ID_ENTRENADOR -> id del entrenador
                pokemon.setName(rs.getString("pokemon_name"));      // Columna pokemon_name -> nombre del Pokemon
                pokemon.setEntrenador(rs.getString("entrenador_name"));  // Columna entrenador_name -> nombre del entrenador

                // Añadir el Pokemon a la lista
                this.player.getTeamPokemon().add(pokemon);
            }

            System.out.println("Pokemones listados correctamente.");

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return this.player.getTeamPokemon();
    }

    @Override
    public void crear(Pokemon t) {
        try {
            // Query para insertar en la tabla PokeUsables
            String sqlInsert = "INSERT INTO pokeusables (ID_POKE, RAREZA, NIVEL, PRECIO, ID_ENTRENADOR) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmtInsert = conexion.prepareStatement(sqlInsert);

            // Asignar los valores del objeto Pokemon al PreparedStatement
            stmtInsert.setInt(1, ((int) (1 + (Math.random() * 3))));
            stmtInsert.setInt(2,  ((int) (1 + (Math.random() * 2))));
            stmtInsert.setInt(3, ((int) (1 + (Math.random() * 2))));
            stmtInsert.setInt(4, 0);
            stmtInsert.setInt(5, this.player.getId());

            // Ejecutar la inserción
            stmtInsert.executeUpdate();

            System.out.println("Pokemon ID " + t.getIdPoke() + " insertado en la base de datos.");
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    @Override
    public void actualizar(Pokemon t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
