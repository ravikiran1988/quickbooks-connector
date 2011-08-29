/**
 * Mule FWS Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

/**
 * This file was automatically generated by the Mule Development Kit
 */
package org.mule.modules.quickbooks;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.Validate;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Module;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.lifecycle.Start;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.quickbooks.api.DefaultQuickBooksClient;
import org.mule.modules.quickbooks.api.MapBuilder;
import org.mule.modules.quickbooks.schema.Account;
import org.mule.modules.quickbooks.schema.Bill;
import org.mule.modules.quickbooks.schema.BillPayment;
import org.mule.modules.quickbooks.schema.CashPurchase;
import org.mule.modules.quickbooks.schema.Check;
import org.mule.modules.quickbooks.schema.CreditCardCharge;
import org.mule.modules.quickbooks.schema.Customer;
import org.mule.modules.quickbooks.schema.Estimate;
import org.mule.modules.quickbooks.schema.Invoice;
import org.mule.modules.quickbooks.schema.Item;
import org.mule.modules.quickbooks.schema.Payment;
import org.mule.modules.quickbooks.schema.PaymentMethod;
import org.mule.modules.quickbooks.schema.SalesReceipt;
import org.mule.modules.quickbooks.schema.SalesTerm;
import org.mule.modules.quickbooks.schema.Vendor;

import ar.com.zauber.commons.mom.CXFStyle;
import ar.com.zauber.commons.mom.MapObjectMapper;

import com.sun.jndi.toolkit.url.Uri;


@Module(name = "quickbooks",
        namespace = "http://repository.mulesoft.org/releases/org/mule/modules/mule-module-quick-books",
        schemaLocation = "http://repository.mulesoft.org/releases/org/mule/modules/mule-module-quick-books/1.0-SNAPSHOT/mule-quickbooks.xsd")
public class QuickBooksModule
{
    @Configurable
    private String realmId;
    
    @Configurable
    private String consumerKey;
    
    @Configurable
    private String consumerSecret;
    
    @Configurable
    private String accessKey;
    
    @Configurable
    private String accessSecret;
    
    private DefaultQuickBooksClient client;
    private MapObjectMapper mom;

    @Processor
    public void createAccount(String name, @Optional String desc, String subtype, @Optional String acctNum,
                              @Optional String openingBalance, @Optional Date openingBalanceDate,
                              @Optional Map<String, Object> accountParentId)
    {   
        client.create(
            mom.fromMap(Account.class,            
                new MapBuilder()
                .with("accountParentId", accountParentId)
                .with("desc", desc)
                .with("subType", subtype)
                .with("acctNum", acctNum)
                .with("openingBalance", new BigDecimal(openingBalance))
                .with("openingBalanceDate", openingBalanceDate)
                .build()
            )
        );
    }
    
    @Processor
    public void createBill(Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.create(
            mom.fromMap(Bill.class,
                new MapBuilder()
                .with("billHeader", header)
                .with("billLine", line)
                .build()
            )
        );
    }
    
    @Processor
    public void createBillPayment(Map<String, Object> header, List<Map<String, Object>> line)
    {    
        client.create(
            mom.fromMap(BillPayment.class,
                new MapBuilder()
                .with("billPaymentHeader", header)
                .with("billPaymentLine", line)
                .build()
            )
        );
    }
    
    @Processor
    public void createCashPurchase(Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.create(
            mom.fromMap(CashPurchase.class,
                new MapBuilder()
                .with("cashPurchaseHeader", header)
                .with("cashPurchaseLine", line)
                .build()
            )
        );
    }
    
    @Processor
    public void createCheck(Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.create(
            mom.fromMap(Check.class,
                new MapBuilder()
                .with("checkHeader", header)
                .with("checkLine", line)
                .build()
            )
        );
    }
    
    @Processor
    public void createCreditCardCharge(Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.create(
            mom.fromMap(CreditCardCharge.class,
                new MapBuilder()
                .with("creditCardChargeHeader", header)
                .with("creditCardChargeLine", line)
                .build()
            )
        );
    }

