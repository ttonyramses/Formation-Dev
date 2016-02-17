package segment;

import java.util.List;
import java.util.ArrayList;

public class TestSegment {

	public static void main(String[] args) {
		
		if(args.length<3){
			System.out.println("Veuillez saisir au moins 3 entiers (extermité 1 et 2 du segment puis un ou plusieurs point) : Exemple");
			System.out.println(System.getProperty("sun.java.command").split(" ")[0]+" -5 4 2");
			System.exit(-1);
		}
		
		for(String arg : args){
			
			try{
				Integer.parseInt(arg);
			}catch(NumberFormatException e){
				System.out.println(arg+" n'est pas un entier, veuillez saisir un entier");
				System.exit(-1);
			}
		}
		
		Segment s=new Segment(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		System.out.println("Longeur du "+s+" : "+s.longueur());
		
		for(int k=2; k<args.length;k++){
			int pt=Integer.parseInt(args[k]);
			if(s.appartient(pt)){
				System.out.println(pt+" appartient au "+s);
			}else{
				System.out.println(pt+" n'appartient pas au "+s);
			}
		}
	}

}
