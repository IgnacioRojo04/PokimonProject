
package Interface;

import java.util.List;


public interface DAO<T>{
    List<T> listar();
    T leer (int id);
    void crear (T t);
    void actualizar (T t);
    void eliminar (int id);
}
