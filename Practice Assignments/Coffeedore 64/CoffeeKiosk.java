import java.util.ArrayList;

public class CoffeeKiosk{
    private ArrayList<Item> menu = new ArrayList<Item>();
    private ArrayList<Order> orders = new ArrayList<Order>();

    public CoffeeKiosk(){
    }

    public ArrayList<Item> getMenu(){
        return this.menu;
    }
    public ArrayList<Order> getOrders(){
        return this.orders;
    }
}