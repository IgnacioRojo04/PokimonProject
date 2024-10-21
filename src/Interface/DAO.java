
package Interface;

import java.util.List;


public interface DAO<T>{
    List<T> listar(); // Mostrar tabla poke 
    void crear (T t); // cuando se crea la view Market creas o capturas 
    void actualizar (T t); // cuando compras o cuando subis de nivel 
    void eliminar (int id); // cuando vendes y cuando salis de la MarketView
}
