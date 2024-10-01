
package Player.Model.Repository.JDBC;

import Interface.DAO;
import Player.Model.Entity.Player;
import java.beans.Statement;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class PlayerDAOJDBC implements DAO<Player>{
    private Connection cn = null;
    
    public PlayerDAOJDBC(){
        try {
            cn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/Pokemone?user=root&password=root");
            System.out.println("Conectado");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PlayerDAOJDBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }          
    }
    
    
    
    @Override
    public List<Player> listar() {
    }

    @Override
    public Player leer(int id) {
    }

    @Override
    public void crear(Player t) {
        try {
            String insertStmtProduct = "INSERT INTO entrenadores(ID, NOMBRE) VALUES(20,?)";
            String insertStmtStock = "INSERT INTO pokeUsables(ID, ID_POKE, RAREZA,NIVEL, PRECIO, ID_ENTRENADOR) VALUES(?,1,1,10,10,20);";
            PreparedStatement pstmtStock = cn.prepareStatement(insertStmtStock, 20);
            pstmtStock.setInt(1, product.getStock().getCurrentQuantity());
            pstmtStock.executeUpdate();

            ResultSet rsStock = pstmtStock.getGeneratedKeys(); // this id begin in the position 1
            int stock_id = 0;
            if (rsStock.next()) {
                stock_id = rsStock.getInt(1);
            }

            PreparedStatement pstmtProduct = cn.prepareStatement(insertStmtProduct, Statement.RETURN_GENERATED_KEYS);
            pstmtProduct.setString(1, product.getName());
            pstmtProduct.setString(2, product.getCategory());
            pstmtProduct.setInt(3, stock_id);
            pstmtProduct.setInt(4, product.getWidth());
            pstmtProduct.setInt(5, product.getHeight());
            pstmtProduct.setInt(6, product.getDepth());
            pstmtProduct.executeUpdate();
            System.out.println("producto agregado");
        } catch (SQLException ex) {
            System.out.println("Error al insertar producto: " + ex.getErrorCode());
        }
    }

    @Override
    public void actualizar(Player t) {
    }

    @Override
    public void eliminar(int id) {
    }
    
}
