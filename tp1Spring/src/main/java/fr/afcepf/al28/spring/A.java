package fr.afcepf.al28.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A {

	private B b;
	public A() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public void setMachin(B b){
		this.b=b;
	}
	
	public String test(){
		return b.hello();
	}

}
