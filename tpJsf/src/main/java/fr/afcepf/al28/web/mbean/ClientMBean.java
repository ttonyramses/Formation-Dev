package fr.afcepf.al28.web.mbean;

import java.util.List;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.afcepf.al28.data.Client;
import fr.afcepf.al28.data.Compte;

@ManagedBean
@SessionScoped
//@RequestScoped
public class ClientMBean { 

	private Long numero;
	private Client client;
	private List<Compte> comptes;

	public ClientMBean() {
		// TODO Auto-generated constructor stub
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public String identification(){
		String suite=null;
		//Simulation sans base de données
		client=new Client(this.numero, "Tafeumewe", "Tony", "20 rue max jacob 75013 Paris");


		if(numero ==null || numero<=0 || numero>9999){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("numero client invalide ","pas entre 1 et 9999"));
		}else{

			suite="espaceClient";
		}
		return suite;
	}
	
	public String recupererComptes(){
		
		String suite=null;
		
		comptes=new ArrayList(0);
		comptes.add(new Compte(1245l,"Courant",1235.5));
		comptes.add(new Compte(5246l,"Compte Livret A", 5500.50));
		comptes.add(new Compte(7564l,"Compte PEL", 15000.80));
		return suite;
		
	}

}
