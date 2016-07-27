package fr.afcepf.al28.tp9;

public class Bagage implements Transportable{

	private String label;
	private float poids;
	private float volume;
	
	
	
	public Bagage(String label, float poids, float volume) {
		this.label = label;
		this.poids = poids;
		this.volume = volume;
	}

	@Override
	public String getDesignation() {
		return this.toString();
	}

	@Override
	public float getPoids() {
		return poids;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	@Override
	public String toString() {
		return "Bagage [label=" + label + ", poids=" + poids + ", volume=" + volume + "]";
	}
	
	

}
