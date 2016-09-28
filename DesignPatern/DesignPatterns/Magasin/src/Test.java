import fr.afcepf.magasin.Magasin;
import fr.afcepf.magasin.articles.Guitare;
import fr.afcepf.magasin.articles.PizzaAdapter;
import fr.afcepf.pizzeria.Pizza;
import fr.afcepf.pizzeria.Pizzeria;
import fr.afcepf.pronto.factories.HawaiCheezyFactory;

public class Test {

	public static void main(String[] args)
	{
		Magasin m = new Magasin();
		
		m.ajouter(new Guitare(2490, "Les Paul", "Gibson"));
		m.ajouter(new Guitare(1540, "Stratocaster", "Fender"));
		m.ajouter(new Guitare(2800, "HD28", "Martin"));
		
		Pizzeria p = new Pizzeria();
		Pizza p1 = p.creerPizza(new HawaiCheezyFactory());
		
		m.ajouter(new PizzaAdapter(p1));
		
		m.afficherCatalogue();
		
	}
	
}
