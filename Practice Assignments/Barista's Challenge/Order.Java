import java.util.ArrayList;
    
// Here we're creating a new data type called Order
public class Order {
    
    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items = new ArrayList<Item>(); // defaults to null
    
    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order() {
        this.name = "Guest";
    }
    
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name){
        this.name = name;
    }
    
    // ORDER METHODS
    	// Most of your code will go here, 
    	// so implement the getters and setters first!
    public void addItem(Item item){
        this.items.add(item);
    }

    public String getStatusMessage(){
        if(this.ready == false){
            return "Thank you for wairing. Your order will be ready soon.";
        } else {
            return "Your order is ready.";
        }
    }

// CHANGE BELOW TO RETURN TYPE DOUBLE WHEN IT WORKS
    public void getOrderTotal(){
        ArrayList<Item> allItems = getOrderItems();
        System.out.println(allItems);
    }

    
    // GETTERS & SETTERS
    public String getOrderName(){
        return this.name;
    }

    public boolean isOrderReady(){
        return this.ready;
    }

    public ArrayList<Item> getOrderItems(){
        return this.items;
    }

    public void setOrderName(String name){
        this.name = name;
    }

    public void setOrderStatus(boolean status){
        this.ready = status;
    }

    // public void setOrderItems(ArrayList<Items> items){
    //     this.items = items;
    // }
}

