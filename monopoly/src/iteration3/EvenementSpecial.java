package iteration3;

public class EvenementSpecial extends Case {

    public EvenementSpecial(String nom) {
        super(nom);
    }

    @Override
    public void action(Joueur joueur) {

        if (this.getNom().equals("Chance") || this.getNom().equals("Caisse de communauté") ) {
        String card = joueur.tirerCarte(joueur, nom);
        int result = Monopoly.appliquerEffetCarte(joueur, card);
        if (card.contains("Gagnez") || card.contains("Recevez")) {
            joueur.crediter(result);
        } else if (card.contains("Payez")) {
            try {
                joueur.debiter(result);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (card.contains("Avancez")) {
            joueur.seDeplacer(result, Monopoly.plateau.getTaille());
        } else if (card.contains("Reculez")) {
            joueur.seDeplacer(result, Monopoly.plateau.getTaille());
        }
    }
    }
}
