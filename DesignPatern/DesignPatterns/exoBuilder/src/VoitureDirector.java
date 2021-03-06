
import java.util.*;

/**
 * 
 */
public class VoitureDirector {

    /**
     * Default constructor
     */
    public VoitureDirector() {
    }

    /**
     * @param vb 
     * @return
     */
    public Voiture construct(VoitureBuilder vb) {
        
    	Voiture v = new Voiture();
    	
    	vb.setVoiture(v);
    	
    	vb.definirChassis();
    	vb.definirMoteur();
    	vb.definirTransmission();
    	
        return v;
    }

}