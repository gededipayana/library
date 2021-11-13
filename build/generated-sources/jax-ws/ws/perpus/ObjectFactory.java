
package ws.perpus;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.perpus package. 
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

    private final static QName _GetTanggal_QNAME = new QName("http://perpus.ws/", "getTanggal");
    private final static QName _GetTanggalHome_QNAME = new QName("http://perpus.ws/", "getTanggalHome");
    private final static QName _GetTanggalHomeResponse_QNAME = new QName("http://perpus.ws/", "getTanggalHomeResponse");
    private final static QName _GetTanggalKembaliSQL_QNAME = new QName("http://perpus.ws/", "getTanggalKembaliSQL");
    private final static QName _GetTanggalKembaliSQLResponse_QNAME = new QName("http://perpus.ws/", "getTanggalKembaliSQLResponse");
    private final static QName _GetTanggalResponse_QNAME = new QName("http://perpus.ws/", "getTanggalResponse");
    private final static QName _GetTanggalSQL_QNAME = new QName("http://perpus.ws/", "getTanggalSQL");
    private final static QName _GetTanggalSQLResponse_QNAME = new QName("http://perpus.ws/", "getTanggalSQLResponse");
    private final static QName _GetWaktu_QNAME = new QName("http://perpus.ws/", "getWaktu");
    private final static QName _GetWaktuResponse_QNAME = new QName("http://perpus.ws/", "getWaktuResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.perpus
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTanggal }
     * 
     */
    public GetTanggal createGetTanggal() {
        return new GetTanggal();
    }

    /**
     * Create an instance of {@link GetTanggalHome }
     * 
     */
    public GetTanggalHome createGetTanggalHome() {
        return new GetTanggalHome();
    }

    /**
     * Create an instance of {@link GetTanggalHomeResponse }
     * 
     */
    public GetTanggalHomeResponse createGetTanggalHomeResponse() {
        return new GetTanggalHomeResponse();
    }

    /**
     * Create an instance of {@link GetTanggalKembaliSQL }
     * 
     */
    public GetTanggalKembaliSQL createGetTanggalKembaliSQL() {
        return new GetTanggalKembaliSQL();
    }

    /**
     * Create an instance of {@link GetTanggalKembaliSQLResponse }
     * 
     */
    public GetTanggalKembaliSQLResponse createGetTanggalKembaliSQLResponse() {
        return new GetTanggalKembaliSQLResponse();
    }

    /**
     * Create an instance of {@link GetTanggalResponse }
     * 
     */
    public GetTanggalResponse createGetTanggalResponse() {
        return new GetTanggalResponse();
    }

    /**
     * Create an instance of {@link GetTanggalSQL }
     * 
     */
    public GetTanggalSQL createGetTanggalSQL() {
        return new GetTanggalSQL();
    }

    /**
     * Create an instance of {@link GetTanggalSQLResponse }
     * 
     */
    public GetTanggalSQLResponse createGetTanggalSQLResponse() {
        return new GetTanggalSQLResponse();
    }

    /**
     * Create an instance of {@link GetWaktu }
     * 
     */
    public GetWaktu createGetWaktu() {
        return new GetWaktu();
    }

    /**
     * Create an instance of {@link GetWaktuResponse }
     * 
     */
    public GetWaktuResponse createGetWaktuResponse() {
        return new GetWaktuResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTanggal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://perpus.ws/", name = "getTanggal")
    public JAXBElement<GetTanggal> createGetTanggal(GetTanggal value) {
        return new JAXBElement<GetTanggal>(_GetTanggal_QNAME, GetTanggal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTanggalHome }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://perpus.ws/", name = "getTanggalHome")
    public JAXBElement<GetTanggalHome> createGetTanggalHome(GetTanggalHome value) {
        return new JAXBElement<GetTanggalHome>(_GetTanggalHome_QNAME, GetTanggalHome.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTanggalHomeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://perpus.ws/", name = "getTanggalHomeResponse")
    public JAXBElement<GetTanggalHomeResponse> createGetTanggalHomeResponse(GetTanggalHomeResponse value) {
        return new JAXBElement<GetTanggalHomeResponse>(_GetTanggalHomeResponse_QNAME, GetTanggalHomeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTanggalKembaliSQL }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://perpus.ws/", name = "getTanggalKembaliSQL")
    public JAXBElement<GetTanggalKembaliSQL> createGetTanggalKembaliSQL(GetTanggalKembaliSQL value) {
        return new JAXBElement<GetTanggalKembaliSQL>(_GetTanggalKembaliSQL_QNAME, GetTanggalKembaliSQL.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTanggalKembaliSQLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://perpus.ws/", name = "getTanggalKembaliSQLResponse")
    public JAXBElement<GetTanggalKembaliSQLResponse> createGetTanggalKembaliSQLResponse(GetTanggalKembaliSQLResponse value) {
        return new JAXBElement<GetTanggalKembaliSQLResponse>(_GetTanggalKembaliSQLResponse_QNAME, GetTanggalKembaliSQLResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTanggalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://perpus.ws/", name = "getTanggalResponse")
    public JAXBElement<GetTanggalResponse> createGetTanggalResponse(GetTanggalResponse value) {
        return new JAXBElement<GetTanggalResponse>(_GetTanggalResponse_QNAME, GetTanggalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTanggalSQL }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://perpus.ws/", name = "getTanggalSQL")
    public JAXBElement<GetTanggalSQL> createGetTanggalSQL(GetTanggalSQL value) {
        return new JAXBElement<GetTanggalSQL>(_GetTanggalSQL_QNAME, GetTanggalSQL.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTanggalSQLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://perpus.ws/", name = "getTanggalSQLResponse")
    public JAXBElement<GetTanggalSQLResponse> createGetTanggalSQLResponse(GetTanggalSQLResponse value) {
        return new JAXBElement<GetTanggalSQLResponse>(_GetTanggalSQLResponse_QNAME, GetTanggalSQLResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWaktu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://perpus.ws/", name = "getWaktu")
    public JAXBElement<GetWaktu> createGetWaktu(GetWaktu value) {
        return new JAXBElement<GetWaktu>(_GetWaktu_QNAME, GetWaktu.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWaktuResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://perpus.ws/", name = "getWaktuResponse")
    public JAXBElement<GetWaktuResponse> createGetWaktuResponse(GetWaktuResponse value) {
        return new JAXBElement<GetWaktuResponse>(_GetWaktuResponse_QNAME, GetWaktuResponse.class, null, value);
    }

}
