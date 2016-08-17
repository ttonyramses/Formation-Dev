package ecrireDouble;

public class EcrireDouble {

	
	public static String tronque(String nombre, int nbDecimal){
		
		int posit=nombre.indexOf(".");
		
		System.out.println("posit="+posit);
		if(posit>=0){
			return nombre.substring(0,posit+nbDecimal+1);
		}
		return nombre;
	}
	
	public static void main(String[] args) {
		
		System.out.println("nombre="+tronque(args[0], Integer.parseInt(args[1])));

	}

}
