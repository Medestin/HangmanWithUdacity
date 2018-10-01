public class Hangman {

    private final String passwordString;
    private final char[] passwordCharArray;

    Hangman(String passwordString) {
        this.passwordString = passwordString;

        this.passwordCharArray = new char[passwordString.length()];
        for (int i = 0; i < passwordString.length(); i++) {
            passwordCharArray[i] = '_';
        }

        int spaces = passwordString.indexOf(' ');
        while (spaces != -1) {
            passwordCharArray[spaces] = ' ';
            spaces = passwordString.indexOf(' ', spaces + 1);
        }
    }

    public void printCharArray() {
        System.out.println(passwordCharArray);
    }

    public int blanksLeft() {
        int blanksLeft = 0;
        for (int i = 0; i < passwordCharArray.length; i++) {
            if (passwordCharArray[i] == '_') {
                blanksLeft++;
            }
        }
        return blanksLeft;
    }

    public boolean hasWon() {
        return blanksLeft() == 0;
    }

    public void revealLetter(char letter) {
        int letterIndex = passwordString.indexOf(letter);
        while (letterIndex != -1) {
            passwordCharArray[letterIndex] = letter;
            letterIndex = passwordString.indexOf(letter, letterIndex + 1);
        }
    }
}
