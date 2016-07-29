package fr.afcepf.uml.employe;

public class ConsoleAppUml {

	public ConsoleAppUml() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Personnel p= new Personnel();
		
		p.ajouterEmploye(new Technicien("Nom 1", "Prenom 2", 20, 200));

		p.ajouterEmploye(new TechnicienARisque("Nom 2", "Prenom 2", 25, 250));
		p.ajouterEmploye(new Vendeur("Nom 3", "Prenom 3", 30, 10000));
		p.ajouterEmploye(new Representant("Nom 4", "Prenom 4", 30, 15000));
		p.ajouterEmploye(new Manutentionnaire("Nom 5", "Prenom 6", 32, 100));
		p.ajouterEmploye(new ManutentionnaireARisque("Nom 6", "Prenom 6", 27, 200));


		p.calculerSalaires();
		System.out.println("Salaire Moyen : "+p.salaireMoyen());
	}

}
