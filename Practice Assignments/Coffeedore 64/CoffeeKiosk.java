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

    public void addMenuItem(String name, double price){
        Item newItem = new Item(name, price);
        menu.add(newItem);
        int index = menu.indexOf(newItem);
        newItem.setIndex(index);
    }

    public void displayMenu(){
        for(Item item : this.menu){
            System.out.println(item.getIndex() + " " + item.getName() + " - - $" + item.getPrice());
        }
    }

    public void newOrder() {
    
    // Shows the user a message prompt and then sets their input to a variable, name
    System.out.println("Please enter customer name for new order:");
    String name = System.console().readLine();

    // Your code:
    // Create a new order with the given input string
    // Show the user the menu, so they can choose items to add.
    Order newOrder = new Order(name);
    displayMenu();
    
    // Prompts the user to enter an item number
    System.out.println("Please enter a menu item index or q to quit:");
    String itemNumber = System.console().readLine();
    
    // Write a while loop to collect all user's order items
    while(!itemNumber.equals("q")) {
        // Get the item object from the menu, and add the item to the order
        int indexInput = Integer.parseInt(itemNumber);
        if(indexInput < this.menu.size()){
            Item indexInputToOrderItem = menu.get(indexInput);
            newOrder.addItem(indexInputToOrderItem);
        } else {
            System.out.println("Sorry, we don't have that on our menu.");
        }

        // Ask them to enter a new item index or q again, and take their input
        System.out.println("Please enter a menu item index or q to quit:");
        itemNumber = System.console().readLine();
    }
    // After you have collected their order, print the order details 
    newOrder.display();
    this.orders.add(newOrder);
    }

    public void addMenuItemByInput(){
        boolean adding = true;
        while(adding){
            System.out.println("Enter name of product to be added to menu");
            String itemName = System.console().readLine();
            
            System.out.println("Enter the price for " + itemName);
            String itemPrice = System.console().readLine();
            double itemPriceAsDouble = Double.parseDouble(itemPrice);

            addMenuItem(itemName, itemPriceAsDouble);
            System.out.println("Would you like to continue adding menu items? (Enter: y/n)");
            String continueAdding = System.console().readLine().toLowerCase();
            if(continueAdding.equals("n")){
                adding = false;
            }
        }
    }
}