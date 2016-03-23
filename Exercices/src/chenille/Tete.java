package chenille;

import java.awt.Color;
import java.awt.Graphics;

public class Tete extends Anneau{

	private double cap; //direction

	//xInt, yInit represente le centre du cercle
	public Tete(int xInit, int yInit) {
		super(xInit, yInit);
	}
	
	public Tete(int xInit, int yInit, double cap) {
		super(xInit, yInit);
		this.cap=cap;
	}
	
	public double getCap(){
		return cap;
	}
	
	public void dessiner(Graphics g){
		g.fillOval(x-R, y-R, R*2, R*2);
	}
	
	public void devierCap(double deltac){
		cap+=deltac;
	}
	
	public void capOpposer(int xMax, int yMax){
		
		double x1=x+R*Math.cos(Math.toRadians(cap))+R;
		double y1=y+R*Math.sin(Math.toRadians(cap))+R;
		
		if(x1>=xMax){
			//On applique une deviation de manière à ce que le cosinus soit negatif
			while(Math.cos(Math.toRadians(cap))>0){
				devierCap(Math.random()*30);
			}
		}
		if(x1<=R){
			while(Math.cos(Math.toRadians(cap))<0){
				devierCap(Math.random()*30);
			}
		}
		
		if(y1>=yMax){
			//On applique une deviation de manière à ce que le sinus soit negatif			
			while(Math.sin(Math.toRadians(cap))>0){
				devierCap(Math.random()*30);
			}
		}
		if(y1<=R){
			while(Math.sin(Math.toRadians(cap))<0){
				devierCap(Math.random()*30);
			}
		}
	}
	public void capOpposer(Tete t){
		
		if(x>t.getX()){
			//On applique une deviation de manière à ce que le cosinus soit positif
			while(Math.cos(Math.toRadians(cap))<0){
				devierCap(Math.random()*30);
			}
		}else{
			while(Math.cos(Math.toRadians(cap))>=0){
				devierCap(Math.random()*30);
			}
		}
		
		if(y>t.getY()){
			//On applique une deviation de manière à ce que le sinus soit positif			
			while(Math.sin(Math.toRadians(cap))<0){
				devierCap(Math.random()*30);
			}
		}else{
			while(Math.cos(Math.toRadians(cap))>=0){
				devierCap(Math.random()*30);
			}
		}
	} 
	
	public void deplacerSelonCap(){
		x=(int) (x+R*Math.cos(Math.toRadians(cap)));
		y=(int) (y+R*Math.sin(Math.toRadians(cap)));
	}
	
	public boolean capOk(int xMax, int yMax){
		
		double x1=x+R*Math.cos(Math.toRadians(cap))+R;
		double y1=y+R*Math.sin(Math.toRadians(cap))+R;
		return (xMax>=x1) && (R<=x1) && (yMax>=y1) && (R<=y1);

	}

	@Override
	public String toString() {
		return "Tete [cap=" + cap + ", x=" + x + ", y=" + y + ", R=" + R + " cos(cap)="+Math.cos(Math.toRadians(cap))+" sin(cap)="+Math.sin(Math.toRadians(cap))+"]";
	}
	
	
}
