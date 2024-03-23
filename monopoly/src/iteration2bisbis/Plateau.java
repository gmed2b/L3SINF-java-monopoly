package iteration2bisbis;

public class Plateau {

    private Case[] cases = new Case[40];

    public Plateau() {
    }

    public int getTaille() {
        return this.cases.length;
    }

    public int[] getCasesIndexees() {
        int[] p = new int[40];
        for (int i = 0; i < 40; i++) {
            p[i] = i;
        }
        return p;
    }

    public Case getCase(int position) {
        return this.cases[position];
    }

}
