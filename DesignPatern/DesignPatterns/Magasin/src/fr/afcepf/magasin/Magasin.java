package fr.afcepf.magasin;

import java.util.ArrayList;

import fr.afcepf.magasin.articles.Article;

public class Magasin {

	private ArrayList<Article> catalogue = new ArrayList<>();
	
	public void ajouter(Article a)
	{
		catalogue.add(a);
	}
	
	public void afficherCatalogue()
	{
		for (Article a : catalogue)
		{
			System.out.println(a.getLibelle() + " - " + a.getPrix());
		}
		
	}

}
