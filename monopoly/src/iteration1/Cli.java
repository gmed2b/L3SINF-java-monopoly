package iteration1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cli {

    static Scanner reader = new Scanner(System.in);

    /**
     * Get an integer input from the user
     *
     * @return The integer input
     */
    public static int getIntInput() {
        System.out.print("-> ");
        try {
            int choice = reader.nextInt();
            reader.nextLine(); // Consume the \n character
            return choice;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            reader.nextLine(); // Consume the invalid input
            return getIntInput(); // Recursive call to get a valid integer input
        }
    }

    /**
     * Display a message and wait for the user to press enter
     */
    public static void pressToContinue() {
        System.out.println();
        System.out.print("press enter to continue...");
        reader.nextLine();
    }

}

