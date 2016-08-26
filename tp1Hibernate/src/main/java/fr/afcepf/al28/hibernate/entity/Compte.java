package fr.afcepf.al28.hibernate.entity;

import java.util.Set;

public class Compte {

	private Integer numero;
	private String libelle;
	private Personne personne;
	private Set<Operation> operations;
	
	public Compte() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Compte(Integer numero, String libelle, Personne personne) {
		super();
		this.numero=numero;
		this.libelle = libelle;
		this.personne = personne;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public Personne getPersonne() {
		return personne;
	}


	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	

	public Set<Operation> getOperations() {
		return operations;
	}


	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}


	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", libelle=" + libelle + "]";
	}




}
