package fr.afcepf.al28.spring.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MonAspect {

	private Logger log = Logger.getLogger(MonAspect.class);
	
	@Before("execution(* fr..UneClasse.uneMethode(..))")
	public void testBeforeMethode(){
		log.info("avant la méthode");
	}
	
	@After("execution(* fr..UneClasse.uneMethode(..))")
	public void testAfterMethode(){
		log.info("après la méthode");
	}
	
	@Before("execution(* fr..UneClasse.*(..))")
	public void testBeforeAllMethode(JoinPoint jp){
		log.info("avant .. "+jp.getSignature().getName());
	}
	
	@AfterThrowing(pointcut="execution(* fr..UneClasse.*(..))", throwing="e")
	public void apresException(JoinPoint jp, Exception e){
		log.fatal("Exception sur "+jp.getSignature().getName()+"\t"+e.getMessage(),e);
	}
	
	@Around("execution(* fr..UneClasse.uneAutreMethode(..))")
	public Object aroundUneAutreMethode(ProceedingJoinPoint jp) throws Throwable{
		Object o=45455;
		
		jp.getArgs()[0]=(Integer.parseInt(jp.getArgs()[0].toString()))+1+ "";
		o =jp.proceed(jp.getArgs());
		return o;
	}

}
