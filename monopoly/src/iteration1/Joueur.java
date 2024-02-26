package iteration1;

public class Joueur {
    private int position = 0;
    private int nbTours = 0;

    public Joueur() {
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nbTour=" + nbTours +
                '}';
    }

    /**
     * Deplace le joueur de nbCases.
     * @param nbCases
     * @param taillePlateau
     * @return La position du joueur après déplacement
     */
    public int seDeplacer(int nbCases, int taillePlateau) {
        int prochainePosition = this.position + nbCases;

        // Passe par la case départ
        if (prochainePosition >= taillePlateau) {
            nbTours++;
            this.position = prochainePosition - taillePlateau;
        } else {
            this.position = prochainePosition;
        }

        return this.position;
    }

    /**
     * Lance les 2 dés.
     * @return L'addition des 2 dés
     */
    public int lancerDes() {
        int lancer1 = Monopoly.de1.lancer();
        int lancer2 = Monopoly.de2.lancer();

        return lancer1 + lancer2;
    }

    public int getPosition() {
        return position;
    }

    public int getNbTours() {
        return nbTours;
    }
}
