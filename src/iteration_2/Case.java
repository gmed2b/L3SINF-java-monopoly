package iteration_2;

public abstract class Case {

    public String nom;

    public Case(String nom) {
        this.setNom(nom);
    }

    @Override
    public String toString() {
        return this.getNom().toUpperCase();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom.isEmpty()) {
            throw new IllegalArgumentException("Le nom d'une case ne peut être vide.");
        }
        this.nom = nom;
    }

    public abstract void action(Joueur joueur);
}
