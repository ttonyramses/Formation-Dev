package fr.afcepf.al28.tpDAO;

import java.io.Serializable;

/**
 * 
 * @author stagiaire
 * DAO = Data Access Object
 *      avec methode CRUD = Create, Retrive, Update, Delete 
 *
 * @param <E> Type d'entité (Personne, Avion, ....)
 * @param <ID> Type de clef primaire (Integer, String, Long, ...)
 */
public interface GenericDao<E, ID extends Serializable> {
	
	E findEntity(ID id); // recherche par clef primaire
	boolean deleteEntity(E e); //suppression en base
	boolean insertEntity (E e); //insertion en base, return auto_incr id
	void updateEntity(E e); //update
}
