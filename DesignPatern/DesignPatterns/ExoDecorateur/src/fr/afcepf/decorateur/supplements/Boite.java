package fr.afcepf.decorateur.supplements;

import java.util.ArrayList;

import fr.afcepf.decorateur.ICustomizable;
import fr.afcepf.decorateur.Supplement;

public class Boite extends Supplement {
	
	public Boite(ICustomizable composant) {
		super(composant);
	}
	
	@Override
	public ArrayList<String> getComposition() {
		ArrayList<String> compo = super.getComposition();
		compo.add("Boite de luxe");
		return compo;
	}

	@Override
	public float getPrix() {
		return super.getPrix() + 3f;
	}
}
