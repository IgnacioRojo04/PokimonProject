package Market.Controller;

import Market.Model.RepositoryJDBC.MarketDAOJDBC;
import Market.View.MarketView;
import Pókemon.Model.Entity.Pokemon;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class MarketController {
    
    public MarketView marketView;
    public MarketDAOJDBC marketDao;
    
    public MarketController(){
    this.marketView = new MarketView();
    this.marketDao = new MarketDAOJDBC();
    }
    
    public void fillTable(List<Pokemon> pokemonList){
//        pokemonList.add(new Pokemon("pika"));
//        pokemonList.add(new Pokemon("charmander"));
//        pokemonList.add(new Pokemon("Squirtle"));
        DefaultTableModel model = (DefaultTableModel) this.marketView.tMarket.getModel();

        model.setRowCount(0);
        for (Pokemon pokemon : pokemonList) {
            model.addRow(new Object[]{
                pokemon.getName(),
                pokemon.getLevel(),
                pokemon.getRarity(),
                pokemon.getOwner(),
            });
            this.marketView.cbMarket.addItem(pokemon.getName()); 
        }
    }
    public void showMoney(int money){
        money = 2;
        this.marketView.lblMoney.setText(money + "");
    }
    public void buyPoke(List<Pokemon> pokemonTeam, List<Pokemon> pokemonList){
        int indice = this.marketView.cbMarket.getSelectedIndex();
        Pokemon comprado = pokemonList.get(indice);
        System.out.println(comprado.getName());
        comprado.setOwner(20); //pokemonTeam.get(1).getOwner()
        pokemonList.remove(indice);
        pokemonTeam.add(comprado);
        DefaultTableModel model = (DefaultTableModel) marketView.tMarket.getModel();
        model.removeRow(indice);
        marketView.cbMarket.removeItem(marketView.cbMarket.getSelectedItem());
               //updateDAO(comprado);
    }
}
