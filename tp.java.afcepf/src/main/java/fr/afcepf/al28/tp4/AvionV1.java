package fr.afcepf.al28.tp4;

import java.util.Random;

public class AvionV1 {

	private final static int MAX=5;
	private final static int MIN=2;

	private Personne[] tabElements;
	private int nbElements;



	public AvionV1(){
		nbElements=0;
		tabElements=new Personne[MAX];
	}


	public void addElement(Personne p){
		if(nbElements>=MAX){
			System.out.println("Impossible d'ajouter un nouvel element");
		}else{
			tabElements[nbElements]=p;
			nbElements++;	
		}
	}

	public void initialiser(){
		Random rand = new Random();

		int initNBElement=rand.nextInt(MAX - MIN + 1) + MIN;
		for(int i=0;i<initNBElement;i++){
			addElement(new Personne("toto"+i, 20+i,50.2f));

		}
	}


	public void afficher(){

		for(int i=0; i<nbElements;i++){
			tabElements[i].afficher();
		}
	}

}
