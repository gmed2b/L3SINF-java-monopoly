package iteration3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Monopoly {

    public final static int NB_TOURS_AVANT_ACHAT = 1;
    private final static int NB_JOUEURS = 2;

    public Plateau plateau;
    public Queue<Carte> cartesCommunaute = new LinkedList<>();
    public Queue<Carte> cartesChance = new LinkedList<>();
    private List<Joueur> joueurs;
    public static De de1;
    public static De de2;

    public Monopoly(String plateauCsv, String cartesCommunauteCsv, String cartesChanceCsv) throws IOException {
        this.plateau = new Plateau(plateauCsv);
        this.cartesCommunaute = initialiserCartes(cartesCommunauteCsv);
        this.cartesChance = initialiserCartes(cartesChanceCsv);
        this.joueurs = new ArrayList<Joueur>();
        Monopoly.de1 = new De();
        Monopoly.de2 = new De();
    }

    public void initialisationPartie() {
        System.out.println("====== Monopoly ======"); // à mettre dans une méthode de la classe Cli

        this.setNbJoueurs(NB_JOUEURS);
        Cli.printInitGameMessage(NB_JOUEURS);

        this.commencerPartie();
    }

    private void commencerPartie() {
        while (this.partieToujoursEnCours()) {
            for (int i = 0; i < joueurs.size(); i++) {
                Joueur joueurActuel = joueurs.get(i);
                this.plateau.afficherPlateau(this.joueurs);

                Cli.printPlayer(joueurActuel);
                Cli.pressToContinue("Appuyez sur Entrée pour lancer les dés ...");

                // 1- Lancer les dés
                int scoreDes = joueurActuel.lancerDes();
                Cli.afficherScoreDes(scoreDes);

                // 2- Bouger le pion
                joueurActuel.seDeplacer(scoreDes, this.plateau.getTaille());

                // 3- Action case
                Case caseActuelle = this.plateau.getCase(joueurActuel.getPosition());
                Cli.afficherCase(caseActuelle);
                caseActuelle.action(joueurActuel, this.plateau);

                // 6- Fin de tour
                Cli.endTurn();
            }
        }

        Cli.pressToContinue("");
    }

    /**
     * Verifie si la partie est toujours en cours.
     * La partie est terminée si tous les terrains sont achetés.
     *
     * @return true si la partie est toujours en cours, false sinon
     */
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

    private void setNbJoueurs(int nbJoueur) {
        for (int i = 0; i < nbJoueur; i++) {
            Joueur joueur = new Joueur();
            this.joueurs.add(joueur);
        }
    }

    static int appliquerEffetCarte(Joueur joueur, String carteTiree) {
        if (carteTiree.contains("Gagnez") || carteTiree.contains("Recevez")) {
            // récupérer le montant (c'est le dernier mot de la phrase)
            int montant = Integer.parseInt(carteTiree.split(" ")[carteTiree.split(" ").length - 1].replace("€", ""));
            return montant;
        } else if (carteTiree.contains("Payez")) {
            int montant = Integer.parseInt(carteTiree.split(" ")[carteTiree.split(" ").length - 1].replace("€", ""));
            return montant;
        } else if (carteTiree.contains("Avancez")) {
            // récupérer le nombre de case (c'est le avant dernier mot de la phrase)
            int nbCases = Integer.parseInt(carteTiree.split(" ")[carteTiree.split(" ").length - 2]);
            return nbCases;
        } else if (carteTiree.contains("Reculez")) {
            int nbCases = Integer.parseInt(carteTiree.split(" ")[carteTiree.split(" ").length - 2]);
            return -nbCases;
        }
        return 0;
    }

    private LinkedList<Carte> initialiserCartes(String csvFilePath) {
        LinkedList<Carte> cartes = new LinkedList<Carte>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String description = fields[0].trim();
                int effet = Integer.parseInt(fields[1].trim());
                TypeCarte type = TypeCarte.valueOf(fields[2].trim());
                cartes.add(new Carte(description, effet, type));
            }
            return cartes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cartes;
    }

}
