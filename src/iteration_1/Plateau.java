package iteration_1;

import java.util.Arrays;
import java.util.List;

public class Plateau {

    private int[] cases;

    public Plateau(int nbCases) {
        this.setCases(nbCases);
    }

    public Plateau() {
        this(40);
    }

    public int[] getCases() {
        return cases;
    }

    public void setCases(int nbCases) {
        this.cases = new int[nbCases];
        for (int i = 0; i < nbCases; i++) {
            cases[i] = i;
        }
    }

    public int getTaillePlateau() {
        return this.cases.length;
    }

    public void afficherPlateau(List<Joueur> joueurs) {
        // Plateau
        for (int i = 0; i < this.getTaillePlateau(); i++) {
            System.out.print(STR."\{i} ");
        }
        System.out.println();

        // Joueurs
        for (int j = 0; j < joueurs.size(); j++) {
            // Afficher la position du joueur
            for (int i = 0; i < joueurs.get(j).getPosition(); i++) {
                System.out.print("  ");
                if (i >= 10) {
                    System.out.print(" ");
                }
            }
            // Affiche le nom du joueur
            System.out.println(STR."* Joueur \{j + 1}");
        }
        System.out.println();
    }
}
