package chenille;

import java.awt.Graphics;

public class Anneau {

	protected int x;
	protected int y;
	public static final int R=20;
	/**
	 * crée un Anneau en fixant sa position initiale et son rayon
	 * @param xInit abscisse du centre de l'anneau
	 * @param yInit ordonnée du centre de l'anneau
	 * @param r rayon de l'anneau
	 */
	public Anneau(int xInit, int yInit){
		this.x=xInit;
		this.y=yInit;
	}

	/**
	 * retourne abscisse du centre de l'anneau
	 * @return abscisse du centre de l'anneau
	 */

	public int getX(){
		return x;
	}
	/**
	 * retourne ordonnée du centre de l'anneau
	 * @return ordonnée du centre de l'anneau
	 */
	public int getY() {
		return y;
	}

	/** positionne le centre de l'anneau en un point donné
	 * @param px abscisse du point
	 * @param py ordonnée du point
	 */
	public void placerA(int px, int py){
		x=px;
		y=py;
	}
	


	/**
	 * affiche l'anneau en le matérialisant par un cercle noir
	 * @param g objet de classe Graphics qui prend en charge la gestion
	 * de l'affichage dans la fenêtre de dessin
	 */
	public void dessiner(Graphics g){
		g.drawOval(x-R, y-R, R*2, R*2);
	}
	
	public double getDistance(Anneau a){
		return Math.sqrt(Math.pow(x-a.getX(), 2)+Math.pow(y-a.getY(), 2));
	}

	@Override
	public String toString() {
		return "Anneau [x=" + x + ", y=" + y + ", R=" + R + "]";
	}
	
	
}
