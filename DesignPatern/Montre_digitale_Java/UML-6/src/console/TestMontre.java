package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import montre.Montre;

public class TestMontre {

	private Montre montre;
	
	public void demarrer() {
		afficherMontre();
		String cmd = readInput();
		
		if (cmd.equals("A")) {
			montre.avance();
		} else if (cmd.equals("M")) {
			montre.mode();
		} else {
			System.exit(0);
		}
		
		demarrer();
		
	}
	
	private void afficherMontre() {
		System.out.println("-------------------");
		System.out.println(montre.getHeureAsString() + " : " + montre.getMinuteAsString());
		System.out.println("Etat = " + montre.getEtatCourant());
		System.out.println("-------------------");
	}
	private String readInput() {
		System.out.println("M pour mode");
		System.out.println("A pour avance");
		System.out.print("Votre choix : ");
		
		BufferedReader reader = 
			new BufferedReader(new InputStreamReader(System.in));
		
		String choix  = null;
		try {
			choix = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (choix.length() > 0) {
			choix = String.valueOf(choix.charAt(0));
		} else {
			choix = readInput();
		}
		
		return choix;
	}
	public TestMontre() {
		montre = new Montre();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestMontre test = new TestMontre();
		test.demarrer();

	}

}
