import exoStrategy.CanardPlastique;
import exoStrategy.Mandarin;

public class Test {

	public static void main(String[] args) {
		
		Mandarin m = new Mandarin();
		CanardPlastique p = new CanardPlastique();
		
		m.effectuerVol();
		p.effectuerVol();
		
		m.couperAiles();
		
		m.effectuerVol();
	}

}
