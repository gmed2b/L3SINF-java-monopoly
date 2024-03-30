package iteration3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joueur {

    private static int NB_INSTANCE = 1;

    private String nom;
    private int position;
    private int nbTours;
    private int solde;

    public Joueur(String nom) {
        setNom(nom);
        this.position = 0;
        this.nbTours = 0;
        this.solde = 1500; // Initialisation du solde du joueur par défaut

        NB_INSTANCE++;
    }

    public Joueur() {
        this("Joueur " + NB_INSTANCE);
    }

    @Override
    public String toString() {
        return this.getNom() + " {" +
                "nbTours=" + this.getNbTours() +
                ", solde=" + this.getSolde() +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("Le nom du joueur ne peut pas être vide.");
        }
        this.nom = nom;
    }

    public int getPosition() {
        return position;
    }

    public int getNbTours() {
        return nbTours;
    }

    public int getSolde() {
        return solde;
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

    /**
     * Deplace le joueur de nbCases.
     *
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
     *
     * @return L'addition des 2 dés
     */
    public int lancerDes() {
        int lancer1 = Monopoly.de1.lancer();
        int lancer2 = Monopoly.de2.lancer();

        return lancer1 + lancer2;
    }

    public void debiter(int montant) throws Exception {
        int nouveauSolde = this.solde - montant;
        if (nouveauSolde < 0) {
            throw new Exception("Vous n'avez pas assez d'argent pour effectuer cette opération.");
        }
        this.solde = nouveauSolde;
    }

    public void crediter(int montant) {
        this.solde += montant;
    }
}
