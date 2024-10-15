package Market.Model.RepositoryJDBC;

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
import Market.Model.Entity.Market;
import Pókemon.Model.Entity.Pokemon;
import java.util.Random;

public class MarketDAOJDBC implements DAO<Market> {

    private Connection conexion = null;
    String URL = "jdbc:mariadb://localhost:3306/pokemones"; // Nombre de tu base de datos
    String USER = "root"; // Usuario de tu base de datos
    String PASS = "root"; // Contraseña de tu base de datos

    public MarketDAOJDBC() {
        conectar();
    }

    @Override
    public List<Market> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Market leer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void crear(Market t) {
        Random random = new Random();

        try {

            // Query para insertar en la tabla PokeUsables
            String sqlInsert = "INSERT INTO pokeusables (ID_POKE, RAREZA, NIVEL, PRECIO, ID_ENTRENADOR) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmtInsert = conexion.prepareStatement(sqlInsert);

            for (int i = 0; i < 20; i++) {
                // Generar valores aleatorios para los campos
                int pokemonId = random.nextInt(151) + 1; // Pokémon id (de 1 a 151)
                int rareza = random.nextInt(5) + 1; // Rareza (de 1 a 5)
                int nivel = random.nextInt(100) + 1; // Nivel (de 1 a 100)
                int entrenadorId = random.nextInt(19) + 1; // Entrenador id (de 1 a 19)

                // Calcular el precio en base a la rareza y el nivel
                double multiplicador = 1.0 + (rareza - 1) * 0.50;
                double precio = nivel * multiplicador;

                // Asignar los valores en el PreparedStatement
                stmtInsert.setInt(1, pokemonId);
                stmtInsert.setInt(2, rareza);
                stmtInsert.setInt(3, nivel);
                stmtInsert.setDouble(4, precio);
                stmtInsert.setInt(5, entrenadorId);

                // Ejecutar la inserción
                stmtInsert.executeUpdate();

                System.out.println("Registro " + (i + 1) + " insertado: Pokémon ID " + pokemonId + ", Entrenador ID " + entrenadorId);
            }

            System.out.println("Inserción completada.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
    public void actualizar(Market t) {

    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
