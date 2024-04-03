package iteration_2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String CsvPlateau = "src/iteration_2/plateaux/classique.csv";

        Monopoly jeu = new Monopoly(CsvPlateau);
        jeu.initialisationPartie();
    }
}

