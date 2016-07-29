package fr.afcepf.uml.employe;

import java.util.*;

/**
 * 
 */
public class Representant extends Commercial {

    public Representant(String nom, String prenom, int age, double caRealise){
    	super(nom, prenom, age, caRealise);
    	setTaux(0.2);
    }
    

    public String toString() {
        // TODO implement here
    	return super.toString().replace("Employe", "Representant").replace("]",", caRealise="+getCaRealise()+"]");
    }

}