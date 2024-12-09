/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gx.us;



//import com.sap.cloud.sdk.cloudplatform.connectivity.DefaultHttpDestination;
import com.google.gson.Gson;
import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpClientAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.exception.DestinationAccessException;
import com.sap.cloud.sdk.datamodel.odata.client.ODataProtocol;
import com.sap.cloud.sdk.datamodel.odata.client.query.StructuredQuery;
import com.sap.cloud.sdk.datamodel.odata.client.request.ODataRequestRead;
import com.sap.cloud.sdk.datamodel.odata.client.request.ODataRequestResultGeneric;

//import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;



public class Conecta {

     private final String servicePath; //BaseURL 
     private final String entityName; //Execute
     private final String destinationName; // destination nome 
    // private final String sapclient;
    // private final String top; // ATRIBUTO
     private final String var;
     String encodedQuery; // VARIAVEL LOCAL 
     
     
     static String erro = "{\"Error\":\"A classe não respondeu.\"}";
     
    //static String servicePath = "/sap/opu/odata/sap/API_CLFN_PRODUCT_SRV";
  //  static String entityName = "A_ProductCharcValue";
  //  static String destinationName = "******_API_CLFN_PRODUCT_SRV";

    public Conecta(String servicePath, String entityName, String destinationName,String var) {
        this.servicePath = servicePath;
        this.entityName = entityName;
        this.destinationName = destinationName;
        this.var        = var;
    }
  
    

   
    public String getRes() {
        
       try {
            Destination destination = DestinationAccessor.getDestination(destinationName);
            HttpClient httpClient = HttpClientAccessor.getHttpClient(destination);

            // Define the query
          //  if (top == "0"){
            String encodedQuery = StructuredQuery.onEntity(var, ODataProtocol.V2)                     
                    // .withCustomParameter("$format", "json")
                   // .withCustomParameter("sap-client", sapclient)
                    .getEncodedQueryString();
       /*     }else{ 
                     String encodedQuery = StructuredQuery.onEntity(entityName, ODataProtocol.V2)
                    .withCustomParameter("$top", top)
                    .withCustomParameter("$format", "json")
                    .withCustomParameter("sap-client", sapclient)
                    .getEncodedQueryString();
            }*/
            // Create a read request
            ODataRequestRead request = new ODataRequestRead(
                    servicePath,
                    entityName,
                    var,
                    ODataProtocol.V2);

            // Execute the request
            ODataRequestResultGeneric result = request.execute(httpClient);

            // Handle the response
       System.out.println("Response: " + result.asListOfMaps());
       
       String Json = new Gson().toJson(result.asListOfMaps());
         
        return Json;
        
        

    } catch (DestinationAccessException e) {
            
       
              return erro;
        }
    
        
        
     //   return result.asListOfMaps();
      
    }

    public void setRes(String res) {
    }

    public String getServicePath() {
        return servicePath;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public static String getErro() {
        return erro;
    }

   
    
    
    
}
