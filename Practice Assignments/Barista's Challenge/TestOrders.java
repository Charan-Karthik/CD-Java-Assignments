import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {

    // Create Menu Items
        Item item1 = new Item("mocha", 4.75);
        Item item2 = new Item("latte", 5.25);
        Item item3 = new Item("drip coffee", 3.75);
        Item item4 = new Item("capuccino", 6.25);
    
    // Two Orders for Unspecified Guests
        Order order1 = new Order();
        Order order2 = new Order();

    // Three Orders via Overloading
        Order order3 = new Order("Cindhuri");
        Order order4 = new Order("Jimmy");
        Order order5 = new Order("Noah");

    // Add at least two items to each order
        order1.addItem(item3);
        order1.addItem(item4);
        order1.addItem(item2);
        order1.setOrderStatus(true);

        order2.addItem(item4);
        order2.addItem(item3);
        order2.setOrderStatus(true);

        order3.addItem(item1);
        order3.addItem(item3);
        order3.setOrderStatus(true);

        order4.addItem(item2);
        order4.addItem(item4);
        order4.addItem(item1);

        order5.addItem(item1);
        order5.addItem(item2);
        order5.addItem(item3);
        order5.addItem(item4);

    // Testing Methods
        // System.out.println(order1.getOrderItems());
        // order1.getOrderItems().forEach((item) -> System.out.println(item.getName()));

        // System.out.println(order1.getOrderStatus());
        // System.out.println(order5.getOrderStatus());

        // System.out.println(order2.getOrderTotal());
        
        order1.display();
        System.out.println("\n");
        order2.display();
        System.out.println("\n");
        order3.display();
        System.out.println("\n");
        order4.display();
        System.out.println("\n");
        order5.display();
    }
}