package boule;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;

public class Fenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Panneau pan = new Panneau();
	private JPanel container = new JPanel();
	private JButton boutonAdd = new JButton("Ajouter une boule");
	private JButton boutonDel = new JButton("Enlever une boule");
	private JPanel boutonPane = new JPanel();
	public Fenetre(){
		this.setTitle("Mes Merveilleuses boules magiques");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//container.setBackground(Color.white);
		boutonPane.setLayout(new GridLayout(1, 2));
		boutonPane.add(boutonAdd);
		boutonPane.add(boutonDel);
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);
		container.add(boutonPane , BorderLayout.SOUTH);
		this.setContentPane(container);
		this.setVisible(true);
		addBoutonEvent();
		go((int)(3+Math.random()*(12-3)));
		//go(10);
	}

	public void addBoutonEvent(){
		boutonAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				pan.addBoule();
			}
		});
		
		boutonDel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				pan.delBoule();
			}
		});
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
				Thread.sleep((long)(2+Math.random()*(15-2)));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
}
