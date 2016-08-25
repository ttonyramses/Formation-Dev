package fr.afcepf.al28.dom;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomXmlParser {

	public DomXmlParser() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try {
			InputStream is = Thread.currentThread().getContextClassLoader()
//					.getResourceAsStream("sans_namespace/produit.xml");
			.getResourceAsStream("avec_namespace/produit.xml");
			
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);

			DocumentBuilder parser = documentBuilderFactory.newDocumentBuilder();
			
			Document doc = parser.parse(is);
			
			Element racine=doc.getDocumentElement();
			
			System.out.println("num="+racine.getAttribute("num"));
			
			NodeList sousNoeuds=racine.getChildNodes();
			
			for(int i=0;i<sousNoeuds.getLength();i++){
				Node noeud= sousNoeuds.item(i);
				if(noeud.getNodeType()==Node.ELEMENT_NODE){
					Element noeudBalise=(Element) noeud;
					
					String texte=noeudBalise.getTextContent();
					String nomBalise=noeudBalise.getNodeName();
					System.out.println(nomBalise+" : "+texte);
				}
				
			}
			
			//V2 access direct via getElementByTagName
			System.out.println("***** Access direct via getElementByTagName() *****");
//			Element sousNoeudPrix = (Element) racine.getElementsByTagName("prix").item(0);
			Element sousNoeudPrix = (Element) doc.getElementsByTagNameNS("http://www.afcepf.fr/2016/produit", "prix").item(0);

			System.out.println("prix = "+sousNoeudPrix.getTextContent());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
