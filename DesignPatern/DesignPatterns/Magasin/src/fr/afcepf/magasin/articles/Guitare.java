package fr.afcepf.magasin.articles;

public class Guitare extends Article {

	private String marque;

	public Guitare(float prix, String libelle, String marque) {
		super(prix, libelle);
		this.marque = marque;
	}
	
	@Override
	public String getLibelle()
	{
		return marque + " " + libelle;
	}
	
}
