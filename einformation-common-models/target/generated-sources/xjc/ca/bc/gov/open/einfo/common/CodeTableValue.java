//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.21 at 06:52:39 AM PDT 
//


package ca.bc.gov.open.einfo.common;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CodeTableValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CodeTableValue"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodeTableValue" type="{http://brooks/EInformation.Source.FormsLookupServices.ws.provider:CodeTableValues}CodeTableValue2"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodeTableValue", propOrder = {
    "codeTableValue"
})
public class CodeTableValue
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "CodeTableValue", required = true, nillable = true)
    protected CodeTableValue2 codeTableValue;

    /**
     * Gets the value of the codeTableValue property.
     * 
     * @return
     *     possible object is
     *     {@link CodeTableValue2 }
     *     
     */
    public CodeTableValue2 getCodeTableValue() {
        return codeTableValue;
    }

    /**
     * Sets the value of the codeTableValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeTableValue2 }
     *     
     */
    public void setCodeTableValue(CodeTableValue2 value) {
        this.codeTableValue = value;
    }

}
