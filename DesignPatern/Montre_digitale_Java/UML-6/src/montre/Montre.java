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
		etatCourant = Etat.AFFICHAGE_HEURE;
	}
	
	public void incrementerHeure() {
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
	
	public void avance() {
		etatCourant = etatCourant.avance(this);
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

	public Etat getEtatCourant() {
		return etatCourant;
	}
	
	private void afficherInfos() {
		System.out.println("-------------------");
		System.out.println(getHeureAsString() + " : " + getMinuteAsString());
		System.out.println("Etat = " + getEtatCourant());
		System.out.println("-------------------");
	}
	
	public static void main(String[] args) {
		Montre montre = new Montre();
		montre.afficherInfos();
		montre.mode();
		montre.afficherInfos();
		montre.mode();
		montre.avance();
		montre.afficherInfos();
	}
}
