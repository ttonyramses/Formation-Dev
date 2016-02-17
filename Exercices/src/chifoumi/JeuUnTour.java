package chifoumi;

public class JeuUnTour {
	
	protected Joueur j1, j2;
	
	final int NBCHOIX=3;
	
	
	public JeuUnTour(String nom1, String nom2){
		j1=new Joueur(nom1);
		j2=new Joueur(nom2);
	}
	
	public void jouer(){
		
		tour();
		j1.ecrireScore();
		j2.ecrireScore();
		conclure();
	}
	
	private void tour(){
		Choix[] choixJoueur1=new Choix[NBCHOIX];
		Choix[] choixJoueur2=new Choix[NBCHOIX];
		
		choisir(j1,choixJoueur1);
		choisir(j2,choixJoueur2);
		
		for(int i=0; i<NBCHOIX;i++){
			if(compare(choixJoueur1[i],choixJoueur2[i])){
				j1.crediter();
			}
			if(compare(choixJoueur2[i],choixJoueur1[i])){
				j2.crediter();
			}
		}
		
	}
	
	
	private void conclure(){
		if(j1.getScore()==j2.getScore()){
			System.out.println("Egalité");
		}else if(j1.getScore()>j2.getScore()){
			System.out.println(j1.getNom()+" est le vainqueur");
		}else{
			System.out.println(j2.getNom()+" est le vainqueur");
		}
	}
	
	private void choisir(Joueur j,Choix[] choix){
		for(int i=0; i<choix.length;i++){
			choix[i]=j.choisir();
		}
	}
	
	private boolean compare(Choix c1, Choix c2){
		
		return ((c1==Choix.CAILLOU && c2==Choix.CISEAU) ||(c1==Choix.CISEAU && c2==Choix.PAPIER)||(c1==Choix.PAPIER && c2==Choix.CAILLOU));
		
	}

}
