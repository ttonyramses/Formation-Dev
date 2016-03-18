package ihm;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class Fenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Panneau pan = new Panneau();
	public Fenetre(){
		this.setTitle("Ma première fenêtre Java");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setContentPane(pan);
		this.setVisible(true);

		go();
	}

	private void go(){

		for(;;){

			move1();
			move2();
			colision();
			pan.repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}



		}

	}
	int avX=1;
	int avY=1;
	private void move1(){

		int x = pan.getPosX(), y = pan.getPosY();
		//System.out.println("postX="+pan.getPosX()+" postY="+pan.getPosY()+" panX="+pan.getWidth()+" panY="+pan.getHeight());
		if(x >pan.getWidth()-50){
			avX=-1;
		}
		if(x<1){
			avX=1;
		}
		
		if(y >pan.getHeight()-50){
			avY=-1;
		}
		if(y<1){
			avY=1;
		}
		
		x+=avX;
		y+=avY;
		pan.setPosX(x);
		pan.setPosY(y);
	}
	
	int av2X=1;
	int av2Y=1;
	private void move2(){
		
		int x = pan.getPos2X(), y = pan.getPos2Y();
		//System.out.println("postX="+pan.getPosX()+" postY="+pan.getPosY()+" panX="+pan.getWidth()+" panY="+pan.getHeight());
		if(x >pan.getWidth()-50){
			av2X=-1;
		}
		if(x<1){
			av2X=1;
		}
		
		if(y >pan.getHeight()-50){
			av2Y=-1;
		}
		if(y<1){
			av2Y=1;
		}
		
		x+=av2X;
		y+=av2Y;
		pan.setPos2X(x);
		pan.setPos2Y(y);
	}
	
	public void colision(){
		if(pan.getDistance()<51){
				avX=-avX; 
				av2X=-av2X; 
			
				avY=-avY; 
				av2Y=-av2Y; 
			
			//av2X=-av2X; av2Y=-av2Y; 
			
		}
	}

	/*	private void go() {
		int x = pan.getPosX(), y = pan.getPosY();
		boolean backX = false;
		boolean backY = false;

		while (true) {
			if (x < 1)
				backX = false;
			// Si la coordonnée x est supérieure à la taille du Panneau			moins la taille du rond, on recule
			if (x > pan.getWidth() - 50)
				backX = true;
			// Idem pour l'axe y
			if (y < 1)
				backY = false;
			if (y > pan.getHeight() - 50)
				backY = true;

			if (backX == false)
				pan.setPosX(++x);
			else
				pan.setPosX(--x);
			// Idem pour l'axe Y
			if (!backY)
				pan.setPosY(++y);
			else
				pan.setPosY(--y);
			// On redessine notre Panneau
			pan.repaint();
			// Comme on dit : la pause s'impose ! Ici, trois millièmes de			seconde
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	 */
}
