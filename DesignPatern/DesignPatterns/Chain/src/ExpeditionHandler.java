
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
        System.out.println("Exp�dition : pr�parer colis");
        commande.setStatut("� exp�dier");
        return true;
    }

    
}