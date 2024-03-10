package iteration2;

import java.util.Random;

/**
 * The {@code De} class represents a dice with a specified number of faces.
 * Each dice has a name and can be rolled to produce a random number between 1
 * and the number of faces.
 */
public class De {
    public static final int NB_FACES_MIN = 3;
    public static final int NB_FACES_MAX = 120;
    public static final int NB_FACES_DEFAUT = 6;
    public static final int BORNE_MIN_DEFAUT = 1;
    private static final Random nbRandom = new Random();
    private int nbFaces;

    /**
     * Constructs a dice with the specified number of faces.
     *
     * @param nbFaces the number of faces on the dice
     */
    public De(int nbFaces) {
        this.setNbFaces(nbFaces);
    }

    /**
     * Constructs a dice with a default number of faces.
     */
    public De() {
        this(NB_FACES_DEFAUT);
    }

    /**
     * Returns a string representation of the dice.
     *
     * @return a string representing the name and number of faces of the dice
     */
    @Override
    public String toString() {
        return "Faces: " + this.getNbFaces();
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
            System.err.println("(" + this + ") Le nombre de faces doit être compris entre 3 et 120");
        }
    }

    /**
     * Rolls the dice and returns the result.
     *
     * @return a random number between 1 and the number of faces on this dice
     */
    public int lancer() {
        return nbRandom.nextInt(BORNE_MIN_DEFAUT, this.nbFaces + 1);
    }
}
