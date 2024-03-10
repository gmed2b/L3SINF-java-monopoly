package iteration2;

public class Solde {

    private int M1;
    private int M5;
    private int M10;
    private int M20;
    private int M50;
    private int M100;
    private int M500;

    /**
     * Solde par défaut pour un joueur.
     */
    public Solde() {
        this.M1 = 5;
        this.M5 = 1;
        this.M10 = 2;
        this.M20 = 1;
        this.M50 = 1;
        this.M100 = 4;
        this.M500 = 2;
    }

    @Override
    public String toString() {
        return "Solde [ " +
                "$1: " + M1 +
                "   $5: " + M5 +
                "   $10: " + M10 +
                "   $20: " + M20 +
                "   $50: " + M50 +
                "   $100: " + M100 +
                "   $500: " + M500 +
                " ]";
    }

    public int getMX(int x) {
        switch (x) {
            case 1:
                return this.M1;
            case 5:
                return this.M5;
            case 10:
                return this.M10;
            case 20:
                return this.M20;
            case 50:
                return this.M50;
            case 100:
                return this.M100;
            case 500:
                return this.M500;
            default:
                return 0;
        }
    }

    public void setM1(int m1) {
        M1 = m1;
    }

    public void setM5(int m5) {
        M5 = m5;
    }

    public void setM10(int m10) {
        M10 = m10;
    }

    public void setM20(int m20) {
        M20 = m20;
    }

    public void setM50(int m50) {
        M50 = m50;
    }

    public void setM100(int m100) {
        M100 = m100;
    }

    public void setM500(int m500) {
        M500 = m500;
    }

}
