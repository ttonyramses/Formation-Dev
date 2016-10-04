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
@WebService(endpointInterface="fr.afcepf.al28.service.TvaService")
@Service
public class TvaServiceImpl implements TvaService {

	/**
	 * 
	 */
	public TvaServiceImpl() {
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al28.service.TvaService#tva(double, double)
	 */
	@Override
	public double tva(double ht, double tauxPct) {
		System.out.println("enter tva ht = "+ht+" tauxPct = "+tauxPct);
		System.out.println("reurn tva (ht * tauxPct / 100) = "+(ht * tauxPct / 100));
		return ht * tauxPct / 100;
	}
	
	

	/* (non-Javadoc)
	 * @see fr.afcepf.al28.service.TvaService#ttc(double, double)
	 */
	@Override
	public double ttc(double ht, double tauxPct) {
		System.out.println("enter ttc ht = "+ht+" tauxPct = "+tauxPct);
		System.out.println("return ttc ht * ( 1+ tauxPct / 100) = "+(ht * ( 1+ tauxPct / 100)));
		return ht * ( 1+ tauxPct / 100);
	}
	
	@Override
	public String getAuteur(){
		return "Tony Tafeumewe";
	}

}
