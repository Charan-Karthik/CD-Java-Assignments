import java.util.Random;
import java.text.NumberFormat;

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
            return "Insufficient Balance in Checking Account";
        } else {
            this.checkingBalance -= withdrawAmount;
            this.totalBalance -= withdrawAmount;

            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
            String checkingAmount = currencyFormat.format(this.checkingBalance);

            return "New Checking Account Balance: " + checkingAmount;
        }
    }

    public String withdrawFromSavings(double withdrawAmount){
        if(this.savingsBalance < withdrawAmount){
            return "Insufficient Balance in Savings Account";
        } else {
            this.savingsBalance -= withdrawAmount;
            this.totalBalance -= withdrawAmount;

            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
            String savingsAmount = currencyFormat.format(this.savingsBalance);

            return "New Savings Account Balance: " + savingsAmount;
        }
    }

    public void displayAccountInfo(){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

        System.out.println("Account Number: " + this.getAccountNumber());

        String checkingAmount = currencyFormat.format(this.checkingBalance);
        System.out.println("Checking: " + checkingAmount);

        String savingsAmount = currencyFormat.format(this.savingsBalance);
        System.out.println("Savings: " + savingsAmount);

        String totalAmount = currencyFormat.format(this.totalBalance);
        System.out.println("Total: " + totalAmount);

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