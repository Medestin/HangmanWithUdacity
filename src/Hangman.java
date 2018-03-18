public class Hangman {

    private String passwordString;
    private char[] passwordCharArray;

    Hangman(String inputString, char[] inputCharArray) {
        passwordString = inputString;
        passwordCharArray = inputCharArray;


        int spaces = passwordString.indexOf(' ');
        while (spaces != -1) {
            passwordCharArray[spaces] = ' ';
            spaces = passwordString.indexOf(' ', spaces + 1);
        }

    }

    public void printCharArray() {
        System.out.println(passwordCharArray);

    }

    public void checkBlanksLeft() {
        int countLeft = 0;
        for (int i = 0; i < passwordCharArray.length; i++) {
            if (passwordCharArray[i] == '_') {
                countLeft++;
            }

        }
        System.out.println("Blank spaces left: " + countLeft);
    }

    public boolean hasWon() {
        boolean hasWon;
        int countLeft = 0;
        for (int i = 0; i < passwordCharArray.length; i++) {
            if (passwordCharArray[i] == '_') {
                countLeft++;
            }
        }
        if (countLeft == 0) {
            hasWon = true;
        } else {
            hasWon = false;
        }

        return hasWon;
    }


    public void guess(char letter) {
        int spaces = passwordString.indexOf(letter);
        while (spaces != -1) {
            passwordCharArray[spaces] = letter;
            spaces = passwordString.indexOf(letter, spaces + 1);
        }

    }


}
