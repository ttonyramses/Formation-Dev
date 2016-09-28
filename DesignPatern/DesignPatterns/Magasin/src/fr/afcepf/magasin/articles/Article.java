package fr.afcepf.magasin.articles;

public abstract class Article {

	protected float prix;
	protected String libelle;
	
	public float getPrix() {
		return prix;
	}
	public String getLibelle() {
		return libelle;
	}
	
	public Article(float prix, String libelle) {
		super();
		this.prix = prix;
		this.libelle = libelle;
	}
	
	
	
}
