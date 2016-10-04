
package fr.afcepf.al28.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ttc complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propri�t� ht.
     * 
     */
    public double getHt() {
        return ht;
    }

    /**
     * D�finit la valeur de la propri�t� ht.
     * 
     */
    public void setHt(double value) {
        this.ht = value;
    }

    /**
     * Obtient la valeur de la propri�t� tauxPct.
     * 
     */
    public double getTauxPct() {
        return tauxPct;
    }

    /**
     * D�finit la valeur de la propri�t� tauxPct.
     * 
     */
    public void setTauxPct(double value) {
        this.tauxPct = value;
    }

}
