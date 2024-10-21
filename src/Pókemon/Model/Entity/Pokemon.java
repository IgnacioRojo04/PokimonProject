
package Pókemon.Model.Entity;

public class Pokemon {
    String name;
    int rarity;
    int level;
    int owner; // check 
    int cost;

    public Pokemon() {
    }

    public Pokemon(String name) {
        this.name = name;
        this.cost = 1;
    }

    public Pokemon(String name, int rarity, int level, int owner, int cost) {
        this.name = name;
        this.rarity = rarity;
        this.level = level;
        this.owner = owner;
        this.cost = cost;
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
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
    
    public int getCost(){
        return this.cost;
    }
    public void setCost(int money){
        this.cost = money;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "name=" + name + ", rarity=" + rarity + ", level=" + level + ", owner=" + owner + ", cost=" + cost + '}';
    }
    
    
    
    
}
