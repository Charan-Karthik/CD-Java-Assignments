public class TestCafe {
	public static void main(String[] args) {
		
        CafeUtil cafeMethods = new CafeUtil();

        System.out.println(cafeMethods.getStreakGoal(10));

        double[] itemPrices = {2.5, 3.5, 4.5, 5.5};
        System.out.println(cafeMethods.getOrderTotal(itemPrices));
	}
}