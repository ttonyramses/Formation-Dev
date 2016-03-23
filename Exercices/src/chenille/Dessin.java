package chenille;

import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.Color;

/**
 * Dessin.java
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Defini le contenu de la fenêtre de l'application d'animation des VisageRond. Une zone
 * de dessin est un JPanel qui gère un liste d'objets VisageRond. Lorsqu'il se réaffiche
 * l'objet Dessin redessinne les différents objets VisageRond contenus dans cette liste.
 *
 * @author Philippe Genoud
 * @version
 */
public class Dessin extends JPanel {
	/**
	 * stocke la liste des VisageRond ayant été ajoutées à cette zone de
	 * dessin.
	 */
	private List<Chenille> listeChenilles = new ArrayList<Chenille>();
	private List<Salade> listeSalades=new ArrayList<Salade>();

	/**
	 * retourne la largeur de la zone de dessin.
	 * @return la largeur.
	 */
	public int getLargeur() {
		return getWidth();
	}

	/**
	 * retourne la hauteur de la zone de dessin.
	 * @return la hauteur.
	 */
	public int getHauteur() {
		return getHeight();
	}

	/**
	 * ajoute un VisageRond à la zone de dessin.
	 * @param c la VisageRond à ajouter au Dessin
	 * @see VisageRond
	 */
	public void ajouterObjet(Chenille c) {

		if (! listeChenilles.contains(c)) {
			// l'objet n'est pas déjà dans la liste
			// on le rajoute a la liste des objets du dessin
			listeChenilles.add(c);
			// fixe le dessin associé au visage rond v : c'est CE dessin
			c.setDessin(this);
			// le dessin se réaffiche
			repaint();
		}
	}
	
	public void ajouterObjet(Salade s){
		if(!listeSalades.contains(s)){
			listeSalades.add(s);
			s.setDessin(this);
			
			repaint();
		}
	}

	/**
	 * temporisation de l'animation.
	 * @param durée delai de temporisation en ms.
	 */
	public void pause(int duree) {
		try {
			Thread.sleep(duree);
		} catch (Exception e) {}
	}

	/**
	 * affiche la zone de dessin et son contenu
	 * @param g le contexte graphique
	 */
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		super.paintComponent(g);

		for (Chenille c : listeChenilles)
			c.dessiner(g);
		
		for (Salade s : listeSalades)
			s.dessiner(g);
	}

	public void deplacer(){
		for (Chenille c : listeChenilles)
			c.deplacer();
	}
	
	public void mangerSalade(){
		for(Chenille c :listeChenilles){
			for(Salade s:listeSalades){
				if(c.getTete().getDistance(s)<2*Anneau.R){
					c.ajoutAnneau();
					listeSalades.remove(s);
					break;
				}
			}
		}
	}
	
	public void toucherLesAutres(){

		Tete ti,tj;
		
		for(Chenille ci:listeChenilles){
			
			ti=ci.getTete();
			for(Chenille cj:listeChenilles){
				if(ci.equals(cj)) {
					continue;
				}
				tj=cj.getTete();
				
				//cas de colision de tête entre deux chenille
				if(ti.getDistance(tj)<2*Tete.R+Tete.R/2){
					ti.capOpposer(tj);
					tj.capOpposer(ti);
					continue;
				}
				
				//cas ou la tête d'une chenille est proche de l'anneau d'une autre chenille
				for(Anneau a : cj.getAnneaux()){
					if(ti.getDistance(a)<Anneau.R*2){
						cj.enleverAnneau();
						break;
					}
				}
			}
		}
		
	}

}
