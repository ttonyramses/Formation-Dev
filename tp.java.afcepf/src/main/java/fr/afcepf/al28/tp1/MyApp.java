package fr.afcepf.al28.tp1;

public class MyApp {

	public static void main(String[] args) {
		System.out.println("Hello Word");
		
		String s1=null;
		System.out.println("s1="+s1+" "+System.identityHashCode(s1));

		s1=new String("abc");
		
		System.out.println("s1="+s1+" "+System.identityHashCode(s1));
		s1="toto";
		System.out.println("s1="+s1+" "+System.identityHashCode(s1));

		String s2=new String("abc");
		System.out.println("s2="+s2+" "+System.identityHashCode(s2));
		
		int a=5;
		int b=6;
		String s3 = String.valueOf(a);
		System.out.println("s3="+s3+" "+System.identityHashCode(s3));
		
		System.out.println("a="+a+" "+System.identityHashCode(a));
		System.out.println("b="+b+" "+System.identityHashCode(b));
		
		Integer c=new Integer(5);
		Integer d=new Integer(6);
		
		System.out.println("c="+c+" "+System.identityHashCode(c));
		System.out.println("d="+d+" "+System.identityHashCode(d));

		c=d;
		System.out.println("c="+c+" "+System.identityHashCode(c));


		
		;
	}

}
