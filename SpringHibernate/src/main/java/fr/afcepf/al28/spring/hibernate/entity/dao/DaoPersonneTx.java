package fr.afcepf.al28.spring.hibernate.entity.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al28.spring.hibernate.entity.Compte;
import fr.afcepf.al28.spring.hibernate.entity.Personne;
import fr.afcepf.al28.spring.hibernate.entity.IDao.IDaoPersonne;

@Service
@Transactional
public class DaoPersonneTx implements IDaoPersonne {

	private SessionFactory sf;
	public DaoPersonneTx() {
		// TODO Auto-generated constructor stub
	}

	@Override
	
	public Personne ajouter(Personne pers) {
		try{
			pers=(Personne) sf.getCurrentSession().save(pers);
		}catch (Exception e){
			e.printStackTrace();
		}	
		
		return pers;
	}
	

	@Override
	public Boolean supprimer(Personne pers) {
		
		Boolean retour=false;
		try{
			sf.getCurrentSession().delete(pers);			
			retour=true;
			
		}catch (Exception e){
			e.printStackTrace();
		}
		return retour;
	}

	@Override
	public List<Personne> rechercher(String nom) {
		
		List<Personne> personnes=null;
		try{
			
			Query hql=sf.getCurrentSession().createQuery("SELECT DISTINCT(p) from Personne p left join fetch p.comptes where p.nom like :nom");
			hql.setParameter("nom", "%"+nom+"%");
			personnes= hql.list();

		}catch (Exception e){
			e.printStackTrace();
		}
		
		return personnes;
	}

	public SessionFactory getSf() {
		return sf;
	}

	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Personne get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
