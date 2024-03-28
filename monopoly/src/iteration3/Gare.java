package iteration3;

public class Gare extends Propriete {

    public Gare(String nom, int tarifAchat) {
        super(nom, tarifAchat);
    }

    // @Override
    // public void action(Joueur joueur, Plateau plateau) {
    // if (this.getProprietaire() == null) {
    // boolean joueurVeutAcheter = Cli.acheterPropriete(this);
    // if (!joueurVeutAcheter)
    // return;

    // boolean achatReussi = joueur.acheterPropriete(this);
    // if (!achatReussi)
    // return;

    // Cli.achatReussi(this);

    // } else if (this.getProprietaire() != joueur) {
    // System.out.println("Vous êtes sur la gare de " +
    // this.getProprietaire().getNom());
    // } else {
    // System.out.println("Vous êtes sur votre gare");
    // }
    // }

}
