package montre;

public abstract class Etat {

	public Etat mode(Montre montre) {
		return this;
	}
	public Etat avance(Montre m) {
		return this;
	}
	
	public static final Etat AFFICHAGE_HEURE = new AffichageHeure();
	public static final Etat MODIF_HEURE = new ModifHeure();
	public static final Etat MODIF_MINUTE = new ModifMinute();
}
