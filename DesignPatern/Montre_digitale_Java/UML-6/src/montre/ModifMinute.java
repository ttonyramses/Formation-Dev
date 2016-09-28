package montre;

public class ModifMinute extends Etat {

	@Override
	public Etat avance(Montre montre) {
		montre.incrementerMinute();
		return this;
	}

	@Override
	public Etat mode(Montre montre) {
		montre.setMinuteClignotante(false);
		return Etat.AFFICHAGE_HEURE;
	}
	
	public String toString() {
		return "Modif minute";
	}

}
