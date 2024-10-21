
package Interface;

import java.util.List;


public interface DAO<T>{
    List<T> listar();
    void crear (T t);
    void actualizar (T t);
    void eliminar (int id);
}
