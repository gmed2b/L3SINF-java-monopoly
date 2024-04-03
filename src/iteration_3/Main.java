package iteration_3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String CsvPlateau = "src/iteration_3/plateaux/classique.csv";
        String CsvCommunaute = "src/iteration_3/cartes/communautes.csv";
        String CsvChances = "src/iteration_3/cartes/chances.csv";

        Monopoly jeu = new Monopoly(CsvPlateau, CsvCommunaute, CsvChances);
        jeu.initialisationPartie();
    }
}

