package iteration_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Plateau {
    // Codes ANSI pour les couleurs de texte
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String ITALIC = "\u001b[3m";
    public static final String RED = "\u001B[31m";


    private List<Case> cases = new ArrayList<Case>();
    public Queue<Carte> cartesCommunaute = new LinkedList<Carte>();
    public Queue<Carte> cartesChance = new LinkedList<Carte>();

    public Plateau(String CsvPlateau, String CsvCommunaute, String CsvChance) throws IOException {
        this.initialiserPlateau(CsvPlateau);
        this.cartesCommunaute = initialiserCartes(CsvCommunaute);
        this.cartesChance = initialiserCartes(CsvChance);
    }

    public Case getCase(int index) {
        return cases.get(index);
    }

    public int getTaillePlateau() {
        return this.cases.size();
    }

    public Carte getCarteCommunaute() {
        Carte carte = this.cartesCommunaute.poll();
        cartesCommunaute.add(carte);
        return carte;
    }

    public Carte getCarteChance() {
        Carte carte = this.cartesChance.poll();
        cartesChance.add(carte);
        return carte;
    }

    public void afficherPlateau(List<Joueur> joueurs, Joueur joueurActuel) {
        // Plateau
        for (int i = 0; i < this.getTaillePlateau(); i++) {
            System.out.print(STR."\{i} ");
        }
        System.out.println();

        // Joueurs
        for (Joueur joueur : joueurs) {
            // Afficher la position du joueur
            for (int i = 0; i < joueur.getPosition(); i++) {
                System.out.print("  ");
                if (i >= 10) {
                    System.out.print(" ");
                }
            }
            // Affiche le nom du joueur
            if (joueur.equals(joueurActuel)) {
                System.out.println(STR."\{BOLD}\{RED}* \{joueur.getNom()}\{RESET} ");
            } else {
                System.out.println(STR."\{ITALIC}* \{joueur.getNom()}\{RESET} ");
            }
        }
        System.out.println();
    }

    private void initialiserPlateau(String csvFilePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");

                Character type = fields[0].trim().charAt(0); // Type de case
                String nom = fields[1].trim(); // Nom de la case
                int tarifAchat = 0;
                GroupeTerrain groupe = null;
                TypeCaseSpeciale typeCaseSpeciale = null;

                if (fields.length > 2 && !fields[2].trim().equals("null")) {
                    tarifAchat = Integer.parseInt(fields[2].trim()); // Tarif d'achat
                }
                if (fields.length > 3 && !fields[3].trim().equals("null")) {
                    groupe = GroupeTerrain.valueOf(fields[3].trim()); // Groupe de terrain
                }
                if (fields.length > 4 && !fields[4].trim().equals("null")) {
                    typeCaseSpeciale = TypeCaseSpeciale.valueOf(fields[4].trim()); // Type case speciale
                }

                Case nouvelleCase;
                switch (type) {
                    case 'T': // Terrain
                        nouvelleCase = (Terrain) new Terrain(nom, tarifAchat, groupe);
                        break;
                    case 'G': // Gare
                        nouvelleCase = (Gare) new Gare(nom, tarifAchat);
                        break;
                    case 'S': // ServicePublique
                        nouvelleCase = (ServicePublique) new ServicePublique(nom, tarifAchat);
                        break;
                    case 'E': // EvenementSpecial
                        nouvelleCase = (CaseSpeciale) new CaseSpeciale(nom, typeCaseSpeciale);
                        break;
                    default:
                        nouvelleCase = null;
                        break;
                }

                if (nouvelleCase != null) {
                    cases.add(nouvelleCase);
                }
            }
        }
    }

    private LinkedList<Carte> initialiserCartes(String csvFilePath) {
        LinkedList<Carte> cartes = new LinkedList<Carte>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");

                String designation = fields[0].trim();
                TypeCarte type = TypeCarte.valueOf(fields[1].trim());
                int effet = Integer.parseInt(fields[2].trim());

                Carte carte = new Carte(designation, type, effet);
                cartes.add(carte);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return cartes;
    }

}
