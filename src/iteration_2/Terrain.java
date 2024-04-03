package iteration_2;

public class Terrain extends Propriete {

    public GroupeTerrain groupe;

    public Terrain(String nom, int tarifAchat, GroupeTerrain groupe) {
        super(nom, tarifAchat);
        setGroupe(groupe);
    }

    @Override
    public String toString() {
        return STR."\{this.getNom().toUpperCase()} {tarifAchat=\{this.getTarifAchat()}, proprietaire=\{this.getProprietaire()}, groupe=\{this.getGroupe()} }";
    }

    public GroupeTerrain getGroupe() {
        return groupe;
    }

    public void setGroupe(GroupeTerrain groupe) {
        this.groupe = groupe;
    }
}
