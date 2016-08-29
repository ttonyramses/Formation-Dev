package fr.afcepf.al28.hibernate.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.afcepf.al28.hibernate.heritage.Etudiant;
import fr.afcepf.al28.hibernate.heritage.Formateur;
import fr.afcepf.al28.hibernate.util.HibernateUtil;

public class TestHeritage {

	private static Logger log=Logger.getLogger(TestHeritage.class);

	public static void main( String[] args){
		Session session=null;
		Transaction tx=null;
		
		Formateur f1=new Formateur(null, "Java", "Sebastien", "Malakoff", new Date(), 3500d);
		Etudiant e1=new Etudiant(null, "Tafeumewe", "Tony", "Sotteville les rouen", new Date(), "Achitecte Logiciel");

		
		try {
			session = HibernateUtil.getSession();
			tx=session.beginTransaction();

			session.save(f1);
			session.save(e1);
			
			tx.commit();
		} catch (Exception e) {
			log.fatal("probleme lors de l'execution du traitement"+e.getMessage(),e);	
			tx.rollback();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				log.fatal("probleme lors de l'execution du traitement"+e2.getMessage(),e2);		
			}

		}


		log.info("fin methode");
	}

}
