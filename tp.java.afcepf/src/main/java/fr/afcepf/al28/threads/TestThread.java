package fr.afcepf.al28.threads;

import java.util.Set;

public class TestThread {
	
	public static void main(String[] args){
		
		
		Thread t1=new Thread(new MyTask(6));
		Thread t2=new Thread(new MyTask(8));
		Thread t3=new Thread(new MyTask(9));
		Thread t4=new Thread(new MyTask(5));
		
		System.out.println("Suite immediate du main");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		
		for(Thread t: threadSet){
			System.out.println(t.getName()+" "+t.getState()+" "+t.getId());
		}
		
		System.out.println("fin du main");
		
		
	}

}
