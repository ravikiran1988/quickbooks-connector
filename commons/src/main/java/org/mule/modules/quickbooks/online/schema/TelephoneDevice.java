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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TelephoneDevice.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TelephoneDevice">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LandLine"/>
 *     &lt;enumeration value="Mobile"/>
 *     &lt;enumeration value="Fax"/>
 *     &lt;enumeration value="Pager"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TelephoneDevice")
@XmlEnum
public enum TelephoneDevice {

    @XmlEnumValue("LandLine")
    LAND_LINE("LandLine"),
    @XmlEnumValue("Mobile")
    MOBILE("Mobile"),
    @XmlEnumValue("Fax")
    FAX("Fax"),
    @XmlEnumValue("Pager")
    PAGER("Pager");
    private final String value;

    TelephoneDevice(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TelephoneDevice fromValue(String v) {
        for (TelephoneDevice c: TelephoneDevice.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
