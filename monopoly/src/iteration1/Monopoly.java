package iteration1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Monopoly {

    private Plateau plateau;
    private List<Joueur> joueurs;
    public static De de1;
    public static De de2;
    private boolean partieEnCours = false;
    private int nbToursVictorieux = 3;

    public Monopoly() {
        this.plateau = new Plateau();
        this.joueurs = new ArrayList<Joueur>();
        Monopoly.de1 = new De();
        Monopoly.de2 = new De();
    }

    public void initialisationPartie() {
        System.out.println("====== Monopoly ======");
        System.out.println("Initialisation d'une partie avec 2 joueurs ...");
        this.setJoueurs(2);

        System.out.println("Initialisation terminée. La partie peut commencer.");
        this.partieEnCours = true;
        this.commencerPartie();
    }

    private void commencerPartie() {
        while (this.partieEnCours) {
            for (int i = 0; i < joueurs.size(); i++) {

                Joueur joueurActuel = joueurs.get(i);
                this.afficherPlateau();
                System.out.println();

                System.out.println("===== JOUEUR " + (i + 1) + " =====");
                Cli.pressToContinue("Appuyez sur Entrée pour lancer les dés ...");

                // 1- Lancer les dés
                int scoreDes = joueurActuel.lancerDes();
                System.out.println("Vous avez fait " + scoreDes);

                // 2- Bouger le pion
                joueurActuel.seDeplacer(scoreDes, this.plateau.getTaille());

                // 3- Fin de tour
                Cli.pressToContinue("===== FIN DU TOUR =====");

                // Effacer la console pour le prochain joueur
                System.out.print("\033\143");

                // Iteration 1- Verification du gagnant
                if (joueurActuel.getNbTours() == this.nbToursVictorieux) {
                    System.out.println("Félicitation ! Le joueur " + (i + 1) + " à gagné.");
                    this.partieEnCours = false;
                    break;
                }
            }

        }

        Cli.pressToContinue("");
    }

    public void afficherPlateau() {
        // Plateau
        System.out.println(Arrays.toString(this.plateau.getCases()));

        // Joueurs
        for (int i = 0; i < joueurs.size(); i++) {
            System.out.print(" ");
            for (int j = 0; j < joueurs.get(i).getPosition(); j++) {
                System.out.print("   ");
                if (j >= 10) {
                    System.out.print(" ");
                }
            }
            System.out.println("* Joueur " + (i + 1));
        }
    }

    private void setJoueurs(int nbJoueur) {
        for (int i = 0; i < nbJoueur; i++) {
            Joueur joueur = new Joueur();
            this.joueurs.add(joueur);
        }
    }
}
