package fr.afcepf.al28.tpTri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConsoleAppTpTri {

	public static void main(String[] args) {

		(new ConsoleAppTpTri()).testTri();

	}

	public void testTri(){

		List<Personne> listeP= new ArrayList<Personne>();
		listeP.add(new Personne("bb", 5,78));
		listeP.add(new Personne("aa", 25,7));
		listeP.add(new Personne("zz", 45,47));
		listeP.add(new Personne("dd", 35,57));


//		Collections.sort(listeP, new /*classe anonyme*/Comparator <Personne>(){
//
//			@Override
//			public int compare(Personne o1, Personne o2) {
//				return o1.getAge()-o2.getAge();
//			}
//		} );
		
//		Collections.sort(listeP,
//				(Personne p1, Person p2) -> p1.getAge() == p2.getAge() ? 0 : (p1.getAge() < p2.getAge() ? -1 : 1 ) );
		Collections.sort(listeP, (Personne p1, Personne p2) -> p1.getAge() - p2.getAge()  );


		for( Personne p :listeP){
			System.out.println(p);
		}
	}
	//	
	//	private class ComparatorPersSelonAge implements Comparator <Personne>{
	//
	//		@Override
	//		public int compare(Personne o1, Personne o2) {
	//			return o1.getAge()-o2.getAge();
	//		}
	//		
	//	}

}
