import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class PasswordPicker {

    public static String pickPassword() {
        Scanner scannedPasswords = loadPasswords();
        List<String> passwords = new ArrayList<>();

        if (scannedPasswords != null) {
            while (scannedPasswords.hasNextLine()) {
                String line = scannedPasswords.nextLine();
                passwords.add(line);
            }
        }
        int passwordsCount = passwords.size();
        int randomPasswordIndex = (int) (Math.random() * passwordsCount);

        return passwords.get(randomPasswordIndex).toLowerCase();
    }

    private static Scanner loadPasswords(){
        File file = new File("wordList.txt");
        Scanner wordScanner = null;
        try {
            wordScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return wordScanner;
    }

}