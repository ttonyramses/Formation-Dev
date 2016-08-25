package fr.afcepf.al28.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="client")
public class Client {

	private String nom;
	private String prenom;
	private String email;
	private Integer age;
	private String adresse;
	
	
	public Client(String nom, String prenom, String email, Integer age, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.age = age;
		this.adresse = adresse;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public Client() {
		// TODO Auto-generated constructor stub
	}

}
