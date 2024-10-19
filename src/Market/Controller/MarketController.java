package Market.Controller;

import Market.Model.RepositoryJDBC.MarketDAOJDBC;
import Market.View.MarketView;

public class MarketController {
    
    public MarketView marketView;
    public MarketDAOJDBC marketDao;
    
    public MarketController(){
    this.marketView = new MarketView();
    this.marketDao = new MarketDAOJDBC();
}
    
}
