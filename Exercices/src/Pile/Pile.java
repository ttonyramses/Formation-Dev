package Pile;

import java.util.List;

public interface Pile {
	
	public void empiler(Integer n);
	public int depiler() throws PileVideException;
	public boolean estVide();

}
