package Pile;

import java.util.ArrayList;
import java.util.List;

public class Pile1 implements Pile{

	List<Integer> liste=new ArrayList<Integer>();

	@Override
	public void empiler(Integer n) {
		liste.add(n);
		
	}

	@Override
	public int depiler() throws PileVideException {
		
		if(estVide()){
			throw new PileVideException();
		}
		
		return liste.remove(liste.size()-1);
		
	}
	
	public boolean estVide(){
		return liste.size()==0;
	}

}
