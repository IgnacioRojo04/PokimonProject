package Market.Controller;

import Market.Model.Repository.JDBC.MarketDAOJDBC;
import Market.View.MarketView;
import Player.Model.Entity.Player;
import Pókemon.Model.Entity.Pokemon;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class MarketController {

    public MarketView marketView;
    public MarketDAOJDBC marketDao;

    public MarketController(Player Player) {
        this.marketView = new MarketView();
        this.marketDao = new MarketDAOJDBC(Player);
    }

    public void createPokemon() {
        if (this.marketDao.pokemonList.size() == 0) {
            Pokemon pokemonNew = new Pokemon();
            for (int i = 0; i < 20; i++) {
                pokemonNew.setLevel((int) (1 + (Math.random() * 70)));
                pokemonNew.setRarity((int) (1 + (Math.random() * 5)));
                pokemonNew.setOwner((int) (1 + (Math.random() * 9)));
                pokemonNew.setIdPoke((int) (1 + (Math.random() * 150)));
                if(pokemonNew.getRarity() == 1 || pokemonNew.getRarity() == 2){
                    pokemonNew.setCost((pokemonNew.getLevel() * pokemonNew.getRarity())) ;
                }else{
                 pokemonNew.setCost((pokemonNew.getLevel() * pokemonNew.getRarity()) * (int) ((1 + (Math.random() * 2))) );   
                }
                System.out.println(pokemonNew.getOwner());
                this.marketDao.crear(pokemonNew);
            }
        }
        this.marketDao.listar();
        fillTable();
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) this.marketView.tMarket.getModel();

        model.setRowCount(0);
        this.marketView.cbMarket.removeAllItems();
        for (Pokemon pokemon : this.marketDao.pokemonList) {
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
        Pokemon comprado = this.marketDao.pokemonList.get(indice);
        this.marketView.lblMoney.setText(player.getMoney() + "");
        comprado.setOwner(player.getId()); //pokemonTeam.get(1).getOwner()
        pokemonTeam.add(comprado);
        this.marketDao.pokemonList.remove(indice);
        DefaultTableModel model = (DefaultTableModel) this.marketView.tMarket.getModel();
        model.removeRow(indice);
        this.marketView.cbMarket.removeItem(this.marketView.cbMarket.getSelectedItem());
        this.marketDao.actualizar(comprado);
    }
}
