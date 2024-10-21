
package Pókemon.Model.Entity;

public class Pokemon {
    int id;
    String name;
    int rarity;
    int level;
    int owner; // check 
    int cost;
    String entrenador;

    public Pokemon(int id, String name, int rarity, int level, int precio , int entrenador ) {
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.level = level;
         this.cost = precio;
        this.owner = entrenador;
       
    }

    public Pokemon() {
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getOwner() {
        return this.owner;
    }

    public void setOwner(int entrenador) {
        this.owner = entrenador;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }
    
    
    
    
}
