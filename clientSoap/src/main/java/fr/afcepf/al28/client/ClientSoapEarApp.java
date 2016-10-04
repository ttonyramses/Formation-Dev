package fr.afcepf.al28.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import fr.afcepf.al28.jeeapp.ejb.impl.ServiceDevise;
import fr.afcepf.al28.jeeapp.ejb.impl.ServiceDeviseBeanService;

public class ClientSoapEarApp {

	public ClientSoapEarApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try {
			
			String strUrl = "http://localhost:8080/jeeapp-ejb-impl/ServiceDeviseBean?wsdl";
			URL wsdlUrl = new URL(strUrl);
			
			ServiceDevise proxyWs = (new ServiceDeviseBeanService(wsdlUrl)).getServiceDeviseBeanPort();
			
			
		/*	javax.xml.ws.BindingProvider bp = (javax.xml.ws.BindingProvider) proxyWs;
			Map<String,Object> context = bp.getRequestContext();
			

			context.put(bp.ENDPOINT_ADDRESS_PROPERTY, strUrl);
			for(Object o : context.values()){
				System.out.println(o);
			}*/
			
			System.out.println("Devise = " + proxyWs.rechercherDevise("Eur"));
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}


	}

}
