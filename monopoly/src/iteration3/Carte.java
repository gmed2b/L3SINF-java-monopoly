package iteration3;

public class Carte {

    public enum TypeCarte {
        GAGNER,
        PAYER,
        AVANCER,
        RECULER
    }

    String texte;
    Integer effet;
    TypeCarte type;

    public Carte(String texte, Integer effet, TypeCarte type) {
        this.texte = texte;
        this.effet = effet;
        this.type = type;
    }

    /**
     * Applique l'effet de la carte sur le joueur
     *
     * @param joueur
     * @return l'effet de la carte (positif ou négatif)
     */
    // public int actionCarte(Joueur joueur) {
    // switch (this.type) {
    // case GAGNER:
    // joueur.crediter(this.effet);
    // break;
    // case PAYER:
    // try {
    // joueur.debiter(this.effet);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // break;
    // case AVANCER:
    // joueur.seDeplacer(this.effet);
    // break;
    // case RECULER:
    // joueur.seDeplacer(-this.effet);
    // break;
    // }
    // return this.effet;
    // }

    // TODO: ANCIENNE METHODE (A SUPPRIMER)

    // static int appliquerEffetCarte(Joueur joueur, String carteTiree) {
    // if (carteTiree.contains("Gagnez") || carteTiree.contains("Recevez")) {
    // // récupérer le montant (c'est le dernier mot de la phrase)
    // int montant = Integer.parseInt(carteTiree.split(" ")[carteTiree.split("
    // ").length - 1].replace("€", ""));
    // return montant;
    // } else if (carteTiree.contains("Payez")) {
    // int montant = Integer.parseInt(carteTiree.split(" ")[carteTiree.split("
    // ").length - 1].replace("€", ""));
    // return montant;
    // } else if (carteTiree.contains("Avancez")) {
    // // récupérer le nombre de case (c'est le avant dernier mot de la phrase)
    // int nbCases = Integer.parseInt(carteTiree.split(" ")[carteTiree.split("
    // ").length - 2]);
    // return nbCases;
    // } else if (carteTiree.contains("Reculez")) {
    // int nbCases = Integer.parseInt(carteTiree.split(" ")[carteTiree.split("
    // ").length - 2]);
    // return -nbCases;
    // }
    // return 0;
    // }

}
