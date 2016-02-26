package Pile;

import java.util.List;
import java.util.LinkedList;

class Maillon {
	  int donnee;
	  Maillon suivant;

	  Maillon(int donnee, Maillon suivant) {
	      this.donnee = donnee;
	      this.suivant = suivant;
	    }
}

public class Pile2 implements Pile{

	private Maillon debut;

	
	@Override
	public void empiler(Integer n) {
		
		debut=new Maillon(n, debut);
	}

	@Override
	public int depiler() throws PileVideException {
		
		if(estVide()){
			throw new PileVideException();
		}
		int v=debut.donnee;
		
		debut=debut.suivant;
		return v;
		
		
	}
	
	public boolean estVide(){
		return debut==null;
	}

}
