package chenille;

import java.awt.Color;
import java.awt.Graphics;

public class Tete extends Anneau{

	private double cap; //direction

	public Tete(int xInit, int yInit, int r) {
		super(xInit, yInit, r);
	}
	
	public Tete(int xInit, int yInit, int r, double cap) {
		super(xInit, yInit, r);
		this.cap=cap;
	}
	
	public void dessiner(Graphics g){
		g.fillOval(x, y, r*2, r*2);
	}
	
	public void devierCap(double deltac){
		cap+=deltac;
	}
	
	public void deplacerSelonCap(){
		x=(int) (x+r*Math.cos(Math.toRadians(cap)));
		y=(int) (y+r*Math.sin(Math.toRadians(cap)));
	}
	
	public boolean capOk(int xMax, int yMax){
		
		double x1=x+r*Math.cos(Math.toRadians(cap))+r;
		double y1=y+r*Math.sin(Math.toRadians(cap))+r;
		return (xMax>=x1) && (r<=x1) && (yMax>=y1) && (r<=y1);

	}

	@Override
	public String toString() {
		return "Tete [cap=" + cap + ", x=" + x + ", y=" + y + ", r=" + r + "]";
	}
	
	
}
