
import java.util.*;

/**
 * 
 */
public class FacturationHandler extends CommandeHandler {

    /**
     * Default constructor
     */
    public FacturationHandler() {
    }

    /**
     * @param commande
     */
    public boolean specifique(Commande commande) {
        System.out.println("Facturation : Validation paiement");
        commande.setStatut("payée");
        return true;
    }

   
}