    @Processor
    public void createCustomer(@Optional String name, @Optional String givenName, @Optional String middleName,
                               @Optional String familyName, @Optional String suffix, @Optional String dBAName,
                               @Optional String showAs, List<Uri> webSite, @Optional Map<String, Object> salesTermId,
                               @Optional String salesTaxCodeId, List<String> email, List<Map<String, Object>> phone,
                               Map<String, Object> address)
    {
        client.create(
            mom.fromMap(Customer.class,
                new MapBuilder()
                .with("name", name)
                .with("givenName", givenName)
                .with("middleName", middleName)
                .with("familyName", familyName)
                .with("suffix", suffix)
                .with("dBAName", dBAName)
                .with("showAs", showAs)
                .with("webSite", webSite)
                .with("salesTermId", salesTermId)
                .with("salesTaxCodeId", salesTaxCodeId)
                .with("email", email)
                .with("phone", phone)
                .with("address", address)
                .build()
            )
        );
    }
    
    @Processor
    public void createEstimate(Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.create(
            mom.fromMap(Estimate.class,
                new MapBuilder()
                .with("estimateHeader", header)
                .with("estimateLine", line)
                .build()
            )
        );
    }
    
    @Processor
    public void createInvoice(Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.create(
            mom.fromMap(Invoice.class,
                new MapBuilder()
                .with("invoiceHeader", header)
                .with("invoiceLine", line)
                .build()
            )
        );
    }
    
    @Processor
    public void createItem(@Optional @Default("") String name, Map<String,Object> unitPrice, @Optional String desc,
                           @Optional @Default("false") Boolean tasable, Map<String, Object> incomeAccountRef,
                           Map<String, Object> itemParentId, String itemParentName, @Optional String purchaseDesc,
                           Map<String, Object> purchaseCost, Map<String, Object> expenseAccountRef)
    {
        client.create(
            mom.fromMap(Item.class,
                new MapBuilder()
                .with("name", name)
                .with("unitPrice", unitPrice)
                .with("desc", desc)
                .with("tasable", tasable)
                .with("incomeAccountRef", incomeAccountRef)
                .with("itemParentId", itemParentId)
                .with("itemParentName", itemParentName)
                .with("purchaseDesc", purchaseDesc)
                .with("purchaseCosto", purchaseCost)
                .with("expenseAccountRef", expenseAccountRef)
                .build()
            )
        );
    }
    
    @Processor
    public void createPayment(Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.create(
            mom.fromMap(Payment.class,
                new MapBuilder()
                .with("paymentHeader", header)
                .with("paymentLine", line)
                .build()
            )
        );
    }
    
    @Processor
    public void createPaymentMethod(String name, @Optional @Default("NON_CREDIT_CARD") String type)
    {
        client.create(
            mom.fromMap(PaymentMethod.class,
                new MapBuilder()
                .with("name", name)
                .with("type", type)
                .build()
            )
        );
    }
    
    @Processor
    public void createSalesReceipt(Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.create(
            mom.fromMap(SalesReceipt.class,
                new MapBuilder()
                .with("salesReceiptHeader", header)
                .with("salesReceiptLine", line)
                .build()
            )
        );
    }
    
    @Processor
    public void createSalesTerm(String name, Integer dueDays, @Optional Integer discountDay,
                                @Optional String discountPercent, Integer dayOfMonthDue,
                                @Optional Integer dueNextMonthDays, @Optional Integer discountDayOfMonth,
                                @Optional String dateDiscountPercent)
    {
        client.create(
            mom.fromMap(SalesTerm.class,
                new MapBuilder()
                .with("name", name)
                .with("dueDays", dueDays)
                .with("discountDay", discountDay)
                .with("discountPercent", new BigDecimal(discountPercent))
                .with("dayOfMonthDue", dayOfMonthDue)
                .with("dueNextMonthDays", dueNextMonthDays)
                .with("discountDayOfMonth", discountDayOfMonth)
                .with("discountPercent", new BigDecimal(dateDiscountPercent))
                .build()
            )
        );
    }
    
