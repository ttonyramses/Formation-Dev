package exoClone.clones;

public abstract class Soldier implements Cloneable{

	protected int numeroSerie;
	protected int poids;
	protected int hauteur;
	protected int largeur;
	
	
	
	@Override
	public Soldier clone() throws CloneNotSupportedException 	
	{
		Soldier clone = (Soldier)(super.clone());
		clone.numeroSerie = clone.hashCode();
		return clone;
	}
}
