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

public class PremierTestHibernate {

	private static Logger log=Logger.getLogger(PremierTestHibernate.class);

	public static void main( String[] args){
		log.info("debut methode");
		Session session=null;
		Transaction tx=null;

		try {
			session = HibernateUtil.getSession();
			tx=session.beginTransaction();

//			Personne pers=new Personne(null, "Storero", "Nicolas", "Montrouge", new Date());
//			session.save(pers);
//			tx.commit();
			
			
			//log.info(pers.getId());
			Personne pers2 =(Personne) session.get(Personne.class, 1);
			log.info("\nnom="+pers2.getNom()+"\nprenom="+pers2.getPrenom()+"\nadresse="+pers2.getAdresse());
			
			pers2.setAdresse("Rouen");
			
			Compte cpt=new Compte(null, "Compte Courant", pers2);
			session.save(cpt);
			
			Operation op1= new Operation(null, 1000d, "Crédit", cpt);
			Operation op2= new Operation(null, 20.99, "Débit", cpt);
			Operation op3= new Operation(null, 500d, "Virement", cpt);
			Operation op4= new Operation(null, 498.5, "Débit", cpt);
			
			session.save(op1);
			session.save(op2);
			session.save(op3);
			session.save(op4);
			
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
