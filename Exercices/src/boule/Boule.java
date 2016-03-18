package boule;

import java.awt.Color;

public class Boule {

	private double x;
	private double y;
	private double diametre;
	private Color couleur;

	private boolean directX;
	private boolean directY;



	public Boule(double x, double y, double diametre, Color couleur, boolean directX,
			boolean directY) {
		super();
		this.x = x;
		this.y = y;
		this.diametre = diametre;
		this.couleur = couleur;
		this.directX = directX;
		this.directY = directY;
	}


	@Override
	public String toString() {
		return "Boule [x=" + x + ", y=" + y + ", diametre=" + diametre
				+ ", couleur=" + couleur + ", directX=" + directX
				+ ", directY=" + directY + "]";
	}

	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getDiametre() {
		return diametre;
	}
	public void setDiametre(double diametre) {
		this.diametre = diametre;
	}
	public Color getCouleur() {
		return couleur;
	}
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	public boolean isDirectX() {
		return directX;
	}
	public void setDirectX(boolean directX) {
		this.directX = directX;
	}
	public boolean isDirectY() {
		return directY;
	}
	public void setDirectY(boolean directY) {
		this.directY = directY;
	}

	public double getXCentre(){
		return x+diametre/2;
	}

	public double getYCentre(){
		return y+diametre/2;
	}

	public double getDistance(Boule b){
		return Math.sqrt(Math.pow(this.getXCentre()-b.getXCentre(), 2)+Math.pow(this.getYCentre()-b.getYCentre(), 2));
	}

	/**
	 * 
	 * @param width largeur du conteneur
	 * @param height hauteur du conteneur
	 * @param pas longueur d'avance des coordonnées de la boule
	 */
	public void move(int width, int height, double pas){

		if (x < pas)
			directX = true;
		if (x > width - diametre)
			directX = false;

		// Idem pour l'axe y
		if (y < pas)
			directY = true;
		if (y > height - diametre)
			directY = false;

		if (directX == true)
			x+=pas;
		else
			x-=pas;

		// Idem pour l'axe Y
		if (directY)
			y+=pas;
		else
			y-=pas;
		
	}
	
	public void directChange(){
		directX=!directX;
		directY=!directY;
	}

}
