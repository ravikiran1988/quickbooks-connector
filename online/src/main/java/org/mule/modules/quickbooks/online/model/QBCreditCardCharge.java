/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.online.model;

import org.mule.modules.quickbooks.online.schema.CreditCardCharge;

/**
 * 
 * Wrapper class for QB online CreditCardPurchase
 * 
 * @author Mulesoft, inc
 *
 */
public class QBCreditCardCharge {

    private CreditCardCharge creditCardCharge;
    
    public QBCreditCardCharge() {

    }
    
    public QBCreditCardCharge (CreditCardCharge creditCardCharge) {
        this.setCreditCardCharge(creditCardCharge);
    }

    public CreditCardCharge getCreditCardCharge() {
        return creditCardCharge;
    }

    public void setCreditCardCharge(CreditCardCharge creditCardCharge) {
        this.creditCardCharge = creditCardCharge;
    }
}
