import java.util.Scanner;

public class Game {
    private final String passwordString = PasswordPicker.pickPassword();
    private Hangman hangman = new Hangman(passwordString);
    private String usedLetters = "";
    private int triesLeft = 10;

    private Scanner charScanner = new Scanner(System.in);

    public void newGame() {
        while(triesLeft != 0) {
            if (hangman.hasWon()) {
                System.out.println("Congrats!");
                hangman.printCharArray();
                break;
            } else {
                printInformation();
                guess(getInput());
            }
        }
        if (!hangman.hasWon()) {
            System.out.println("Huehuehue Looser");
        }
    }

    private void guess(String inputString){
        char inputChar = inputString.charAt(0);

        if ((usedLetters.contains(inputString))) {
            System.out.println("You already used this letter...");
        } else if (passwordString.contains(inputString)) {
            hangman.revealLetter(inputChar);
            usedLetters = usedLetters + inputString;
        } else {
            System.out.println("Errr! Mistake!");
            usedLetters = usedLetters + inputString;
            triesLeft--;
        }
    }

    private String getInput(){
        String inputString = charScanner.nextLine().toLowerCase();

        if (inputString.length() > 1) {
            System.out.println("ONE LETTER PLEASE");
            getInput();
        }
        return inputString;
    }

    private void printInformation(){
        hangman.printCharArray();
        System.out.println("Blanks left: " + hangman.blanksLeft() + ".");
        System.out.println("Used letters:" + usedLetters);
        System.out.println("Lives left: " + triesLeft + "\n");
        System.out.print("Gimme a letter! ");
    }
}
