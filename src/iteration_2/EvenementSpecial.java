package iteration_2;

public class EvenementSpecial extends Case {

    public EvenementSpecial(String nom) {
        super(nom);
    }

    @Override
    public void action(Joueur joueur) {
        System.out.println("action speciale");
    }
}
