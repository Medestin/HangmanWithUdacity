import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Let's play hangman!");

        //Use password picker to pick a password
        PasswordPicker passwordPicker = new PasswordPicker();
        String passwordString = passwordPicker.pickPassword();
        passwordString = passwordString.toLowerCase();


        //convert to char[] and cover with "_"
        int passwordLength = passwordString.length();
        char[] charPassword = new char[passwordLength];

        for (int i = 0; i < passwordLength; i++) {
            charPassword[i] = '_';
        }

        //inputs String and charArray to the Hangman class
        Hangman hangman = new Hangman(passwordString, charPassword);


        //Init. Scanner for user input
        Scanner charScanner = new Scanner(System.in);

        String usedLetters = " ";
        for (int triesLeft = 10; triesLeft != 0; ) {



            //The game:

            if (hangman.hasWon()) {
                System.out.println("Congrats!");
                hangman.printCharArray();
                break;
            } else {

                hangman.printCharArray();
                hangman.checkBlanksLeft();
                System.out.println("Used letters:" + usedLetters);
                System.out.println("Lives left: " + triesLeft + "\n");
                System.out.print("Gimme a letter! ");
                String inputString = charScanner.nextLine();
                inputString = inputString.toLowerCase();
                char inputChar = inputString.charAt(0);

                if (inputString.length() > 1) {
                    System.out.println("ONE LETTER PLEASE");
                } else if (usedLetters.contains(inputString)) {
                    System.out.println("You already used this letter...");

                } else if (passwordString.contains(inputString)) {

                    hangman.guess(inputChar);
                    usedLetters = usedLetters + inputString;


                } else {
                    System.out.println("Errr! Mistake!");
                    usedLetters = usedLetters + inputString;
                    triesLeft--;

                }


            }

        }

        if (!hangman.hasWon()) {
            System.out.println("Huehuehue Looser");
        }


    }


}
