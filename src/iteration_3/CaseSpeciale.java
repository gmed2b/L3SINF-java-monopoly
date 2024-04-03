package iteration_3;

public class CaseSpeciale extends Case {

    public TypeCaseSpeciale type;

    public CaseSpeciale(String nom, TypeCaseSpeciale type) {
        super(nom);
        setType(type);
    }

    @Override
    public void action(Joueur joueur, Plateau plateau) {
        Cli.messageCaseSpeciale(this.getType());

        switch (this.getType()) {
            case CHANCE, COMMUNAUTE -> {
                Carte carte = joueur.tirerCarte(this.getType(), plateau);
                Cli.afficherMessageCarte(carte);
                carte.actionCarte(joueur, plateau);
            }
            case IMPOTS -> {
                try {
                    joueur.debiter(Monopoly.MONTANT_IMPOTS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case TAXE -> {
                try {
                    joueur.debiter(Monopoly.MONTANT_TAXE_LUXE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case PRISON -> {
                joueur.mettreEnPrison();
            }
            case DEPART -> {
                joueur.crediter(Monopoly.MONTANT_ARRET_CASE_DEPART);
            }
        }
    }

    public TypeCaseSpeciale getType() {
        return type;
    }

    public void setType(TypeCaseSpeciale type) {
        this.type = type;
    }
}
