package fr.afcepf.al28.hibernate.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.afcepf.al28.hibernate.entity.Compte;
import fr.afcepf.al28.hibernate.entity.Operation;
import fr.afcepf.al28.hibernate.entity.Personne;
import fr.afcepf.al28.hibernate.util.HibernateUtil;

public class TestAssociations {

	private static Logger log=Logger.getLogger(TestAssociations.class);

	public static void main( String[] args){
		log.info("debut methode");
		Session session=null;
		Transaction tx=null;

		try {
			session = HibernateUtil.getSession();
			tx=session.beginTransaction();
			
			Compte cpt = (Compte) session.get(Compte.class, 1);
			log.info(cpt);

			Personne pers=cpt.getPersonne();
			log.info(pers);
			
			tx.commit();
		} catch (HibernateException e) {
			log.fatal("probleme lors de l'execution du traitement"+e.getMessage(),e);	
			tx.rollback();
		}finally{
			try {
				session.close();
			} catch (HibernateException e2) {
				log.fatal("probleme lors de l'execution du traitement"+e2.getMessage(),e2);		
			}

		}


		log.info("fin methode");
	}

}
