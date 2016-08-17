package gestionEleves;

import java.util.ArrayList;

public class Eleve {
	
	private String nom;
	private ArrayList<Integer> listNotes=new ArrayList<Integer>(0);
	private double moyenne=0;
	
	
	
	public Eleve(String nom){
		this.nom=nom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public ArrayList<Integer> getListNotes() {
		return listNotes;
	}


	public void setListNotes(ArrayList<Integer> listNotes) {
		this.listNotes = listNotes;
	}


	public double getMoyenne() {
		return moyenne;
	}


	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}


	@Override
	public String toString() {
		return nom+" ("+ moyenne + ")";
	}
	
	public void ajouterNote(int note){
		if(note<0) note=0;
		if(note>20) note=20;
		
		int nbNotes = listNotes.size();
		
		listNotes.add(note);
		
		moyenne=((moyenne*nbNotes)+note)/(nbNotes+1);
		
	}
	
	

}
