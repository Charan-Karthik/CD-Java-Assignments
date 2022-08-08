import java.util.ArrayList;

public class TestCafe {
    public static void main(String[] args){

        CafeUtil cafeMethods = new CafeUtil();

        // System.out.println(cafeMethods.getStreakGoal(10));

        // double[] itemPrices = {2.5, 3.5, 4.5, 5.5};
        // System.out.println(cafeMethods.getOrderTotal(itemPrices));

        // ArrayList<String> menuItems = new ArrayList<String>();
        // menuItems.add("drip coffee");
        // menuItems.add("cappuccino");
        // menuItems.add("latte");
        // menuItems.add("mocha");
        // cafeMethods.displayMenu(menuItems);

        // ArrayList<String> customers = new ArrayList<String>();
        // cafeMethods.addCustomer(customers);

        /* ============ App Test Cases ============= */
    
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", cafeMethods.getStreakGoal(10));
    
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n", cafeMethods.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test-----");
        
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        cafeMethods.displayMenu(menu);

        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            cafeMethods.addCustomer(customers);
            System.out.println("\n");
        } 

        System.out.println("\n----- Price Chart Test-----");
        cafeMethods.printPriceChart("mocha", 2.5, 4);
    }
} 