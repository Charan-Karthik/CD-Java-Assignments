import java.util.Random;

public class BankAccount {
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;

    private static int numberOfAccounts = 0;
    private static double totalBalance = 0.0;

    Random randomMethods = new Random();

    public char getRandomNumber(){
        char[] numberArray = "0123456789".toCharArray();
        int randomNumberPosition = randomMethods.nextInt(10);
        return numberArray[randomNumberPosition];
    }

    public String generateAccountNumber(){
        String generatedAccountNumber = "";
        for(int i=0; i<10; i++){
            generatedAccountNumber += getRandomNumber();
        }
        return generatedAccountNumber;
    }

    public BankAccount(){ //String accountNumber){
        this.accountNumber = generateAccountNumber();
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

    public void displayAccountInfo(){
        System.out.println("Account Number: " + this.getAccountNumber());
        System.out.println("Checking: " + this.getCheckingBalance());
        System.out.println("Savings: " + this.getSavingsBalance());
        System.out.println("Total: " + this.getTotalBalance());
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

    public String getAccountNumber(){
        return this.accountNumber;
    }
}