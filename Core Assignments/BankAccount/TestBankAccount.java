public class TestBankAccount {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount();

        // System.out.println("Checking: " + account1.getCheckingBalance());
        // System.out.println("Savings: " + account1.getSavingsBalance());
        // System.out.println("Total: " + account1.getTotalBalance());
        account1.displayAccountInfo();

        account1.depositToChecking(50.0);
        account1.displayAccountInfo();
        // System.out.println("Checking: " + account1.getCheckingBalance());
        // System.out.println("Savings: " + account1.getSavingsBalance());
        // System.out.println("Total: " + account1.getTotalBalance());
        
        account1.depositToSavings(25.0);
        account1.displayAccountInfo();
        // System.out.println("Checking: " + account1.getCheckingBalance());
        // System.out.println("Savings: " + account1.getSavingsBalance());
        // System.out.println("Total: " + account1.getTotalBalance());

        System.out.println(account1.withdrawFromChecking(10));
        System.out.println(account1.withdrawFromChecking(70));

    }
}