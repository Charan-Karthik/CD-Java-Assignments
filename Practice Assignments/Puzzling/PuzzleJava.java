import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {
    Random randMachine = new Random();

    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> tenRandomNumbers = new ArrayList<Integer>();
        for(int i=0; i<10; i++){
            int x = randMachine.nextInt(21);
            // System.out.println("i = " + i + " & x = " + x);
            if(x!=0){
                tenRandomNumbers.add(x);
            } else {
                i--;
            }
        }
        return tenRandomNumbers;
    }

    public char getRandomLetter(){
        char[] letterArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int randomLetterPosition = randMachine.nextInt(26);
        return letterArray[randomLetterPosition];
    }

    public String generatePassword(){
        String password = "";
        for(int i=0; i<8; i++){
            password += getRandomLetter();
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int numberOfPasswords){
        if(numberOfPasswords == 0){
            numberOfPasswords += 1;
        }

        ArrayList<String> passwordsArray = new ArrayList<String>();
        for(int i=0; i<numberOfPasswords; i++){
            passwordsArray.add(generatePassword());
        }
    return passwordsArray;
    }
}