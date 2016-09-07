package exoClone.clones;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException 
	{
		StormTrooper proto = new StormTrooper();
	
		ArrayList<Soldier> armee = new ArrayList<>();
		
		for(int i = 0; i < 100; i++)
		{
			armee.add(proto.clone());			
		}
		
		for(Soldier s : armee)
		{
			System.out.println(s);
		}
	}

}
