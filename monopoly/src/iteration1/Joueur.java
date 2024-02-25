package iteration1;

public class Joueur {
    private int position = 0;
    private int nbTour = 0;
    private int nbDouble = 0;
    private boolean enPrison = false;

    public Joueur() {
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nbTour=" + nbTour +
                ", nbDouble=" + nbDouble +
                ", enPrison=" + enPrison +
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
            nbTour++;
            this.position = prochainePosition - taillePlateau;
        } else {
            this.position = prochainePosition;
        }

        return this.position;
    }

    /**
     * Lance les 2 dés. Verifie les doubles.
     * Envoie le joueur en prison s'il a fait 3 doubles
     * @return L'addition des 2 dés
     */
    public int lancerDes() {
        int lancer1 = Monopoly.de1.lancer();
        int lancer2 = Monopoly.de2.lancer();

        // Verification si double
        if (lancer1 == lancer2) {
            // Si 3 double, alors prison
            if (this.nbDouble == 3) { // Integrer variable de config ??
                this.allerEnPrison();
                return -1;
            }
            nbDouble++;
        }

        return lancer1 + lancer2;
    }

    /**
     * Fin de tour, réinitialise les variables. <br>
     * - nbDouble à 0
     */
    public void finDeTour() {
        this.nbDouble = 0;
    }

    /**
     * Envoie le joueur en prison.
     */
    private void allerEnPrison() {
        this.enPrison = true;
        this.position = 30; // TODO: recuperer la case prison.index
        this.finDeTour();
    }

    public int getNbDouble() {
        return nbDouble;
    }

    public int getPosition() {
        return position;
    }

    public int getNbTour() {
        return nbTour;
    }
}
