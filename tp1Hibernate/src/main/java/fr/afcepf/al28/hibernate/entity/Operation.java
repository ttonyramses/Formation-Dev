package fr.afcepf.al28.hibernate.entity;

public class Operation {

	
	private Integer id;
	private Double montant;
	private String type;
	private Compte compte;
	
	public Operation() {
		// TODO Auto-generated constructor stub
	}
	
	public Operation(Integer id,Double montant, String type, Compte compte) {
		super();
		this.id=id;
		this.montant = montant;
		this.type = type;
		this.compte = compte;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Double getMontant() {
		return montant;
	}


	public void setMontant(Double montant) {
		this.montant = montant;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Compte getCompte() {
		return compte;
	}


	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", montant=" + montant + ", type=" + type + "]";
	}



	

}
