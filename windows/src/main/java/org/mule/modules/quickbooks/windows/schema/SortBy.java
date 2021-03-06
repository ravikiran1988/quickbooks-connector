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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for SortBy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SortBy">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="sortOrder" type="{http://www.intuit.com/sb/cdm/v2}sortOrder" default="Descending" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SortBy", propOrder = {
    "value"
})
@XmlSeeAlso({
    SortByColumnInventorySiteWithOrder.class,
    SortByColumnEmployeeWithOrder.class,
    SortByColumnSalesReceiptWithOrder.class,
    SortByColumnChargeWithOrder.class,
    SortByColumnDepositWithOrder.class,
    SortByColumnInventoryAdjustmentWithOrder.class,
    SortByColumnTaskWithOrder.class,
    SortByColumnEstimateWithOrder.class,
    SortByColumnNameDateWithOrder.class,
    SortByColumnAccountWithOrder.class,
    SortByColumnBuildAssemblyWithOrder.class,
    SortByColumnFixedAssetWithOrder.class,
    SortByColumnItemReceiptWithOrder.class,
    SortByColumnPayrollNonWageItemWithOrder.class,
    SortByColumnCreditMemoWithOrder.class,
    SortByColumnCurrencyInfoWithOrder.class,
    SortByColumnJournalEntryWithOrder.class,
    SortByColumnBillPaymentWithOrder.class,
    SortByColumn.class,
    SortByColumnCustomerWithOrder.class,
    SortByColumnBillWithOrder.class,
    SortByColumnItemWithOrder.class,
    SortByColumnPurchaseOrderWithOrder.class,
    SortByColumnTimeActivityWithOrder.class,
    SortByColumnInventoryTransferWithOrder.class,
    SortByColumnOtherNameWithOrder.class,
    SortByColumnInvoiceWithOrder.class,
    SortByColumnPaymentWithOrder.class,
    SortByColumnVendorWithOrder.class,
    SortByColumnSalesOrderWithOrder.class
})
public abstract class SortBy
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlValue
    protected String value;
    @XmlAttribute(name = "sortOrder")
    protected SortOrder sortOrder;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the sortOrder property.
     * 
     * @return
     *     possible object is
     *     {@link SortOrder }
     *     
     */
    public SortOrder getSortOrder() {
        if (sortOrder == null) {
            return SortOrder.DESCENDING;
        } else {
            return sortOrder;
        }
    }

    /**
     * Sets the value of the sortOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link SortOrder }
     *     
     */
    public void setSortOrder(SortOrder value) {
        this.sortOrder = value;
    }

}
