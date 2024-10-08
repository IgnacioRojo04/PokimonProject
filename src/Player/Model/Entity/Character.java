
package Player.Model.Entity;

import java.util.Objects;


public abstract class Character {
    private String name;
    //List<Pokemon> pokemonList;
    //List<Object> objectList;
    private int money;
    private int id;
    
    
    public Character(){
        this.name = "";
        this.money = 0;
        id = 0; //crear metodo par aque los id no se repitan
        //this.pokemonList = ArrayList<>()
    }
    public Character(String name, int money){
        this.name = name;
        this.money = money;
        id = 0;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public abstract void sell();
    public abstract void buy();
    
    @Override
    public String toString(){
        return "Id: "+this.id+"Nombre: "+this.name+", Money: "+this.money;
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Character character = (Character) obj;
        return id == character.id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + this.money;
        hash = 43 * hash + this.id;
        return hash;
    }
    
}
