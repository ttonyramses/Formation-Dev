package fr.afcepf.al28.tp9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AvionV4 extends ObjetVolant{

	
	static{
		PLAFOND=10000;
	}
	
	private List<Transportable> listeElements;



	public AvionV4(){
		listeElements=new ArrayList<Transportable>();
	}


	public void addElement(Transportable p){
		listeElements.add(p);
	}

	public void initialiser(){
		Random rand = new Random();

		int initNBElement=rand.nextInt(4) + 3;
		for(int i=0;i<initNBElement;i++){
			if(i%3==0)
				addElement(new Personne("Personne-"+i, 20+i,50.2f));
			if(i%3==1)
				addElement(new Employe("Employe-"+i, 20+i,50.2f,750.5d*i));

			if(i%3==2)
				addElement(new Bagage("Bagage-"+i, 10.12f*i,5.2f*i));

		}
	}


	public void afficher(){

		float charge=0;
		for(Transportable p : listeElements){
			System.out.println(p.getDesignation());
			charge+=p.getPoids();

		}
		System.out.println("Charge Total = "+charge);
	}


	@Override
	public int getPlafond() {
		
		return PLAFOND;
	}

}
