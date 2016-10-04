
package fr.afcepf.al28.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ttc complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ttc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ht" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tauxPct" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ttc", propOrder = {
    "ht",
    "tauxPct"
})
public class Ttc {

    protected double ht;
    protected double tauxPct;

    /**
     * Obtient la valeur de la propriété ht.
     * 
     */
    public double getHt() {
        return ht;
    }

    /**
     * Définit la valeur de la propriété ht.
     * 
     */
    public void setHt(double value) {
        this.ht = value;
    }

    /**
     * Obtient la valeur de la propriété tauxPct.
     * 
     */
    public double getTauxPct() {
        return tauxPct;
    }

    /**
     * Définit la valeur de la propriété tauxPct.
     * 
     */
    public void setTauxPct(double value) {
        this.tauxPct = value;
    }

}
