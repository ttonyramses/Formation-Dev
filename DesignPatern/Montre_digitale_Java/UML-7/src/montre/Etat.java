package montre;

public abstract class Etat {

	public Etat mode(Montre montre) {
		return this;
	}
	
	public Etat avanceAppuye(Montre montre) {
		return this;
	}
	
	public Etat avanceRelache(Montre montre) {
		return this;
	}
	
	public static final Etat AFFICHARGE_HEURE = new AffichageHeure();
	public static final Etat MODIF_HEURE = new ModifHeure();
	public static final Etat MODIF_MINUTE = new ModifMinute();
	public static final AbstractIncAuto INC_AUTO_HEURE = new IncAutoHeure(200);
	public static final AbstractIncAuto INC_AUTO_MINUTE = new IncAutoMinute(200);
	public static final Etat TEMPO_MODIF_MINUTE = new EtatTempo(MODIF_MINUTE, INC_AUTO_MINUTE, 2000);
	public static final Etat TEMPO_MODIF_HEURE = new EtatTempo(MODIF_HEURE, INC_AUTO_HEURE, 2000);
}
