package chifoumi;

public class Jeu extends JeuUnTour {

	private int scoreAAtteindre;
	public Jeu(String nom1, String nom2,int scoreAAtteindre) {
		super(nom1, nom2);
		this.scoreAAtteindre=scoreAAtteindre;
	}

	public void jouer(){
		boolean fini=false;
		do{
			super.jouer();
			if(j1.getScore()>=scoreAAtteindre||j2.getScore()>=scoreAAtteindre)
				fini=true;

		}while(!fini);
	}

}
