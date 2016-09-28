package montre;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Montre {

	private Etat etatCourant;
	private boolean heureClignotante;
	private boolean minuteClignotante;
	private int deltaHeure;
	private int deltaMinute;
	
	private static final String MINUTE_PATTERN = "mm";  
	private static final String HEURE_PATTERN = "HH";
	private static final String SECONDE_PATTERN = "ss";
	
	public Montre() {
		etatCourant = Etat.AFFICHARGE_HEURE;
	}
	
	protected void incrementerHeure() {
		deltaHeure = (deltaHeure + 1) % 24;
	}
	
	public void incrementerMinute() {
		deltaMinute = (deltaMinute + 1) % 60;
	}
	
	public String getHeureAsString() {
		Date heure = new Date();
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(heure);
		cal.add(Calendar.HOUR, deltaHeure);
		heure = cal.getTime();
		
		return new SimpleDateFormat(HEURE_PATTERN).format(heure);
	}
	
	public String getMinuteAsString() {
		Date heure = new Date();
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(heure);
		cal.add(Calendar.MINUTE, deltaMinute);
		heure = cal.getTime();
		
		return new SimpleDateFormat(MINUTE_PATTERN).format(heure);
	}
	
	public String getSecondesAsString() {
		return new SimpleDateFormat(SECONDE_PATTERN).format(new Date());
	}
	
	public void mode() {
		etatCourant = etatCourant.mode(this);
	}
	
	public void avanceAppuye() {
		etatCourant = etatCourant.avanceAppuye(this);
	}
	
	public void avanceRelache() {
		etatCourant = etatCourant.avanceRelache(this);
	}
	
	public boolean isHeureClignotante() {
		return heureClignotante;
	}

	public void setHeureClignotante(boolean heureClignotante) {
		this.heureClignotante = heureClignotante;
	}

	public boolean isMinuteClignotante() {
		return minuteClignotante;
	}

	public void setMinuteClignotante(boolean minuteClignotante) {
		this.minuteClignotante = minuteClignotante;
	}

	protected void setEtatCourant(Etat etatCourant) {
		this.etatCourant = etatCourant;
	}
}
