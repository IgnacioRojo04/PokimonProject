
package Interface;




public interface DAO<T>{
    void listar();
    void crear (T t);
    void actualizar (T t);
    void eliminar (int number);

}
