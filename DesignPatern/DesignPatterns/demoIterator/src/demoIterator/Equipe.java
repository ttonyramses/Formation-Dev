package demoIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Equipe 
		implements 	Iterable<Joueur>, 
					Iterator<Joueur> 
{
	private int positionCourante;
	
	private String nom;
	
	private ArrayList<Joueur> titulaires = new ArrayList<>();
	private ArrayList<Joueur> remplacants = new ArrayList<>();
	
	public Equipe()
	{
		this.nom = "Arsenal";
		
		titulaires.add(new Joueur("Lionel"));
		titulaires.add(new Joueur("Cristiano"));
		titulaires.add(new Joueur("Antoine"));
		titulaires.add(new Joueur("Franck"));
		titulaires.add(new Joueur("Samir"));
		remplacants.add(new Joueur("Nour"));
		remplacants.add(new Joueur("Nick"));
		remplacants.add(new Joueur("Florian"));		
	}

	@Override
	public Iterator<Joueur> iterator() {
		//return new EquipeIterator(titulaires, remplacants);
		positionCourante = 0;
		return this;
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
