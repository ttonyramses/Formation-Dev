package fr.afcepf.al28.tpDAO;

import java.io.Serializable;
import java.util.List;

public interface PersonneDao extends GenericDao<Personne, Integer> {
	
	public List<Personne> findAllPersonnes();

}
