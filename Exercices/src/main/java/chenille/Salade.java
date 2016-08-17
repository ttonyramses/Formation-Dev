package chenille;

import java.awt.Color;
import java.awt.Graphics;

public class Salade extends Anneau{

	private Color col;
	private Dessin d;
	public Salade(int xInit, int yInit, Color col) {
		super(xInit, yInit);
		this.col=col;
		// TODO Auto-generated constructor stub
	}
	
	public void dessiner(Graphics g){
		Graphics gr=g.create();
		gr.setColor(col);
		gr.fillOval(x, y, R*2, R*2);
	}
	
	public void setDessin(Dessin d){
		this.d=d;
	}

	@Override
	public String toString() {
		return "Salade [col=" + col + ", x=" + x + ", y=" + y + " R="+R+"]";
	}
	
	

}
