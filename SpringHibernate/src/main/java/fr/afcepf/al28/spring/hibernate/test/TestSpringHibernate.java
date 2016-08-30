package fr.afcepf.al28.spring.hibernate.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al28.spring.hibernate.entity.Compte;
import fr.afcepf.al28.spring.hibernate.entity.Personne;
import fr.afcepf.al28.spring.hibernate.entity.IDao.IDaoPersonne;
import fr.afcepf.al28.spring.hibernate.entity.dao.DaoPersonne;
import fr.afcepf.al28.spring.hibernate.entity.dao.DaoPersonneTx;


public class TestSpringHibernate {

	private static Logger log=Logger.getLogger(TestSpringHibernate.class);

	public TestSpringHibernate() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){

		log.info("demarrage");

		BeanFactory bf=new ClassPathXmlApplicationContext("classpath:spring.xml");
		Personne p1=null,p2=null,p3=null;
		try {
			 p1= new Personne(null, "Tafeumewe", "Lynda", "Gabon - Port-Gentil", new SimpleDateFormat("yyyy-MM-dd").parse("1980-06-24"));
			 p2= new Personne(null, "Tafeumewe", "Joyce", "France - Rouen", new SimpleDateFormat("yyyy-MM-dd").parse("2014-03-29"));
			 p3= new Personne(null, "Tafeumewe", "Daniel", "France - Rouen", new SimpleDateFormat("yyyy-MM-dd").parse("2016-07-24"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		IDaoPersonne daoPersonne= bf.getBean(IDaoPersonne.class);
		
//		daoPersonne.ajouter(p1);
//		daoPersonne.ajouter(p2);
//		daoPersonne.ajouter(p3);
		List<Personne> personnes=daoPersonne.rechercher("Taf");
		
//		daoPersonne.supprimer(personnes.get(1));
//		daoPersonne.supprimer(personnes.get(2));
//		daoPersonne.supprimer(personnes.get(3));

		
		for(Personne p:personnes){
			log.info("Personne "+p);
			if(p.getComptes()!=null){
				
				for(Compte c:p.getComptes()){
					log.info("Compte "+c);
				}
			}
		}
	}

}
