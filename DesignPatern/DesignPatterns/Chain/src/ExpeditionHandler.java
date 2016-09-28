
import java.util.*;

/**
 * 
 */
public class ExpeditionHandler extends CommandeHandler {

    /**
     * Default constructor
     */
    public ExpeditionHandler() {
    }

    public boolean specifique(Commande commande) {
        System.out.println("Expédition : préparer colis");
        commande.setStatut("à expédier");
        return true;
    }

    
}