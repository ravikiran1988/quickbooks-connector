/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
 */

package org.mule.modules.quickbooks.online;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.modules.quickbooks.MapBuilder;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.online.schema.Account;
import org.mule.modules.quickbooks.online.schema.Customer;
import org.mule.modules.quickbooks.online.schema.GenericEntity;
import org.mule.modules.quickbooks.online.schema.Invoice;
import org.mule.modules.quickbooks.online.schema.InvoiceHeader;
import org.mule.modules.quickbooks.online.schema.InvoiceLine;
import org.mule.modules.quickbooks.online.schema.Item;
import org.mule.modules.quickbooks.online.schema.PhysicalAddress;
import org.mule.modules.quickbooks.online.schema.SalesTerm;
import org.mule.modules.utils.mom.JaxbMapObjectMappers;

import com.zauberlabs.commons.mom.MapObjectMapper;


/**
 * 
 * 
 * @author Gaston Ponti
 * @since Sep 9, 2011
 */

public class QuickBooksOnlineModuleTestDriver
{

    private static QuickBooksModule module;
    private static String appKey = System.getenv("appKey");
    private final String realmId = System.getenv("realmId");
    private final String realmIdPseudonym = System.getenv("realmIdPseudonym");
    private final String authIdPseudonym = System.getenv("authIdPseudonym");
    private final MapObjectMapper mom = JaxbMapObjectMappers.defaultWithPackage("org.mule.modules.quickbooks.online.schema").build();
    
    /**
     * 
     */
    @BeforeClass
    public static void setup()
    {
        module = new QuickBooksModule();
        module.setBaseUri("https://qbo.intuit.com/qbo1/rest/user/v2");
        module.init();
    }
    
