import java.util.ArrayList;

public class CafeUtil {
    
    public int getStreakGoal(int numWeeks){
        int sum = 0;
        for(int i=0; i <= numWeeks; i++){
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double total = 0;
        for(int i=0; i<prices.length; i++){
            total += prices[i];
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for(int i=0; i<menuItems.size(); i++){
            System.out.println(i + " " + menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName);

        if(customers.size() == 1){
            System.out.println("There is " + customers.size() + " person in front of you");
        } else {
            System.out.println("There are " + customers.size() + " people in front of you");
        }

        customers.add(userName);
        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int maxQuantity){
        if(maxQuantity == 0){
            System.out.println("You cannot buy 0 items");
        } else {
            System.out.println(product);
            double chainPrice = price;
            for(int i=1; i<=maxQuantity; i++){
                System.out.println(i + " - " + String.format("$%,.2f", chainPrice));
                chainPrice += price;
            }
        }

    }
}