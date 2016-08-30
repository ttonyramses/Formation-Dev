package fr.afcepf.al28.spring.aop.test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al28.spring.aop.UneClasse;;

public class TestSpringAop {

	private static Logger log =Logger.getLogger(TestSpringAop.class);

	public static void main(String[] args){
		
		BeanFactory bf=new ClassPathXmlApplicationContext("classpath:spring.xml");
		log.info("Dans la classe de test");
		
		UneClasse uneClasse= bf.getBean(UneClasse.class);
		
		String s= uneClasse.uneMethode(6);
		log.info("s = "+s);
		
		//uneClasse.methode();
		log.info(uneClasse.uneAutreMethode("120"));
	}
	

}
