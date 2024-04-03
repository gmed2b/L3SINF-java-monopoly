package iteration_2;

public class Joueur {

    private static int NB_INSTANCE = 1;

    private String nom;
    private int position;
    private int nbTours;
    private int solde;

    public Joueur(String nom) {
        this.setNom(nom);
        this.setPosition(0);
        this.setNbTours(0);
        this.setSolde(90000);

        NB_INSTANCE++;
    }

    public Joueur() {
        this(STR."Joueur \{NB_INSTANCE}");
    }

    @Override
    public String toString() {
        return STR."\{this.getNom()} { nbTours = \{this.getNbTours()}    solde = \{this.getSolde()} }";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getNbTours() {
        return nbTours;
    }

    public void setNbTours(int nbTours) {
        this.nbTours = nbTours;
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

    public boolean acheterPropriete(Propriete propriete) {
        try {
            this.debiter(propriete.getTarifAchat());
            propriete.setProprietaire(this);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void debiter(int montant) throws Exception {
        int nouveauSolde = this.solde - montant;
        if (nouveauSolde < 0) {
            throw new Exception("Vous n'avez pas assez d'argent pour effectuer cette opération.");
        }
        this.solde = nouveauSolde;
    }

}
