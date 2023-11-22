import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        WordBank b = new WordBank();
        System.out.println("Please enter your name");
        String n = scnr.next();
        Player player = new Player(n);
        String hiddenWord = b.getRandomWord();
        HangmanGame h;
        String chosenChar = "";
        boolean isPlaying = true;
        while(!chosenChar.equals("n")){
            h= new HangmanGame(hiddenWord,4);
            h.printGameStatus();
            isPlaying=true;
            while(isPlaying){
                ChooseLetter(h,scnr,player);
                isPlaying= !h.isGameOver();


            }
            if(h.wonGame){
                int points = 10-h.getCurrentAttempts();
                player.incrementScores(points);
                System.out.println("Hey " + player.getName() + ". You got " + player.getScore() + " points!!!!");
            }

            System.out.println("Do you want to keep playing y or n");
            chosenChar = scnr.next();

        }
        System.out.println("Exiting the game");

    }


    private static void ChooseLetter(HangmanGame h,Scanner scnr,Player player){
        System.out.println("Choose Your Letter " + player.getName());
        String c = scnr.next();
        char p = c.charAt(0);
        h.guessedLetter(p);
    }
}