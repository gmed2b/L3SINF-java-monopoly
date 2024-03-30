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
        Case caseActuelle = plateau.getCase(joueur.getPosition());
        switch (type) {
            case CHANCE:
            case COMMUNAUTE:
                Carte carte = (type == TypeEvenement.CHANCE) ? plateau.getCartesChance()
                        : plateau.getCartesCommunaute();
                Cli.afficherMessageSelonTypeCase(type, carte);
                switch (carte.type) {
                    case GAGNER:
                        joueur.crediter(carte.effet);
                        break;
                    case PAYER:
                        try {
                            joueur.debiter(carte.effet);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case AVANCER:
                        joueur.seDeplacer(carte.effet, plateau.getTaille());
                        Cli.afficherCase(caseActuelle);
                        caseActuelle.action(joueur, plateau);
                        break;
                    case RECULER:
                        joueur.seDeplacer(-carte.effet, plateau.getTaille());
                        Cli.afficherCase(caseActuelle);
                        caseActuelle.action(joueur, plateau);
                        break;
                    default:
                        break;
                }
                break;
            case TAXE:
            case IMPOTS:
                try {
                    joueur.debiter(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Cli.afficherMessageSelonTypeCase(type, null);
                break;
            case PARC:
            case VISITE:
                Cli.afficherMessageSelonTypeCase(type, null);
                break;
            case PRISON:
                Cli.afficherMessageSelonTypeCase(type, null);
                plateau.envoyerEnPrison(joueur);
                break;
            case DEPART:
                Cli.afficherMessageSelonTypeCase(type, null);
                joueur.crediter(200);
                break;
            default:
                break;
        }
    }

}
