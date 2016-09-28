package montre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class EtatTempo extends Etat implements ActionListener {
	
	private Etat etatAvant;
	private AbstractIncAuto etatApres;
	private Montre montre;
	private int delai;
	private Timer timer;
	
	public EtatTempo(Etat etatAvant, AbstractIncAuto etatApres, int delai) {
		this.etatAvant = etatAvant;
		this.etatApres = etatApres;
		this.delai = delai;
		timer = new Timer(delai, this);
	}
	
	public void startTempo(Montre montre) {
		this.montre = montre;
		
		if (timer == null) {
			timer = new Timer(delai, this);
		}
		timer.start();
	}

	public void actionPerformed(ActionEvent event) {
		montre.setEtatCourant(etatApres);
		etatApres.startTempo(montre);
		
		if (timer != null) {
			timer.stop();
			timer = null;
		}
	}

	//@Override
	public Etat avanceRelache(Montre montre) {
		
		if (timer != null) {
			timer.stop();
			timer = null;
		}
		
		return etatAvant;
	}

	

}
