package exoSingleton;

public class MonThread extends Thread {

	public void run()
	{
		DistributeursTickets d1 = DistributeursTickets.getInstance();
	
		System.out.println(d1.getNumero());
		System.out.println(d1.getNumero());
		System.out.println(d1.getNumero());				
	}
	
}
