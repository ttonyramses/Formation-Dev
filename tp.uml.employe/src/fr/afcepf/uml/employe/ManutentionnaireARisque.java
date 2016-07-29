package fr.afcepf.uml.employe;

import java.util.*;

/**
 * 
 */
public class ManutentionnaireARisque extends Manutentionnaire implements ARisque {

    /**
     * Default constructor
     */
    public ManutentionnaireARisque(String nom, String prenom, int age, int nbHeures){
    	super(nom, prenom,age,nbHeures);
    }
    /**
     * @return
     */
    public String toString() {
        // TODO implement here
    	return super.toString().replace("Manutentionnaire", "ManutentionnaireARisque");
    }

    /**
     * @return
     */
    public double calculerSalaire() {
    	return super.calculerSalaire()+PRIME;
    }

}