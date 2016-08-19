package fr.afcepf.al28.data;

public class Compte {

	private Long numero;
	private String label;
	private Double solde;
	
	public Compte() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Compte(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}


	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}

	@Override
	public boolean equals(Object o){
		
		if(!(o instanceof Compte)){
			return false;
		}else{
			
			if(numero!=null && numero.equals(((Compte)o).getNumero())){
				return true;
			}else{
				return false;
			}
			
		}
		
		
		
	}

}
