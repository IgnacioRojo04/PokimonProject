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

    private Connection conexion = null;
    String URL = "jdbc:mariadb://localhost:3306/pokemones"; // Nombre de tu base de datos
    String USER = "root"; // Usuario de tu base de datos
    String PASS = "root"; // Contraseña de tu base de datos

    public PokemonDAOJDBC() {
       conectar();
      
    }

    
    public void conectar(){
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
        return null;
    }


    @Override
    public void crear(Pokemon t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
