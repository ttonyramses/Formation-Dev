
import java.util.*;

/**
 * 
 */
public class Commande {

    /**
     * Default constructor
     */
    public Commande() {
    }

    
    
    public Commande(float prix) {
		super();
		this.statut = "en attente";
		this.prix = prix;
	}



	/**
     * 
     */
    private String statut;
    
    private float prix;
    
    private float reduction;

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public float getReduction() {
		return reduction;
	}

	public void setReduction(float reduction) {
		this.reduction = reduction;
	}
    
    

}