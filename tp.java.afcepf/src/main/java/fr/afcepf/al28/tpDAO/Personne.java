package fr.afcepf.al28.tpDAO;

public class Personne {

	private Integer id;
	private String nom;
	private Integer age;
	private float poids;
	
	public Personne() {
	}

	public Personne(Integer id, String nom, int age, float poids) {

		this.id=id;
		this.nom = nom;
		this.age = age;
		this.poids = poids;
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
	
	

}
