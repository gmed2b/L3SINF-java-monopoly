package iteration_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private List<Case> cases = new ArrayList<Case>();

    public Plateau(String CsvPlateau) throws IOException {
        this.initialiserPlateau(CsvPlateau);
    }

    public Case getCase(int index) {
        return cases.get(index);
    }

    public int getTaillePlateau() {
        return this.cases.size();
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

    private void initialiserPlateau(String csvFilePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                Character type = fields[0].charAt(0); // Type de case
                String nom = fields[1].trim(); // Nom de la case
                int tarifAchat = 0;
                GroupeTerrain groupe = null;

                if (fields.length > 2 && !fields[2].trim().equals("null")) {
                    tarifAchat = Integer.parseInt(fields[2].trim()); // Tarif d'achat
                }
                if (fields.length > 3 && !fields[3].trim().equals("null")) {
                    groupe = GroupeTerrain.valueOf(fields[3].trim()); // Groupe de terrain
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
                        nouvelleCase = (EvenementSpecial) new EvenementSpecial(nom);
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

}
