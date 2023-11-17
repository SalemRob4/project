import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        WordBank b = new WordBank();
        String hiddenWord = b.getRandomWord();
        HangmanGame h = new HangmanGame(hiddenWord,3);
        String chosenChar = "";
        boolean isPlaying = true;
        while(!chosenChar.equals("n")){
            isPlaying=true;
            while(isPlaying){
                ChooseLetter(h,scnr);
                isPlaying= !h.isGameOver();


            }
            System.out.println("Do you want to keep playing y or n");
            chosenChar = scnr.next();

        }
        System.out.println("Exiting the game");

    }


    private static void ChooseLetter(HangmanGame h,Scanner scnr){
        System.out.println("Choose Your Letter");
        String c = scnr.next();
        char p = c.charAt(0);
        h.guessedLetter(p);
    }
}