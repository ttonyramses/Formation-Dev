
package fr.afcepf.al28.jeeapp.ejb.itf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour paysDto complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="paysDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capitale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codePays" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="devise" type="{http://itf.ejb.jeeapp.al28.afcepf.fr/}deviseDto" minOccurs="0"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paysDto", propOrder = {
    "capitale",
    "codePays",
    "devise",
    "nom"
})
public class PaysDto {

    protected String capitale;
    protected String codePays;
    protected DeviseDto devise;
    protected String nom;

    /**
     * Obtient la valeur de la propriété capitale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapitale() {
        return capitale;
    }

    /**
     * Définit la valeur de la propriété capitale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapitale(String value) {
        this.capitale = value;
    }

    /**
     * Obtient la valeur de la propriété codePays.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodePays() {
        return codePays;
    }

    /**
     * Définit la valeur de la propriété codePays.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodePays(String value) {
        this.codePays = value;
    }

    /**
     * Obtient la valeur de la propriété devise.
     * 
     * @return
     *     possible object is
     *     {@link DeviseDto }
     *     
     */
    public DeviseDto getDevise() {
        return devise;
    }

    /**
     * Définit la valeur de la propriété devise.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviseDto }
     *     
     */
    public void setDevise(DeviseDto value) {
        this.devise = value;
    }

    /**
     * Obtient la valeur de la propriété nom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit la valeur de la propriété nom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

	@Override
	public String toString() {
		return "PaysDto [capitale=" + capitale + ", codePays=" + codePays + ", devise=" + devise + ", nom=" + nom + "]";
	}

    
}
