package fr.afcepf.pronto.factories;

import fr.afcepf.pizzeria.Garniture;
import fr.afcepf.pizzeria.IPizzaFactory;
import fr.afcepf.pizzeria.Pate;
import fr.afcepf.pronto.garnitures.GarnitureLondon;
import fr.afcepf.pronto.pates.PateCheezy;

public class LondonCheezyFactory implements IPizzaFactory {

	@Override
	public Pate creerPate() {
		return new PateCheezy();
	}

	@Override
	public Garniture creerGarniture() {
		return new GarnitureLondon();
	}

}
