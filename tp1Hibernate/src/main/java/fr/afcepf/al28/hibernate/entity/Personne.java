package fr.afcepf.al28.hibernate.entity;

import java.util.Date;
import java.util.List;

public class Personne {
	
	private Integer id;
	private String nom;
	private String prenom;
	private String adresse;
	private Date naissance;
	private List<Compte> comptes;



	public Personne() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Personne(Integer id,String nom, String prenom, String adresse, Date naissance) {
		super();
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.naissance = naissance;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}



	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", naissance="
				+ naissance + "]";
	}
	
	
	

}
