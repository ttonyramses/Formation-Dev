package fr.afcepf.pizzeria;

public class Pizzeria {

	public Pizza creerPizza(IPizzaFactory pf)
	{
		Pizza resultat = new Pizza();
		
		resultat.setPate(pf.creerPate());
		resultat.setGarniture(pf.creerGarniture());
		resultat.Cuire();
		
		return resultat;
	}
	
}
