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
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 			
 * 			Product: QBW 
 * 			Description: Specifies the CustomFieldDefinition that can be defined to a CDM to add additional columns dynamically on a existing CDM entities, this object is not extended from CdmBase as it is considered as definition that can be manipulated by specifying the definition ID 
 * 			
 * 
 * <p>Java class for CustomFieldDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomFieldDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.intuit.com/sb/cdm/v2}CdmObject">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.intuit.com/sb/cdm/v2}IdType" minOccurs="0"/>
 *         &lt;element name="SyncToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CdmType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Hidden" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Required" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SetName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SetId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomFieldDefinition", propOrder = {
    "id",
    "syncToken",
    "cdmType",
    "name",
    "hidden",
    "required",
    "setName",
    "setId"
})
@XmlSeeAlso({
    BooleanTypeCustomFieldDefinition.class,
    StringTypeCustomFieldDefinition.class,
    DateTypeCustomFieldDefinition.class,
    NumberTypeCustomFieldDefinition.class
})
public abstract class CustomFieldDefinition
    extends CdmObject
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Id")
    protected IdType id;
    @XmlElement(name = "SyncToken")
    protected String syncToken;
    @XmlElement(name = "CdmType")
    protected String cdmType;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Hidden", defaultValue = "false")
    protected Boolean hidden;
    @XmlElement(name = "Required", defaultValue = "false")
    protected Boolean required;
    @XmlElement(name = "SetName")
    protected String setName;
    @XmlElement(name = "SetId")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger setId;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link IdType }
     *     
     */
    public IdType getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdType }
     *     
     */
    public void setId(IdType value) {
        this.id = value;
    }

    /**
     * Gets the value of the syncToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSyncToken() {
        return syncToken;
    }

    /**
     * Sets the value of the syncToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSyncToken(String value) {
        this.syncToken = value;
    }

    /**
     * Gets the value of the cdmType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdmType() {
        return cdmType;
    }

    /**
     * Sets the value of the cdmType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdmType(String value) {
        this.cdmType = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the hidden property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getHidden() {
        return hidden;
    }

    /**
     * Sets the value of the hidden property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHidden(Boolean value) {
        this.hidden = value;
    }

    /**
     * Gets the value of the required property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getRequired() {
        return required;
    }

    /**
     * Sets the value of the required property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequired(Boolean value) {
        this.required = value;
    }

    /**
     * Gets the value of the setName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSetName() {
        return setName;
    }

    /**
     * Sets the value of the setName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSetName(String value) {
        this.setName = value;
    }

    /**
     * Gets the value of the setId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSetId() {
        return setId;
    }

    /**
     * Sets the value of the setId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSetId(BigInteger value) {
        this.setId = value;
    }

}