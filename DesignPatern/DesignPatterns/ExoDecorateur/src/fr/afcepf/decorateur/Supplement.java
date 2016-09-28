package fr.afcepf.decorateur;

import java.util.ArrayList;

public abstract class Supplement implements ICustomizable {

	private ICustomizable composant;
	
	public Supplement(ICustomizable composant)
	{
		this.composant = composant;		
	}
	
	@Override
	public ArrayList<String> getComposition() {
		return composant.getComposition();
	}

	@Override
	public float getPrix() {
		return composant.getPrix();
	}

}
