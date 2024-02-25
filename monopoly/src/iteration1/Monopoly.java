package iteration1;
import java.util.ArrayList;
import java.util.List;

public class Monopoly {

    public Plateau plateau;
    public static De de1;
    public static De de2;
    private List<Joueur> joueurs;
    private int nbTours = 0;
    private boolean gagnant = false;

    public Monopoly() {
        this.plateau = new Plateau(40);
        this.de1 = new De();
        this.de2 = new De();
        this.joueurs = new ArrayList<Joueur>();

        this.initialisationPartie();
    }

    public void initialisationPartie() {
        this.setJoueurs(2);
        this.commencerPartie();
    }

    public void commencerPartie() {
        //while (this.gagnant == false) {// fonction qui check a chaque fin de tour si un joueur a bouclé 3 tour
            for (int i = 0; i < joueurs.size(); i++) {
                Joueur joueurActuel = joueurs.get(i);
                System.out.println();
                System.out.println("C'est au tour du joueur " + (i+1));

                // Lancer les dés
                int nbDoubleAvantLancer = joueurActuel.getNbDouble();
                int score = joueurActuel.lancerDes();
                int nbDoubleApresLancer = joueurActuel.getNbDouble();

                // Apres le premier lancé, verifier si joueur obtient double
                while (nbDoubleAvantLancer < nbDoubleApresLancer) {
                    System.out.println("DOUBLE ! Vous pouvez rejouer.");
                    nbDoubleAvantLancer = nbDoubleApresLancer;
                    score = joueurActuel.lancerDes();

                    // Si score == -1, le joueur a fait 3 double -> prison
                    if (score == -1) {
                        System.out.println("Un policier vous a repéré !");
                        System.out.println("Vous êtes envoyé en prison.");
                        continue;
                    }

                    nbDoubleApresLancer = joueurActuel.getNbDouble();
                }
                // move
                // actions (v0, nothing)
            }

        //}
    }

    public void setJoueurs(int nbJoueur) {
        for (int i = 0; i < nbJoueur; i++) {
            Joueur joueur = new Joueur();
            this.joueurs.add(joueur);
        }
    }
}
