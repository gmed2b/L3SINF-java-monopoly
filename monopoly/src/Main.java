import iteration2.Case;
import iteration2.GroupeTerrain;
import iteration2.Terrain;

public class Main {

    public static void main(String[] args) {
        // Monopoly jeu = new Monopoly();
        // jeu.initialisationPartie();

        /**
         * Test de la classe Case
         */
        Case blvrdBelleville = new Terrain("Boulevard de Belleville", 1, GroupeTerrain.MARRON);
        System.out.println(blvrdBelleville);

    }

}
