package fr.afcepf.al28.tp2;

public class ConsoleAppTp2 {

	public static void main(String[] args) {

		Personne p1 =new Personne("Tony",  30, 73.2f);
		Personne p3 =new Personne("Tony",  30, 73.2f);

		Personne p2 =new Personne("Nicolas", 32, 70);
		
		
		System.out.println("p1 : "+p1.toString());
		System.out.println("p2 : "+p2.toString());
		System.out.println("p3 : "+p3.toString());
		
		if(p1.equals(p2)){
			System.out.println("p1 est egal pas à p2");
		}else{
			System.out.println("p1 n'est egal pas à p2");

		}
		
		if(p1.equals(p3)){
			System.out.println("p1 est egal pas à p3");
		}else{
			System.out.println("p1 n'est egal pas à p3");

		}
	}

}
