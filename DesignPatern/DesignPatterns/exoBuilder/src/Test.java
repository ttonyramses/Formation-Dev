
public class Test {

	public static void main(String[] args) {

		VoitureDirector dir = new VoitureDirector();
		
		Voiture v1 = dir.construct(new Formule1Builder());		
		Voiture v2 = dir.construct(new BerlineBuilder());
		Voiture v3 = dir.construct(new QuatreQuatreBuilder());	
		Voiture v4 = dir.construct(new BerlineBuilder());
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
	}

}
