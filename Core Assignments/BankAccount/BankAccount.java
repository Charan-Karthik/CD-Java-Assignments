public class BankAccount {
    // private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;

    private static int numberOfAccounts = 0;
    private static double totalBalance = 0.0;

    public BankAccount(){ //String accountNumber){
        // self.accountNumber = accountNumber;
        numberOfAccounts ++;
    }

    public double depositToChecking(double depositAmount){
        this.checkingBalance += depositAmount;
        this.totalBalance += depositAmount;
        return checkingBalance;
    }

    public double depositToSavings(double depositAmount){
        this.savingsBalance += depositAmount;
        this.totalBalance += depositAmount;
        return checkingBalance;
    }

    public String withdrawFromChecking(double withdrawAmount){
        if(this.checkingBalance < withdrawAmount){
            return "Insufficient Balance";
        } else {
            this.checkingBalance -= withdrawAmount;
            this.totalBalance -= withdrawAmount;
            return "New Balance: " + checkingBalance;
        }
    }

    public String withdrawFromSavings(double withdrawAmount){
        if(this.savingsBalance < withdrawAmount){
            return "Insufficient Balance";
        } else {
            this.savingsBalance -= withdrawAmount;
            this.totalBalance -= withdrawAmount;
            return "New Balance: " + savingsBalance;
        }
    }

    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public double getTotalBalance(){
        return this.totalBalance;
    }
}