package fr.afcepf.uml.employe;

import java.util.*;

/**
 * 
 */
public class TechnicienARisque extends Technicien implements ARisque {


	public TechnicienARisque(String nom, String prenom, int age, double nbUnite){
    	super(nom, prenom,age,nbUnite);
    }

    /**
     * @return
     */
    public String toString() {
    	return super.toString().replace("Technicien", "TechnicienARisque");
    }

    /**
     * @return
     */
    public double calculerSalaire() {
        // TODO implement here
    	return super.calculerSalaire()+PRIME;
    }

}