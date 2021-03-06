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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for objectName.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="objectName">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Account"/>
 *     &lt;enumeration value="Bill"/>
 *     &lt;enumeration value="BillPayment"/>
 *     &lt;enumeration value="BillPaymentCreditCard"/>
 *     &lt;enumeration value="Charge"/>
 *     &lt;enumeration value="Check"/>
 *     &lt;enumeration value="Class"/>
 *     &lt;enumeration value="Company"/>
 *     &lt;enumeration value="CreditCardCharge"/>
 *     &lt;enumeration value="CreditCardCredit"/>
 *     &lt;enumeration value="CreditMemo"/>
 *     &lt;enumeration value="Customer"/>
 *     &lt;enumeration value="CustomerMsg"/>
 *     &lt;enumeration value="CustomerType"/>
 *     &lt;enumeration value="Discount"/>
 *     &lt;enumeration value="Employee"/>
 *     &lt;enumeration value="Estimate"/>
 *     &lt;enumeration value="FixedAsset"/>
 *     &lt;enumeration value="InventoryAdjustment"/>
 *     &lt;enumeration value="InventorySite"/>
 *     &lt;enumeration value="InventoryTransfer"/>
 *     &lt;enumeration value="Invoice"/>
 *     &lt;enumeration value="Item"/>
 *     &lt;enumeration value="ItemReceipt"/>
 *     &lt;enumeration value="Job"/>
 *     &lt;enumeration value="JobType"/>
 *     &lt;enumeration value="JournalEntry"/>
 *     &lt;enumeration value="OtherName"/>
 *     &lt;enumeration value="Payment"/>
 *     &lt;enumeration value="PaymentMethod"/>
 *     &lt;enumeration value="PayrollItem"/>
 *     &lt;enumeration value="Preferences"/>
 *     &lt;enumeration value="PurchaseOrder"/>
 *     &lt;enumeration value="SalesOrder"/>
 *     &lt;enumeration value="SalesReceipt"/>
 *     &lt;enumeration value="SalesRep"/>
 *     &lt;enumeration value="SalesTax"/>
 *     &lt;enumeration value="SalesTaxCode"/>
 *     &lt;enumeration value="SalesTaxGroup"/>
 *     &lt;enumeration value="SalesTaxPaymentCheck"/>
 *     &lt;enumeration value="ShipMethod"/>
 *     &lt;enumeration value="Task"/>
 *     &lt;enumeration value="TemplateName"/>
 *     &lt;enumeration value="Term"/>
 *     &lt;enumeration value="TimeActivity"/>
 *     &lt;enumeration value="UOM"/>
 *     &lt;enumeration value="Vendor"/>
 *     &lt;enumeration value="VendorCredit"/>
 *     &lt;enumeration value="VendorType"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "objectName")
@XmlEnum
public enum ObjectName {

    @XmlEnumValue("Account")
    ACCOUNT("Account"),
    @XmlEnumValue("Bill")
    BILL("Bill"),
    @XmlEnumValue("BillPayment")
    BILL_PAYMENT("BillPayment"),
    @XmlEnumValue("BillPaymentCreditCard")
    BILL_PAYMENT_CREDIT_CARD("BillPaymentCreditCard"),
    @XmlEnumValue("Charge")
    CHARGE("Charge"),
    @XmlEnumValue("Check")
    CHECK("Check"),
    @XmlEnumValue("Class")
    CLASS("Class"),
    @XmlEnumValue("Company")
    COMPANY("Company"),
    @XmlEnumValue("CreditCardCharge")
    CREDIT_CARD_CHARGE("CreditCardCharge"),
    @XmlEnumValue("CreditCardCredit")
    CREDIT_CARD_CREDIT("CreditCardCredit"),
    @XmlEnumValue("CreditMemo")
    CREDIT_MEMO("CreditMemo"),
    @XmlEnumValue("Customer")
    CUSTOMER("Customer"),
    @XmlEnumValue("CustomerMsg")
    CUSTOMER_MSG("CustomerMsg"),
    @XmlEnumValue("CustomerType")
    CUSTOMER_TYPE("CustomerType"),
    @XmlEnumValue("Discount")
    DISCOUNT("Discount"),
    @XmlEnumValue("Employee")
    EMPLOYEE("Employee"),
    @XmlEnumValue("Estimate")
    ESTIMATE("Estimate"),
    @XmlEnumValue("FixedAsset")
    FIXED_ASSET("FixedAsset"),
    @XmlEnumValue("InventoryAdjustment")
    INVENTORY_ADJUSTMENT("InventoryAdjustment"),
    @XmlEnumValue("InventorySite")
    INVENTORY_SITE("InventorySite"),
    @XmlEnumValue("InventoryTransfer")
    INVENTORY_TRANSFER("InventoryTransfer"),
    @XmlEnumValue("Invoice")
    INVOICE("Invoice"),
    @XmlEnumValue("Item")
    ITEM("Item"),
    @XmlEnumValue("ItemReceipt")
    ITEM_RECEIPT("ItemReceipt"),
    @XmlEnumValue("Job")
    JOB("Job"),
    @XmlEnumValue("JobType")
    JOB_TYPE("JobType"),
    @XmlEnumValue("JournalEntry")
    JOURNAL_ENTRY("JournalEntry"),
    @XmlEnumValue("OtherName")
    OTHER_NAME("OtherName"),
    @XmlEnumValue("Payment")
    PAYMENT("Payment"),
    @XmlEnumValue("PaymentMethod")
    PAYMENT_METHOD("PaymentMethod"),
    @XmlEnumValue("PayrollItem")
    PAYROLL_ITEM("PayrollItem"),
    @XmlEnumValue("Preferences")
    PREFERENCES("Preferences"),
    @XmlEnumValue("PurchaseOrder")
    PURCHASE_ORDER("PurchaseOrder"),
    @XmlEnumValue("SalesOrder")
    SALES_ORDER("SalesOrder"),
    @XmlEnumValue("SalesReceipt")
    SALES_RECEIPT("SalesReceipt"),
    @XmlEnumValue("SalesRep")
    SALES_REP("SalesRep"),
    @XmlEnumValue("SalesTax")
    SALES_TAX("SalesTax"),
    @XmlEnumValue("SalesTaxCode")
    SALES_TAX_CODE("SalesTaxCode"),
    @XmlEnumValue("SalesTaxGroup")
    SALES_TAX_GROUP("SalesTaxGroup"),
    @XmlEnumValue("SalesTaxPaymentCheck")
    SALES_TAX_PAYMENT_CHECK("SalesTaxPaymentCheck"),
    @XmlEnumValue("ShipMethod")
    SHIP_METHOD("ShipMethod"),
    @XmlEnumValue("Task")
    TASK("Task"),
    @XmlEnumValue("TemplateName")
    TEMPLATE_NAME("TemplateName"),
    @XmlEnumValue("Term")
    TERM("Term"),
    @XmlEnumValue("TimeActivity")
    TIME_ACTIVITY("TimeActivity"),
    UOM("UOM"),
    @XmlEnumValue("Vendor")
    VENDOR("Vendor"),
    @XmlEnumValue("VendorCredit")
    VENDOR_CREDIT("VendorCredit"),
    @XmlEnumValue("VendorType")
    VENDOR_TYPE("VendorType");
    private final String value;

    ObjectName(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ObjectName fromValue(String v) {
        for (ObjectName c: ObjectName.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
