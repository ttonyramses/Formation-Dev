package montre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public abstract class AbstractIncAuto extends Etat implements ActionListener {
	
	private int delai;
	private Timer timer;
	private Montre montre;
	
	public AbstractIncAuto(int delai) {
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
		effectuerInc(montre);
	}
	
	//@Override
	public Etat avanceRelache(Montre montre) {
		
		if (timer != null) {
			timer.stop();
			timer = null;
		}
		
		
		Etat etatSuivant = getEtatSuivant();
		
		return getEtatSuivant();
	}
	
	protected abstract void effectuerInc(Montre montre);
	protected abstract Etat getEtatSuivant();
}
