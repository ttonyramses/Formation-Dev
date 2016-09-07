import fr.afcepf.pizzeria.Pizza;
import fr.afcepf.pizzeria.Pizzeria;
import fr.afcepf.pronto.factories.HawaiCheezyFactory;
import fr.afcepf.pronto.factories.LondonCheezyFactory;

public class Test {

	public static void main(String[] args) {

		Pizzeria p = new Pizzeria();

		Pizza p1 = p.creerPizza(new LondonCheezyFactory());
		Pizza p2 = p.creerPizza(new HawaiCheezyFactory());
		
	}

}
