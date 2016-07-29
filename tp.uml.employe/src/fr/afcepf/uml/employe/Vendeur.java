package fr.afcepf.uml.employe;


/**
 * 
 */
public class Vendeur extends Commercial {

    public Vendeur(String nom, String prenom, int age, double caRealise){
    	super(nom, prenom, age, caRealise);
    	setTaux(0.2);
    }


    /**
     * @return
     */
    public String toString() {
        // TODO implement here
    	return super.toString().replace("Employe", "Vendeur").replace("]",", caRealise="+getCaRealise()+"]");
    }

}