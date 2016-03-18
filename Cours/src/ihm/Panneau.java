package ihm;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;

import javax.swing.JPanel;


public class Panneau extends JPanel {

	private static final long serialVersionUID = 1736548696074160151L;
	private int posX = (int)(Math.random()*300);
	private int posY = (int)(Math.random()*300);
	
	private int pos2X = (int)(Math.random()*300);
	private int pos2Y = (int)(Math.random()*300);
	
	public void paintComponent(Graphics gr){
		Graphics2D g=(Graphics2D)gr;
		
//		GradientPaint gp = new GradientPaint(25, 25, Color.white, 25, 0, Color.red,true);
		
		g.setColor(Color.gray);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		float[] f={0.01f,0.5f};
		Color[] c={Color.cyan, Color.blue};
		
		
		g.setPaint(new RadialGradientPaint  (posX+25,posY+25,90,f,c));
		g.fillOval(posX, posY, 50, 50);
		
		Color[] c2={Color.orange, Color.red};
		g.setPaint(new RadialGradientPaint  (pos2X+25,pos2Y+25,90,f,c2));
		//g.setColor(Color.blue);
		g.fillOval(pos2X, pos2Y, 50, 50);
		//g.fillOval(0, 0, 50, 50);
		//g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getPos2X() {
		return pos2X;
	}
	public void setPos2X(int pos2x) {
		pos2X = pos2x;
	}
	public int getPos2Y() {
		return pos2Y;
	}
	public void setPos2Y(int pos2y) {
		pos2Y = pos2y;
	}
	
	public double getDistance(){
		return Math.sqrt(Math.pow(posX-pos2X, 2)+Math.pow(posY-pos2Y, 2));
	}
}
