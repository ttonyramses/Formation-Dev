
import java.util.*;

/**
 * 
 */
public class VendeurHandler extends CommandeHandler {

    /**
     * Default constructor
     */
    public VendeurHandler() {
    }

    /**
     * @param commande 
     * @return
     */
    public boolean specifique(Commande commande) {
        
    	System.out.println("Vendeur : calcul réduc");
    	if (commande.getPrix() >= 100)
    	{
    		commande.setReduction(0.1f);
    	}
    	commande.setStatut("acceptée");
    	
        return true;
    }

  
}