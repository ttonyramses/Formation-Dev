package fr.afcepf.decorateur.supplements;

import java.util.ArrayList;

import fr.afcepf.decorateur.ICustomizable;
import fr.afcepf.decorateur.Supplement;

public class PeanutButter extends Supplement {

	public PeanutButter(ICustomizable composant) {
		super(composant);
	}
	
	@Override
	public ArrayList<String> getComposition() {
		ArrayList<String> compo = super.getComposition();
		compo.add("beurre de cacachuette");
		return compo;
	}

	@Override
	public float getPrix() {
		return super.getPrix() + 5f;
	}
	
}
