package com.gx.us;

import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpClientAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpDestinationProperties;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;

public class SapRequestExample {

  private  String SERVICE_PATH ; //  = "/sap/opu/odata/sap/";
  private  String ENTITY_NAME; //  = "z_gw_authorization_poc_srv";
  private  String DESTINATION_NAME; // = "****_API_CLFN_PRODUCT_SRV";
  private  String baseUrl;
  private  String client; 

    public SapRequestExample(String SERVICE_PATH, String ENTITY_NAME, String DESTINATION_NAME, String client) {
        this.SERVICE_PATH = SERVICE_PATH;
        this.ENTITY_NAME = ENTITY_NAME;
        this.DESTINATION_NAME = DESTINATION_NAME;
        this.client = client;    }

     public String getRes() throws IOException{
     
            Destination destination = DestinationAccessor.getDestination(DESTINATION_NAME).asHttp();
         
            // Recupera a URL base do destino como uma string
           baseUrl = destination.get("URL").toString();
           
           baseUrl = baseUrl.replace("(", "");
           baseUrl = baseUrl.replace(")", "");

            // Constrói a URL completa para a requisição
            String url = baseUrl + SERVICE_PATH + ENTITY_NAME;

            HttpClient httpClient = HttpClientAccessor.getHttpClient((HttpDestinationProperties) destination);

            // Configura a requisição GET
            HttpGet request = new HttpGet(url);
            request.setHeader("x-csrf-token", "fetch");
            request.setHeader("sap-client", client.trim());
            // Executa a requisição
            HttpResponse response = httpClient.execute(request);

            // Verifica o código de status da resposta
            int statusCode = response.getStatusLine().getStatusCode();
            
            if (statusCode == 200) {
                // Lê a resposta
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println("Resposta: " + responseBody);
                
                //  System.out.println("Cabeçalhos da Resposta:");
               // for (Header header : response.getAllHeaders()) {
                 //   System.out.println(header.getName() + ": " + header.getValue());
               // }
               
                Header csrfTokenHeader = response.getFirstHeader("x-csrf-token");
                Header setcookie = response.getFirstHeader("set-cookie");
                
   
                
                if (csrfTokenHeader != null) {
                    String csrfToken = csrfTokenHeader.getValue();
                    System.out.println("x-csrf-token: " + csrfToken);
                    
              //   String Json = new Gson().toJson(pg);
                     return  csrfToken; 
// csrfToken;
                } else {
                    System.out.println("x-csrf-token não encontrado na resposta.");
                     return "x-csrf-token não encontrado na resposta";
                }
  
            } else {
                System.err.println("Erro na resposta: Código " + statusCode);
                
                 return "Error na esposta da classe";
            }
            
        }
   }

 
     
 
 
 
 
