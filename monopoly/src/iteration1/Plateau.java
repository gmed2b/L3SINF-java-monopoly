package iteration1;

import java.util.Arrays;

public class Plateau {
    private int[] cases;

    public Plateau(int nbCases) {
        this.setCases(nbCases);
    }

    @Override
    public String toString() {
        return "Plateau{" +
                "cases=" + Arrays.toString(cases) +
                '}';
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
}
