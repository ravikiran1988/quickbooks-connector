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
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdvancedReportQuery complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdvancedReportQuery">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.intuit.com/sb/cdm/v2}AdvReportParamBase"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdvancedReportQuery", propOrder = {
    "advReportParamBase"
})
public class AdvancedReportQuery
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElementRef(name = "AdvReportParamBase", namespace = "http://www.intuit.com/sb/cdm/v2", type = JAXBElement.class)
    protected JAXBElement<? extends AdvReportParamBase> advReportParamBase;

    /**
     * Gets the value of the advReportParamBase property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CustomTxnDetail }{@code >}
     *     {@link JAXBElement }{@code <}{@link Summary1099 }{@code >}
     *     {@link JAXBElement }{@code <}{@link SalesByCustomerSummary }{@code >}
     *     {@link JAXBElement }{@code <}{@link BalanceSheetStd }{@code >}
     *     {@link JAXBElement }{@code <}{@link SalesByItemSummary }{@code >}
     *     {@link JAXBElement }{@code <}{@link AdvReportParamBase }{@code >}
     *     
     */
    public JAXBElement<? extends AdvReportParamBase> getAdvReportParamBase() {
        return advReportParamBase;
    }

    /**
     * Sets the value of the advReportParamBase property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CustomTxnDetail }{@code >}
     *     {@link JAXBElement }{@code <}{@link Summary1099 }{@code >}
     *     {@link JAXBElement }{@code <}{@link SalesByCustomerSummary }{@code >}
     *     {@link JAXBElement }{@code <}{@link BalanceSheetStd }{@code >}
     *     {@link JAXBElement }{@code <}{@link SalesByItemSummary }{@code >}
     *     {@link JAXBElement }{@code <}{@link AdvReportParamBase }{@code >}
     *     
     */
    public void setAdvReportParamBase(JAXBElement<? extends AdvReportParamBase> value) {
        this.advReportParamBase = ((JAXBElement<? extends AdvReportParamBase> ) value);
    }

}