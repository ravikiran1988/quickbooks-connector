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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides the definition to store total hours worked by an employee during a specific Pay Period.
 * 
 * <p>Java class for PayrollEmployeeTimeTrackingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PayrollEmployeeTimeTrackingInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EmployeeId" type="{http://www.intuit.com/sb/cdm/v2}IdType" minOccurs="0"/>
 *         &lt;element name="PayPeriod" type="{http://www.intuit.com/sb/cdm/qbopayroll/v1}PayrollDateRange" minOccurs="0"/>
 *         &lt;element name="TotalHours" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PayrollEmployeeTimeTrackingInfo", namespace = "http://www.intuit.com/sb/cdm/qbopayroll/v1", propOrder = {
    "employeeId",
    "payPeriod",
    "totalHours"
})
public class PayrollEmployeeTimeTrackingInfo {

    @XmlElement(name = "EmployeeId")
    protected IdType employeeId;
    @XmlElement(name = "PayPeriod")
    protected PayrollDateRange payPeriod;
    @XmlElement(name = "TotalHours")
    protected Double totalHours;

    /**
     * Gets the value of the employeeId property.
     * 
     * @return
     *     possible object is
     *     {@link IdType }
     *     
     */
    public IdType getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the value of the employeeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdType }
     *     
     */
    public void setEmployeeId(IdType value) {
        this.employeeId = value;
    }

    /**
     * Gets the value of the payPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link PayrollDateRange }
     *     
     */
    public PayrollDateRange getPayPeriod() {
        return payPeriod;
    }

    /**
     * Sets the value of the payPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PayrollDateRange }
     *     
     */
    public void setPayPeriod(PayrollDateRange value) {
        this.payPeriod = value;
    }

    /**
     * Gets the value of the totalHours property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalHours() {
        return totalHours;
    }

    /**
     * Sets the value of the totalHours property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalHours(Double value) {
        this.totalHours = value;
    }

}
