package fr.afcepf.decorateur.supplements;

import java.util.ArrayList;

import fr.afcepf.decorateur.ICustomizable;
import fr.afcepf.decorateur.Supplement;

public class Anchois extends Supplement {

	public Anchois(ICustomizable composant) {
		super(composant);
	}
	
	@Override
	public ArrayList<String> getComposition() {
		ArrayList<String> compo = super.getComposition();
		compo.add("anchois");
		return compo;
	}

	@Override
	public float getPrix() {
		return super.getPrix() + 0.5f;
	}

	
	
}
