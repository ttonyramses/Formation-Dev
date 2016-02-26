package Racine;



import java.math.BigDecimal;


public class Racine {

	private static Integer precision=2;
	
	public static BigDecimal racineCarree(BigDecimal number){
		
		BigDecimal a=new BigDecimal(1);
		BigDecimal as=a.add(number.divide(a)).divide(new BigDecimal(2));
		BigDecimal p=new BigDecimal(1).divide(( new BigDecimal(10).pow(2)));
		
		
		int i=0;
		//tant (a0+N/a0)/2 -a0 < precision on refait le calcul
		do
		{
			a=as;
			as=a.add(
					number.divide(
							a, precision, BigDecimal.ROUND_HALF_DOWN)
								).divide(
										new BigDecimal(2));
			
			System.out.println(a+"="+a+" as="+as+" delta="+a.subtract(as));
			i++;
		}while(a.subtract(as).compareTo(p)>0);
		
		System.out.println("Rang de l’itération = "+i);
		return as;
	}
	
	public static BigDecimal racineCarree(BigDecimal number,int pre){
		
		BigDecimal a=new BigDecimal(1);
		BigDecimal as=a.add(number.divide(a)).divide(new BigDecimal(2));
		BigDecimal p=new BigDecimal(1).divide(( new BigDecimal(10).pow(pre)));
		
		
		int i=0;
		//tant (a0+N/a0)/2 -a0 < precision on refait le calcul
		do
		{
			a=as;
			as=a.add(
					number.divide(
							a, pre, BigDecimal.ROUND_HALF_DOWN)
								).divide(
										new BigDecimal(2));
			
			System.out.println(a+"="+a+" as="+as+" delta="+a.subtract(as));
			i++;
		}while(a.subtract(as).compareTo(p)>0);
		
		System.out.println("Rang de l’itération = "+i);
		return as;
	}
	
	public static void main(String[] args){
		
		System.out.printf("Racine carre de 2=%.4f",racineCarree(new BigDecimal(2),4));
	}
}
