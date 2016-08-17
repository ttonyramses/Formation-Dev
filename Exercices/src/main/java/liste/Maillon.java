package liste;

public class Maillon  implements Comparable{
	private int donnee;
	private Maillon suivant;
	private Maillon precedent;
	
	// Ajouter un constructeur
	public Maillon(int donnee, Maillon precedent, Maillon suivant){
		this.donnee=donnee;
		this.suivant=suivant;
		this.precedent=precedent;
	}
	
	public Maillon(int donnee, Maillon suivant){
		this.donnee=donnee;
		this.suivant=suivant;
	}
	
	public Maillon getSuivant() {
		return suivant;
	}
	
	public void setSuivant(Maillon suivant) {
		this.suivant = suivant;
		if(suivant!=null) suivant.setPrecedent(this);
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

	@Override
	public int compareTo(Object arg0) {
		
		if( !(arg0 instanceof Maillon)){
			try {
				throw new Exception("Cet Objet n'est pas de type Maillon");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.donnee-((Maillon)arg0).donnee;
	}
	
	@Override
	public Object clone(){
		return new Maillon(donnee, precedent, suivant);
	}
}
