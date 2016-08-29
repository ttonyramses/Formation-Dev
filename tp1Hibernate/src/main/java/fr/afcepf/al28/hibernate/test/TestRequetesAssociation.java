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

public class TestRequetesAssociation {
	private static Logger log=Logger.getLogger(TestRequetesAssociation.class);

	public TestRequetesAssociation() {
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


			String hqlString="SELECT op FROM Operation op "+
					"WHERE op.type='débit'"+
					"and op.compte.personne.id=1";
			List<Operation> result=session.createQuery(hqlString).list();

			for(Operation op:result){
				log.info("---------------------------------");
				log.info(op);
			}


			hqlString="SELECT pers.comptes FROM Personne pers "+
					"WHERE pers.id=1";
			List<Compte> result2=session.createQuery(hqlString).list();

			for(Compte cpt:result2){
				log.info("====================================");
				log.info(cpt);
			}


			tx.rollback();
		} catch (HibernateException e) {
			tx.rollback();
			log.fatal("probleme lors de l'execution du traitement"+e.getMessage(),e);	
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
