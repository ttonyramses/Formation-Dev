package fr.afcepf.al28.spring.hibernate.entity.IDao;

import java.util.List;

import fr.afcepf.al28.spring.hibernate.entity.Compte;

public interface IDaoCompte {

	Compte ajouter(Compte cpt);
	Boolean supprimer(Compte cpt);
	List<Compte> rechercher(String nom);
	Compte get(Integer numero);
}
