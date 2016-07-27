package fr.afcepf.al28.tp7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleAppTp7 {

	private static Logger logger=LoggerFactory.getLogger(ConsoleAppTp7.class);
	public static void main(String[] args) {


		AvionV2 a= new AvionV2();
		a.initialiser();
		
		logger.info("Nombre de personne dans l'avion : "+Personne.getNbInstances());
		a.addElement(new Personne("Moi meme",25,75.5f));
		logger.info("Nombre de personne dans l'avion : "+Personne.getNbInstances());

		a.setCouleur("blanc");
		a.afficher();
		logger.info("Mon appareil volant a un planfond de : "+a.getPlafond());
		logger.info("Mon appareil volant a une couleur : "+a.getCouleur());


		a=null;
		System.gc();
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logger.info("Nombre de personne dans l'avion : "+Personne.getNbInstances());

		logger.info("Racine carré de 81 : "+Math.sqrt(81));

	}

}
