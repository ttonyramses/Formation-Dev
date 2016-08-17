package fr.afcepf.al28.model;

import java.util.ArrayList;
import java.util.List;

public class CalculEmprunt {
	
	private String sMontant;
	private String sDuree;
	private String sTauxAnnuel;
	
	private Double montant;
	private Integer duree;
	private Double tauxAnnuel;
	private List<String> msg;

	public CalculEmprunt() {
	}
	
	public CalculEmprunt(String sMontant, String sDuree, String sTauxAnnuel){
		this.sMontant=sMontant;
		this.sDuree=sDuree;
		this.sTauxAnnuel=sTauxAnnuel;
		msg= new ArrayList<String>();
		
		try{
			this.montant=Double.parseDouble(sMontant);
		}catch (NumberFormatException e) {
			msg.add("Montant '"+sMontant+"' doit être un nombre ");
		}
		
		try{
			this.duree=Integer.parseInt(sDuree);
		}catch (NumberFormatException e) {
			msg.add("Duree '"+sDuree+"' doit être un numerique entier ");
		}
		
		try{
			this.tauxAnnuel=Double.parseDouble(sTauxAnnuel);
		}catch (NumberFormatException e) {
			msg.add("Taux '"+sTauxAnnuel+"' doit être un nombre ");
		}
		
		if(montant!=null && montant<=0){
			msg.add("Veuillez saisir un montant  strictement supérieure à zero");
		}
		
		
		if(duree!=null && duree<=0){
			msg.add("Veuillez saisir une durée strictement supérieure à zero");
		}
		
		
		if(tauxAnnuel!=null && tauxAnnuel<=0){
			msg.add("Veuillez saisir un taux  strictement supérieure à zero");
		}
		
		
		
	}
	
	public CalculEmprunt(Double montant, Integer duree, Double tauxAnnuel) {
		this.montant=montant;
		this.duree=duree;
		this.tauxAnnuel=tauxAnnuel;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Double getTauxAnnuel() {
		return tauxAnnuel;
	}

	public void setTauxAnnuel(Double tauxAnnuel) {
		this.tauxAnnuel = tauxAnnuel;
	}
	
	public Double calculMensualite(){
		
		Double taux=tauxAnnuel/100/12;
		return montant*taux/(1-Math.pow(1+taux,-duree*12));
	}

	public List<String> getMsg() {
		return msg;
	}

	public void setMsg(List<String> msg) {
		this.msg = msg;
	}
	
	
	

}
