package fr.afcepf.decorateur;

import java.util.ArrayList;

public class Pizza implements ICustomizable{

	private String nom;
	private float prix;
	
	public Pizza(String nom, float prix) {
		super();
		this.nom = nom;
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public ArrayList<String> getComposition() {
		ArrayList<String> composition = new ArrayList<>();
		composition.add(this.nom);
		return composition;
	}

	
	
	
}
