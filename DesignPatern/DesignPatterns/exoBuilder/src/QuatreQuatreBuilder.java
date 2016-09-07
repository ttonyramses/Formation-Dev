
import java.util.*;

/**
 * 
 */
public class QuatreQuatreBuilder extends VoitureBuilder {

    /**
     * Default constructor
     */
    public QuatreQuatreBuilder() {
    }

    /**
     * 
     */
    @Override
    public void definirChassis()
    {
    	this.voiture.setChassis("Chassis de chasseur");
    }

    /**
     * 
     */
    @Override
    public void definirMoteur()
    {
    	this.voiture.setMoteur("moteur de tracteur");    	
    }

    /**
     * 
     */
    @Override
    public void definirTransmission()
    {
    	this.voiture.setTransmission("intégrale");
    }

}