package restaurant;

import java.util.ArrayList;

import menu.Menu;
import menu.MenuItem;
import menu.MenuFactory;
import menu.Beverage;
import menu.Dish;

import stock.Stock;
import stock.StockComponent;
import stock.StockItem;
import org.json.JSONArray;
import org.json.JSONObject;

public class RestaurantInit {
    public static ArrayList<Menu> initMenus() {
        JSONArray dbMenus = Database.readAllFromTable("menu", -1, null, "");

        MenuFactory menuFactory = new MenuFactory();
        ArrayList<Menu> menus = new ArrayList<>();

        for (Object obj : dbMenus) {
            JSONObject obj2 = (JSONObject) obj;
            Menu menu = menuFactory.createMenu(obj2);
            menus.add(menu);
        }
        return menus;
    }

    public static StockComponent initStock(int capacity) {
        Stock stock = new Stock(capacity, "All Item Stock");
        JSONArray dbStock = Database.readAllFromTable("stockitems", -1, null, "");
        for (Object obj : dbStock) {
            JSONObject obj2 = (JSONObject) obj;
            StockItem item = new StockItem(obj2);
            stock.add(item);
        }
        return stock;
    }
}