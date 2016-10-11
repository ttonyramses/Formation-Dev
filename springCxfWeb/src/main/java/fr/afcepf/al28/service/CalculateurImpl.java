/**
 * 
 */
package fr.afcepf.al28.service;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

/**
 * @author stagiaire
 *
 */
@WebService(endpointInterface="fr.afcepf.al28.service.Calculateur")
@Service
public class CalculateurImpl implements Calculateur {

	/**
	 * 
	 */
	public CalculateurImpl() {
	}

	@Override
	public double addition(double v1, double v2) {
		// TODO Auto-generated method stub
		return v1+v2;
	}

	@Override
	public double multiplication(double v1, double v2) {
		// TODO Auto-generated method stub
		return v1*v2;
	}


}
