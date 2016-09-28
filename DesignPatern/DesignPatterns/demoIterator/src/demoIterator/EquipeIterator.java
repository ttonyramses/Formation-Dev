package demoIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class EquipeIterator implements Iterator<Joueur> {

	private ArrayList<Joueur> titulaires;
	private ArrayList<Joueur> remplacants;
	
	private int positionCourante;
	
	public EquipeIterator(
			ArrayList<Joueur> titulaires, 
			ArrayList<Joueur> remplacants)
	{
		this.titulaires = titulaires;
		this.remplacants = remplacants;
		this.positionCourante = 0;
	}
	
	@Override
	public boolean hasNext() {
		return (positionCourante < titulaires.size() + remplacants.size());
	}

	@Override
	public Joueur next() {
		Joueur j = null;
		if (positionCourante < titulaires.size())
		{
			j = titulaires.get(positionCourante);
		}
		else
		{
			j = remplacants.get(positionCourante - titulaires.size());
		}
		positionCourante++;
		return j;
	}

	
	
}
