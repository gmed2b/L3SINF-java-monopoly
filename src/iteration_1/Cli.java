package iteration_1;

import java.util.Arrays;
import java.util.Scanner;

public class Cli {
    static Scanner reader = new Scanner(System.in);

    public static void afficherMessageInitialisation(int nbJoueurs) {
        System.out.println(STR."Initialisation d'une partie avec \{nbJoueurs} joueurs ...");
        System.out.println("Initialisation terminée. La partie peut commencer.");
        System.out.println();
    }

    public static void afficherJoueur(int index) {
        System.out.println(STR."===== JOUEUR \{index + 1} =====");
    }

    public static void afficherScoreDes(int scoreDes) {
        System.out.println(STR."Vous avez fait \{scoreDes}");
    }

    public static void finDeTour() {
        System.out.println();
        pressToContinue("=== FIN DU TOUR ===");
        // Effacer la console pour le prochain joueur
//        System.out.print("\033\143");
    }

    public static void afficherJoueurGagnant(Joueur joueur) {
        System.out.println(STR."Le joueur \{joueur} a gagné la partie !");
    }

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
