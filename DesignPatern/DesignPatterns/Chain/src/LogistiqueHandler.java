
import java.util.*;

/**
 * 
 */
public class LogistiqueHandler extends CommandeHandler {

    /**
     * Default constructor
     */
    public LogistiqueHandler() {
    }

    public boolean specifique(Commande commande) {
        System.out.println("Logistique : impact stock");
        commande.setStatut("stock impacté");
        return true;
    }

}