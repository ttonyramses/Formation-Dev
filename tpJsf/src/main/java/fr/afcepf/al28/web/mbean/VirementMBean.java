package fr.afcepf.al28.web.mbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.afcepf.al28.data.Client;
import fr.afcepf.al28.data.Compte;

@ManagedBean
@RequestScoped
public class VirementMBean {

	@ManagedProperty(value="#{clientMBean}")

	private ClientMBean clientMBean;
	private Long cptExpNumero;
	private Long cptDestNumero;
	
	
	public Long getCptExpNumero() {
		return cptExpNumero;
	}

	public void setCptExpNumero(Long cptExpNumero) {
		this.cptExpNumero = cptExpNumero;
	}

	public Long getCptDestNumero() {
		return cptDestNumero;
	}

	public void setCptDestNumero(Long cptDestNumero) {
		this.cptDestNumero = cptDestNumero;
	}



	private Compte cptExp;
	private Compte cptDest;
	private Double montant;

	public VirementMBean() {
	}

	public VirementMBean(Compte cptExp, Compte cptDest, Double montant) {
		super();
		this.cptExp = cptExp;
		this.cptDest = cptDest;
		this.montant = montant;
	}

	public ClientMBean getClientMBean() {
		return clientMBean;
	}

	public void setClientMBean(ClientMBean clientMBean) {
		this.clientMBean = clientMBean;
	}

	public Compte getCptExp() {
		return cptExp;
	}

	public void setCptExp(Compte cptExp) {
		this.cptExp = cptExp;
	}

	public Compte getCptDest() {
		return cptDest;
	}

	public void setCptDest(Compte cptDest) {
		this.cptDest = cptDest;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}



	public String effectuerVirement(){
		String suite=null;
		
		
		
		Boolean viremmentPossible=true;
		
		for(Compte cpt: clientMBean.getComptes()){
			System.out.println(cpt.getNumero()+" "+cptExpNumero+"  "+cptDestNumero);
			if(cpt.getNumero().equals(cptExpNumero))
				cptExp=cpt;
			if(cpt.getNumero().equals(cptDestNumero))
				cptDest=cpt;
		}
		
		if(cptExp==null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez selectionner le compte expediteur "));
			System.out.println("Veuillez selectionner le compte expediteur ");
			viremmentPossible=false;
		}

		if(cptDest==null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez selectionner le compte destinataire "));
			viremmentPossible=false;
			System.out.println("Veuillez selectionner le compte Destinataire ");
		}

		if(cptExpNumero!=null && cptDestNumero!=null && cptExpNumero.equals(cptDestNumero)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Le compte destinaire doit être différent du compte expéditeur"));
			viremmentPossible=false;
			System.out.println("Le compte destinaire doit être différent du compte expéditeur");

		}
		
		if(montant==null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez saisir un montant"));
			viremmentPossible=false;
			System.out.println("Veuillez saisir un montant");

		}
				
		
		if(cptExp!=null && montant!=null && cptExp.getSolde()<montant){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Solde du compte insuffisant ","Veuillez selectionner un montant inférieur à "+cptExp.getSolde()));
			System.out.println("Solde du compte insuffisant ");

			viremmentPossible=false;
		}

		if(viremmentPossible){
			suite="espaceClient";
			cptExp.setSolde(cptExp.getSolde()-montant);
			cptDest.setSolde(cptDest.getSolde()+montant);
			System.out.println("Calcul effectuer");
		}
		
		System.out.println("viremmentPossible="+viremmentPossible);

		return suite;


	}

}
