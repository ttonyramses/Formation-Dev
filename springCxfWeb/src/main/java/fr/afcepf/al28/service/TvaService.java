package fr.afcepf.al28.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

@WebService

public interface TvaService {
	
	public double tva(@WebParam(name="ht") double ht, 
			          @WebParam(name="tauxPct") double tauxPct);
	public double ttc(@WebParam(name="ht")double ht, 
			          @WebParam(name="tauxPct")double tauxPct);
	//Tva caclulerTva(@WebParam(name="ht")double ht, @WebParam(name="tauxPct")double tauxPct);
	public String getAuteur();

}
