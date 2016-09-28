package montre;


public class ModifMinute extends Etat {

	//@Override
	public Etat avanceAppuye(Montre montre) {
		montre.incrementerMinute();
		((EtatTempo) TEMPO_MODIF_MINUTE).startTempo(montre);
		return Etat.TEMPO_MODIF_MINUTE;
	}

	//@Override
	public Etat mode(Montre montre) {
		montre.setMinuteClignotante(false);
		return Etat.AFFICHARGE_HEURE;
	}

}
