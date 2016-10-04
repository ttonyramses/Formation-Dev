package fr.afcepf.al28.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al28.data.TauxTva;
import fr.afcepf.al28.data.Tva;
import fr.afcepf.al28.service.TvaService;

@Component
@Path("/tva")
@Produces("application/json")
//@CrossOrigin
public class TvaServiceRestApdater {

	
	@Autowired //ou EJB ou Inject (CDI) TvaService internalService;
	private TvaService internalTvaService; //interface
	
	
	public TvaServiceRestApdater() {
		
	}
	
	@POST
	@Path("/taux")
	public TauxTva saveOrUpdateTauxTva(TauxTva t){
		System.out.println("tauxTva = "+t);
		return t;
	}
	
	@GET
	@Path("/auteur")
	@Produces("text/plain")
	public String getAuteur(){
		return internalTvaService.getAuteur();
	}

	@GET
	@Path("/calcul")
	public Tva calculer(@QueryParam("ht") double ht,
						@QueryParam("tauxPct") double tauxPct){
		Tva tvaRes=new Tva(ht,
				tauxPct, ht * tauxPct /100,
				ht * (1 + tauxPct / 100)
				);
		
		return tvaRes;
		
	}

	public TvaService getInternalTvaService() {
		return internalTvaService;
	}

	public void setInternalTvaService(TvaService internalTvaService) {
		this.internalTvaService = internalTvaService;
	}
	
}
