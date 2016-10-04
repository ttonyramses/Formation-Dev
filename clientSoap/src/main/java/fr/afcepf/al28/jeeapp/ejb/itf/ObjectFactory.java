
package fr.afcepf.al28.jeeapp.ejb.itf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al28.jeeapp.ejb.itf package. 
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

    private final static QName _ConvertirResponse_QNAME = new QName("http://itf.ejb.jeeapp.al28.afcepf.fr/", "convertirResponse");
    private final static QName _GetListPaysPartageantDeviseResponse_QNAME = new QName("http://itf.ejb.jeeapp.al28.afcepf.fr/", "getListPaysPartageantDeviseResponse");
    private final static QName _RechercherDeviseResponse_QNAME = new QName("http://itf.ejb.jeeapp.al28.afcepf.fr/", "rechercherDeviseResponse");
    private final static QName _GetListPaysPartageantDevise_QNAME = new QName("http://itf.ejb.jeeapp.al28.afcepf.fr/", "getListPaysPartageantDevise");
    private final static QName _ToutesDevises_QNAME = new QName("http://itf.ejb.jeeapp.al28.afcepf.fr/", "toutesDevises");
    private final static QName _Convertir_QNAME = new QName("http://itf.ejb.jeeapp.al28.afcepf.fr/", "convertir");
    private final static QName _RechercherDevise_QNAME = new QName("http://itf.ejb.jeeapp.al28.afcepf.fr/", "rechercherDevise");
    private final static QName _ToutesDevisesResponse_QNAME = new QName("http://itf.ejb.jeeapp.al28.afcepf.fr/", "toutesDevisesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al28.jeeapp.ejb.itf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RechercherDeviseResponse }
     * 
     */
    public RechercherDeviseResponse createRechercherDeviseResponse() {
        return new RechercherDeviseResponse();
    }

    /**
     * Create an instance of {@link ConvertirResponse }
     * 
     */
    public ConvertirResponse createConvertirResponse() {
        return new ConvertirResponse();
    }

    /**
     * Create an instance of {@link GetListPaysPartageantDeviseResponse }
     * 
     */
    public GetListPaysPartageantDeviseResponse createGetListPaysPartageantDeviseResponse() {
        return new GetListPaysPartageantDeviseResponse();
    }

    /**
     * Create an instance of {@link RechercherDevise }
     * 
     */
    public RechercherDevise createRechercherDevise() {
        return new RechercherDevise();
    }

    /**
     * Create an instance of {@link ToutesDevisesResponse }
     * 
     */
    public ToutesDevisesResponse createToutesDevisesResponse() {
        return new ToutesDevisesResponse();
    }

    /**
     * Create an instance of {@link Convertir }
     * 
     */
    public Convertir createConvertir() {
        return new Convertir();
    }

    /**
     * Create an instance of {@link GetListPaysPartageantDevise }
     * 
     */
    public GetListPaysPartageantDevise createGetListPaysPartageantDevise() {
        return new GetListPaysPartageantDevise();
    }

    /**
     * Create an instance of {@link ToutesDevises }
     * 
     */
    public ToutesDevises createToutesDevises() {
        return new ToutesDevises();
    }

    /**
     * Create an instance of {@link DeviseDto }
     * 
     */
    public DeviseDto createDeviseDto() {
        return new DeviseDto();
    }

    /**
     * Create an instance of {@link PaysDto }
     * 
     */
    public PaysDto createPaysDto() {
        return new PaysDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertirResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.ejb.jeeapp.al28.afcepf.fr/", name = "convertirResponse")
    public JAXBElement<ConvertirResponse> createConvertirResponse(ConvertirResponse value) {
        return new JAXBElement<ConvertirResponse>(_ConvertirResponse_QNAME, ConvertirResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListPaysPartageantDeviseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.ejb.jeeapp.al28.afcepf.fr/", name = "getListPaysPartageantDeviseResponse")
    public JAXBElement<GetListPaysPartageantDeviseResponse> createGetListPaysPartageantDeviseResponse(GetListPaysPartageantDeviseResponse value) {
        return new JAXBElement<GetListPaysPartageantDeviseResponse>(_GetListPaysPartageantDeviseResponse_QNAME, GetListPaysPartageantDeviseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercherDeviseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.ejb.jeeapp.al28.afcepf.fr/", name = "rechercherDeviseResponse")
    public JAXBElement<RechercherDeviseResponse> createRechercherDeviseResponse(RechercherDeviseResponse value) {
        return new JAXBElement<RechercherDeviseResponse>(_RechercherDeviseResponse_QNAME, RechercherDeviseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListPaysPartageantDevise }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.ejb.jeeapp.al28.afcepf.fr/", name = "getListPaysPartageantDevise")
    public JAXBElement<GetListPaysPartageantDevise> createGetListPaysPartageantDevise(GetListPaysPartageantDevise value) {
        return new JAXBElement<GetListPaysPartageantDevise>(_GetListPaysPartageantDevise_QNAME, GetListPaysPartageantDevise.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ToutesDevises }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.ejb.jeeapp.al28.afcepf.fr/", name = "toutesDevises")
    public JAXBElement<ToutesDevises> createToutesDevises(ToutesDevises value) {
        return new JAXBElement<ToutesDevises>(_ToutesDevises_QNAME, ToutesDevises.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Convertir }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.ejb.jeeapp.al28.afcepf.fr/", name = "convertir")
    public JAXBElement<Convertir> createConvertir(Convertir value) {
        return new JAXBElement<Convertir>(_Convertir_QNAME, Convertir.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercherDevise }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.ejb.jeeapp.al28.afcepf.fr/", name = "rechercherDevise")
    public JAXBElement<RechercherDevise> createRechercherDevise(RechercherDevise value) {
        return new JAXBElement<RechercherDevise>(_RechercherDevise_QNAME, RechercherDevise.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ToutesDevisesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.ejb.jeeapp.al28.afcepf.fr/", name = "toutesDevisesResponse")
    public JAXBElement<ToutesDevisesResponse> createToutesDevisesResponse(ToutesDevisesResponse value) {
        return new JAXBElement<ToutesDevisesResponse>(_ToutesDevisesResponse_QNAME, ToutesDevisesResponse.class, null, value);
    }

}
