package fr.afcepf.al28.tp8;


public class ConsoleAppTp8 {

	public static void main(String[] args) {

		try{
			System.out.println("arg0="+args[0]);
			Double x=Double.parseDouble(args[0]);
			SousCalcul s= new SousCalcul();
			System.out.println(s.calculerRacine(x));
			
		}catch (ArrayIndexOutOfBoundsException ex){
			System.out.println("Vous n'avez pas mis des arguments");
			ex.printStackTrace();

		}catch (NumberFormatException ex){
			System.out.println("Veuuillez saisir un nombre correct");
			ex.printStackTrace();

		} catch (MyArithmeticException e) {
			System.out.println("Veuillez saisir un nombre positif");
			e.printStackTrace();
		}catch(Exception ex){
			System.out.println("Un autre problème");
			ex.printStackTrace();
		}
	}

}
