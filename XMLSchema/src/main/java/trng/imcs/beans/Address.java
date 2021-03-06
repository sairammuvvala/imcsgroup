//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.15 at 02:46:54 PM CDT 
//


package trng.imcs.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Address complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Address"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StreetNo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="StreetName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Zipcode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Address", namespace = "http://www.example.org/Address", propOrder = {
    "streetNo",
    "streetName",
    "zipcode"
})
public class Address {

    @XmlElement(name = "StreetNo")
    protected int streetNo;
    @XmlElement(name = "StreetName", required = true)
    protected String streetName;
    @XmlElement(name = "Zipcode", required = true)
    protected String zipcode;

    
    public Address() {
		super();
	}

	public Address(int streetNo, String streetName, String zipcode) {
		super();
		this.streetNo = streetNo;
		this.streetName = streetName;
		this.zipcode = zipcode;
	}

	/**
     * Gets the value of the streetNo property.
     * 
     */
    public int getStreetNo() {
        return streetNo;
    }

    /**
     * Sets the value of the streetNo property.
     * 
     */
    public void setStreetNo(int value) {
        this.streetNo = value;
    }

    /**
     * Gets the value of the streetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the value of the streetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetName(String value) {
        this.streetName = value;
    }

    /**
     * Gets the value of the zipcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Sets the value of the zipcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipcode(String value) {
        this.zipcode = value;
    }

}
