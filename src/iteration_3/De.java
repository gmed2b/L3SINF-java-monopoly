package iteration_3;

import java.util.Random;

public class De {

    public static final int NB_FACES_MIN = 3;
    public static final int NB_FACES_MAX = 120;
    public final static int NB_FACES_DEFAUT = 6;
    private static final Random randomizer = new Random();

    private int nbFaces;

    /**
     * Constructs a die with the specified number of faces.
     *
     * @param nbFaces the number of faces on the dice
     */
    public De(int nbFaces) {
        this.setNbFaces(nbFaces);
    }

    /**
     * Constructs a die with a default number of faces.
     */
    public De() {
        this(NB_FACES_DEFAUT);
    }

    @Override
    public String toString() {
        return STR."De{nbFaces=\{nbFaces} }";
    }

    /**
     * Returns the number of faces on this dice.
     *
     * @return the number of faces on this dice
     */
    public int getNbFaces() {
        return this.nbFaces;
    }

    /**
     * Sets the number of faces on this dice, if it is within the valid range.
     *
     * @param nbFaces the number of faces to set
     */
    public void setNbFaces(int nbFaces) {
        if (nbFaces >= NB_FACES_MIN && nbFaces <= NB_FACES_MAX) {
            this.nbFaces = nbFaces;
        } else {
            this.nbFaces = NB_FACES_DEFAUT;
            System.err.println(STR."(\{this}) Le nombre de faces doit être compris entre 3 et 120");
        }
    }

    /**
     * Rolls the dice and returns the result.
     *
     * @return a random number between 1 and the number of faces on this dice
     */
    public int lancer() {
        return randomizer.nextInt(1, this.nbFaces + 1);
    }

}
