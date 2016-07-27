package fr.afcepf.al28.tp6;

public class Employe extends Personne{

	private double salaire;
	
	public Employe() {
		super();
	}

	public Employe(String nom, int age, float poids, double salaire) {
		super(nom, age, poids);
		this.salaire=salaire;
	}

	@Override
	public String toString() {
		return super.toString().replace("Personne", "Employe").replace("]",", salaire="+salaire+"€]");
	}
	
	

	
}
