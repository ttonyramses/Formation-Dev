
import java.util.*;

/**
 * 
 */
public class BerlineBuilder extends VoitureBuilder {

    /**
     * Default constructor
     */
    public BerlineBuilder() {
    }

    /**
     * 
     */
    @Override
    public void definirChassis()
    {
    	this.voiture.setChassis("Chassis de base");
    }

    /**
     * 
     */
    @Override
    public void definirMoteur()
    {
    	this.voiture.setMoteur("moteur 16 soupapes");    	
    }

    /**
     * 
     */
    @Override
    public void definirTransmission()
    {
    	this.voiture.setTransmission("traction");
    }

}