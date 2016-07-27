package fr.afcepf.al28.tp7;

import java.util.Random;

public class AvionV2 extends ObjetVolant{

	private final static int MAX;
	private final static int MIN;
	
	static{
		MAX=10;
		MIN=2;
		PLAFOND=10000;
	}
	
	private Transportable[] tabElements;
	private int nbElements;



	public AvionV2(){
		nbElements=0;
		tabElements=new Transportable[MAX];
	}


	public void addElement(Transportable p){
		if(nbElements>=MAX){
			System.out.println("Impossible d'ajouter un nouvel element");
		}else{
			tabElements[nbElements]=p;
			nbElements++;	
		}
	}

	public void initialiser(){
		Random rand = new Random();

		int initNBElement=rand.nextInt(MAX - MIN ) + MIN;
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
		for(int i=0; i<nbElements;i++){
			System.out.println(tabElements[i].getDesignation());
			charge+=tabElements[i].getPoids();

		}
		System.out.println("Charge Total = "+charge);
	}


	@Override
	public int getPlafond() {
		
		return PLAFOND;
	}

}
