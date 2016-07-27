package fr.afcepf.al28.tp7;

public abstract class ObjetVolant {
	
	private String couleur;
	protected static int PLAFOND=10000;

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	} 
	
	public abstract int getPlafond();
	

}
