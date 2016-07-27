package fr.afcepf.al28.threads;

public class ResaThread implements Runnable {

	private MyStock stock;
	private String syncObjet;

	public ResaThread() {
	}

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName()+ " state : "+Thread.currentThread().getState()+" start run : debut boucle ");
		for(int i=0; i<1000;i++){
			synchronized(stock){

				stock.setQte(stock.getQte()-1);
			}
		}
		System.out.println(Thread.currentThread().getName()+ " state : "+Thread.currentThread().getState()+" start run : fin boucle ");

		if(syncObjet!=null){
			synchronized (syncObjet) {
				syncObjet.notify();
				System.out.println(Thread.currentThread().getName()+ " state : "+Thread.currentThread().getState()+" notify ");

			}
		}
	}

	public MyStock getStock() {
		return stock;
	}

	public void setStock(MyStock stock) {
		this.stock = stock;
	}

	public ResaThread(MyStock stock) {
		super();
		this.stock = stock;
	}

	public String getSyncObjet() {
		return syncObjet;
	}

	public void setSyncObjet(String syncObjet) {
		this.syncObjet = syncObjet;
	}



}
