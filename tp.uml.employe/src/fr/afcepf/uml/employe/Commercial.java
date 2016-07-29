package fr.afcepf.uml.employe;

import java.util.*;

/**
 * 
 */
public abstract class Commercial extends Employe {

    private double caRealise;
    private static double taux;


    /**
     * Default constructor
     */
    public Commercial() {
    }

    public Commercial(String nom, String prenom, int age,double caRealise){
    	super(nom, prenom, age);
    	this.caRealise=caRealise;
    }
    
    public double calculerSalaire(){
    	
    	return taux*caRealise;
    }
    
    public static void setTaux(double tx){
    	taux=tx;
    }

	public double getCaRealise() {
		return caRealise;
	}

	public void setCaRealise(double caRealise) {
		this.caRealise = caRealise;
	}
    
    
}