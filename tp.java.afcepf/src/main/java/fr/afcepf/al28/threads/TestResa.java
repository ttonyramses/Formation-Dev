package fr.afcepf.al28.threads;

public class TestResa {

	public TestResa() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		MyStock stockCommun=new MyStock(8000);
		String[] tabSyncObject= new String[4];
		
		for(int i=0; i<4;i++){
			tabSyncObject[i]=new String("objSync"+i);
			ResaThread resa= new ResaThread(stockCommun);
			resa.setSyncObjet(tabSyncObject[i]);
			new Thread(resa).start();
		}
		
		for(int i=0;i<4;i++){
			synchronized (tabSyncObject[i]) {
				try {
					tabSyncObject[i].wait(200);
					System.out.println(Thread.currentThread().getName()+ " state : "+Thread.currentThread().getState()+" wait ");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("qte en stock après 4000 réservations : "+stockCommun.getQte());
		System.out.println("fin du main");
	}
	

}
