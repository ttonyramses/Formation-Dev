package exoStrategy;

import exoStrategy.strategies.StrategieVol;
import exoStrategy.strategies.VolImpossible;

public class Canard 
{
	protected StrategieVol strategieVol;
	
	public void effectuerVol()
	{
		strategieVol.voler();
	}
	
	
	public void couperAiles()
	{
		this.strategieVol = new VolImpossible();
	}
	
	
}
