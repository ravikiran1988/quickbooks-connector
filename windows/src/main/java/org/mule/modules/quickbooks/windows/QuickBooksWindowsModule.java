/**
 * Mule QuickBooks Connector
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
package org.mule.modules.quickbooks.windows;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Module;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.windows.api.DefaultQuickBooksWindowsClient;
import org.mule.modules.quickbooks.windows.api.QuickBooksWindowsClient;
import org.mule.modules.quickbooks.windows.schema.IdType;
import org.mule.modules.quickbooks.windows.schema.ObjectRef;
import org.mule.modules.quickbooks.windows.schema.SyncActivityRequest;
import org.mule.modules.quickbooks.windows.schema.SyncActivityResponse;
import org.mule.modules.quickbooks.windows.schema.SyncActivityResponses;
import org.mule.modules.quickbooks.windows.schema.SyncStatusRequest;
import org.mule.modules.quickbooks.windows.schema.SyncStatusResponse;
import org.mule.modules.quickbooks.windows.schema.SyncStatusResponses;
import org.mule.modules.utils.mom.JaxbMapObjectMappers;

import com.zauberlabs.commons.mom.MapObjectMapper;



/**
 * QuickBooks software provides an interface that allows you to use forms such as checks, deposit slips and invoices,
 * making the accounting process more comfortable for the average business owner or manager. By using the built-in
 * functions that pertain to your business, you are able to perform your company accounting by simply recording your
 * vendor activities, customer activities, banking transactions, payroll checks and taxes. QuickBooks handles the
 * accounting portion of each transaction behind the scenes.
 *
 * Read more: QuickBooks Accounting Tutorial | eHow.com http://www.ehow.com/way_5462311_quickbooks-accounting-tutorial.html#ixzz1csaydwxl
 * @author MuleSoft, inc.
 */
@Module(name = "quickbooks-windows", schemaVersion= "2.0", friendlyName = "Quickbooks Windows")
public class QuickBooksWindowsModule
{   
    /**
     * Quick-Books client. By default uses DefaultQuickBooksWindowsClient class.
     */
    @Configurable
    @Optional
    private QuickBooksWindowsClient client;
    
    private final MapObjectMapper mom = JaxbMapObjectMappers.defaultWithPackage("org.mule.modules.quickbooks.windows.schema").build();

    /**
     * The base uri of the quickbooks endpoint,
     * used to fetch the company uri. 
     * 
     * Quickbooks connector will first use this uri and the realmId to
     * get a second uri, called company uri, 
     * which is the actual quickbooks endpoint for the connector 
     *  
     */
    @Optional
    @Default("https://services.intuit.com/sb")
    @Configurable
    private String baseUri;
    
    
    /**
     * Creates.
     * 
     * For details of the supported objects and its fields: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0500_Supported_Objects">Supported Objects and Operations</a>
     * 
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:create}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:createJob}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:createCheck}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:createBill}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:createEmployee}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:createPayment}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:createItem}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:createCustomer}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:createAccount}
     *
     * @param realmId The realmID, also known as the Company ID, uniquely identifies the data for a company.
     *                In QuickBooks, the Company ID  appears on the My Account page.
     *                In Data Services for QuickBooks, the realmID is required in the URL for most calls.
     * @param appKey Application Id.
     * @param realmIdPseudonym Pseudonym Realm Id, obtained from the gateway that represents the company.
     * @param authIdPseudonym Pseudonym Auth Id, obtained from the gateway that represents the user.
     * @param type WindowsEntityType of the object.
     * @param entityObject represents the object to be created.
     * @param draft Boolean draft
     *      <p>Saving an IDS object in a draft state prevents it from being synchronized with Quickbooks. Your app 
     *      might want to save an object in a draft state if the user has not finished entering data, or for some other 
     *      reason the user does not want to commit the object for synchronization. You may save an object in draft state 
     *      during a create or update operation by specifying the draft="true" attribute. By default, the Draft attribute 
     *      is false, which means that the saved object will be synchronized with Quickbooks.</p>
     * @param fullResponse Boolean fullResponse. If this flag is true, it will return the created object, otherwise, it
     *                     will return an {@link ObjectRef}.
     * @return The created Object or an {@link ObjectRef} if the fullResponse flag was null of false.
     * 
     * @throws QuickBooksRuntimeException when there is a problem with the server. It has a code 
     *         and a message provided by quickbooks about the error.
     */
    @Processor
    public Object create(String realmId,
                         String appKey,
                         String realmIdPseudonym, 
                         String authIdPseudonym,
                         WindowsEntityType type,
                         @Optional @Default("#[payload]") Object entityObject,
                         @Optional @Default("false") Boolean draft,
                         @Optional @Default("false") Boolean fullResponse)
    {
        return client.create(realmId, appKey, realmIdPseudonym, authIdPseudonym, type,
                             entityObject, generateANewRequestId(), draft, fullResponse);
    }
    
