public class BankAccount {
    // private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;

    private static int numberOfAccounts = 0;
    private static double totalBalance = 0.0;

    public BankAccount(String accountNumber){
        self.accountNumber = accountNumber;
        numberOfAccounts ++;
    }

    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public double viewTotalBalance(){
        return this.totalBalance;
    }
}