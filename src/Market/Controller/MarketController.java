package Market.Controller;

import Market.Model.RepositoryJDBC.MarketDAOJDBC;
import Market.View.MarketView;
import Player.Model.Entity.Player;
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
        this.marketDao.market.pokemonList.add(new Pokemon("pika2"));
        this.marketDao.market.pokemonList.add(new Pokemon("charmander2"));
        this.marketDao.market.pokemonList.add(new Pokemon("Squirtle2"));
        DefaultTableModel model = (DefaultTableModel) this.marketView.tMarket.getModel();

        model.setRowCount(0);
        for (Pokemon pokemon : this.marketDao.market.pokemonList) {
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

    public void buyPoke(List<Pokemon> pokemonTeam, Player player) {
        int indice = this.marketView.cbMarket.getSelectedIndex();
        Pokemon comprado = this.marketDao.market.pokemonList.get(indice);
        this.marketView.lblMoney.setText(player.getMoney() +"");
        comprado.setOwner(player.getId()); //pokemonTeam.get(1).getOwner()
        pokemonTeam.add(comprado);
        this.marketDao.market.pokemonList.remove(indice);
        DefaultTableModel model = (DefaultTableModel) this.marketView.tMarket.getModel();
        model.removeRow(indice);
        this.marketView.cbMarket.removeItem(this.marketView.cbMarket.getSelectedItem());
        //updateDAO(comprado);
    }
}
