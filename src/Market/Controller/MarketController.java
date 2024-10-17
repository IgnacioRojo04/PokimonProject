package Market.Controller;

import Market.Model.RepositoryJDBC.MarketDAOJDBC;
import Market.View.MarketView;
import Pókemon.Model.Entity.Pokemon;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class MarketController {

    public MarketView marketView;
    public MarketDAOJDBC marketDao;

    public MarketController() {
        this.marketView = new MarketView();
        this.marketDao = new MarketDAOJDBC();
    }

    public void fillTable() {
        this.marketView.listPokemon.add(new Pokemon("pika2"));
        this.marketView.listPokemon.add(new Pokemon("charmander2"));
        this.marketView.listPokemon.add(new Pokemon("Squirtle2"));
        DefaultTableModel model = (DefaultTableModel) this.marketView.tMarket.getModel();

        model.setRowCount(0);
        for (Pokemon pokemon : this.marketView.listPokemon) {
            model.addRow(new Object[]{
                pokemon.getName(),
                pokemon.getRarity(),
                pokemon.getLevel(),
                pokemon.getCost(),
                pokemon.getOwner(),});
            this.marketView.cbMarket.addItem(pokemon.getName());
        }
    }

    public void showMoney(int money) {
        this.marketView.lblMoney.setText(money + "");
    }

    public void buyPoke(List<Pokemon> pokemonTeam, int moneyPlayer) {
        int indice = this.marketView.cbMarket.getSelectedIndex();
        Pokemon comprado = this.marketView.listPokemon.get(indice);
        System.out.println(comprado.getName());
        this.marketView.lblMoney.setText(moneyPlayer+"");
        comprado.setOwner(20); //pokemonTeam.get(1).getOwner()
        pokemonTeam.add(comprado);

        this.marketView.listPokemon.remove(indice);
        DefaultTableModel model = (DefaultTableModel) this.marketView.tMarket.getModel();
        model.removeRow(indice);
        this.marketView.cbMarket.removeItem(this.marketView.cbMarket.getSelectedItem());
        //updateDAO(comprado);
    }
}