    @Processor
    public void createVendor(String name, String givenName, @Optional String middleName, @Optional String familyName,
                             @Optional String dBAName, @Optional String showAs, List<Uri> webSite,
                             @Optional Integer taxIdentifier, @Optional String acctNum, @Optional Boolean vendor1099,
                             List<String> email, List<Map<String, Object>> phone, Map<String, Object> address)
    {
        client.create(
            mom.fromMap(Vendor.class,
                new MapBuilder()
                .with("name", name)
                .with("givenName", givenName)
                .with("middleName", middleName)
                .with("familyName", familyName)
                .with("dBAName", dBAName)
                .with("showAs", showAs)
                .with("webSite", webSite)
                .with("taxIdentifier", taxIdentifier)
                .with("acctNum", acctNum)
                .with("vendor1099", vendor1099)
                .with("email", email)
                .with("phone", phone)
                .with("address", address)
                .build()
            )
        );
    }
    
    @Processor
    public Object getObject(String type, String objectId)
    {
        return client.getObject(type, objectId);
    }

    @Processor
    public void updateAccount(String name, @Optional String desc, String subtype, @Optional String acctNum,
                              @Optional String openingBalance, @Optional Date openingBalanceDate,
                              @Optional Map<String, Object> accountParentId) //Map<String,Address> address)
    {   
        client.update(
            mom.fromMap(Account.class,            
                new MapBuilder()
                .with("accountParentId", accountParentId)
                .with("desc", desc)
                .with("subType", subtype)
                .with("acctNum", acctNum)
                .with("openingBalance", new BigDecimal(openingBalance))
                .with("openingBalanceDate", openingBalanceDate)
                .build()
            )
        );
    }
    
    @Processor
    public void updateBill(Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.update(
            mom.fromMap(Bill.class,
                new MapBuilder()
                .with("billHeader", header)
                .with("billLine", line)
                .build()
            )
        );
    }
    
    @Processor
    public void updateBillPayment(Map<String, Object> header, List<Map<String, Object>> line)
    {    
        client.update(
            mom.fromMap(BillPayment.class,
                new MapBuilder()
                .with("billPaymentHeader", header)
                .with("billPaymentLine", line)
                .build()
            )
        );
    }
    
    @Processor
    public void updateCashPurchase(Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.update(
            mom.fromMap(CashPurchase.class,
                new MapBuilder()
                .with("cashPurchaseHeader", header)
                .with("cashPurchaseLine", line)
                .build()
            )
        );
    }
    
    @Processor
    public void updateCheck(Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.update(
            mom.fromMap(Check.class,
                new MapBuilder()
                .with("checkHeader", header)
                .with("checkLine", line)
                .build()
            )
        );
    }
    
    @Processor
    public void updateCreditCardCharge(Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.update(
            mom.fromMap(CreditCardCharge.class,
                new MapBuilder()
                .with("creditCardChargeHeader", header)
                .with("creditCardChargeLine", line)
                .build()
            )
        );
    }

    @Processor
    public void updateCustomer(@Optional String name, @Optional String givenName, @Optional String middleName,
                               @Optional String familyName, @Optional String suffix, @Optional String dBAName,
                               @Optional String showAs, List<Uri> webSite, @Optional Map<String, Object> salesTermId,
                               @Optional String salesTaxCodeId, List<String> email, List<Map<String, Object>> phone,
                               Map<String, Object> address)
    {
        client.update(
            mom.fromMap(Customer.class,
                new MapBuilder()
                .with("name", name)
                .with("givenName", givenName)
                .with("middleName", middleName)
                .with("familyName", familyName)
                .with("suffix", suffix)
                .with("dBAName", dBAName)
                .with("showAs", showAs)
                .with("webSite", webSite)
                .with("salesTermId", salesTermId)
                .with("salesTaxCodeId", salesTaxCodeId)
                .with("email", email)
                .with("phone", phone)
                .with("address", address)
                .build()
            )
        );
    }
    
    @Processor
    public void updateEstimate(Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.update(
            mom.fromMap(Estimate.class,
                new MapBuilder()
                .with("estimateHeader", header)
                .with("estimateLine", line)
                .build()
            )
        );
    }
    
    @Processor
    public void updateInvoice(Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.update(
            mom.fromMap(Invoice.class,
                new MapBuilder()
                .with("invoiceHeader", header)
                .with("invoiceLine", line)
                .build()
            )
        );
    }
    
