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
}