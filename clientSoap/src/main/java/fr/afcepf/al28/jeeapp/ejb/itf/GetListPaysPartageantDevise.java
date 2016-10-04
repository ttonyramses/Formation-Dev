
package fr.afcepf.al28.jeeapp.ejb.itf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getListPaysPartageantDevise complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getListPaysPartageantDevise">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeDevise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getListPaysPartageantDevise", propOrder = {
    "codeDevise"
})
public class GetListPaysPartageantDevise {

    protected String codeDevise;

    /**
     * Obtient la valeur de la propriété codeDevise.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeDevise() {
        return codeDevise;
    }

    /**
     * Définit la valeur de la propriété codeDevise.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeDevise(String value) {
        this.codeDevise = value;
    }

}