    @Processor
    public void updateItem(@Optional @Default("") String name, Map<String,Object> unitPrice, @Optional String desc,
                           @Optional @Default("false") Boolean tasable, Map<String, Object> incomeAccountRef,
                           Map<String, Object> itemParentId, String itemParentName, @Optional String purchaseDesc,
                           Map<String, Object> purchaseCost, Map<String, Object> expenseAccountRef)
    {
        client.update(
            mom.fromMap(Item.class,
                new MapBuilder()
                .with("name", name)
                .with("unitPrice", unitPrice)
                .with("desc", desc)
                .with("tasable", tasable)
                .with("incomeAccountRef", incomeAccountRef)
                .with("itemParentId", itemParentId)
                .with("itemParentName", itemParentName)
                .with("purchaseDesc", purchaseDesc)
                .with("purchaseCosto", purchaseCost)
                .with("expenseAccountRef", expenseAccountRef)
                .build()
            )
        );
    }
    
    @Processor
    public void updatePayment(Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.update(
            mom.fromMap(Payment.class,
                new MapBuilder()
                .with("paymentHeader", header)
                .with("paymentLine", line)
                .build()
            )
        );
    }
    
    @Processor
    public void updatePaymentMethod(String name, @Optional @Default("NON_CREDIT_CARD") String type)
    {
        client.update(
            mom.fromMap(PaymentMethod.class,
                new MapBuilder()
                .with("name", name)
                .with("type", type)
                .build()
            )
        );
    }
    
    @Processor
    public void updateSalesReceipt(Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.update(
            mom.fromMap(SalesReceipt.class,
                new MapBuilder()
                .with("salesReceiptHeader", header)
                .with("salesReceiptLine", line)
                .build()
            )
        );
    }
    
    @Processor
    public void updateSalesTerm(String name, Integer dueDays, @Optional Integer discountDay,
                                @Optional String discountPercent, Integer dayOfMonthDue,
                                @Optional Integer dueNextMonthDays, @Optional Integer discountDayOfMonth,
                                @Optional String dateDiscountPercent)
    {
        client.update(
            mom.fromMap(SalesTerm.class,
                new MapBuilder()
                .with("name", name)
                .with("dueDays", dueDays)
                .with("discountDay", discountDay)
                .with("discountPercent", new BigDecimal(discountPercent))
                .with("dayOfMonthDue", dayOfMonthDue)
                .with("dueNextMonthDays", dueNextMonthDays)
                .with("discountDayOfMonth", discountDayOfMonth)
                .with("discountPercent", new BigDecimal(dateDiscountPercent))
                .build()
            )
        );
    }
    
    @Processor
    public void updateVendor(String name, String givenName, @Optional String middleName, @Optional String familyName,
                             @Optional String dBAName, @Optional String showAs, List<Uri> webSite,
                             @Optional Integer taxIdentifier, @Optional String acctNum, @Optional Boolean vendor1099,
                             List<String> email, List<Map<String, Object>> phone, Map<String, Object> address)
    {
        client.update(
            mom.fromMap(Vendor.class,
                new MapBuilder()
                .with("name", name)
                .with("givenName", givenName)
                .with("middleName", middleName)
                .with("familyName", familyName)
                .with("dBAName", dBAName)
                .with("showAs", showAs)
                .with("webSite", webSite)
                .with("taxIdentifier", taxIdentifier)
                .with("acctNum", acctNum)
                .with("vendor1099", vendor1099)
                .with("email", email)
                .with("phone", phone)
                .with("address", address)
                .build()
            )
        );
    }
    
    @Processor
    public void deleteObject(String type, String objectId)
    {
        client.deleteObject(type, objectId);
    }

    public List<Object> findObjects()
    {
        return client.findObjects();
    }
    
    /**
     * 
     */
    @Start
    public void init()
    {
        if (client == null )
        {
            client = new DefaultQuickBooksClient(realmId, consumerKey, consumerSecret, accessKey, accessSecret);
        }
        mom.setPropertyStyle(new CXFStyle());
    }
    
    /**
     * Sets the realmId. 
     *
     * @param realmId  with the realmId.
     */

    public void setRealmId(String realmId)
    {
        this.realmId = realmId;
    }
    /**
     * Returns the realmId.
     * 
     * @return  with the realmId.
     */

    public String getRealmId()
    {
        return realmId;
    }

    /**
     * Returns the consumerKey.
     * 
     * @return  with the consumerKey.
     */
    
    public String getConsumerKey()
    {
        return consumerKey;
    }

