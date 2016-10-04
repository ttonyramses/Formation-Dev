package fr.afcepf.al28.data;

public class TauxTva {

	private String nom;
	private double taux;
	
	
	public TauxTva() {
		// TODO Auto-generated constructor stub
	}


	public TauxTva(String nom, double taux) {
		super();
		this.nom = nom;
		this.taux = taux;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public double getTaux() {
		return taux;
	}


	public void setTaux(double taux) {
		this.taux = taux;
	}


	@Override
	public String toString() {
		return "TauxTva [nom=" + nom + ", taux=" + taux + "]";
	}
	
}
