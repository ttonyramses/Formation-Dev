
import java.util.*;

/**
 * 
 */
public abstract class VoitureBuilder {

    /**
     * Default constructor
     */
    public VoitureBuilder() {
    }

    /**
     * 
     */
    protected Voiture voiture;

    /**
     * 
     */
    public abstract void definirChassis();

    /**
     * 
     */
    public abstract void definirMoteur();

    /**
     * 
     */
    public abstract void definirTransmission();

    /**
     * 
     */
    public void VoitureBuilder() {
        // TODO implement here
    }

}