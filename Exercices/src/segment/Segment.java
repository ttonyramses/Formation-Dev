package segment;

public class Segment {

	
	private int extr1;
	private int extr2;
	
	
	
	public Segment(int extr1, int extr2) {
		super();
		
		this.extr1 = extr1;
		this.extr2 = extr2;
		
		ordonne();
	}



	public int getExtr1() {
		return extr1;
	}



	public void setExtr1(int extr1) {
		this.extr1 = extr1;
	}



	public int getExtr2() {
		return extr2;
	}



	public void setExtr2(int extr2) {
		this.extr2 = extr2;
	}


	private void ordonne(){
		if(extr1>extr2){
			int tmp=extr1;
			this.extr1=extr2;
			extr2=tmp;
		}
	}
	
	public int longueur(){
		return extr2-extr1;
	}

	public boolean appartient(int x){
		return x>=extr1 && x<=extr2 ;
	}



	@Override
	public String toString() {
		return "segment [" + extr1 + ", " + extr2 + "]";
	}
	
}
