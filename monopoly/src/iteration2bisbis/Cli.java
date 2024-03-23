package iteration2bisbis;

import java.util.Arrays;
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

    /**
     * Display a message and wait for the user to press enter
     *
     * @param message
     * @return
     */
    public static String prompt(String message, String[] options) {
        while (true) {
            System.out.print(message + " " + Arrays.toString(options));
            String input = reader.nextLine().toLowerCase();
            for (String option : options) {
                if (option.toLowerCase().equals(input)) {
                    return input;
                }
            }
            System.out.println("Invalid input. Please try again.");
        }
    }

    public static String prompt(String message) {
        String[] options = { "O", "N" };
        return prompt(message, options);
    }

}
