package fr.afcepf.pronto.factories;

import fr.afcepf.pizzeria.Garniture;
import fr.afcepf.pizzeria.IPizzaFactory;
import fr.afcepf.pizzeria.Pate;
import fr.afcepf.pronto.garnitures.GarnitureHawai;
import fr.afcepf.pronto.pates.PateCheezy;

public class HawaiCheezyFactory implements IPizzaFactory {

	@Override
	public Pate creerPate() {
		
		return new PateCheezy();
	}

	@Override
	public Garniture creerGarniture() {
		return new GarnitureHawai();
	}

}
