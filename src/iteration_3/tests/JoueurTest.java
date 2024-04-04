package iteration_3.tests;

import iteration_3.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {
    Joueur med = new Joueur("Medjourney");
    Joueur anto = new Joueur("Antocreadev");

    @org.junit.jupiter.api.Test
    void seDeplacer() {
        // Préparation
        med.setPosition(10);

        // Execution
        int nouvellePosition = med.seDeplacer(7, 40);

        // Vérification
        assertEquals(17, nouvellePosition); // Initial 10 + deplacement 7 = 17
    }

    @org.junit.jupiter.api.Test
    void seDeplacerParCaseDepart() {
        // Préparation
        anto.setPosition(37);
        anto.setSolde(1500);
        int soldeInitial = anto.getSolde();
        int nbToursInitial = anto.getNbTours();

        // Exécution
        int nouvellePosition = anto.seDeplacer(11, 40);

        // Vérification
        assertEquals(8, nouvellePosition); // Initial 37 + deplacement 11 = 8

        // Passage par la case depart +200€
        Assertions.assertEquals(soldeInitial + Monopoly.MONTANT_CASE_DEPART, anto.getSolde());

        // Incrementation du nombre de tours
        assertEquals(nbToursInitial + 1, anto.getNbTours());
    }

    @org.junit.jupiter.api.Test
    void acheterPropriete() {
        // Préparation
        Terrain propriete = new Terrain("Rue de la paix", 200, GroupeTerrain.BLEU);

        // Exécution
        boolean aAchete = anto.acheterPropriete(propriete);

        // Vérification
        assertTrue(aAchete);
        assertEquals(anto, propriete.getProprietaire());
        assertEquals(anto.getSolde(), Monopoly.MONTANT_SOLDE_DEPART - 200);
    }

    @org.junit.jupiter.api.Test
    void debiter() throws Exception {
        // Préparation
        med.setSolde(500);

        // Exécution
        med.debiter(200);

        // Vérification
        assertEquals(300, med.getSolde());
    }

    @org.junit.jupiter.api.Test
    void debiterFail() {
        // Préparation
        anto.setSolde(100);

        // Exécution
        // Vérification
        assertThrows(Exception.class, () -> anto.debiter(300));
    }

    @org.junit.jupiter.api.Test
    void crediter() {
        // Préparation
        anto.setSolde(100);

        // Exécution
        anto.crediter(300);

        // Vérification
        assertEquals(400, anto.getSolde());
    }

    @org.junit.jupiter.api.Test
    void tenterSortirPrisonSuccess() {
        // Préparation
        anto.mettreEnPrison();

        // Configuration du mock pour simuler un lancer de dés avec un double de 3
        Mockito.when(Monopoly.de1.lancer()).thenReturn(3);
        Mockito.when(Monopoly.de2.lancer()).thenReturn(3);

        // Exécution
        anto.tenterSortirPrison();

        // Vérification
        assertFalse(anto.isEnPrison());
    }

    @org.junit.jupiter.api.Test
    void tenterSortirPrisonEchec() {
        // Préparation
        med.mettreEnPrison();

        Monopoly.de1 = Mockito.mock(De.class);
        Monopoly.de2 = Mockito.mock(De.class);

        // Configuration du mock pour simuler un lancer de dés avec un double de 3
        Mockito.when(Monopoly.de1.lancer()).thenReturn(2);
        Mockito.when(Monopoly.de2.lancer()).thenReturn(5);

        // Exécution
        med.tenterSortirPrison();

        // Vérification
        assertTrue(med.isEnPrison());
    }
}
