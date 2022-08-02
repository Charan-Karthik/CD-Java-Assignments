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
        this.items = [];
    }
    
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name){
        this.name = name;
        this.items = [];
    }
    
    // ORDER METHODS
    	// Most of your code will go here, 
    	// so implement the getters and setters first!
    
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

    public void setOrderItems(ArrayList<Items> items){
        this.items = items;
    }
}

