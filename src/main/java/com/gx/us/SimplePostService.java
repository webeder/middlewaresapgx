/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gx.us;

/**
 *
 * @author 086997
 */

import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SimplePostService {
    private String token, cookie;
     String requestUrl ;

    // Construtor para inicializar o token
    public SimplePostService(String token,String cookie) {
        this.token = token;
        this.cookie = cookie;
    }

    // Método que realiza a requisição POST e retorna a resposta como uma String
    public String sendPostRequest(String jsonBody) {
        String responseContent = "";

        try {
            // Obtém a destination configurada
            Destination destination = DestinationAccessor.getDestination("S4HANA_API_CLFN_PRODUCT_SRV").asHttp();
            if (destination == null) {
                
                return "Erro: Destination não encontrada.";
               
            }

            // Obter a URL base da Destination
          String baseUrl = destination.get("URL").toString(); 
          
                
           baseUrl = baseUrl.replace("(", "");
           baseUrl = baseUrl.replace(")", "");
           baseUrl = baseUrl.replace("Some", "");   
          
          
          
          
           requestUrl = baseUrl + "/sap/opu/odata/sap/z_gw_authorization_poc_srv/AuthorizationSet";

            // Configuração da conexão
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("sap-client", "110");
            connection.setRequestProperty("Authorization", "Basic SUFTX0RFVl9QT0M6UGFzc3dvcmRpYXNwb2NAMjAyNA==");
          //  connection.setRequestProperty( "Cookie", cookie);
           
            connection.setRequestProperty("x-csrf-token", token);
            connection.setDoOutput(true);

            // Enviar o JSON no corpo da requisição
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonBody.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
           
            // Obter a resposta
            int statusCode = connection.getResponseCode();
            System.out.println("Código de resposta: " + statusCode);

            if (statusCode == HttpURLConnection.HTTP_OK) {
                // Ler o corpo da resposta
                StringBuilder response = new StringBuilder();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                }
                responseContent = response.toString();
            } else {
                responseContent = "Erro na requisição: Código de resposta " + statusCode;
            }

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
            responseContent = "Erro: " + e.getMessage()+""+requestUrl ;
        }

        // Retornar o conteúdo da resposta
        return responseContent;
    }
}
