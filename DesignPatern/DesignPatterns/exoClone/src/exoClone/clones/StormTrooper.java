package exoClone.clones;

public class StormTrooper extends Soldier {

	protected int munitions;
	protected int obeissance;
	
	@Override
	public String toString() {
		return "StormTrooper [munitions=" + munitions + ", obeissance=" + obeissance + ", numeroSerie=" + numeroSerie
				+ ", poids=" + poids + ", hauteur=" + hauteur + ", largeur=" + largeur + "]";
	}



	public StormTrooper()
	{
		System.out.print("Cr�ation du stormtrooper....");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.numeroSerie = 1;
		this.largeur = 80;
		this.hauteur = 180;
		this.munitions = 42;
		this.obeissance = 100;
		this.poids = 120;
		System.out.println(".......OK");
	}
	
}