    /**
     * Retrieve objects by ID.
     * 
     * For details of the supported objects:
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0500_Supported_Objects">Supported Objects and Operations</a>
     * 
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:get-object}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:get-object2}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:get-object3}
     * 
     * @param realmId The realmID, also known as the Company ID, uniquely identifies the data for a company.
     *                In QuickBooks, the Company ID  appears on the My Account page.
     *                In Data Services for QuickBooks, the realmID is required in the URL for most calls.
     * @param appKey Application Id.
     * @param realmIdPseudonym Pseudonym Realm Id, obtained from the gateway that represents the company.
     * @param authIdPseudonym Pseudonym Auth Id, obtained from the gateway that represents the user.
     * @param type WindowsEntityType of the object.
     * @param idType Id {@link IdType} which is assigned by Data Services when the object is created.
     * @return The object.
     * 
     * @throws QuickBooksRuntimeException when there is a problem with the server. It has a code 
     *         and a message provided by quickbooks about the error.
     */
    @Processor
    public Object getObject(String realmId,
                            String appKey,
                            String realmIdPseudonym,
                            String authIdPseudonym,
                            WindowsEntityType type,
                            @Optional @Default("#[payload]") Object idType)
    {
        return client.getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, (IdType) idType);
    }
    
    /**
     * Updates.
     * 
     * <p>Specify all the parameters for the object, not just the new or changed elements.
     * If you omit an element, it is removed from the object by the update operation.</p>
     * 
     * For details of the supported objects and its fields: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0500_Supported_Objects">Supported Objects and Operations</a>
     * 
     * <p>When updating transaction objects (such as Estimate or Invoice), note the following:</p>
     * <p>* To retain existing line items, specify them in the request XML body and do not change their order. </p>
     * <p>* To remove a line item, omit it. </p>
     * <p>* To add a new line item, insert a new one in the list.</p>
     * 
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:update}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:updateJob}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:updateCheck}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:updateBill}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:updateEmployee}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:updatePayment}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:updateItem}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:updateCustomer}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:updateAccount}
     *
     * @param realmId The realmID, also known as the Company ID, uniquely identifies the data for a company.
     *                In QuickBooks Online, the Company ID  appears on the My Account page.
     *                In Data Services for QuickBooks Online, the realmID is required in the URL for most calls.
     * @param appKey Application Id.
     * @param realmIdPseudonym Pseudonym Realm Id, obtained from the gateway that represents the company.
     * @param authIdPseudonym Pseudonym Auth Id, obtained from the gateway that represents the user.
     * @param type WindowsEntityType of the object.
     * @param entityObject represents the object to be updated.
     * @param draft Boolean draft 
     *      <p>Saving an IDS object in a draft state prevents it from being synchronized with Quickbooks. Your app 
     *      might want to save an object in a draft state if the user has not finished entering data, or for some other 
     *      reason the user does not want to commit the object for synchronization. You may save an object in draft state 
     *      during a create or update operation by specifying the draft="true" attribute. By default, the Draft attribute 
     *      is false, which means that the saved object will be synchronized with Quickbooks.</p>
     * @param fullResponse Boolean fullResponse. If this flag is true, it will return the created object, otherwise, it
     *                     will return an {@link ObjectRef}.
     * @return The updated Object or an {@link ObjectRef} if the fullResponse flag was null of false.
     * 
     * @throws QuickBooksRuntimeException when there is a problem with the server. It has a code 
     *         and a message provided by quickbooks about the error.
     */
    @Processor
    public Object update(String realmId,
                         String appKey,
                         String realmIdPseudonym, 
                         String authIdPseudonym,
                         WindowsEntityType type,
                         @Optional @Default("#[payload]") Object entityObject,
                         @Optional @Default("false") Boolean draft,
                         @Optional @Default("false") Boolean fullResponse)
    {
        return client.update(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, entityObject, 
                generateANewRequestId(), draft, fullResponse);
    }
    
    /**
     * Deletes an object.
     * <p>Most objects cannot be deleted by calling Data Services.</p>
     * <p>If the obj map do not have the MetaData field or the SyncToken, internally, will retrieve the
     * object at first, to delete it. So be careful, because it will need two request instead of one, which 
     * could make it slower.</p>
     * <p>For details of the supported objects and its fields: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0500_Supported_Objects">Supported Objects and Operations</a></p>
     * 
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:delete}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:deleteAccount}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:deleteCustomer}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:deleteBill}
     *
     * @param realmId The realmID, also known as the Company ID, uniquely identifies the data for a company.
     *                In QuickBooks Online, the Company ID  appears on the My Account page.
     *                In Data Services for QuickBooks Online, the realmID is required in the URL for most calls.
     * @param appKey Application Id.
     * @param realmIdPseudonym Pseudonym Realm Id, obtained from the gateway that represents the company.
     * @param authIdPseudonym Pseudonym Auth Id, obtained from the gateway that represents the user.
     * @param type WindowsEntityType of the object.
     * @param entityObject represents the object to be deleted.
     * @throws QuickBooksRuntimeException when there is a problem with the server. It has a code 
     *         and a message provided by quickbooks about the error.
     */
    @Processor
    public void delete(String realmId,
                       String appKey,
                       String realmIdPseudonym, String authIdPseudonym,
                       WindowsEntityType type,
                       @Optional @Default("#[payload]") Object entityObject)
    {
        client.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, entityObject, generateANewRequestId());
    }

    /**
     * Lazily retrieves Objects
     *
     * For details on how to generate a query see: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/0500_QuickBooks_Windows/
     * 0100_Calling_Data_Services/0015_Retrieving_Objects">Retrieve Especification</a>
     * 
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:find-objects}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:find-objects-bill}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:find-objects-all-accounts}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:find-objects-list-of-id}
     *
     * @param realmId The realmID, also known as the Company ID, uniquely identifies the data for a company.
     *                In QuickBooks Online, the Company ID  appears on the My Account page.
     *                In Data Services for QuickBooks Online, the realmID is required in the URL for most calls.
     * @param appKey Application Id.
     * @param realmIdPseudonym Pseudonym Realm Id, obtained from the gateway that represents the company.
     * @param authIdPseudonym Pseudonym Auth Id, obtained from the gateway that represents the user.
     * @param type WindowsEntityType of the object.
     * @param query Map that represents every filter and sort for the objects retrieved. Each type of object to be 
     *              retrieved, has a TheObjectQuery class that has the attributes for which it can be filtered 
     *              <p>(To know which attributes are accepted in every ObjectQuery, you could follow the link in 
     *              the documentation of the WindowsEntityType that you require, or you can follow the link changing 
     *              the word OBJECT for the object that you required, for example Account: 
     *              <p>https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     *              0500_QuickBooks_Windows/0600_Object_Reference/OBJECT</p>).</p>
     *              <p>Do not complete the fields chunkSize and startPage, because are need it for the "lazily retrieve".</p>
     *              If query is null, it will retrieve all the objects of that WindowsEntityType.
     * @return Iterable of the objects to be retrieved.
     * 
     * @throws QuickBooksRuntimeException when there is a problem with the server. It has a code 
     *         and a message provided by quickbooks about the error.
     */
    @SuppressWarnings("rawtypes")
    @Processor
    public Iterable findObjects(String realmId,
                                String appKey,
                                String realmIdPseudonym, 
                                String authIdPseudonym,
                                WindowsEntityType type, 
                                @Optional Map<String, Object> query)
    {
        if (query == null)
        {
            query = new HashMap<String, Object>();
        }
        
        return client.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, unmap(type.getQueryType(), query));
    }
    
    /**
     * Generate a new GUID for the requestId
     * 
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:generate-a-new-request-id}
     * 
     * @return a GUID for the requestId
     */
    @Processor
    public String generateANewRequestId()
    {
        return client.generateARequestId();
    }
    
    /**
     * Retrieve the Status
     * 
     * <p>Retrieves information about the sync status of Quickbooks entities. You can also query 
     * specific entity types for either synchronized or unsynchronized objects with filters. You can get information 
     * on recent synchronizations using the syncActivity operation.</p>
     * <p>Note: Sync status information will be maintained for all operations in the cloud up to 30 days old. 
     * Of those operations older than 30 days, only the last operation's synch status will be maintained.</p>
     * 
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:status}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:status2}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:status3}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:status4}
     * 
     * @param realmId The realmID, also known as the Company ID, uniquely identifies the data for a company.
     *                In QuickBooks Online, the Company ID  appears on the My Account page.
     *                In Data Services for QuickBooks Online, the realmID is required in the URL for most calls.
     * @param appKey Application Id.
     * @param realmIdPseudonym Pseudonym Realm Id, obtained from the gateway that represents the company.
     * @param authIdPseudonym Pseudonym Auth Id, obtained from the gateway that represents the user.
     * @param syncStatusRequest Map that represents a {@link SyncStatusRequest} object. It has the specifications
     *                          of the syncStatuses to be retrieved. (like a filter)
     * @return list of {@link SyncStatusResponse}
     */
    @Processor
    public List<SyncStatusResponse> status(String realmId,
                         String appKey,
                         String realmIdPseudonym, 
                         String authIdPseudonym,
                         @Optional Map<String, Object> syncStatusRequest)
    {
        if (syncStatusRequest == null)
        {
            syncStatusRequest = new HashMap<String, Object>();
        }
        
        return ((SyncStatusResponses) client.retrieveWithoutUsingQueryObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
            unmap(SyncStatusRequest.class, syncStatusRequest), "status")).getSyncStatusResponse();
    }
    
    /**
     * Retrieve the SyncActivities
     * 
     * <p>The SyncActivity object contains information about Quickbooks for Windows synchronizations. To get the sync 
     * status of another type of object, for example, a customer, use the status operation.  To filter a query based 
     * on whether or not an object  is synchronized, use a filter.</p>
     * <p>Note: Sync status information will be maintained for all operations in the cloud up to 30 days old. Of those 
     * operations older than 30 days, only the last operation's synch status will be maintained.</p>
     * 
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:sync-activity}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:sync-activity2}
     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:sync-activity3}
     * 
     * @param realmId The realmID, also known as the Company ID, uniquely identifies the data for a company.
     *                In QuickBooks Online, the Company ID  appears on the My Account page.
     *                In Data Services for QuickBooks Online, the realmID is required in the URL for most calls.
     * @param appKey Application Id.
     * @param realmIdPseudonym Pseudonym Realm Id, obtained from the gateway that represents the company.
     * @param authIdPseudonym Pseudonym Auth Id, obtained from the gateway that represents the user.
     * @param syncActivityRequest Map that represents a {@link SyncActivityRequest} object. It has the specifications
     *                            of the SyncActivities to be retrieved. (like a filter)
     * @return list of {@link SyncActivityResponse}
     */
    @Processor
    public List<SyncActivityResponse> syncActivity(String realmId,
                         String appKey,
                         String realmIdPseudonym, 
                         String authIdPseudonym,
                         @Optional Map<String, Object> syncActivityRequest)
    {
        if (syncActivityRequest == null)
        {
            syncActivityRequest = new HashMap<String, Object>();
        }
        
        return ((SyncActivityResponses) client.retrieveWithoutUsingQueryObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
            unmap(SyncActivityRequest.class, syncActivityRequest), "syncActivity")).getSyncActivityResponse();
    }
