package Pile;

public class PileVideException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PileVideException(){
		super();
	}
	
	public String getMessage(){
		return "Impossible de dépiler, La pile est déjà vide";
	}
	
	
}
