package fr.afcepf.al28.tp9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Personne implements Transportable{
	
	private String nom;
	private int age;
	private float poids;
	private static int nbInstances=0;
	Logger logger=LoggerFactory.getLogger(Personne.class);

	
	public Personne(){
		
	}
	
	public Personne(String nom, int age, float poids) {
		this.nom = nom;
		this.age = age;
		this.poids = poids;
		nbInstances++;
		

	}
	
	public static int getNbInstances(){
		return nbInstances;
	}

	
	public void afficher(){
		logger.info(this.toString());
	}
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", age=" + age + ", poids=" + poids + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (age != other.age)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (Float.floatToIntBits(poids) != Float.floatToIntBits(other.poids))
			return false;
		return true;
	}
	
	@Override
	public void finalize(){
		nbInstances--;
	}

	@Override
	public String getDesignation() {
		return this.toString();
	}
	
	
	
	

}
