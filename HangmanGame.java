import java.util.HashSet;
import java.util.Set;

public class HangmanGame {
    private String secretWord;
    private StringBuilder guessedWord;
    private int maxAttempts;
    private int currentAttempts;
    private Set<Character> guessedLetters;

    public HangmanGame(String secretWord, int maxAttempts){

        this.secretWord=secretWord;
        this.maxAttempts=maxAttempts;
        guessedWord = new StringBuilder("_".repeat(secretWord.length()));
        guessedLetters = new HashSet<>();
    }
    public void guessedLetter(char letter){
        if(isLetterAlreadyGuessed(letter)){
            System.out.println("You have already guseed the letter "+letter);
            return;
        }
        guessedLetters.add(letter);
        if(secretWord.indexOf(letter)>=0){
            for(int i =0; i <secretWord.length();i++) {
                if (secretWord.charAt(i) == letter) {
                    guessedWord.setCharAt(i,letter);
                }
            }
            System.out.println("Correct guess!");
        }else{
            currentAttempts++;
            System.out.println("Incorrect Guess!");
        }
        printGameStatus();
    }
    public boolean isGameOver() {
        if (guessedWord.toString().equals(secretWord)) {
            System.out.println("Congratulations! You've guessed the word correctly.");
            return true;
        }
        if (currentAttempts >= maxAttempts) {
            System.out.println("Game Over! You've reached the maximum number of attempts.");
            return true;
        }

        return false;
    }
    public boolean isWordGuessed(){
        return guessedWord.toString().equals(secretWord);
    }
    public boolean isLetterAlreadyGuessed(char letter) {
        // Check if the letter is in the set of guessed letters
        return guessedLetters.contains(letter);
    }
    public void printGameStatus(){

        switch (currentAttempts){
            case 1:
                System.out.println(" ____  ");
                System.out.println(" |   O   ");
                System.out.println(" |       ");
                System.out.println(" |       ");
                System.out.println(" |       ");
                break;
            case 2:
                System.out.println(" ____  ");
                System.out.println(" |   O   ");
                System.out.println(" |   |   ");
                System.out.println(" |   |   ");
                System.out.println(" |       ");
                break;
            case 3:
                System.out.println(" ____  ");
                System.out.println(" |   O   ");
                System.out.println(" | \\|/  ");
                System.out.println(" |   |   ");
                System.out.println(" |       ");
                break;
            case 4:
                System.out.println(" ____  ");
                System.out.println(" |   O   ");
                System.out.println(" | \\|/  ");
                System.out.println(" |   |   ");
                System.out.println(" |  / \\   ");
                break;
            case default:
                System.out.println(" ____  ");
                System.out.println(" |    ");
                System.out.println(" |   ");
                System.out.println(" |    ");
                System.out.println(" |       ");

        }
        System.out.println("Guessed word: " + guessedWord);
        System.out.println("Current attempts: " + currentAttempts);


    }



}
