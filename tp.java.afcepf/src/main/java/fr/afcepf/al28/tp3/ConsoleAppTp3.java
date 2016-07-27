package fr.afcepf.al28.tp3;

import fr.afcepf.al28.tp2.Personne;

public class ConsoleAppTp3 {

	public static void main(String[] args) {


		AvionV1 a= new AvionV1();
		a.initialiser();
		a.addElement(new Personne("Moi meme",25,75.5f));

		a.afficher();
	}

}
