package chenille;

import java.awt.Color;
import java.awt.Graphics;

public class Salade extends Anneau{

	private Color col;
	private Dessin d;
	public Salade(int xInit, int yInit, Color col) {
		super(xInit, yInit, r);
		this.col=col;
		// TODO Auto-generated constructor stub
	}
	
	public void dessiner(Graphics g){
		Graphics gr=g.create();
		gr.setColor(col);
		g.fillOval(x, y, r*2, r*2);
	}
	
	public void setDessin(Dessin d){
		this.d=d;
	}
	
	

}
