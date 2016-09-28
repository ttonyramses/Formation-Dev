package montre;


public class IncAutoHeure extends AbstractIncAuto {

	public IncAutoHeure(int delai) {
		super(delai);
	}

	//@Override
	protected void effectuerInc(Montre montre) {
		montre.incrementerHeure();		
	}

	//@Override
	protected Etat getEtatSuivant() {
		return Etat.MODIF_HEURE;
	}	
}