    /**
     * Sets the consumerKey. 
     *
     * @param consumerKey  with the consumerKey.
     */
    
    public void setConsumerKey(String consumerKey)
    {
        this.consumerKey = consumerKey;
    }

    /**
     * Returns the consumerSecret.
     * 
     * @return  with the consumerSecret.
     */
    
    public String getConsumerSecret()
    {
        return consumerSecret;
    }

    /**
     * Sets the consumerSecret. 
     *
     * @param consumerSecret  with the consumerSecret.
     */
    
    public void setConsumerSecret(String consumerSecret)
    {
        this.consumerSecret = consumerSecret;
    }

    /**
     * Returns the accessKey.
     * 
     * @return  with the accessKey.
     */
    
    public String getAccessKey()
    {
        return accessKey;
    }

    /**
     * Sets the accessKey. 
     *
     * @param accessKey  with the accessKey.
     */
    
    public void setAccessKey(String accessKey)
    {
        this.accessKey = accessKey;
    }

    /**
     * Returns the accessSecret.
     * 
     * @return  with the accessSecret.
     */
    
    public String getAccessSecret()
    {
        return accessSecret;
    }

    /**
     * Sets the accessSecret. 
     *
     * @param accessSecret  with the accessSecret.
     */
    
    public void setAccessSecret(String accessSecret)
    {
        this.accessSecret = accessSecret;
    }
    
    private final DatatypeFactory datatypeFactory;
    {
        mom.registerConverter(new Converter()
        {
            
            @Override
            public Object convert(Class arg0, Object arg1)
            {
                Validate.isTrue(arg0 == XMLGregorianCalendar.class);
                
                return toGregorianCalendar((Date) arg1);
            }
        }, Date.class);
        try
        {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch (DatatypeConfigurationException e)
        {
            throw new AssertionError(e);
        }
    }
    
    private XMLGregorianCalendar toGregorianCalendar(Date openingBalanceDate)
    {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(openingBalanceDate);
        return datatypeFactory.newXMLGregorianCalendar(cal);
    }
    
    enum EntityType
    {
        
        ACCOUNT(Account.class),
        BILL(Bill.class),
        BILLPAYMENT(BillPayment.class),
        CASHPURCHASE(CashPurchase.class),
        CHECK(Check.class),
        CREDITCARDCHARGE(CreditCardCharge.class),
        CUSTOMER(Customer.class),
        ESTIMATE(Estimate.class),
        INVOICE(Invoice.class),
        ITEM(Item.class),
        PAYMENT(Payment.class),
        PAYMENTMETHOD(PaymentMethod.class),
        SALESRECEIPT(SalesReceipt.class),
        SALESTERM(SalesTerm.class),
        VENDOR(Vendor.class);
        
        private final Class<?> type;
        
        private EntityType(Class<?> type)
        {
            this.type = type;
        }
        
        public <A> A newInstance()
        {
            try
            {
                return (A) type.newInstance();
            }
            catch (Exception e)
            {
                throw new AssertionError(e);
            }
        }
    }
}

/*
 *             OAuthConsumer consumer = new DefaultOAuthConsumer(
                consumerKey,
                consumerSecret);

            OAuthProvider p; new DefaultOAuthProvider(requestTokenEndpointUrl, accessTokenEndpointUrl, authorizationWebsiteUrl);
            OAuthProvider provider = new DefaultOAuthProvider(
                "https://oauth.intuit.com/oauth/v1/get_request_token",
                "https://oauth.intuit.com/oauth/v1/get_access_token",
                "https://workplace.intuit.com/app/Account/DataSharing/Authorize");
            try
            {
                // we do not support callbacks, thus pass OOB
                String authUrl = provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND);
    
                System.out.println("Now visit:\n" + authUrl
                    + "\n... and grant this app authorization");
                System.out.println("Enter the PIN code and hit ENTER when you're done:");
    
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String pin = br.readLine();
                provider.retrieveAccessToken(consumer, pin);
    
                URL url = new URL("https://workplace.intuit.com/db/main?a=API_GetUserInfo");
                HttpsURLConnection request = (HttpsURLConnection) url.openConnection();
                
                consumer.sign(request);
                
                request.connect();
            }
            catch (Exception e)
            {
                return;
            }*/
