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
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.19 at 02:46:29 PM ART 
//


package org.mule.modules.quickbooks.online.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * VendorCredit is an AP transaction representing a credit from a third party for returned goods or services not rendered.
 * 
 * <p>Java class for VendorCredit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VendorCredit">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.intuit.com/sb/cdm/v2}CdmBase">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://www.intuit.com/sb/cdm/v2}VendorCreditHeader" minOccurs="0"/>
 *         &lt;element name="Line" type="{http://www.intuit.com/sb/cdm/v2}VendorCreditLine" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VendorCredit", propOrder = {
    "header",
    "line"
})
public class VendorCredit
    extends CdmBase
{

    @XmlElement(name = "Header")
    protected VendorCreditHeader header;
    @XmlElement(name = "Line")
    protected List<VendorCreditLine> line;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link VendorCreditHeader }
     *     
     */
    public VendorCreditHeader getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link VendorCreditHeader }
     *     
     */
    public void setHeader(VendorCreditHeader value) {
        this.header = value;
    }

    /**
     * Gets the value of the line property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the line property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VendorCreditLine }
     * 
     * 
     */
    public List<VendorCreditLine> getLine() {
        if (line == null) {
            line = new ArrayList<VendorCreditLine>();
        }
        return this.line;
    }

}
