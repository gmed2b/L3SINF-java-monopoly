package iteration2bisbis;

public class Terrain extends Propriete {

    public GroupeTerrain groupe;

    public Terrain(String nom, int tarifAchat, GroupeTerrain groupe) {
        super(nom, tarifAchat);
        setGroupe(groupe);
    }

    @Override
    public void action(Joueur joueur) {
        // TODO Auto-generated method stub
        System.out.println("action terrain");
    }

    public GroupeTerrain getGroupe() {
        return groupe;
    }

    public void setGroupe(GroupeTerrain groupe) {
        this.groupe = groupe;
    }

}
