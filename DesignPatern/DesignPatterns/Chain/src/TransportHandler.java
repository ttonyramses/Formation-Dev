
import java.util.*;

/**
 * 
 */
public class TransportHandler extends CommandeHandler {

    /**
     * Default constructor
     */
    public TransportHandler() {
    }

    public boolean specifique(Commande commande) {
        System.out.println("Transport : Livrée");
        commande.setStatut("livrée");
        return true;
    }

 
}