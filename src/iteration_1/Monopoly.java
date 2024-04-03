package iteration_1;

import java.util.ArrayList;
import java.util.List;

public class Monopoly {

    private final static int NB_JOUEURS = 2;
    public final static int NB_TOURS_VICTORIEUX = 2;

    private Plateau plateau;
    private List<Joueur> joueurs;
    public static De de1;
    public static De de2;
    private boolean partieEnCours;

    public Monopoly () {
        this.plateau = new Plateau();
        this.joueurs = new ArrayList<Joueur>();
        Monopoly.de1 = new De();
        Monopoly.de2 = new De();
        this.partieEnCours = true;
    }

    public void initialisationPartie() {
        this.setNbJoueurs(NB_JOUEURS);

        this.commencerPartie();
    }

    private void commencerPartie() {
        while (this.partieEnCours) {
            for (int i = 0; i < joueurs.size(); i++) {

                Joueur joueurActuel = joueurs.get(i);
                plateau.afficherPlateau(this.joueurs);

                System.out.println(joueurActuel);
                Cli.pressToContinue("Appuyez sur Entrée pour lancer les dés ...");

                // 1- Lancer les dés
                int scoreDes = joueurActuel.lancerDes();
                Cli.afficherScoreDes(scoreDes);

                // 2- Bouger le pion
                joueurActuel.seDeplacer(scoreDes, this.plateau.getTaillePlateau());

                plateau.afficherPlateau(this.joueurs);

                // 3- Fin de tour
                Cli.finDeTour();

                // Iteration 1- Verification du gagnant
                if (joueurActuel.getNbTours() == NB_TOURS_VICTORIEUX) {
                    Cli.afficherJoueurGagnant(joueurActuel);
                    this.partieEnCours = false;
                    break;
                }
            }

        }

        Cli.pressToContinue("");
    }

    private void setNbJoueurs(int nbJoueur) {
        for (int i = 0; i < nbJoueur; i++) {
            Joueur joueur = new Joueur();
            this.joueurs.add(joueur);
        }
    }
}