//    /**
//     * Revert.
//     * The revert operation discards all updates made to the object since its last sync to QuickBooks. An object can
//     * be reverted only if it has been synched with QuickBooks at least once. This implies that the object has been 
//     * updated by Data Services (that is, by an update operation). The object may be in the Draft state or not.
//     * <p>For details of the supported objects and its fields: 
//     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
//     * 0500_QuickBooks_Windows/0500_Supported_Objects">Supported Objects and Operations</a></p>
//     * 
//     * {@sample.xml ../../../doc/mule-module-quick-books-windows.xml.sample quickbooks-windows:revert}
//     * 
//     * @param realmId The realmID, also known as the Company ID, uniquely identifies the data for a company.
//     *                In QuickBooks Online, the Company ID  appears on the My Account page.
//     *                In Data Services for QuickBooks Online, the realmID is required in the URL for most calls.
//     * @param appKey Application Id.
//     * @param realmIdPseudonym Pseudonym Realm Id, obtained from the gateway that represents the company.
//     * @param authIdPseudonym Pseudonym Auth Id, obtained from the gateway that represents the user.
//     * @param type WindowsEntityType of the object.
//     * @param obj Map that represents the object to be created.
//     * @param requestId the unique request Id
//     * 
//     * @throws QuickBooksRuntimeException when there is a problem with the server. It has a code 
//     *         and a message provided by quickbooks about the error.
//     */
//    @Processor
//    public void revert(String realmId,
//                       String appKey,
//                       String realmIdPseudonym, 
//                       String authIdPseudonym,
//                       WindowsEntityType type, 
//                       Map<String, Object> obj,
//                       String requestId)
//    {
//        client.revert(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, unmap(type.getType(), obj), requestId);
//    }
    
    /**
     * post construct
     */
    @PostConstruct
    public void init()
    {
        if (client == null )
        {
            client = new DefaultQuickBooksWindowsClient(baseUri);
        }
    }
        
    @SuppressWarnings("unchecked")
    private <T> List<T> coalesceList(List<T> list )
    {
        return (List<T>) (list == null ? Collections.emptyList() : list);
    }
    
    private Map<String, Object> coalesceMap(Map<String, Object> map )
    {
        return map == null ? new HashMap<String, Object>() : map;
    }
    
    public void setBaseUri(String baseUri)
    {
        this.baseUri = baseUri;
    }
    
    public String getBaseUri()
    {
        return baseUri;
    }

    @SuppressWarnings("unchecked")
    private <A> A  unmap(Class<A> class1, Map<String, Object> id)
    {
        return (A) mom.unmap(id, class1);
    }
}
