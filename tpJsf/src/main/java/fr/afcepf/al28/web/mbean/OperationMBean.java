package fr.afcepf.al28.web.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;

import fr.afcepf.al28.data.Operation;

@ManagedBean
@RequestScoped
public class OperationMBean {

	private Long numCmpt;





	private List<Operation> operations;
	
	
	public OperationMBean() {
		// TODO Auto-generated constructor stub
	}


	public Long getNumCmpt() {
		return numCmpt;
	}


	public void setNumCmpt(Long numCmpt) {
		this.numCmpt = numCmpt;
	}


	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	public String recupererOperation(){
		String suite="operations";
		
		chargerOperations();

		
		return suite;
		
	}
	
	//Initialisation "preRenderVie" en mode GET:
	public void initOperations(ComponentSystemEvent event){
		chargerOperations();
	}
	
	public void chargerOperations(){
		
		this.operations=new ArrayList<Operation>(0);
		this.operations.add(new Operation("op 1 (paye) du compte N° "+this.numCmpt, 2500.0));
		this.operations.add(new Operation("op 2 (achat) du compte N° "+this.numCmpt, -1500.0));
		
	}
	
	public void onChangementCompteSelectionne(ValueChangeEvent event)
	{
		this.numCmpt=(Long)event.getNewValue();
		chargerOperations();

	}

	
	
}
