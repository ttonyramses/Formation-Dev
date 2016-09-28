package montre;

public class ModifHeure extends Etat {

	//@Override
	public Etat avanceAppuye(Montre montre) {
		montre.incrementerHeure();
		((EtatTempo) Etat.TEMPO_MODIF_HEURE).startTempo(montre);
		return Etat.TEMPO_MODIF_HEURE;
	}

	//@Override
	public Etat mode(Montre montre) {
		montre.setHeureClignotante(false);
		montre.setMinuteClignotante(true);
		return Etat.MODIF_MINUTE;
	}

}
