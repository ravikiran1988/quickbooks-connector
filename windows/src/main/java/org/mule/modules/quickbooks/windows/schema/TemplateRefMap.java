/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.08.15 at 05:31:44 PM GMT-03:00 
//


package org.mule.modules.quickbooks.windows.schema;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         Product: QBW
 *         Description: Mapping of the transaction to the template it is using for presentation. Temporary object, will be removed in the future once transactions reference the template natively.
 *       
 * 
 * <p>Java class for TemplateRefMap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TemplateRefMap">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.intuit.com/sb/cdm/v2}CdmBase">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://www.intuit.com/sb/cdm/v2}TemplateTypeEnum" minOccurs="0"/>
 *         &lt;element name="TxnId" type="{http://www.intuit.com/sb/cdm/v2}IdType" minOccurs="0"/>
 *         &lt;group ref="{http://www.intuit.com/sb/cdm/v2}TemplateReferenceGroup" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TemplateRefMap", propOrder = {
    "type",
    "txnId",
    "templateId",
    "templateName"
})
public class TemplateRefMap
    extends CdmBase
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Type")
    protected TemplateTypeEnum type;
    @XmlElement(name = "TxnId")
    protected IdType txnId;
    @XmlElement(name = "TemplateId")
    protected IdType templateId;
    @XmlElement(name = "TemplateName")
    protected String templateName;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link TemplateTypeEnum }
     *     
     */
    public TemplateTypeEnum getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemplateTypeEnum }
     *     
     */
    public void setType(TemplateTypeEnum value) {
        this.type = value;
    }

    /**
     * Gets the value of the txnId property.
     * 
     * @return
     *     possible object is
     *     {@link IdType }
     *     
     */
    public IdType getTxnId() {
        return txnId;
    }

    /**
     * Sets the value of the txnId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdType }
     *     
     */
    public void setTxnId(IdType value) {
        this.txnId = value;
    }

    /**
     * Gets the value of the templateId property.
     * 
     * @return
     *     possible object is
     *     {@link IdType }
     *     
     */
    public IdType getTemplateId() {
        return templateId;
    }

    /**
     * Sets the value of the templateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdType }
     *     
     */
    public void setTemplateId(IdType value) {
        this.templateId = value;
    }

    /**
     * Gets the value of the templateName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * Sets the value of the templateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateName(String value) {
        this.templateName = value;
    }

}