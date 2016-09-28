package demoIterator;

import java.util.Iterator;

public class Test {

	public static void main(String[] args) {

		Equipe e = new Equipe();
		
		for(Joueur j : e)
		{
			System.out.println(j.getNom());
		}

	}

}
