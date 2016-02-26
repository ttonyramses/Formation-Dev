package Pile;


public class Pile3 implements Pile{

	Integer[] liste=new Integer[0];

	@Override
	public void empiler(Integer n) {
		Integer[] listeTmp=new Integer[liste.length+1];
		for(int i=0;i<liste.length;i++)
			listeTmp[i]=liste[i];
		listeTmp[liste.length]=n;
		liste=listeTmp;
		
	}

	@Override
	public int depiler() throws PileVideException {
		
		if(estVide()){
			throw new PileVideException();
		}
		int v=liste[liste.length-1];
		Integer[] listeTmp=new Integer[liste.length-1];
		for(int i=0;i<liste.length-1;i++)
			listeTmp[i]=liste[i];
		liste=listeTmp;
		return v;
		
	}
	
	public boolean estVide(){
		return liste.length==0;
	}

}
