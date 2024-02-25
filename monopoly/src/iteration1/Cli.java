package iteration1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cli {

    static Scanner reader = new Scanner(System.in);

    /**
     * Display a message and wait for the user to press enter
     */
    public static void pressToContinue(String message) {
        if (message.isEmpty()) {
            message = "press enter to continue...";
        }
        System.out.print(message);
        reader.nextLine();
        System.out.println();
    }

}

