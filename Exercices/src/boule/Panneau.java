package boule;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class Panneau extends JPanel {

	private static final long serialVersionUID = 1736548696074160151L;
	private List<Boule> boules=new ArrayList<Boule>();
	
	
	public void addBoule(){
		Color color =new Color((int)(Math.random()*255), (int)(Math.random()*255),(int)(Math.random()*255));
		double x=Math.random()*this.getWidth();
		double y=Math.random()*this.getHeight();
		double diametre=30+Math.random()*(100-30);
		boolean directX=Math.random()>0.5d?true:false;
		boolean directY=Math.random()>0.5d?true:false;
		Boule b=new Boule(x,y,diametre,color,directX, directY);
		boules.add(b);
	}
	
	public void move(double pas){
		for(Boule b: boules){
			b.move(this.getWidth(), this.getHeight(), pas);
			
			//System.out.println(b+" pas="+pas+" width="+this.getWidth()+" height="+this.getHeight());

		}
	}
	
	public void collision(double pas){
		int i=0;
		int j=0;
		Boule bi,bj; 
		
		for(i=0;i<boules.size()-1;i++){
			for(j=i+1;j<boules.size();j++){
				bi=boules.get(i);
				bj=boules.get(j);
				
				if(bi.getDistance(bj)<(bi.getDiametre()+bj.getDiametre())/2+pas){
					
					bi.setDirectX(bi.getXCentre()>bj.getXCentre());
					bi.setDirectY(bi.getYCentre()>bj.getYCentre());
					bj.setDirectX(bj.getXCentre()>bi.getXCentre());
					bj.setDirectY(bj.getYCentre()>bi.getYCentre());
				}
			}
		}
		
	}
	
	public void paintComponent(Graphics gr){
		Graphics2D g=(Graphics2D)gr;
				
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		float[] f={0.01f,0.5f};
		
		for(Boule b : boules){
			Color cb=b.getCouleur();
			Color cgr=new Color(cb.getRed(),0,0);
			
			Color[] c={cb,cgr};
			
			g.setPaint(new RadialGradientPaint((int)b.getXCentre(),(int)b.getYCentre(),90,f,c));

			g.fillOval((int)b.getX(), (int)b.getY(), (int)b.getDiametre(), (int)b.getDiametre());
		}
		//Color[] c2={Color.orange, Color.red};
		//g.setColor(Color.blue);
		
		//g.fillOval(0, 0, 50, 50);
		//g.fillRect(0, 0, this.getWidth(), this.getHeight());
		//System.out.println("je redessine");
	}

}
