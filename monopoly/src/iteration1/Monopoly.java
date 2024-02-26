package iteration1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Monopoly {

    public Plateau plateau;
    public static De de1;
    public static De de2;
    private List<Joueur> joueurs;
    private boolean partieEnCours = false;

    public Monopoly() {
        this.plateau = new Plateau();
        this.de1 = new De();
        this.de2 = new De();
        this.joueurs = new ArrayList<Joueur>();

        this.initialisationPartie();
    }

    public void initialisationPartie() {
        System.out.println("====== Monopoly ======");
        System.out.println("Initialisation d'une partie avec 2 joueurs ...");
        this.setJoueurs(2);

        System.out.println("Initialisation terminée. La partie peut commencer.");
        this.partieEnCours = true;
        this.commencerPartie();
    }

    public void commencerPartie() {
        while (this.partieEnCours) {// fonction qui check a chaque fin de tour si un joueur a bouclé 3 tour
            for (int i = 0; i < joueurs.size(); i++) {

                Joueur joueurActuel = joueurs.get(i);
                this.afficherPlateau();
                System.out.println("--> C'est au tour du joueur " + (i+1));
                System.out.println(joueurActuel);
                Cli.pressToContinue("");

                // 1- Lancer les dés
                int scoreDes = joueurActuel.lancerDes();
                System.out.println("Vous avez fait " + scoreDes);

                // 2- Bouger le pion
                int nouvellePosition = joueurActuel.seDeplacer(scoreDes, this.plateau.getTaille());

                // 3- Action case
                // 4- Passé par la case depart
                // 5- Double, relancer

                // 6- Fin de tour
                System.out.println("===== FIN DU TOUR =====");
                System.out.println();

                // Iteration 1- Verification du gagnant
                if (joueurActuel.getNbTours() == 3) {
                    System.out.println("Félicitation ! Le joueur " + (i+1) + " à gagné.");
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
            System.out.println("* Joueur " + (i+1));
        }
    }

    public void setJoueurs(int nbJoueur) {
        for (int i = 0; i < nbJoueur; i++) {
            Joueur joueur = new Joueur();
            this.joueurs.add(joueur);
        }
    }
}
