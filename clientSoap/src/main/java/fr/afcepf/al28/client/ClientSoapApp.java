package fr.afcepf.al28.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import fr.afcepf.al28.service.TvaService;
import fr.afcepf.al28.service.TvaServiceImplService;

public class ClientSoapApp {

	public ClientSoapApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try {
			
			String strUrl = "http://192.168.102.95:8080/springCxfWeb/services/tvaService?wsdl";
			URL wsdlUrl = new URL(strUrl);
			
			TvaService proxyWs = (new TvaServiceImplService(wsdlUrl)).getTvaServiceImplPort();
			
			
			javax.xml.ws.BindingProvider bp = (javax.xml.ws.BindingProvider) proxyWs;
			Map<String,Object> context = bp.getRequestContext();
			

			context.put(bp.ENDPOINT_ADDRESS_PROPERTY, strUrl);
			for(Object o : context.values()){
				System.out.println(o);
			}
			
			System.out.println("auteur = " + proxyWs.getAuteur());
			
			System.out.println(" pour ht=200 et taux 20%, tva=" + proxyWs.tva(200, 20));
			System.out.println(" pour ht=200 et taux 20%, ttc=" + proxyWs.ttc(200, 20));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}


	}

}
