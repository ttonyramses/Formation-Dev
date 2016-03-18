package boule;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Panneau pan = new Panneau();
	public Fenetre(){
		this.setTitle("Mes Merveilleuses boules magiques");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setContentPane(pan);
		this.setVisible(true);

		go(5);
	}


	public void go(int nbBoules){
		for(int i=0;i<nbBoules;i++){
			pan.addBoule();
		}
		double pas=0.5+Math.random()*(2-0.5);
		while(true){
			pan.move(pas);
			pan.collision(pas);
			pan.repaint();
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
