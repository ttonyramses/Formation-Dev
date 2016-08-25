package fr.afcepf.al28.dom;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomXmlValidationParser {
	static final String JAXP_SCHEMA_LANGUAGE =
			"http://java.sun.com/xml/jaxp/properties/schemaLanguage";
			static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
			static final String JAXP_SCHEMA_SOURCE =
					"http://java.sun.com/xml/jaxp/properties/schemaSource";
	public DomXmlValidationParser() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try {
			InputStream is = Thread.currentThread().getContextClassLoader()
//					.getResourceAsStream("sans_namespace/produit.xml");
			.getResourceAsStream("avec_namespace/commande.xml");
			
			InputStream isXsd = Thread.currentThread().getContextClassLoader()
//					.getResourceAsStream("sans_namespace/produit.xsd");
			.getResourceAsStream("avec_namespace/commande.xsd");
			
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);
			documentBuilderFactory.setValidating(true);
			
			documentBuilderFactory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
			documentBuilderFactory.setAttribute(JAXP_SCHEMA_SOURCE, isXsd);

			DocumentBuilder parser = documentBuilderFactory.newDocumentBuilder();
			
			Document doc = parser.parse(is);
			
			Element racine=doc.getDocumentElement();
			
			System.out.println("num="+racine.getAttribute("num"));
						
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
