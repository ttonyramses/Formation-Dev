package chenille;

import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Chenille {
	
	private Tete tete;
	private List<Anneau> anneaux=new ArrayList<Anneau>();
	private Dessin d;
	private Color col;
	
	public Chenille(Color col,Dessin d, int nbAnneau){

		this.col=col;
		this.d=d;
		tete=new Tete(d.getLargeur()/2, d.getHauteur()/2,  15, -30+Math.random()*60);
		tete.placerA(d.getLargeur()/2, d.getHauteur()/2);
		
		int i=0;
		Anneau tampon=tete;
		while(i<nbAnneau){
			Anneau a=new Anneau(tampon.getX()-tampon.getR(), tampon.getY(), tampon.getR());
			anneaux.add(a);
			tampon=a;
			i++;
		}
		
		
	}
	
	public void dessiner(Graphics g){
		Graphics gr=g.create();
		gr.setColor(col);
		tete.dessiner(gr);
		for(Anneau a:anneaux){
			a.dessiner(gr);
		}
	}
	
	public void deplacer(){
		
		//System.out.println(tete.getX()+" "+tete.getY()+" "+d.getLargeur()+" "+d.getHauteur());
		
		tete.devierCap((int)(-30+Math.random()*60));
		while(!tete.capOk(d.getLargeur(), d.getHauteur())){
			tete.devierCap(60*(Math.random()>0.5?1:-1));
		}
		int xCent=tete.getX()+tete.getR();
		int yCent=tete.getY()+tete.getR();
		
		int xC2, yC2;
		
		tete.deplacerSelonCap();
		for(Anneau a :anneaux){
			xC2=a.getX()+a.getR();
			yC2=a.getY()+a.getR();
			
			a.placerA(xCent, yCent);
			xCent=xC2;
			yCent=yC2;
		}
		
	}
	
	public void setDessin(Dessin d){
		
	}

}
