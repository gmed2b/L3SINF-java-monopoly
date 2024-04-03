package iteration_3;

public class Carte {

    private String designation;
    private TypeCarte type;
    private int effet;

    public Carte(String designation, TypeCarte type, int effet) {
        setDesignation(designation);
        setType(type);
        setEffet(effet);
    }

    @Override
    public String toString() {
        return STR."Carte{designation='\{designation}\{'\''}, type=\{type}, effet=\{effet}\{'}'}";
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        if (designation.isEmpty()) {
            throw new IllegalArgumentException("La designation de la carte ne peut être vide.");
        }
        this.designation = designation;
    }

    public TypeCarte getType() {
        return type;
    }

    public void setType(TypeCarte type) {
        this.type = type;
    }

    public int getEffet() {
        return effet;
    }

    public void setEffet(int effet) {
        this.effet = effet;
    }

    public void actionCarte(Joueur joueur, Plateau plateau) {
        switch (this.getType()) {
            case GAIN -> {
                joueur.crediter(this.effet);
            }
            case PERTE -> {
                try {
                    joueur.debiter(this.effet);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case MOUVEMENT -> {
                int positionInitiale = joueur.getPosition();
                joueur.seDeplacer(this.effet, plateau.getTaillePlateau());
                int positionFinale = joueur.getPosition();

                // Verifie si le joueur passe par la case depart
                if (positionFinale < positionInitiale) {
                    joueur.crediter(Monopoly.MONTANT_CASE_DEPART);
                }

                // Action nouvelle case
                Case caseActuelle = plateau.getCase(joueur.getPosition());
                Cli.afficherCase(caseActuelle);
                caseActuelle.action(joueur, plateau);
            }
            case DEPLACEMENT -> {
                int positionInitiale = joueur.getPosition();
                joueur.setPosition(this.effet);
                int positionFinale = joueur.getPosition();

                // Verifie si le joueur passe par la case depart
                if (positionFinale < positionInitiale) {
                    joueur.crediter(Monopoly.MONTANT_CASE_DEPART);
                }

                // Action nouvelle case
                Case caseActuelle = plateau.getCase(joueur.getPosition());
                Cli.afficherCase(caseActuelle);
                caseActuelle.action(joueur, plateau);
            }
            case PRISON -> {
                joueur.mettreEnPrison();
                Cli.messageCaseSpeciale(TypeCaseSpeciale.PRISON);
            }
        }
    }
}
