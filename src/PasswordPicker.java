import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasswordPicker {

    public String pickPassword() {
        //Loads wordList file, which contains passwords for Hangman
        File file = new File("wordList.txt");
        Scanner wordScanner = null;
        try {
            wordScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        }

        //Hangman file can contain up to 100 passwords
        String[] passwords = new String[100];
        int i = 0;

        // Converts file into String array of passwords
        if (wordScanner != null) {
            while (wordScanner.hasNextLine()) {
                String line = wordScanner.nextLine();
                passwords[i] = line;
                i++;
            }
        }

        //pick random password and print it:
        double rDouble = Math.random() * i;
        int rInt = (int) rDouble;


        //returns one password
        return passwords[rInt];

    }



}
