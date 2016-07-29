package fr.afcepf.uml.employe;

import java.util.*;

/**
 * 
 */
public class Personnel {

    /**
     * Default constructor
     */
    public Personnel() {
    	employes=new HashSet();
    }

    /**
     * 
     */
    private Set<Employe> employes;

    /**
     * @param employe 
     * @return
     */
    public void ajouterEmploye(Employe employe) {
    	employes.add(employe);
    }

    /**
     * @return
     */
    public void calculerSalaires() {
    	for(Employe employe :employes){
    		System.out.println( employe.toString().replace("]",", salaire="+employe.calculerSalaire()+"]"));
    	}
    }

    
    public double salaireMoyen() {
        double moyenSalaire=0;
        
        for(Employe employe : employes){
        	moyenSalaire+=employe.calculerSalaire();
        }
        return moyenSalaire/employes.size();
    }

}