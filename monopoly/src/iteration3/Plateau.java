package iteration3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import iteration3.Carte.TypeCarte;

public class Plateau {

    // Codes ANSI pour les couleurs de texte
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";

    private List<Case> cases = new ArrayList<Case>();
    public Queue<Carte> cartesCommunaute = new LinkedList<>();
    public Queue<Carte> cartesChance = new LinkedList<>();

    public Plateau(String csvFilePath, String cartesCommunauteCsv, String cartesChanceCsv) throws IOException {
        this.initialiserPlateau(csvFilePath);
        this.cartesCommunaute = initialiserCartes(cartesCommunauteCsv);
        this.cartesChance = initialiserCartes(cartesChanceCsv);
    }

    public int getTaille() {
        return this.cases.size();
    }

    public Case getCase(int position) {
        return this.cases.get(position);
    }

    public void afficherPlateau(List<Joueur> joueurs) {
        // Plateau
        for (int i = 0; i < this.getTaille(); i++) {
            String couleur = getColorForCase(this.cases.get(i));
            System.out.print(BOLD + couleur + i + RESET + " ");
        }
        System.out.println();

        // Joueurs
        for (int i = 0; i < joueurs.size(); i++) {
            for (int j = 0; j < joueurs.get(i).getPosition(); j++) {
                System.out.print("  ");
                if (j >= 10) {
                    System.out.print(" ");
                }
            }
            System.out.println("* Joueur " + (i + 1));
        }
        System.out.println();
    }

    private String getColorForCase(Case c) {
        if (c instanceof Terrain) {
            // Colorer les terrains en vert
            return BLUE;
        } else if (c instanceof Gare) {
            // Colorer les gares en jaune
            return YELLOW;
        } else if (c instanceof ServicePublique) {
            // Colorer les services publics en cyan
            return PURPLE;
        } else if (c instanceof EvenementSpecial) {
            // Colorer les événements spéciaux en rouge
            return RED;
        } else {
            // Utiliser la couleur par défaut
            return RESET;
        }
    }

    private void initialiserPlateau(String csvFilePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                Character type = fields[0].charAt(0); // Type de case
                String nom = fields[1].trim(); // Nom de la case
                int tarifAchat = 0;
                GroupeTerrain groupe = null;
                EvenementSpecial.TypeEvenement typeEvenement = null;

                if (fields.length > 2 && !fields[2].trim().equals("null")) {
                    tarifAchat = Integer.parseInt(fields[2].trim()); // Tarif d'achat
                }
                if (fields.length > 3 && !fields[3].trim().equals("null")) {
                    groupe = GroupeTerrain.valueOf(fields[3].trim()); // Groupe de terrain
                }
                if (fields.length > 4 && !fields[4].trim().equals("null")) {
                    typeEvenement = EvenementSpecial.TypeEvenement.valueOf(fields[4].trim()); // Type d'événement
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
                        nouvelleCase = (EvenementSpecial) new EvenementSpecial(nom, typeEvenement);
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

    public Carte getCartesCommunaute() {
        Carte carte = cartesCommunaute.poll();
        cartesCommunaute.add(carte);
        return carte;
    }

    public Carte getCartesChance() {
        Carte carte = cartesChance.poll();
        cartesChance.add(carte);
        return carte;
    }

}
