
package fr.afcepf.al28.jeeapp.ejb.itf;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour deviseDto complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="deviseDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeDevise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listePays" type="{http://itf.ejb.jeeapp.al28.afcepf.fr/}paysDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="monnaie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tauxChange" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deviseDto", propOrder = {
    "codeDevise",
    "listePays",
    "monnaie",
    "tauxChange"
})
public class DeviseDto {

    protected String codeDevise;
    @XmlElement(nillable = true)
    protected List<PaysDto> listePays;
    protected String monnaie;
    protected Double tauxChange;

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

    /**
     * Gets the value of the listePays property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listePays property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListePays().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaysDto }
     * 
     * 
     */
    public List<PaysDto> getListePays() {
        if (listePays == null) {
            listePays = new ArrayList<PaysDto>();
        }
        return this.listePays;
    }

    /**
     * Obtient la valeur de la propriété monnaie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonnaie() {
        return monnaie;
    }

    /**
     * Définit la valeur de la propriété monnaie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonnaie(String value) {
        this.monnaie = value;
    }

    /**
     * Obtient la valeur de la propriété tauxChange.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTauxChange() {
        return tauxChange;
    }

    /**
     * Définit la valeur de la propriété tauxChange.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTauxChange(Double value) {
        this.tauxChange = value;
    }

	@Override
	public String toString() {
		return "DeviseDto [codeDevise=" + codeDevise + ", listePays=" + listePays + ", monnaie=" + monnaie
				+ ", tauxChange=" + tauxChange + "]";
	}
    
    
    
    

}
