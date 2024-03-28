import java.io.IOException;

import iteration3.Monopoly;

public class Main {

    public static void main(String[] args) {
        String csvFilePath = "monopoly/src/plateau.csv";

        try {
            Monopoly jeu = new Monopoly(csvFilePath);
            jeu.initialisationPartie();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier CSV");
            e.printStackTrace();
        }
    }

}
