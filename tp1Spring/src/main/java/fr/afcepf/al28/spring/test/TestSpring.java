package fr.afcepf.al28.spring.test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al28.spring.A;

public class TestSpring {

	private static Logger log=Logger.getLogger(TestSpring.class);
	public TestSpring() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
			log.info("demarrage");
			
			BeanFactory bf=new ClassPathXmlApplicationContext("classpath:spring.xml");
		
		A a = (A) bf.getBean(A.class);
		//A a = (A) bf.getBean("beanA");
		
		log.info(a.test());
		log.info("fin du test");
		
//		ApplicationContext context=

	}

}
