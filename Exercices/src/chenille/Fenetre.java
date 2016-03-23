package chenille;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	private Dessin des=new Dessin();
	private JButton boutonStart = new JButton("start");
	private JButton boutonStop = new JButton("stop");
	private JPanel boutonPan=new JPanel();
	private JPanel container=new JPanel();
	private boolean animated=true;


	public Fenetre(){
		this.setTitle("Les Chenilles");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		boutonPan.setLayout(new GridLayout(1,2));
		boutonPan.add(boutonStart);
		boutonPan.add(boutonStop);
		boutonStart.setEnabled(false);
		boutonStop.setEnabled(true);

		boutonStart.addActionListener(new BoutonStartListener());
		boutonStop.addActionListener(new BoutonStopListener());


		container.setLayout(new BorderLayout());
		container.add(des,BorderLayout.CENTER);
		container.add(boutonPan,BorderLayout.SOUTH);

		this.setContentPane(container);
		this.setVisible(true);

		for(int i=0;i<3;i++){
			des.ajouterObjet(new Chenille(new Color(100+(int)(Math.random()*150),(int)(Math.random()*255),(int)(Math.random()*255)), des,3));
		}
		new Animation().run();


	}



	class BoutonStartListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			animated=true;
			//System.out.println("Clic sur le bouton Start");
			boutonStart.setEnabled(false);
			boutonStop.setEnabled(true);
			
		}

	}

	class BoutonStopListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		//	System.out.println("Clic sur le bouton Stop");
			animated=false;
			boutonStop.setEnabled(false);
			boutonStart.setEnabled(true);

		}

	}
	
	class Animation extends Thread{
		
		long time=0;
		int pause=100;
		int newSaladeTime=2000;

		public void run(){
			while(true){
				//System.out.println("hors animation");
				while(animated){
					//System.out.println("animation en cours");
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
				des.pause(pause);
			}

		}
	}

}
