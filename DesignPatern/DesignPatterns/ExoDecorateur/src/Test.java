import java.util.Map;

import fr.afcepf.decorateur.ICustomizable;
import fr.afcepf.decorateur.Pizza;
import fr.afcepf.decorateur.supplements.Anchois;
import fr.afcepf.decorateur.supplements.Boite;
import fr.afcepf.decorateur.supplements.PeanutButter;

public class Test {

	public static void main(String[] args) {

		ICustomizable maPizza = 
			new Boite(
				new Anchois(
					new PeanutButter(
						new Pizza("Napolitaine", 9.9f))));
		
		
		System.out.println(maPizza.getPrix());
		
		for(String s : maPizza.getComposition())
		{
			System.out.println("- " + s);
		}
		

	}

}
