package fr.afcepf.al28.data;

public class Operation {

	private String label;
	private Double montant;
	
	
	public Operation() {
	}
	
	


	public Operation(String label, Double montant) {
		super();
		this.label = label;
		this.montant = montant;
	}




	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public Double getMontant() {
		return montant;
	}


	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
	

}
