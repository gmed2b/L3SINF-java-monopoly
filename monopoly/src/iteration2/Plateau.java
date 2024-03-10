package iteration2;

public class Plateau {

    private int[] cases;

    public Plateau(int nbCases) {
        this.setCases(nbCases);
    }

    public Plateau() {
        this(40);
    }

    public int[] getCases() {
        return cases;
    }

    public void setCases(int nbCases) {
        this.cases = new int[nbCases];
        for (int i = 0; i < nbCases; i++) {
            cases[i] = i;
        }
    }

    public int getTaille() {
        return this.cases.length;
    }

}
