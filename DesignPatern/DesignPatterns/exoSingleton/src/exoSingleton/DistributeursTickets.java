package exoSingleton;

public class DistributeursTickets {

	static
	{
		instance = new DistributeursTickets();		
	}
	
	private int numeroCourant;
	
	public synchronized int getNumero()
	{
		return ++numeroCourant;
	}
	
	private static DistributeursTickets instance;
	
	private DistributeursTickets()
	{
		System.out.println("Constructeur du distributeur");
		numeroCourant = 0;		
	}
	
	public static DistributeursTickets getInstance()
	{
		return instance;
	}
	
}
