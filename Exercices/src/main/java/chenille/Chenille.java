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
		tete=new Tete(d.getLargeur()/2, d.getHauteur()/2, -30+Math.random()*60);
		tete.placerA(d.getLargeur()/2, d.getHauteur()/2);
		
		int i=0;
		Anneau tampon=tete;
		while(i<nbAnneau){
			Anneau a=new Anneau(tampon.getX()-Anneau.R, tampon.getY());
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
//		while(!tete.capOk(d.getLargeur(), d.getHauteur())){
//			tete.devierCap(60*(Math.random()>0.5?1:-1));
//		}
		if(!tete.capOk(d.getLargeur(), d.getHauteur())){

			tete.capOpposer(d.getLargeur(), d.getHauteur());
			tete.deplacerSelonCap();
			
//			while(!tete.capOk(d.getLargeur(), d.getHauteur())){
//				System.out.println(tete);
//				tete.devierCap((int)(-30+Math.random()*60));
//				tete.deplacerSelonCap();
//				
//			}
		}
		int xt=tete.getX();
		int yt=tete.getY();
		
		int xC2, yC2;
		
		tete.deplacerSelonCap();
		for(Anneau a :anneaux){
			xC2=a.getX();
			yC2=a.getY();
			
			a.placerA(xt, yt);
			xt=xC2;
			yt=yC2;
		}
		
	}
	
	public void setDessin(Dessin d){
		this.d=d;
	}
	
	public void ajoutAnneau(){
		
		Anneau newA;
		if(anneaux.size()>1){
			Anneau last=anneaux.get(anneaux.size()-1);
			newA=new Anneau(last.getX(),last.getY());
		}else{
			newA=new Anneau(-2*Anneau.R,-2*Anneau.R); //on initialise l'neau hors du dessin, mais celui recupéra la position de la tête au prochain déplacement
		}
		anneaux.add(newA);
	}
	
	public Anneau enleverAnneau(){
		return anneaux.remove(anneaux.size()-1);
	}
	
	public Tete getTete(){
		return tete;
	}
	
	public List<Anneau> getAnneaux(){
		return anneaux;
	}

}
