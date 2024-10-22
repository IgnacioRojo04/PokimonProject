package Market.Model.Repository.JDBC;

import Interface.DAO;

import Interface.DAO;
import java.sql.Statement;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import Market.Model.Entity.Market;
import Pókemon.Model.Entity.Pokemon;
import java.util.ArrayList;
import java.util.Random;

public class MarketDAOJDBC implements DAO<Pokemon> {

    private Connection conexion = null;
    String URL = "jdbc:mariadb://127.0.0.1:3306/pokemones"; // Nombre de tu base de datos
    String USER = "root"; // Usuario de tu base de datos
    String PASS = "root"; // Contraseña de tu base de datos
    private int idPokeUsable;
    public List<Pokemon> pokemonList;
    public MarketDAOJDBC() {
        this.pokemonList = new ArrayList<>();
//        this.pokemonesEntrenador = new ArrayList<>();
        conectar();
    }

    @Override
    public List<Pokemon> listar() {
        this.pokemonList.clear();

        try {
            // Consulta SQL para obtener todos los registros de pokeusables donde id_entrenador < 20
            String sqlSelect = "SELECT pu.ID_POKE, pu.RAREZA, pu.NIVEL, pu.PRECIO, pu.ID_ENTRENADOR, p.nombre AS pokemon_name, e.nombre AS entrenador_name "
                    + "FROM pokeusables pu "
                    + "JOIN pokemones p ON pu.ID_POKE = p.id "
                    + "JOIN entrenadores e ON pu.ID_ENTRENADOR = e.id "
                    + "WHERE pu.ID_ENTRENADOR < 20";
            PreparedStatement stmtSelect = conexion.prepareStatement(sqlSelect);

            // Ejecutar la consulta y obtener los resultados
            ResultSet rs = stmtSelect.executeQuery();

            // Recorrer los resultados
            while (rs.next()) {
                // Crear una nueva instancia de Pokemon
                Pokemon pokemon = new Pokemon();

                // Asignar los valores de las columnas a los atributos del objeto Pokemon
                pokemon.setId(rs.getInt("ID_POKE"));                // Columna ID_POKE -> id del Pokemon
                pokemon.setRarity(rs.getInt("RAREZA"));             // Columna RAREZA -> rareza
                pokemon.setLevel(rs.getInt("NIVEL"));               // Columna NIVEL -> nivel
                pokemon.setCost(rs.getInt("PRECIO"));               // Columna PRECIO -> precio
                pokemon.setOwner(rs.getInt("ID_ENTRENADOR"));       // Columna ID_ENTRENADOR -> id del entrenador
                pokemon.setName(rs.getString("pokemon_name"));      // Columna pokemon_name -> nombre del Pokemon
                pokemon.setEntrenador(rs.getString("entrenador_name"));  // Columna entrenador_name -> nombre del entrenador

                // Añadir el Pokemon a la lista
                pokemonList.add(pokemon);
            }

            System.out.println("Pokemones listados correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pokemonList; // Devolver la lista de pokemones
    } // llamar Listar despues de cada cambio en la base de datos, para que la lista siempre sea igual

    @Override
    public void crear(Pokemon t) {
        try {
            // Query para insertar en la tabla PokeUsables
            String sqlInsert = "INSERT INTO pokeusables (ID_POKE, RAREZA, NIVEL, PRECIO, ID_ENTRENADOR) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmtInsert = conexion.prepareStatement(sqlInsert);

            // Asignar los valores del objeto Pokemon al PreparedStatement
            stmtInsert.setInt(1, t.getId());         // ID del Pokemon
            stmtInsert.setInt(2, t.getRarity());     // Rareza del Pokemon
            stmtInsert.setInt(3, t.getLevel());      // Nivel del Pokemon
            stmtInsert.setInt(4, t.getCost());       // Precio del Pokemon
            stmtInsert.setInt(5, t.getOwner());      // ID del entrenador (dueño)

            // Ejecutar la inserción
            stmtInsert.executeUpdate();

            System.out.println("Pokemon ID " + t.getId() + " insertado en la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reiniciarTablaBD() {
        try {
             String sqlDeleteTable = "DELETE FROM pokeusables WHERE ID_ENTRENADOR < 20  ";
            PreparedStatement stmtDelete = conexion.prepareStatement(sqlDeleteTable);
            stmtDelete.executeUpdate();
            System.out.println("Se eliminaron los registros.");
             String sqlResetAutoIncrement = "ALTER TABLE pokeusables AUTO_INCREMENT = 1";
            PreparedStatement stmtReset = conexion.prepareStatement(sqlResetAutoIncrement);
            stmtReset.executeUpdate();
            System.out.println("Auto-increment reiniciado a 1 en la tabla pokeusables.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    public void actualizar(Pokemon t) {
        try {
            // Query para actualizar el ID_ENTRENADOR a 20
            String sqlUpdate = "UPDATE pokeusables SET ID_ENTRENADOR = 20 WHERE ID_POKEUSABLE = ?";
            PreparedStatement stmtUpdate = conexion.prepareStatement(sqlUpdate);

            // Asignar el valor del ID_POKEUSABLE del objeto `Market`
            stmtUpdate.setInt(1, t.getId()); // Asumiendo que `getId()` devuelve el ID del registro

            // Ejecutar la actualización
            int filasActualizadas = stmtUpdate.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("El Pokémon fue comprado por el jugador (ID_ENTRENADOR = 20).");
            } else {
                System.out.println("No se encontró ningún registro con ese ID_POKEUSABLE.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(int id) {
        try {
            // Primero obtenemos el ID_ENTRENADOR del registro que queremos eliminar
            String sqlSelect = "SELECT ID_ENTRENADOR FROM pokeusables WHERE ID = ?";
            PreparedStatement stmtSelect = conexion.prepareStatement(sqlSelect);
            stmtSelect.setInt(1, id);
            ResultSet rs = stmtSelect.executeQuery();

            if (rs.next()) {
                int entrenadorId = rs.getInt("ID_ENTRENADOR"); // Obtenemos el ID_ENTRENADOR

                if (entrenadorId >= 20) {
                    // Si el entrenador tiene un ID mayor o igual a 20, no borramos y mostramos un mensaje
                    System.out.println("Pokémon del jugador, no se puede eliminar.");
                } else {
                    // Si el entrenador tiene un ID menor a 20, procedemos con la eliminación
                    String sqlDelete = "DELETE FROM pokeusables WHERE ID = ?";
                    PreparedStatement stmtDelete = conexion.prepareStatement(sqlDelete);
                    stmtDelete.setInt(1, id); // Asignar el valor del ID_POKEUSABLE
                    int filasAfectadas = stmtDelete.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Registro eliminado exitosamente: Pokémon ID_POKEUSABLE " + id);
                    } else {
                        System.out.println("No se encontró un registro con ID_POKEUSABLE " + id);
                    }
                }
            } else {
                System.out.println("No se encontró un registro con ID_ENTRENADOR " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//    public List<Pokemon> listarPokeEntrenador() {
//        pokemonesEntrenador.clear();
//
//        try {
//            // Consulta SQL para obtener todos los registros de pokeusables donde id_entrenador >= 20
//            String sqlSelect = "SELECT ID_POKE, RAREZA, NIVEL, PRECIO, ID_ENTRENADOR FROM pokeusables WHERE ID_ENTRENADOR >= 20";
//            PreparedStatement stmtSelect = conexion.prepareStatement(sqlSelect);
//
//            // Ejecutar la consulta y obtener los resultados
//            ResultSet rs = stmtSelect.executeQuery();
//
//            // Recorrer los resultados
//            while (rs.next()) {
//                // Crear una nueva instancia de Pokemon
//                Pokemon pokemon = new Pokemon();
//
//                // Asignar los valores de las columnas a los atributos del objeto Pokemon
//                pokemon.setId(rs.getInt("ID_POKE"));           // Columna ID_POKE -> id del Pokemon
//                pokemon.setRarity(rs.getInt("RAREZA"));        // Columna RAREZA -> rareza
//                pokemon.setLevel(rs.getInt("NIVEL"));          // Columna NIVEL -> nivel
//                pokemon.setCost(rs.getInt("PRECIO"));          // Columna PRECIO -> precio
//                pokemon.setOwner(rs.getInt("ID_ENTRENADOR"));  // Columna ID_ENTRENADOR -> id del entrenador
//
//                // Añadir el Pokemon a la lista
//                pokemonesEntrenador.add(pokemon);
//            }
//
//            System.out.println("Pokemones del entrenador listados correctamente.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } //finally {
////            // Cerrar la conexión
////            if (conexion != null) {
////                try {
////                    conexion.close();
////                } catch (SQLException e) {
////                    e.printStackTrace();
////                }
////            }
////        }
//
//        return pokemonesEntrenador; // Devolver la lista de pokemones del entrenador
//    }

