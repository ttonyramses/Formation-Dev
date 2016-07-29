package fr.afcepf.uml.employe;

import java.util.*;

/**
 * 
 */
public class Manutentionnaire extends Employe {

    /**
     * Default constructor
     */
    public Manutentionnaire(String nom, String prenom, int age, int nbHeures){
    	super(nom, prenom,age);
    	this.nbHeures=nbHeures;
    }

    /**
     * 
     */
    private int nbHeures;

    /**
     * 
     */
    public final static  double SALAIRE_HORAIRE=20;
    
    /**
     * @return
     */
    public String toString() {
    	return super.toString().replace("Employe", "Manutentionnaire").replaceAll("]", ", nbHeures="+nbHeures+"]");
    }

    /**
     * @return
     */
    public double calculerSalaire() {
        // TODO implement here
       return SALAIRE_HORAIRE*nbHeures;
    }

}