package fr.afcepf.al28.web.mbean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class GeneralMBean {

	private Date date;
	private String pays;
	private List<String> listePays=Arrays.asList("France","Allemagne","Cameroun","Gabon","Togo","Senegal","Finlande","Trinide","Cambodge");

	public GeneralMBean() {
		// TODO Auto-generated constructor stub
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public List<String> completePays(String p){
		List<String> suggestions = new ArrayList<String>();
		//String uP = p.substring(0, 1).toUpperCase();
		//if(p.length()>1) uP+=p.substring(1);
		for(String s : listePays){
			if(s.toUpperCase().startsWith(p.toUpperCase()))
				suggestions.add(s);
		} return suggestions;
	}

}
