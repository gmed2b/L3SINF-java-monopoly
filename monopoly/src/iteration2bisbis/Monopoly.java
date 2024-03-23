package iteration2bisbis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Monopoly {

    private final static int NB_TOURS_AVANT_ACHAT = 1;

    private Plateau plateau;
    private List<Joueur> joueurs;
    public static De de1;
    public static De de2;

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
        System.out.println();

        this.commencerPartie();
    }

    private void commencerPartie() {
        while (this.partieToujoursEnCours()) {
            for (int i = 0; i < joueurs.size(); i++) {

                Joueur joueurActuel = joueurs.get(i);
                this.afficherPlateau();
                System.out.println();

                System.out.println("===== " + joueurActuel.getNom() + " =====");
                System.out.println("Solde: " + joueurActuel.getSolde() + "€");
                System.out.println();

                Cli.pressToContinue("Appuyez sur Entrée pour lancer les dés ...");

                // 1- Lancer les dés
                int scoreDes = joueurActuel.lancerDes();
                System.out.println("Vous avez fait " + scoreDes);
                System.out.println();

                // 2- Bouger le pion
                joueurActuel.seDeplacer(scoreDes, this.plateau.getTaille());

                // 3- Action case
                Case caseActuelle = this.plateau.getCase(joueurActuel.getPosition());
                System.out.println("Vous êtes sur la case " + caseActuelle.getNom());

                if (caseActuelle instanceof Propriete) {
                    Propriete propriete = (Propriete) caseActuelle;

                    if (joueurActuel.getNbTours() >= NB_TOURS_AVANT_ACHAT) {
                        if (propriete.getProprietaire() == null) {
                            String reponse = Cli
                                    .prompt("Voulez-vous acheter cette propriété pour " + propriete.getTarifAchat()
                                            + "€ ?");
                            if (reponse.equals("o")) {
                                joueurActuel.acheterPropriete(propriete);
                                System.out.println("Vous avez acheté " + propriete.getNom());
                                System.out.println("Votre solde est maintenant de " + joueurActuel.getSolde() + "€");
                            }
                        } else if (propriete.getProprietaire() != joueurActuel) {
                            System.out.println("La propriété appartient à " + propriete.getProprietaire().getNom());
                        } else {
                            System.out.println("Vous êtes sur votre propriété.");
                        }
                    } else {
                        System.out.println("Vous ne pouvez pas acheter cette propriété pour le moment.");
                    }
                }

                // 6- Fin de tour
                System.out.println();
                Cli.pressToContinue("=== FIN DU TOUR ===");
                // Effacer la console pour le prochain joueur
                System.out.print("\033\143");

            }

        }

        Cli.pressToContinue("");
    }

    private boolean partieToujoursEnCours() {
        for (int i = 0; i < this.plateau.getTaille(); i++) {
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

    public void afficherPlateau() {
        // Plateau
        System.out.println(Arrays.toString(this.plateau.getCasesIndexees()));

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
