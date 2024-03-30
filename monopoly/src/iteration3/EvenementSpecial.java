package iteration3;

public class EvenementSpecial extends Case {

    public enum TypeEvenement {
        DEPART, VISITE, PRISON, PARC, TAXE,
        IMPOTS, CHANCE, COMMUNAUTE, COMPAGNIE_EAU,
        COMPAGNIE_ELECTRICITE
    }

    public TypeEvenement type;

    public EvenementSpecial(String nom, TypeEvenement type) {
        super(nom);
        this.type = type;
    }

    @Override
    public void action(Joueur joueur, Plateau plateau) {
        if (this.type == TypeEvenement.CHANCE || this.type == TypeEvenement.COMMUNAUTE) {
            Carte carte = this.type == TypeEvenement.CHANCE ? plateau.getCartesChance() : plateau.getCartesCommunaute();
            System.out.println("Carte tirée : " + carte.texte); // à mettre dans le CLI
            if (carte.type == Carte.TypeCarte.GAGNER) {
                joueur.crediter(carte.effet);
                System.out.println("Vous avez gagné " + carte.effet + "€ !"); // à mettre dans le CLI
            } else if (carte.type == Carte.TypeCarte.PAYER) {
                try {
                    joueur.debiter(carte.effet);
                    System.out.println("Vous avez payé " + carte.effet + "€ !"); // à mettre dans le CLI
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (carte.type == Carte.TypeCarte.AVANCER) {
                joueur.seDeplacer(carte.effet, plateau.getTaille());
                System.out.println("Vous avancez de " + carte.effet + " cases !"); // à mettre dans le CLI
                Case caseActuelle = plateau.getCase(joueur.getPosition());
                Cli.afficherCase(caseActuelle);
                caseActuelle.action(joueur, plateau);
            } else if (carte.type == Carte.TypeCarte.RECULER) {
                joueur.seDeplacer(-carte.effet, plateau.getTaille());
                System.out.println("Vous reculez de " + carte.effet + " cases !"); // à mettre dans le CLI
                Case caseActuelle = plateau.getCase(joueur.getPosition());
                Cli.afficherCase(caseActuelle);
                caseActuelle.action(joueur, plateau);
            }
        }

    }
}
