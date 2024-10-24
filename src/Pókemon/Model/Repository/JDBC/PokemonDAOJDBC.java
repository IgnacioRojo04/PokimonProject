/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pókemon.Model.Repository.JDBC;

import Interface.DAO;
import Player.Model.Entity.Player;
import Pókemon.Model.Entity.Pokemon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author retam
 */
public class PokemonDAOJDBC implements DAO<Pokemon>{
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
    public void listar() {
        this.player.getTeamPokemon().clear();
        String sqlSelect = "SELECT pu.ID,  pu.ID_POKE, pu.RAREZA, pu.NIVEL, pu.PRECIO, pu.ID_ENTRENADOR, p.nombre AS pokemon_name, e.nombre AS entrenador_name "
                + "FROM pokeusables pu "
                + "JOIN pokemones p ON pu.ID_POKE = p.id "
                + "JOIN entrenadores e ON pu.ID_ENTRENADOR = e.id "
                + "WHERE pu.ID_ENTRENADOR = ?";
        System.out.println("HOLAAA " + this.player.getId());
        try (PreparedStatement stmtSelect = conexion.prepareStatement(sqlSelect)) {
            System.out.println(this.player.getId());
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
        
    }

    @Override
    public void crear(Pokemon t) {
        try {
            // Query para insertar en la tabla PokeUsables
            String sqlInsert = "INSERT INTO pokeusables (ID_POKE, RAREZA, NIVEL, PRECIO, ID_ENTRENADOR) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmtInsert = conexion.prepareStatement(sqlInsert);

            // Asignar los valores del objeto Pokemon al PreparedStatement
            stmtInsert.setInt(1, t.getIdPoke());         // ID del Pokemon
            stmtInsert.setInt(2, t.getRarity());     // Rareza del Pokemon
            stmtInsert.setInt(3, t.getLevel());      // Nivel del Pokemon
            stmtInsert.setInt(4, t.getCost());       // Precio del Pokemon
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
        try {
            // Query para actualizar los valores de la tabla pokeusables basados en el ID_POKE
            String sqlUpdate = "UPDATE pokeusables SET RAREZA = ?, NIVEL = ?, PRECIO = ?, ID_ENTRENADOR = ? WHERE ID = ?";
            PreparedStatement stmtUpdate = conexion.prepareStatement(sqlUpdate);

            // Asignar los nuevos valores del objeto Pokemon al PreparedStatement
            stmtUpdate.setInt(1, t.getRarity());       // Nueva rareza
            stmtUpdate.setInt(2, t.getLevel());        // Nuevo nivel
            stmtUpdate.setInt(3, t.getCost());         // Nuevo precio
            stmtUpdate.setInt(4, t.getOwner());        // Nuevo ID de entrenador
            stmtUpdate.setInt(5, t.getId());       // ID del Pokémon que se va a actualizar

            // Ejecutar la actualización
            int rowsAffected = stmtUpdate.executeUpdate();

            // Comprobar si se actualizó algún registro
            if (rowsAffected > 0) {
                System.out.println("Pokemon con ID_POKE " + t.getIdPoke() + " actualizado en la base de datos.");
            } else {
                System.out.println("No se encontró un Pokemon con ID_POKE " + t.getIdPoke());
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        try {
            // Query para eliminar de la tabla PokeUsables según el ID
            String sqlDelete = "DELETE FROM pokeusables WHERE ID = ?";
            PreparedStatement stmtDelete = conexion.prepareStatement(sqlDelete);

            // Asignar el valor del ID al PreparedStatement
            stmtDelete.setInt(1, id);

            // Ejecutar la eliminación
            int rowsAffected = stmtDelete.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Pokemon con ID " + id + " eliminado de la base de datos.");
            } else {
                System.out.println("No se encontró un Pokemon con ID " + id);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

}
