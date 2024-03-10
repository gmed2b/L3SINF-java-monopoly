package iteration2;

public abstract class Case {

    String nom;
    int position;

    public Case(String nom, int position) {
        this.nom = nom;
        this.position = position;
    }

    public String getNom() {
        return nom;
    }

    public int getPosition() {
        return position;
    }

    public abstract void action(Joueur joueur);

}