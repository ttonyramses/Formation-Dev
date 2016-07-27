package fr.afcepf.al28.tp4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleAppTp4 {

	private static Logger logger=LoggerFactory.getLogger(ConsoleAppTp4.class);
	public static void main(String[] args) {


		AvionV1 a= new AvionV1();
		a.initialiser();
		
		logger.info("Nombre de personne dans l'avion : "+Personne.getNbInstances());
		a.addElement(new Personne("Moi meme",25,75.5f));
		logger.info("Nombre de personne dans l'avion : "+Personne.getNbInstances());

		a.afficher();
		

		a=null;
		System.gc();
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logger.info("Nombre de personne dans l'avion : "+Personne.getNbInstances());

		System.out.println("Racine carré de 81 : "+Math.sqrt(81));

	}

}
