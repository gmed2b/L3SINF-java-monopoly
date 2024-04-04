package iteration_3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Monopoly {

    public final static int MONTANT_SOLDE_DEPART = 1500;
    public final static int MONTANT_CASE_DEPART = 200;
    public final static int MONTANT_ARRET_CASE_DEPART = 400;
    public final static int MONTANT_TAXE_LUXE = 100;
    public final static int MONTANT_IMPOTS = 200;
    public final static int NB_TOURS_EN_PRISON = 3;

    private final static int NB_JOUEURS = 4;
    public final static int NB_TOURS_AVANT_ACHAT = 1;

    private Plateau plateau;
    private List<Joueur> joueurs;
    public static De de1;
    public static De de2;

    public Monopoly (String CsvPlateau, String CsvCommunaute, String CsvChance) throws IOException {
        this.plateau = new Plateau(CsvPlateau, CsvCommunaute, CsvChance);
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

                System.out.println(joueurActuel);

                // Verification si le joueur est en prison
                if (joueurActuel.isEnPrison()) {
                    if (joueurActuel.getNbToursEnPrison() < NB_TOURS_EN_PRISON) {
                        joueurActuel.tenterSortirPrison();
                        Cli.finDeTour();
                        continue;
                    } else {
                        joueurActuel.sortirDePrison();
                        Cli.messageSortieDePrison();
                    }
                }

                // Lancer les dés
                Cli.pressToContinue("Appuyez sur Entrée pour lancer les dés ...");
                int scoreDes = joueurActuel.lancerDes();
                Cli.afficherScoreDes(scoreDes);

                // Bouger le pion
                joueurActuel.seDeplacer(scoreDes, this.plateau.getTaillePlateau());

                this.plateau.afficherPlateau(this.joueurs, joueurActuel);

                // Action case
                Case caseActuelle = this.plateau.getCase(joueurActuel.getPosition());
                Cli.afficherCase(caseActuelle);
                caseActuelle.action(joueurActuel, this.plateau);

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
