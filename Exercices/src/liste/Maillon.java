package liste;

public class Maillon  {
	private int donnee;
	private Maillon suivant;
	private Maillon precedent;
	
	// Ajouter un constructeur
	public Maillon(int donne, Maillon precedent, Maillon suivant){
		this.donnee=donne;
		this.suivant=suivant;
		this.precedent=precedent;
	}
	
	public Maillon getSuivant() {
		return suivant;
	}
	public void setSuivant(Maillon suivant) {
		this.suivant = suivant;
	}
	
	public Maillon getPrecedent(){
		return precedent;
	}
	
	public void setPrecedent(Maillon precedent){
		this.precedent=precedent;
	}
	
	public int getDonnee() {
		return donnee;
	}
	public void setDonnee(int donnee) {
		this.donnee = donnee;
	}
}
