package fr.afcepf.al28.threads;

public class MyTask implements Runnable {

	private int compteur;
	
	
	public MyTask() {
		compteur=5;
	}

	
	public MyTask(int compteur) {
		super();
		this.compteur = compteur;
	}


	public int getCompteur() {
		return compteur;
	}


	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}


	@Override
	public void run() {

		int i=compteur;
		
		while(i>0){
			//System.out.println(Thread.currentThread().getName()+" ---> "+i--+" "+Thread.currentThread().getState());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
