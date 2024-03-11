package iteration2;

public class Plateau {

    private Case[] cases = new Case[40];

    public Plateau() {
        this.chargerCases();
    }

    public int getTaille() {
        return this.cases.length;
    }

    public int[] getCases() {
        int[] p = new int[40];
        for (int i = 0; i < 40; i++) {
            p[i] = i;
        }
        return p;
    }

    public Case getCase(int position) {
        return this.cases[position];
    }

    private void chargerCases() {

        this.cases[0] = new Case("Départ") {
            public void action(Joueur joueur) {
                System.out.println("Case départ ! Vous gagnez 200€");
            }
        };

        this.cases[1] = new Propriete("Boulevard de Belleville", 60, GroupePropriete.MARRON) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[2] = new Case("Caisse de communauté") {
            public void action(Joueur joueur) {
                System.out.println("Caisse de communauté ! Tirer une carte");
            }
        };

        this.cases[3] = new Propriete("Rue Lecourbe", 60, GroupePropriete.MARRON) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[4] = new Case("Impôts sur le revenu") {
            public void action(Joueur joueur) {
                System.out.println("Impôts sur le revenu ! Vous perdez 200€");
            }
        };

        this.cases[5] = new Propriete("Gare Montparnasse", 200, GroupePropriete.GARE) {
            public void action(Joueur joueur) {
                System.out.println("Case gare !");
            }
        };

        this.cases[6] = new Propriete("Rue de Vaugirard", 100, GroupePropriete.BLEU_CIEL) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[7] = new Case("Chance") {
            public void action(Joueur joueur) {
                System.out.println("Chance ! Tirer une carte");
            }
        };

        this.cases[8] = new Propriete("Rue de Courcelles", 100, GroupePropriete.BLEU_CIEL) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[9] = new Propriete("Avenue de la République", 120, GroupePropriete.BLEU_CIEL) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[10] = new Case("Simple visite") {
            public void action(Joueur joueur) {
                System.out.println("Simple visite en prison");
            }
        };

        this.cases[11] = new Propriete("Boulevard de la Villette", 140, GroupePropriete.ROSE) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[12] = new Propriete("Compagnie d'électricité", 150, GroupePropriete.COMPAGNIE_ELECTRIQUE) {
            public void action(Joueur joueur) {
                System.out.println("Case compagnie !");
            }
        };

        this.cases[13] = new Propriete("Avenue de Neuilly", 140, GroupePropriete.ROSE) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[14] = new Propriete("Rue de Paradis", 160, GroupePropriete.ROSE) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[15] = new Propriete("Gare de Lyon", 200, GroupePropriete.GARE) {
            public void action(Joueur joueur) {
                System.out.println("Case gare !");
            }
        };

        this.cases[16] = new Propriete("Avenue Mozart", 180, GroupePropriete.ORANGE) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[17] = new Case("Caisse de communauté") {
            public void action(Joueur joueur) {
                System.out.println("Caisse de communauté ! Tirer une carte");
            }
        };

        this.cases[18] = new Propriete("Boulevard Saint-Michel", 180, GroupePropriete.ORANGE) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[19] = new Propriete("Place Pigalle", 200, GroupePropriete.ORANGE) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[20] = new Case("Parc gratuit") {
            public void action(Joueur joueur) {
                System.out.println("Parc gratuit");
            }
        };

        this.cases[21] = new Propriete("Avenue Matignon", 220, GroupePropriete.ROUGE) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[22] = new Case("Chance") {
            public void action(Joueur joueur) {
                System.out.println("Chance ! Tirer une carte");
            }
        };

        this.cases[23] = new Propriete("Boulevard Malesherbes", 220, GroupePropriete.ROUGE) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[24] = new Propriete("Avenue Henri-Martin", 240, GroupePropriete.ROUGE) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[25] = new Propriete("Gare du Nord", 200, GroupePropriete.GARE) {
            public void action(Joueur joueur) {
                System.out.println("Case gare !");
            }
        };

        this.cases[26] = new Propriete("Faubourg Saint-Honoré", 260, GroupePropriete.JAUNE) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[27] = new Propriete("Place de la Bourse", 260, GroupePropriete.JAUNE) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[28] = new Propriete("Compagnie des eaux", 150, GroupePropriete.COMPAGNIE_EAUX) {
            public void action(Joueur joueur) {
                System.out.println("Case compagnie !");
            }
        };

        this.cases[29] = new Propriete("Rue La Fayette", 280, GroupePropriete.JAUNE) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[30] = new Case("Allez en prison") {
            public void action(Joueur joueur) {
                System.out.println("Allez en prison");
            }
        };

        this.cases[31] = new Propriete("Avenue de Breteuil", 300, GroupePropriete.VERT) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[32] = new Propriete("Avenue Foch", 300, GroupePropriete.VERT) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[33] = new Case("Caisse de communauté") {
            public void action(Joueur joueur) {
                System.out.println("Caisse de communauté ! Tirer une carte");
            }
        };

        this.cases[34] = new Propriete("Boulevard des Capucines", 320, GroupePropriete.VERT) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[35] = new Propriete("Gare Saint-Lazare", 200, GroupePropriete.GARE) {
            public void action(Joueur joueur) {
                System.out.println("Case gare !");
            }
        };

        this.cases[36] = new Case("Chance") {
            public void action(Joueur joueur) {
                System.out.println("Chance ! Tirer une carte");
            }
        };

        this.cases[37] = new Propriete("Avenue des Champs-Élysées", 350, GroupePropriete.BLEU) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

        this.cases[38] = new Case("Taxe de luxe") {
            public void action(Joueur joueur) {
                System.out.println("Taxe de luxe ! Vous perdez 100€");
            }
        };

        this.cases[39] = new Propriete("Rue de la Paix", 400, GroupePropriete.BLEU) {
            public void action(Joueur joueur) {
                System.out.println("Case propriété !");
            }
        };

    }

}
