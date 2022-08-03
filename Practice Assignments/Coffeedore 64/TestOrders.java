import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
        CoffeeKiosk kiosk1 = new CoffeeKiosk();
    
        kiosk1.addMenuItem("banana", 2.00);
        kiosk1.addMenuItem("coffee", 1.50);
        kiosk1.addMenuItem("latte", 4.50);
        kiosk1.addMenuItem("capuccino", 3.00);
        kiosk1.addMenuItem("muffin", 4.00);
        // kiosk1.displayMenu();

        kiosk1.newOrder();
    }
}