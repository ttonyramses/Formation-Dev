package montre;


public class IncAutoMinute extends AbstractIncAuto {
	
	public IncAutoMinute(int delai) {
		super(delai);
	}

	//@Override
	protected void effectuerInc(Montre montre) {
		montre.incrementerMinute();		
	}

	//@Override
	protected Etat getEtatSuivant() {
		return Etat.MODIF_MINUTE;
	}
}
