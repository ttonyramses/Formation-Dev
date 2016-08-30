package fr.afcepf.al28.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class B {

	private C c;
	
	
	public B() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String hello(){
		return c.helloSpring();
	}
	
	@Autowired
	public void setUnTruc(C c){
		this.c=c;
	}

}
