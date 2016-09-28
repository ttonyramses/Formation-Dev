package montre;

public class AffichageHeure extends Etat {


	//@Override
	public Etat mode(Montre montre) {
		montre.setHeureClignotante(true);
		return Etat.MODIF_HEURE;
	}

}
