package Pókemon.Model.Entity;

public class Pokemon {

    int id;
    int idPoke;
    String name;
    int rarity;
    int level;
    int owner; // check 
    int cost;
    String ownerString;

    public int getIdPoke() {
        return idPoke;
    }

    public void setIdPoke(int idPoke) {
        this.idPoke = idPoke;
    }

    public String getOwnerString() {
        return ownerString;
    }

    public void setOwnerString(String ownerString) {
        this.ownerString = ownerString;
    }

    public Pokemon() {
    }

    public Pokemon(String name) {
        this.name = name;
        this.cost = 1;
    }

    public Pokemon(int idPoke, String name, int rarity, int level, int owner, int cost) {
        this.idPoke = idPoke;
        this.name = name;
        this.rarity = rarity;
        this.level = level;
        this.cost = cost;
        this.owner = owner;

    }

    public Pokemon(String name, int rarity, int level, int owner, int cost) {
        this.name = name;
        this.rarity = rarity;
        this.level = level;
        this.owner = owner;
        this.cost = cost;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getEntrenador() {
        return ownerString;
    }

    public void setEntrenador(String ownerString) {
        this.ownerString = ownerString;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "name=" + name + ", rarity=" + rarity + ", level=" + level + ", owner=" + owner + ", cost=" + cost + '}';
    }

}
