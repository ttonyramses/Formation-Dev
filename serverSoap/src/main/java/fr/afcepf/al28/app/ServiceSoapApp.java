package fr.afcepf.al28.app;

import javax.xml.ws.Endpoint;

import fr.afcepf.al28.service.TvaService;
import fr.afcepf.al28.service.TvaServiceImpl;

public class ServiceSoapApp {


	public static void main(String[] args) {
		
		TvaService tvaService = new TvaServiceImpl();
		String wsEndPoint = "http://192.168.102.91:8081/serviceTva";
		System.out.println("Lancement du service");
		Endpoint.publish(wsEndPoint, tvaService);
		System.out.println("Lancement ok");

		System.out.println("Pause");
		try {
			Thread.sleep(10*60*1000); //10 minute
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("fin du service");
		System.exit(0);
	}

}
