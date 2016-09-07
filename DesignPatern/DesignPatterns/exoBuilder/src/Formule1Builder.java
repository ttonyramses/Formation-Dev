
import java.util.*;

/**
 * 
 */
public class Formule1Builder extends VoitureBuilder {

    /**
     * Default constructor
     */
    public Formule1Builder() {
    }

    /**
     * 
     */
    @Override
    public void definirChassis()
    {
    	this.voiture.setChassis("Chassis de compet'");
    }

    /**
     * 
     */
    @Override
    public void definirMoteur()
    {
    	this.voiture.setMoteur("moteur d'avion � r�action");    	
    }

    /**
     * 
     */
    @Override
    public void definirTransmission()
    {
    	this.voiture.setTransmission("propulsion");
    }

}