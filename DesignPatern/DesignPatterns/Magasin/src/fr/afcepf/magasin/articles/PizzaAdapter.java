package fr.afcepf.magasin.articles;

import fr.afcepf.pizzeria.Pizza;

public class PizzaAdapter extends Article {

	private Pizza pizza;
	
	public PizzaAdapter(Pizza pizza)
	{
		super(12.5f, "PIZZA " + pizza.getGarniture());
		this.pizza = pizza;
	}
	
}
