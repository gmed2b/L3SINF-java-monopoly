package iteration3;

import java.util.Arrays;
import java.util.Scanner;

public class Cli {

    static Scanner reader = new Scanner(System.in);

    public static boolean acheterPropriete(Propriete propriete) {
        String input = prompt(
                "Voulez-vous acheter " + propriete.getNom() + " pour " + propriete.getTarifAchat() + "€ ?");
        return input.toLowerCase().equals("o");
    }

    public static void achatReussi(Propriete propriete) {
        System.out.println("Vous avez acheté " + propriete.getNom() + " !");
    }

    public static void afficherScoreDes(int scoreDes) {
        System.out.println("Vous avez fait " + scoreDes);
        System.out.println();
    }

    public static void afficherCase(Case caseActuelle) {
        System.out.println("Vous êtes sur la case " + caseActuelle.getNom());
    }

    public static void printPlayer(Joueur joueur) {
        System.out.println(joueur);
    }

    public static void endTurn() {
        System.out.println();
        pressToContinue("=== FIN DU TOUR ===");
        // Effacer la console pour le prochain joueur
        System.out.print("\033\143");
    }

    public static void printWinner(Joueur joueur) {
        System.out.println("Le joueur " + joueur + " a gagné la partie !");
    }

    public static void printInitGameMessage(int nbJoueurs) {
        System.out.println("Initialisation d'une partie avec " + nbJoueurs + " joueurs ...");
        System.out.println("Initialisation terminée. La partie peut commencer.");
        System.out.println();
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

    public static void afficherMessageSelonTypeCase(EvenementSpecial.TypeEvenement type, Carte carte) {
        switch (type) {
            case CHANCE:
                System.out.println("Carte tirée : " + carte.texte);
                break;
            case COMMUNAUTE:
                System.out.println("Carte tirée : " + carte.texte);
                break;
            case TAXE:
                System.out.println("Vous avez payé 100€ !");
                break;
            case IMPOTS:
                System.out.println("Vous avez payé 100€ !");
                break;
            case PARC:
                System.out.println("Il n'y a rien à faire ici, au repos !");
                break;
            case VISITE:
                System.out.println("Il n'y a rien à faire ici, au repos !");
                break;
            case PRISON:
                System.out.println(
                        "Attendez, j'vous connais !? Il n'y a pas d'erreur, vous êtes rechercher... Et il est temps de payer pour vos crimes !");
                break;
            case DEPART:
                System.out.println("Tu es sur la case départ, tu gagnes 200€ !");
                break;
            default:
                break;
        }
    }

    public static void afficherMessageSortiePrison() {
        System.out.println("Vous êtes sorti de prison !");
    }

    public static void affichageEncorePrison() {
        System.out.println("Vous êtes encore en prison !");
    }

}
