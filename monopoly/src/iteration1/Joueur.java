package iteration1;

public class Joueur {
    private int position = 0;
    private int nbTour = 0;
    private int nbDouble = 0;
    private boolean enPrison = false;

    public Joueur() {
    }

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

    public void finDeTour() {
        this.nbDouble = 0;
    }

    private void allerEnPrison() {
        this.enPrison = true;
        this.position = 30; // TODO: recuperer la case prison.index
        this.nbDouble = 0;
    }

    public int getNbDouble() {
        return nbDouble;
    }
}
