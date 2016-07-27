package fr.afcepf.al28.tp8;

public class SousCalcul {
	
	public double calculerRacine(double x) throws MyArithmeticException{
		
		if(x<0){
			throw new MyArithmeticException("Impossible de calculer la racine carré d'un nombre negative");
		}
		
		return Math.sqrt(x);
	}

}
