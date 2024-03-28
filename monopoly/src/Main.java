import java.io.IOException;

import iteration3.Monopoly;

public class Main {

    public static void main(String[] args) {

        String plateauCsv = "monopoly/src/plateau.csv";
        String cartesCommunauteCsv = "monopoly/src/cartesCaisseCommunaute.csv";
        String cartesChanceCsv = "monopoly/src/cartesChance.csv";

        try {
            Monopoly jeu = new Monopoly(plateauCsv, cartesCommunauteCsv, cartesChanceCsv);
            jeu.initialisationPartie();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier CSV");
            e.printStackTrace();
        }
    }

}
