package exoStrategy;

import exoStrategy.strategies.VolImpossible;

public class CanardPlastique extends Canard 
{
	public CanardPlastique() 
	{
		this.strategieVol = new VolImpossible();
	}
}
