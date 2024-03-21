package iteration2;

public abstract class Case {

    public String nom;

    public Case(String nom) {
        setNom(nom);
    }

    @Override
    public String toString() {
        return nom.toUpperCase();
    }

    public void setNom(String nom) {
        if (nom == null) {
            throw new IllegalArgumentException("Le nom ne peut pas être null");
        }
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public abstract void action(Joueur joueur);

}