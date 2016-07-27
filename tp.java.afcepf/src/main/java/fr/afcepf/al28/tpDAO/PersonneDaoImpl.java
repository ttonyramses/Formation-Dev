package fr.afcepf.al28.tpDAO;

import java.util.List;

public class PersonneDaoImpl extends GenericDaoImpl<Personne, Integer> implements PersonneDao{

	public PersonneDaoImpl() {
	}

	@Override
	public List<Personne> findAllPersonnes() {

		return dataList;
	}

}
