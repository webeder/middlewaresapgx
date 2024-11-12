/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gx.us.controllers;

/**
 *
 * @author Eder Quadros
 */

import com.gx.us.SimplePostService;
import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpDestination;
import com.sap.cloud.sdk.cloudplatform.connectivity.exception.DestinationAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import org.springframework.http.HttpHeaders;

@RestController
@RequestMapping("/api/middleware")
public class MiddlewareController {

   String baseUrl,csrfToken,cookie;
  
    @PostMapping
   public String post(@RequestHeader HttpHeaders headers ){
        
        
          csrfToken =  headers.get("x-csrf-token").toString();
          csrfToken = csrfToken.replace("[", "");
          csrfToken = csrfToken.replace("]", "");
          
           cookie =  headers.get("cookie").toString();
          cookie = cookie.replace("[", "");
          cookie = cookie.replace("]", "");
          
          
     
        
       
       // Destination destination = DestinationAccessor.getDestination("S4HANA_API_CLFN_PRODUCT_SRV").asHttp();
         
            // Recupera a URL base do destino como uma string
          /* baseUrl = destination.get("URL").toString();           
           baseUrl = baseUrl.replace("(", "");
           baseUrl = baseUrl.replace(")", "");
           baseUrl = baseUrl.replace("Some", "");          
           String bar = baseUrl + "/" + "sap/opu/odata/sap/z_gw_authorization_poc_srv/AuthorizationSet";*/
      //  String endpoint = "https://api.exemplo.com/seu-endpoint";
        String jsonBody = """
            {
                "Uname": "ZEUS_02",
                "ObjectName": "",
                "StartPurchorg": "",
                "StartPurchgroup": "",
                "EndPurchorg": "",
                "EndPurchgroup": "",
                "Status": false,
                "OrgLevel": [],
                "Objects": [
                    {
                        "Uname": "",
                        "ObjectName": "",
                        "Activities": []
                    }
                ]
            }
        """;

        // Instanciar o serviço e fazer a requisição POST
        SimplePostService postService = new SimplePostService(csrfToken,cookie);
        String response = postService.sendPostRequest(jsonBody);
        System.out.println("Resposta da requisição: " + response);      
        return "Resposta da requisição: " + response;
           
           
           
   }
   
   
}
    
    
    
    
    
  //  public ResponseEntity<?> postToSapService(
       //     @RequestHeader("x-csrf-token") String csrfToken,
           // @RequestHeader("destination-name") String destinationName,
            //@RequestParam("endpointPath") String endpointPath,
       //     @RequestBody Map<String, Object> data) {
        
        
        /*
                  @RequestHeader("x-csrf-token") String csrfToken,
            @RequestHeader("destination-name") String destinationName,
            @RequestParam("endpointPath") String endpointPath,
            @RequestBody Map<String, Object> data) {
        
        */
        
        

     //   try {
            // Recupera a destination usando o SAP SDK
        //    Destination destination = DestinationAccessor.getDestination(destinationName);
    //    Destination destination = DestinationAccessor.getDestination("S4HANA_API_CLFN_PRODUCT_SRV");
         
   //     if (!(destination instanceof HttpDestination)) {
    //            throw new DestinationAccessException("Destination não é do tipo HTTP");
    //        }
      //      HttpDestination httpDestination = destination.asHttp();
            
            
      //      String baseUrl = httpDestination.get("URL").toString();           
       //     baseUrl = baseUrl.replace("(", "");
       //     baseUrl = baseUrl.replace(")", "");

            // Constrói a URL completa para a requisição
        //    String url = baseUrl + SERVICE_PATH + ENTITY_NAME;
            
         //    String bar = baseUrl + "/" + "sap/opu/odata/sap/z_gw_authorization_poc_srv/AuthorizationSet";

         //   // Monta a URL completa com o endpointPath
        //    URI uri = URI.create(baseUrl + "/" + "sap/opu/odata/sap/z_gw_authorization_poc_srv/AuthorizationSet");
        //    URL url = uri.toURL();

            // Abre uma conexão HTTP
         //   HttpURLConnection connection = (HttpURLConnection) url.openConnection();
         //   connection.setRequestMethod("POST");
         //   connection.setRequestProperty("sap-client", "110");
         //   connection.setRequestProperty("x-csrf-token", csrfToken);
        
         //   connection.setDoOutput(true);

            // Converte o Map<String, Object> para JSON
         //   String jsonInput = new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(data);

            // Envia o JSON no corpo da requisição
         //   try (OutputStream os = connection.getOutputStream()) {
          //      byte[] input = jsonInput.getBytes("utf-8");
          //      os.write(input, 0, input.length);
         //   }

            // Lê a resposta do SAP
          //  int status = connection.getResponseCode();
          //  BufferedReader br = new BufferedReader(new InputStreamReader(
          //          status >= 200 && status < 300 ? connection.getInputStream() : connection.getErrorStream(), "utf-8"));

        //    StringBuilder response = new StringBuilder();
        //    String responseLine;
       //     while ((responseLine = br.readLine()) != null) {
        //        response.append(responseLine.trim());
        //    }
        //    connection.disconnect();

            // Retorna a resposta do SAP BTP para a aplicação que chamou o middleware
        //    return ResponseEntity.status(status).body(response.toString());

      //  } catch (DestinationAccessException e) {
            // Erro ao acessar a destination configurada no SAP BTP
        //    return ResponseEntity.status(500).body("Erro ao acessar a destination: " + e.getMessage());
       // } catch (Exception e) {
            // Loga o erro e retorna uma mensagem de erro
       //     return ResponseEntity.status(500).body("Erro ao processar a requisição: " + e.getMessage());
      //  }
   // }
//} */




