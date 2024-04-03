package iteration_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Monopoly {

    private final static int NB_JOUEURS = 2;
    public final static int NB_TOURS_AVANT_ACHAT = 1;

    private Plateau plateau;
    private List<Joueur> joueurs;
    public static De de1;
    public static De de2;

    public Monopoly (String CsvPlateau) throws IOException {
        this.plateau = new Plateau(CsvPlateau);
        this.joueurs = new ArrayList<Joueur>();
        Monopoly.de1 = new De();
        Monopoly.de2 = new De();
    }

    public void initialisationPartie() {
        this.setNbJoueurs(NB_JOUEURS);
        this.commencerPartie();
    }

    private void commencerPartie() {
        while (this.partieToujoursEnCours()) {
            for (Joueur joueurActuel : this.joueurs) {

                plateau.afficherPlateau(this.joueurs);

                System.out.println(joueurActuel);
                Cli.pressToContinue("Appuyez sur Entrée pour lancer les dés ...");

                // Lancer les dés
                int scoreDes = joueurActuel.lancerDes();
                Cli.afficherScoreDes(scoreDes);

                // Bouger le pion
                joueurActuel.seDeplacer(scoreDes, this.plateau.getTaillePlateau());

                plateau.afficherPlateau(this.joueurs);

                // Action case
                Case caseActuelle = this.plateau.getCase(joueurActuel.getPosition());
                Cli.afficherCase(caseActuelle);
                caseActuelle.action(joueurActuel);

                // Fin de tour
                Cli.finDeTour();
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

    /**
     * Verifie si la partie est toujours en cours.
     * La partie est terminée si tous les terrains sont achetés.
     *
     * @return true si la partie est toujours en cours, false sinon
     */
    private boolean partieToujoursEnCours() {
        for (int i = 0; i < this.plateau.getTaillePlateau(); i++) {
            Case c = this.plateau.getCase(i);
            if (c instanceof Propriete) {
                Propriete p = (Propriete) c;
                if (p.getProprietaire() == null) {
                    return true;
                }
            }
        }
        return false;
    }

}
