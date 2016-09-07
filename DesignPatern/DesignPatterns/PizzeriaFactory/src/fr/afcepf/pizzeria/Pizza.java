package fr.afcepf.pizzeria;

public class Pizza {

	Pate pate;
	Garniture garniture;
	boolean estCuite = false;

	public void Cuire()
	{
		System.out.println("Cuisson de la pizza");
		estCuite = true;	
	}
	
	public Pate getPate() {
		return pate;
	}

	public void setPate(Pate pate) {
		System.out.println("Pate : " + pate);
		this.pate = pate;
	}

	public Garniture getGarniture() {
		return garniture;
	}

	public void setGarniture(Garniture garniture) {
		System.out.println("Garniture : " + garniture);
		this.garniture = garniture;
	}
	
	
	
}
