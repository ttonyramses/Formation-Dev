package fr.afcepf.al28.spring.hibernate.entity.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al28.spring.hibernate.entity.Personne;
import fr.afcepf.al28.spring.hibernate.entity.IDao.IDaoPersonne;

//@Service
public class DaoPersonne implements IDaoPersonne {

	private SessionFactory sf;
	public DaoPersonne() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Personne ajouter(Personne pers) {
		Session session =null;
		Transaction tx = null;
		try{
			session=sf.openSession();
			tx= session.beginTransaction();
			
			session.save(pers);
			tx.commit();
			

		}catch (Exception e){
			tx.rollback();
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}		
		}
		return pers;
	}
	

	@Override
	public Boolean supprimer(Personne pers) {
		
		Session session =null;
		Transaction tx = null;
		Boolean retour=false;
		try{
			session=sf.openSession();
			tx= session.beginTransaction();
			
			session.delete(pers);
			retour=true;
			tx.commit();
			

		}catch (Exception e){
			tx.rollback();
			e.printStackTrace();
			retour=false;
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				retour=false;
			}		
		}
		return retour;
	}

	@Override
	public List<Personne> rechercher(String nom) {
		
		List<Personne> personnes=null;
		try{
			Session session=sf.openSession();
			
			Query hql=session.createQuery("from Personne p where p.nom = :nom");
			hql.setParameter("nom", nom);
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