    @Test
    public void createAccount()
    {
        Account acc = module.createAccount(realmId, appKey, realmIdPseudonym, authIdPseudonym,
            "Test Account82", null, AccountOnlineDetail.SAVINGS, "36544", "0", new Date(), null);
                
        Map<String, Object> idType = new HashMap<String, Object>();
        idType.put("value", acc.getId().getValue());
        
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.ACCOUNT, idType, acc.getSyncToken());
    }
    @Test
    public void createCustomerAnswersNonNullCustomerWithId() throws Exception
    {
        List<Map<String, Object>> auxList = new ArrayList<Map<String, Object>>();
        
        Map<String, Object> auxMap = new HashMap<String, Object>();
        
        auxMap.put("Line1", null);
        auxMap.put("Line2", null);
        auxMap.put("City", null);
        auxMap.put("CountrySubDivisionCode", null);
        auxMap.put("PostalCode", null);
        auxMap.put("Tag", "Billing");
        
        auxList.add(auxMap);

        Customer c = module.createCustomer(realmId, appKey, realmIdPseudonym, authIdPseudonym,
            "Susana", 
            "Susana", 
            "Melina", 
            "Perez",
            null, null, null, 
            new ArrayList<Map<String, Object>>(), 
            null, null, new ArrayList<Map<String, Object>>(),
            new ArrayList<Map<String, Object>>(),
            new ArrayList<Map<String, Object>>(),
            new ArrayList<Map<String, Object>>()
//            auxList
//            Arrays.<Map<String, Object>>asList(new HashMap<String, Object>()
//                {
//                    {
//                        put("Line1", null);
//                        put("Line2", null);
//                        put("City", null);
//                        put("CountrySubDivisionCode", null);
//                        put("PostalCode", null);
//                        put("Tag", "Billing");
//                    } 
//               }
//            )
        );
        
        assertEquals("Susana", c.getName());
        assertNotNull(c.getId());

        Map<String, Object> idType = new HashMap<String, Object>();
        idType.put("value", c.getId().getValue());
        //idType.put("idDomain", c.getId().getIdDomain());
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, idType, c.getSyncToken());
    }
    
    @Test
    @Ignore
    public void testname() throws Exception
    {
        
     List<Map<String, Object>> auxList = new ArrayList<Map<String, Object>>();
        
        Map<String, Object> auxMap = new HashMap<String, Object>();
        
        auxMap.put("Line1", null);
        auxMap.put("Line2", null);
        auxMap.put("City", null);
        auxMap.put("CountrySubDivisionCode", null);
        auxMap.put("PostalCode", null);
        auxMap.put("Tag", "Billing");
        
        auxList.add(auxMap);

        Customer c = (Customer) mom.unmap(
                new MapBuilder()
                .with("name", "Susana")
                .with("givenName", "Susana")
                .with("middleName", "Melina")
                .with("familyName", "Perez")
                .with("suffix", null)
                .with("DBAName", null)
                .with("showAs", null)
                .with("webSite", new ArrayList<Map<String, Object>>())
                .with("salesTermId", null)
                .with("salesTaxCodeId", null)
                .with("email", new ArrayList<String>())
                .with("phone", new ArrayList<Map<String, Object>>())
                .with("address", auxList)
                .build(), Customer.class
                );
        
        PhysicalAddress ph = c.getAddress().get(0);
        
        assertEquals(ph.getTag(), "Billing");
    }
    
    @Test
    public void getCustomerAnswersNonNullCustomerWithId() throws Exception
    {
        Map<String, Object> idType = new HashMap<String, Object>();
        idType.put("value", "1");
        //idType.put("idDomain", c.getId().getIdDomain());
        Customer c = (Customer) module.getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, idType);
        
        assertEquals("Ricardo (deleted)", c.getName());
        assertNotNull(c.getId());
    }
    
    @Test
    public void modifyCustomer()
    {
        Customer c1 = module.createCustomer(realmId, appKey, realmIdPseudonym, authIdPseudonym,
            "Paul M. Jonhson", 
            "Paul", 
            "Mark", 
            "Jhonson",
            null, null, null, 
            new ArrayList<Map<String, Object>>(), 
            null, null, new ArrayList<Map<String, Object>>(),
            new ArrayList<Map<String, Object>>(),
            new ArrayList<Map<String, Object>>(),
            null
        );
        
        assertEquals("Jhonson", c1.getFamilyName());
        
        Map<String, Object> idType = new HashMap<String, Object>();
        idType.put("value", c1.getId().getValue());
        
        Customer c2 = module.updateCustomer(realmId, appKey, realmIdPseudonym, authIdPseudonym,
            idType, 
            c1.getSyncToken(), 
            c1.getName(), 
            c1.getGivenName(), 
            c1.getMiddleName(), 
            "Smith", 
            null, null, null, 
            new ArrayList<Map<String, Object>>(), 
            null, null, new ArrayList<Map<String, Object>>(),
            new ArrayList<Map<String, Object>>(),
            new ArrayList<Map<String, Object>>(),
                new ArrayList<Map<String, Object>>()
        );
        
        Customer c3 = (Customer) module.getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, idType);
        
        assertEquals("Smith", c3.getFamilyName());
        
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, idType, null);
    }
    
    @Test
    public void getAllCustomersAnswersNonNullListWithCustomers() throws Exception
    {       
        Iterable<Customer> it = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, null, null);
        
        for (Customer c : it)
        {
            assertNotNull(c.getId());
        }
    }
    
    @Test
    public void getSomeCustomersAnswersNonNullListWithCustomers() throws Exception
    {
        Iterable<Customer> it = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, "GivenName :EQUALS: Susana", null);
        
        for (Customer c : it)
        {
            assertNotNull(c.getId());
        }
    }
    
    @Test
    public void createSalesTermAnswersNonNullSalesTermWithId()
    {
        SalesTerm salesTerm = module.createSalesTerm(realmId, appKey, realmIdPseudonym, authIdPseudonym,
            "SalesTerm1",
            3,
            null,
            null,
            2,
            null,
            null,
            null);
        
        assertEquals("SalesTerm1", salesTerm.getName());
        Map<String, Object> idType = new HashMap<String, Object>();
        idType.put("value", salesTerm.getId().getValue());
        
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.SALESTERM, idType, null);
    }

    @Test
    public void retrievesAEmptyIterable()
    {
        Iterable<Customer> it = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, "Name :EQUALS: MFASDAEAEAAASS", null);

        assertEquals(false, it.iterator().hasNext());
    }
    
    @Test
    @Ignore
    public void deleteCustomer()
    {        
        Iterable<Customer> it= module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, "Name :EQUALS: Paul M. Jenkins 4", null);
        
        for (Customer customer: it)
        {
            module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, (Map<String, Object>) mom.map(customer.getId()), customer.getSyncToken());
        }
    }
    
    @Test
    @Ignore
    public void deleteItem()
    {        
        Iterable<Item> it= module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.ITEM, "Name :EQUALS: ItemTest0057", null);
        
        for (Item item: it)
        {
            module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.ITEM, (Map<String, Object>) mom.map(item.getId()), item.getSyncToken());
        }
    }
    
    @Test
    public void createInvoiceRetrieveAndUpdateIt()
    {
        //creates a customer
        Customer customer = module.createCustomer(realmId, appKey, realmIdPseudonym, authIdPseudonym,
            "Paul M. Jenkins 4", 
            "Paul", 
            "Mark", 
            "Jenkins",
            null, null, null, 
            new ArrayList<Map<String, Object>>(), 
            null, null, new ArrayList<Map<String, Object>>(),
            new ArrayList<Map<String, Object>>(),
            new ArrayList<Map<String, Object>>(),
            null
        );
        
        //create an item
        Map<String, Object> unitPrice = new HashMap<String, Object>(){{
            put("amount", 100);
        }};
        
        Item item = module.createItem(realmId, appKey, realmIdPseudonym, authIdPseudonym,
            "ItemTest0057", unitPrice, null, false, null, null, null, null, null, null);
        
        //create an invoice with the customer and item created before
        InvoiceHeader invHeader = new InvoiceHeader();
        invHeader.setCustomerId(customer.getId());
        invHeader.setDocNumber("DOC-00000010101");
        
        List<InvoiceLine> lines = new ArrayList<InvoiceLine>();
        InvoiceLine invoiceLine = new InvoiceLine();
        invoiceLine.setAmount(new BigDecimal(100));
        invoiceLine.setItemId(item.getId());
        lines.add(invoiceLine);
        Map<String, Object> mapAux = (Map<String, Object>) mom.map(invHeader);
        List<Map<String, Object>> listAux = (List<Map<String, Object>>) mom.map(lines);
        Invoice invoice = module.createInvoice(realmId, appKey, realmIdPseudonym, authIdPseudonym, (Map<String, Object>) mom.map(invHeader), (List<Map<String, Object>>) mom.map(lines));
        
        //retrieve the invoices of our customer
        String filter = "CustomerId :EQUALS: " + customer.getId().getValue();
        Iterable<Invoice> iterableInv = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.INVOICE, filter, null);

        //We know that only has one invoice, because we have created him
        invoice = iterableInv.iterator().next();
        
        //change the docNumber and update it
        invoice.getHeader().setDocNumber("DOC-NEW:001111111101");
        invoice = module.updateInvoice(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
                             (Map<String, Object>) mom.map(invoice.getId()), 
                             invoice.getSyncToken(), 
                             (Map<String, Object>) mom.map(invoice.getHeader()), 
                             (List<Map<String, Object>>) mom.map(invoice.getLine()));
        
        //delete everything
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.INVOICE, (Map<String, Object>) mom.map(invoice.getId()), invoice.getSyncToken());
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.ITEM, (Map<String, Object>) mom.map(item.getId()), item.getSyncToken());
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, (Map<String, Object>) mom.map(customer.getId()), customer.getSyncToken());
    
        //verify the change
        assertEquals("DOC-NEW:001111111101", invoice.getHeader().getDocNumber());
    }
    
    @Test
    public void findChangeDataDeleted()
    {
        Iterable<GenericEntity> it = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
            OnlineEntityType.CHANGEDATADELETED, 
            "Entity :in: (Customer, Invoice, Item) :and: LastUpdatedTime :after: 2011-06-30T01:00:00-0700", null);
        
        for(GenericEntity ge : it)
        {
            assertTrue(ge.getEntityType().value().equals("Customer") || ge.getEntityType().value().equals("Invoice") 
                    || ge.getEntityType().value().equals("Item"));
        }
    }
    
    @Test
    public void testIfTheNotesHasBeenSaved()
    {
        List<Map<String, Object>> notes = new ArrayList<Map<String, Object>>();
        Map<String, Object> note = new HashMap<String, Object>();
        note.put("content", "This is a test note");
        notes.add(note);
        
        Customer customer = module.createCustomer(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                "Mr test for notes 2", 
                "Test", 
                "Notes", 
                "James",
                null, null, null, 
                null, null, null,
                null, null, null,
                notes
            );
        
        assertEquals(1, customer.getNotes().size());
        assertEquals("This is a test note", customer.getNotes().get(0).getContent());
        
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, (Map<String, Object>) mom.map(customer.getId()), customer.getSyncToken());
    }
    
    @Test
    @Ignore
    public void testASecondCompany()
    {
        String appKey2 = System.getenv("appKey");
        String realmId2 = System.getenv("realmId2");
        String realmIdPseudonym2 = System.getenv("realmIdPseudonym2");
        String authIdPseudonym2 = System.getenv("authIdPseudonym2");
                
        Account acc = module.createAccount(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                "Test Account82", null, AccountOnlineDetail.SAVINGS, "36544", "0", new Date(), null);
                    
        Map<String, Object> idType = new HashMap<String, Object>();
        idType.put("value", acc.getId().getValue());
        
        Account acc2 = module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account82", null, AccountOnlineDetail.SAVINGS, "36544", "0", new Date(), null);
                    
        Map<String, Object> idType2 = new HashMap<String, Object>();
        idType2.put("value", acc2.getId().getValue());
            
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.ACCOUNT, idType, acc.getSyncToken());
            
        module.deleteObject(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2, OnlineEntityType.ACCOUNT, idType2, acc2.getSyncToken());
    }
    
    @Test
    @Ignore
    public void testCallBetweenLazyRetrieve()
    {
        String appKey2 = System.getenv("appKey");
        String realmId2 = System.getenv("realmId2");
        String realmIdPseudonym2 = System.getenv("realmIdPseudonym2");
        String authIdPseudonym2 = System.getenv("authIdPseudonym2");
        
        Iterable<Account> it = module.findObjects(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2, 
                OnlineEntityType.ACCOUNT, null, null);
        
        Iterator<Account> itAcc = it.iterator();
        assertNotNull(itAcc.next().getId());
        
        Account acc = module.createAccount(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                "Test Account82", null, AccountOnlineDetail.SAVINGS, "36544", "0", new Date(), null);
        
        while(itAcc.hasNext()) {
            assertNotNull(itAcc.next().getId());
        }
        
        Map<String, Object> idType = new HashMap<String, Object>();
        idType.put("value", acc.getId().getValue());
            
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.ACCOUNT, idType, acc.getSyncToken());
    }
    
    @Test
    @Ignore
    public void testCreate20Accounts()
    {
        String appKey2 = System.getenv("appKey");
        String realmId2 = System.getenv("realmId2");
        String realmIdPseudonym2 = System.getenv("realmIdPseudonym2");
        String authIdPseudonym2 = System.getenv("authIdPseudonym2");
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account01", null, AccountOnlineDetail.SAVINGS, "0001", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account02", null, AccountOnlineDetail.SAVINGS, "0002", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account03", null, AccountOnlineDetail.SAVINGS, "0003", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account04", null, AccountOnlineDetail.SAVINGS, "0004", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account05", null, AccountOnlineDetail.SAVINGS, "0005", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account06", null, AccountOnlineDetail.SAVINGS, "0006", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account07", null, AccountOnlineDetail.SAVINGS, "0007", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account08", null, AccountOnlineDetail.SAVINGS, "0008", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account09", null, AccountOnlineDetail.SAVINGS, "0009", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account10", null, AccountOnlineDetail.SAVINGS, "0010", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account11", null, AccountOnlineDetail.SAVINGS, "0011", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account12", null, AccountOnlineDetail.SAVINGS, "0012", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account13", null, AccountOnlineDetail.SAVINGS, "0013", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account14", null, AccountOnlineDetail.SAVINGS, "0014", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account15", null, AccountOnlineDetail.SAVINGS, "0015", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account16", null, AccountOnlineDetail.SAVINGS, "0016", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account17", null, AccountOnlineDetail.SAVINGS, "0017", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account18", null, AccountOnlineDetail.SAVINGS, "0018", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account19", null, AccountOnlineDetail.SAVINGS, "0019", "0", new Date(), null);
        module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2,
                "Test Account20", null, AccountOnlineDetail.SAVINGS, "0020", "0", new Date(), null);
    }
    
    @Test(expected = QuickBooksRuntimeException.class)
    public void createAccountThrowingExceptionForWrongCredentials()
    {
        QuickBooksModule module2;
        module2 = new QuickBooksModule();
        module2.setBaseUri("https://qbo.intuit.com/qbo1/rest/user/v2");
        module2.init();
        
        Account acc = module2.createAccount("wrongRealmId", appKey, realmIdPseudonym, authIdPseudonym,
            "Test Account", null, AccountOnlineDetail.SAVINGS, "36547", "0", new Date(), null);
    }
    
}
