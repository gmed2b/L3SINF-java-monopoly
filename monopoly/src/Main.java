import java.io.IOException;

import iteration3.Monopoly;

public class Main {

    public static void main(String[] args) {
        String csvFilePath = "monopoly/src/plateau.csv";
        String cartesCaisseCommunaute = "monopoly/src/cartesCaisseCommunaute.csv";
        String cartesChance = "monopoly/src/cartesChance.csv";
        try {
            Monopoly jeu = new Monopoly(csvFilePath, cartesCaisseCommunaute, cartesChance);
            jeu.initialisationPartie();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier CSV");
            e.printStackTrace();
        }
    }

}
