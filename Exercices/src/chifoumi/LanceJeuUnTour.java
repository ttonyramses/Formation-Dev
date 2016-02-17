package chifoumi;

public class LanceJeuUnTour {

	public static void main(String[] args) {
		//new JeuUnTour(args[0], args[1]).jouer();
		new Jeu(args[0], args[1], Integer.parseInt(args[2])).jouer();
		System.exit(0);

	}

}
