import java.util.Random;
import java.util.ArrayList;

public class TestPuzzle {
    public static void main(String[] args){
        PuzzleJava puzzleMethods = new PuzzleJava();
        Random randMachine = new Random();

        System.out.println(puzzleMethods.getTenRolls());
        System.out.println(puzzleMethods.getRandomLetter());
        System.out.println(puzzleMethods.generatePassword());
        System.out.println(puzzleMethods.getNewPasswordSet(randMachine.nextInt(10)));
    }
}