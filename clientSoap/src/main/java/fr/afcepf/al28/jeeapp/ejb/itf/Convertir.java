
package fr.afcepf.al28.jeeapp.ejb.itf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour convertir complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="convertir">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="montant" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="devSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="devCible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "convertir", propOrder = {
    "montant",
    "devSource",
    "devCible"
})
public class Convertir {

    protected double montant;
    protected String devSource;
    protected String devCible;

    /**
     * Obtient la valeur de la propriété montant.
     * 
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Définit la valeur de la propriété montant.
     * 
     */
    public void setMontant(double value) {
        this.montant = value;
    }

    /**
     * Obtient la valeur de la propriété devSource.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevSource() {
        return devSource;
    }

    /**
     * Définit la valeur de la propriété devSource.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevSource(String value) {
        this.devSource = value;
    }

    /**
     * Obtient la valeur de la propriété devCible.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevCible() {
        return devCible;
    }

    /**
     * Définit la valeur de la propriété devCible.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevCible(String value) {
        this.devCible = value;
    }

}
