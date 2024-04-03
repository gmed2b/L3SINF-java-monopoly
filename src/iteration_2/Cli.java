package iteration_2;

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

    /**
     * Display a message and wait for the user to press enter
     *
     * @param message
     * @return
     */
    public static String prompt(String message, String[] options) {
        while (true) {
            System.out.print(STR."\{message} \{Arrays.toString(options)}");
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

    public static boolean acheterPropriete(Propriete propriete) {
        String input = prompt(
                STR."Voulez-vous acheter \{propriete.getNom()} pour \{propriete.getTarifAchat()}€ ?");
        return input.toLowerCase().equals("o");
    }

    public static void achatProprieteReussi(Propriete propriete) {
        System.out.println(STR."Vous avez acheté \{propriete.getNom()} !");
    }

    public static void afficherCase(Case caseActuelle) {
        System.out.println(STR."Vous êtes sur la case \{caseActuelle.getNom()}");
    }

    public static void achatNonPossible() {
        System.out.println(STR."Vous ne pouvez pas acheter de propriété avant d'avoir fait \{Monopoly.NB_TOURS_AVANT_ACHAT} tours");
    }

    public static void joueurDansSaPropriete() {
        System.out.println("Vous êtes sur votre propriété");
    }

    public static void joueurDansProprieteAdverse(Propriete propriete) {
        System.out.println(STR."Vous êtes sur la propriété de \{propriete.getProprietaire().getNom()}");
    }

}
