package fr.afcepf.al28.spring.controller;

import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al28.spring.hibernate.entity.IDao.IDaoPersonne;
import fr.afcepf.al28.spring.hibernate.entity.Compte;
import fr.afcepf.al28.spring.hibernate.entity.Personne;

@ManagedBean(name = "mbSpring")
@SessionScoped
public class SpringWebManagedBean {
	private Personne persInsert = new Personne();
	private List<Personne> personnes;
	private Set<Compte> comptesSelected;
	private Personne persSelected;
	// ici nom de l'instance (couplage fort)
	// en meme temps pas le choix!!
	@ManagedProperty(value = "#{daoPersonneTx}")
	private IDaoPersonne dao;
	public void ajouter() {
		persInsert = dao.ajouter(persInsert);
	}
	public void rechercher() {
		personnes = 
				dao.rechercher(persInsert.getNom());
		if(personnes.size() > 0) {
			persSelected = personnes.get(0);
			comptesSelected = persSelected.getComptes();
		}
	}
	public void afficherComptes(Personne pers) {
		comptesSelected = pers.getComptes();
	}
	
	public void setDao(IDaoPersonne dao) {
		this.dao = dao;
	}
	public Personne getPersInsert() {
		return persInsert;
	}
	public void setPersInsert(Personne persInsert) {
		this.persInsert = persInsert;
	}
	public List<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}
	public Set<Compte> getComptesSelected() {
		return comptesSelected;
	}
	public void setComptesSelected(Set<Compte> comptesSelected) {
		this.comptesSelected = comptesSelected;
	}
	public Personne getPersSelected() {
		return persSelected;
	}
	public void setPersSelected(Personne persSelected) {
		this.persSelected = persSelected;
	}
}
