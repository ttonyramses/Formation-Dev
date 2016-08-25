//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.08.25 à 04:11:09 PM CEST 
//


package fr.afcepf._2016.produit;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf._2016.produit package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Produit_QNAME = new QName("http://www.afcepf.fr/2016/produit", "produit");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf._2016.produit
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProduitType }
     * 
     */
    public ProduitType createProduitType() {
        return new ProduitType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduitType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.afcepf.fr/2016/produit", name = "produit")
    public JAXBElement<ProduitType> createProduit(ProduitType value) {
        return new JAXBElement<ProduitType>(_Produit_QNAME, ProduitType.class, null, value);
    }

}
