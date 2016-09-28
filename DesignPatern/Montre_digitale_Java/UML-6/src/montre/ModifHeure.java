package montre;

public class ModifHeure extends Etat {

	@Override
	public Etat avance(Montre montre) {
		montre.incrementerHeure();
		return this;
	}

	@Override
	public Etat mode(Montre montre) {
		montre.setHeureClignotante(false);
		montre.setMinuteClignotante(true);
		return Etat.MODIF_MINUTE;
	}
	
	public String toString() {
		return "Modif Heure";
	}

}
