
package Lideres.Model.Entity;


public class Lideres {
    
    int idLider;
    String nombreLider;
    int dificultad;

    public Lideres(int idLider, String nombreLider, int dificultad) {
        this.idLider = idLider;
        this.nombreLider = nombreLider;
        this.dificultad = dificultad;
    }

    public int getIdLider() {
        return idLider;
    }

    public String getNombreLider() {
        return nombreLider;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setIdLider(int idLider) {
        this.idLider = idLider;
    }

    public void setNombreLider(String nombreLider) {
        this.nombreLider = nombreLider;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
    
    
    
    
}
