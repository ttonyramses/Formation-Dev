package chenille;

import java.awt.Graphics;

public class Anneau {

	protected int x;
	protected int y;
	public static int r=5;
	/**
	 * crée un Anneau en fixant sa position initiale et son rayon
	 * @param xInit abscisse du centre de l'anneau
	 * @param yInit ordonnée du centre de l'anneau
	 * @param r rayon de l'anneau
	 */
	public Anneau(int xInit, int yInit, int r){
		this.x=xInit;
		this.y=yInit;
		this.r=r;
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
		x=px-r;
		y=py-r;
	}
	
	public int getR(){
		return r;
	}

	/**
	 * affiche l'anneau en le matérialisant par un cercle noir
	 * @param g objet de classe Graphics qui prend en charge la gestion
	 * de l'affichage dans la fenêtre de dessin
	 */
	public void dessiner(Graphics g){
		g.drawOval(x, y, r*2, r*2);
	}

	@Override
	public String toString() {
		return "Anneau [x=" + x + ", y=" + y + ", r=" + r + "]";
	}
	
	
}
