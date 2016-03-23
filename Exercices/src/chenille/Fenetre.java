package chenille;


import java.awt.Color;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
	
	private Dessin des=new Dessin();
	
	public Fenetre(){
		this.setTitle("Les Chenilles");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//container.setBackground(Color.white);

		this.setContentPane(des);
		this.setVisible(true);
		
		for(int i=0;i<3;i++){
			des.ajouterObjet(new Chenille(new Color(100+(int)(Math.random()*150),(int)(Math.random()*255),(int)(Math.random()*255)), des,3));
		}

		animation();
		
	}
	long time=0;
	int pause=100;
	int newSaladeTime=2000;
	public void animation(){
		while(true){
			
			des.pause(pause);
			des.deplacer();
			des.mangerSalade();
			if(time>2*newSaladeTime){
				des.toucherLesAutres();
			}
			time+=pause;
			if(time%newSaladeTime==0){
				des.ajouterObjet(new Salade((int)(2*Salade.R+Math.random()*(des.getWidth()-4*Salade.R)),(int)(2*Salade.R+Math.random()*(des.getHeight()-4*Salade.R)),Color.GREEN));
			}
			des.repaint();
		}
	}

}
