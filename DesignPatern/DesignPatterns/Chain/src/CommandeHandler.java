
import java.util.*;

/**
 * 
 */
public abstract class CommandeHandler {

    /**
     * Default constructor
     */
    public CommandeHandler() {
    }

    /**
     * 
     */
    private CommandeHandler successeur;

    
    

    public CommandeHandler getSuccesseur() {
		return successeur;
	}

	public void setSuccesseur(CommandeHandler successeur) {
		this.successeur = successeur;
	}

	/**
     * @param commande
     */
    public void traiterCommande(Commande commande) {
        boolean estValide = this.specifique(commande);
        if (estValide && this.successeur != null)
        {
        	this.successeur.traiterCommande(commande);
        }
    }

    /**
     * @param commande 
     * @return
     */
    protected abstract boolean specifique(Commande commande);

}