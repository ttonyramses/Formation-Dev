package fr.afcepf.al28.jaxb;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import fr.afcepf._2016.produit.ProduitType;
import fr.afcepf.al28.data.Client;

public class Jaxb2XmlParser {

	public Jaxb2XmlParser() {


	}
	
	public  static void main (String[] args){
		
		try{

			JAXBElement<ProduitType> produitElement=null;
			JAXBContext jctx=JAXBContext.newInstance("fr.afcepf._2016.produit");
			Unmarshaller um =jctx.createUnmarshaller();
			Marshaller m =jctx.createMarshaller();
			
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);			
			
			InputStream is = Thread.currentThread().getContextClassLoader()
					//				.getResourceAsStream("sans_namespace/produit.xml");
					.getResourceAsStream("avec_namespace/produit.xml");
			
			produitElement =(JAXBElement<ProduitType>) um.unmarshal(is);
			
			ProduitType produit=produitElement.getValue();
			
			System.out.println("prix="+produit.getPrix());
			System.out.println("numero="+produit.getNum());
			System.out.println("desciption="+produit.getDescription());
			
			fr.afcepf._2016.produit.ObjectFactory objFactory=new fr.afcepf._2016.produit.ObjectFactory();
			ProduitType produit2=objFactory.createProduitType();
			
			produit2.setDescription("Mon nouveau produit");
			produit2.setNum(BigInteger.valueOf(8));
			produit2.setPrix(BigDecimal.valueOf(20.99));
			
			JAXBElement<ProduitType> produitElement2 =objFactory.createProduit(produit2);
			
			m.marshal(produitElement2, new FileOutputStream("prod2.xml"));
			
			
			JAXBContext jctxBis=JAXBContext.newInstance(Client.class);
			Marshaller m2=jctxBis.createMarshaller();
			
			Client client=new Client("Tafeumewe", "Tony", "ttonyramses@gmail.com", 30, "1 rue benoit Malon 76300 sottevile-les-rouen");
			m2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m2.marshal(client, new FileOutputStream("client.xml"));
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	

}
