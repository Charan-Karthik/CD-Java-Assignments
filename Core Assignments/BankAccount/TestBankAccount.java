public class TestBankAccount {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount();

        System.out.println("Checking: " + account1.getCheckingBalance());
        System.out.println("Savings: " + account1.getSavingsBalance());
        System.out.println("Total: " + account1.getTotalBalance());

        account1.depositToChecking(50.0);
        System.out.println("Checking: " + account1.getCheckingBalance());
        System.out.println("Savings: " + account1.getSavingsBalance());
        System.out.println("Total: " + account1.getTotalBalance());
        
        account1.depositToSavings(25.0);
        System.out.println("Checking: " + account1.getCheckingBalance());
        System.out.println("Savings: " + account1.getSavingsBalance());
        System.out.println("Total: " + account1.getTotalBalance());

        System.out.println(account1.withdrawFromChecking(10));

    }
}