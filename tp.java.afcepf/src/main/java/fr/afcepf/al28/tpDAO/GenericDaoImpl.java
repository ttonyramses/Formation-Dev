package fr.afcepf.al28.tpDAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class GenericDaoImpl<E, ID extends Serializable> implements GenericDao<E,ID> {


	protected List<E> dataList =new ArrayList<E> ();
	
	public E findEntity(ID id) {
		return null;
	}

	@Override
	public boolean deleteEntity(E e) {	
		return dataList.remove(e);
	}

	@Override
	public boolean insertEntity(E e) {
		
		return dataList.add(e);
		
	}

	@Override
	public void updateEntity(E e) {

	}


}
