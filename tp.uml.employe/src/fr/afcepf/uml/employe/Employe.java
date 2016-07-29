package fr.afcepf.uml.employe;

import java.util.*;

/**
 * 
 */
public abstract class Employe {

    /**
     * Default constructor
     */
    public Employe() {
    }
    
    public Employe(String nom, String prenom, int age){
    	this.nom=nom;
    	this.prenom=prenom;
    	this.age=age;
    }

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private String prenom;

    /**
     * 
     */
    public int age;

    /**
     * @return
     */
    public abstract double calculerSalaire();

	@Override
	public String toString() {
		return "Employe [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}


    

}