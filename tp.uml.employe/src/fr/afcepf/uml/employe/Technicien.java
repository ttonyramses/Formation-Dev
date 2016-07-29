package fr.afcepf.uml.employe;

import java.util.*;

/**
 * 
 */
public class Technicien extends Employe {

    public Technicien(String nom, String prenom, int age, double nbUnite){
    	super(nom, prenom,age);
    	this.nbUnite=nbUnite;
    }

    /**
     * 
     */
    private double nbUnite;

    /**
     * 
     */
    public final int MULTIPLICATEUR=5;

    /**
     * @return
     */
    public String toString() {

    	return super.toString().replace("Employe", "Technicien").replaceAll("]", ", nbUnite="+nbUnite+"]");
    }

    /**
     * @return
     */
    public double calculerSalaire() {
        return nbUnite*MULTIPLICATEUR;
    }

}