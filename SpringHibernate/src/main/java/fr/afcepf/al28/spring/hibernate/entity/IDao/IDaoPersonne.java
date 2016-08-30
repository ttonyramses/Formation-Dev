package fr.afcepf.al28.spring.hibernate.entity.IDao;

import java.util.List;

import fr.afcepf.al28.spring.hibernate.entity.Personne;

public interface IDaoPersonne {

	Personne ajouter(Personne pers);
	Boolean supprimer(Personne Pers);
	List<Personne> rechercher(String nom);
	Personne get (Integer id);
}
