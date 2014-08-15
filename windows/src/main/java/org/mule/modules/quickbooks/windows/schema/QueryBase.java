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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.intuit.com/sb/cdm/v2}GlobalParameterGroup" minOccurs="0"/>
 *         &lt;group ref="{http://www.intuit.com/sb/cdm/v2}IteratorParameterGroup" minOccurs="0"/>
 *         &lt;element name="IncludeTagElements" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="DeletedObjects" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryBase", propOrder = {
    "offeringId",
    "iteratorId",
    "startPage",
    "chunkSize",
    "includeTagElements"
})
@XmlSeeAlso({
    BOMComponentQuery.class,
    NameValueQuery.class,
    RecordCountQuery.class,
    CustomFieldDefinitionSetQuery.class,
    CustomFieldQuery.class,
    ItemGroupComponentQuery.class,
    CustomFieldDefinitionQuery.class,
    ExternalRoleQuery.class,
    JournalEntryQueryBase.class,
    TemplateRefMapQuery.class,
    TransactionQueryBase.class,
    ListQueryBase.class
})
public abstract class QueryBase implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "OfferingId")
    protected OfferingId offeringId;
    @XmlElement(name = "IteratorId")
    protected String iteratorId;
    @XmlElement(name = "StartPage")
    protected BigInteger startPage;
    @XmlElement(name = "ChunkSize")
    protected Integer chunkSize;
    @XmlElement(name = "IncludeTagElements")
    protected List<String> includeTagElements;
    @XmlAttribute(name = "DeletedObjects")
    protected Boolean deletedObjects;

    /**
     * Gets the value of the offeringId property.
     * 
     * @return
     *     possible object is
     *     {@link OfferingId }
     *     
     */
    public OfferingId getOfferingId() {
        return offeringId;
    }

    /**
     * Sets the value of the offeringId property.
     * 
     * @param value
     *     allowed object is
     *     {@link OfferingId }
     *     
     */
    public void setOfferingId(OfferingId value) {
        this.offeringId = value;
    }

    /**
     * Gets the value of the iteratorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIteratorId() {
        return iteratorId;
    }

    /**
     * Sets the value of the iteratorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIteratorId(String value) {
        this.iteratorId = value;
    }

    /**
     * Gets the value of the startPage property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStartPage() {
        return startPage;
    }

    /**
     * Sets the value of the startPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStartPage(BigInteger value) {
        this.startPage = value;
    }

    /**
     * Gets the value of the chunkSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getChunkSize() {
        return chunkSize;
    }

    /**
     * Sets the value of the chunkSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setChunkSize(Integer value) {
        this.chunkSize = value;
    }

    /**
     * Gets the value of the includeTagElements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includeTagElements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludeTagElements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIncludeTagElements() {
        if (includeTagElements == null) {
            includeTagElements = new ArrayList<String>();
        }
        return this.includeTagElements;
    }

    /**
     * Gets the value of the deletedObjects property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean getDeletedObjects() {
        if (deletedObjects == null) {
            return false;
        } else {
            return deletedObjects;
        }
    }

    /**
     * Sets the value of the deletedObjects property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeletedObjects(Boolean value) {
        this.deletedObjects = value;
    }

    /**
     * Sets the value of the includeTagElements property.
     * 
     * @param includeTagElements
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncludeTagElements(List<String> includeTagElements) {
        this.includeTagElements = includeTagElements;
    }

}