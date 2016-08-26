package fr.afcepf.al28.hibernate.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.afcepf.al28.hibernate.entity.Compte;
import fr.afcepf.al28.hibernate.entity.Operation;
import fr.afcepf.al28.hibernate.entity.Personne;
import fr.afcepf.al28.hibernate.util.HibernateUtil;

public class TestRequetes {
	private static Logger log=Logger.getLogger(TestRequetes.class);

	public TestRequetes() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		
		log.info("debut methode");
		Session session=null;
		Transaction tx=null;

		try {
			session = HibernateUtil.getSession();
			tx=session.beginTransaction();
			
			log.info("Exemple de SQL en Hibernate");
			String reqSelect="SELECT id, nom, prenom, adresse, naissance FROM personne";
			
			Query sql=session.createSQLQuery(reqSelect);
			List<Object[]> result =sql.list();
			
			for(Object[] obj:result){
				log.info("\n"+obj[0]+"\n"+obj[1]+"\n"+obj[2]+"\n"+obj[3]+"\n");
				log.info("================================");
			}
			
			log.info("Exemple de HQL en Hibernate");
			List<Personne> result2=session.createQuery("from Personne").list();
			
			for(Personne pers:result2){
				log.info(pers);
			}
			
			Query hql=session.createQuery("from Personne p where p.nom = :nom");
			hql.setParameter("nom", "Tafeumewe");
			result2=hql.list();
			
			log.info("================================");
			for(Personne pers:result2){
				log.info(pers);
				
				if(pers.getComptes()!=null)
				for(Compte cpt : pers.getComptes()){
					log.info("--------------------------------");
					log.info(cpt);
					
					if(cpt!=null && cpt.getOperations()!=null)
					for(Operation op:cpt.getOperations()){
						log.info("###################################");
						log.info(op);
					}
				}
			}


			
			tx.rollback();
		} catch (HibernateException e) {
			tx.rollback();
			log.fatal("probleme lors de l'execution du traitement"+e.getMessage(),e);	
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
