/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gx.us.controllers;

import com.gx.us.Conecta;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
  

// OBS SÓ TESTA A DESTINATION ESSE PROGRAMA 


//import com.sap.cloud.sdk.us.models.HelloWorldResponse;
//import com.sap.cloud.sdk.us.models.Unida;

@RestController // Esse é um Controlador Rest
@RequestMapping( "/destination/" ) // Esse é o caminho do controlador  
public class nova
{
     static String teste = "{\"Error\":\"Não foi possivel conectar\"}";
     static String token = "{\"Error\":\"Token Inválido.\"}";
    String  baseurl;
    String par;
    String destino; 
    String  authorization;
    String sapclient;
    String var;
    String top;
    /* @GetMapping(value = "/{userId}")
     public ResponseEntity getUser(@PathVariable("userId") String id){
         return new ResponseEntity("id: "+id,HttpStatus.ACCEPTED);
     }*/
     /*
     @GetMapping 
     public String getAllUser(@RequestParam(value = "par", required = false) String par,@RequestParam(value = "baseurl", required = false) String baseurl, @RequestParam(value = "destino", required = false) String destino){
        // return new ResponseEntity( "Destination: "+destino+"URI: "+baseurl +" Base "+par ,HttpStatus.ACCEPTED);
            //baseurl = baseurl.replace("\/", "/");
           //   if (baseurl != null | baseurl.isBlank()){
          if (baseurl.isBlank()){
              return teste;  
          }else{
               Conecta dest = new Conecta(baseurl, par, destino);       
          return dest.getRes();  
             
          }  
             
     } 
     */
     
       @GetMapping 
     public String getAllUser(@RequestHeader HttpHeaders headers ){
   
         
         /*limpa variaveis */
         baseurl =  headers.get("Baseurl").toString();
         baseurl = baseurl.replace("[", "");
         baseurl = baseurl.replace("]", "");
         
         par =  headers.get("par").toString();
         par = par.replace("[", "");
         par = par.replace("]", "");
         
         destino =  headers.get("destino").toString();
         destino = destino.replace("[", "");
         destino = destino.replace("]", "");
         
         authorization  = headers.get("authorization").toString();         
         authorization = authorization.replace("[", "");
         authorization = authorization.replace("]", "");
         
       //   sapclient  = headers.get("sapclient").toString();         
       //  sapclient = sapclient.replace("[", "");
       //  sapclient = sapclient.replace("]", "");
         
      //   top  = headers.get("top").toString();         
      //   top = top.replace("[", "");
      //   top = top.replace("]", "");
         
     
         var  = headers.get("var").toString();         
         var = var.replace("[", "");
         var = var.replace("]", "");
         
         
         /*verifica se o token é igual*/
          if ("Rx35M274".equals(authorization)){
              
              
              if (baseurl.isEmpty()){
                   return  "{\"Error\":\"BaseUrl não pode ser vazio\"}";
              }else if (destino.isEmpty()) {
                   return  "{\"Error\":\"Destino não pode ser vazio\"}";
              }else if (par.isEmpty()) {
                   return  "{\"Error\":\"Parametro não pode ser vazio\"}";
              }else if (var.isEmpty()) {
                   return  "{\"Error\":\"Parametro variaveis não pode ser vazio\"}";     
              }else{
              /*vamos chamar a classe*/
              //   return headers.toString(); //teste headers 
              
              /*chama a classe */
              Conecta dest = new Conecta(baseurl, par, destino,var);       
               return dest.getRes();  
                    //  throw new AssertionError();
              }             
    }else{
              //  Conecta dest = new Conecta(baseurl, par, destino);       
        
           return token; 
             
          }  
             
     } 
     
     
     
    
     
     
     
    //http://localhost:8080/destination/?par=A_ProductCharcValue&baseurl=/sap/opu/odata/sap/API_CLFN_PRODUCT_SRV&destino=S4HANA_API_CLFN_PRODUCT_SRV 
     
    /* @RequestMapping( method = RequestMethod.GET )
     public String testeapi() {

      //  TesteJava destino = new TesteJava();
      
      Conecta destino = new Conecta("/sap/opu/odata/sap/API_CLFN_PRODUCT_SRV", "A_ProductCharcValue", "S4HANA_API_CLFN_PRODUCT_SRV");
           
      
         return destino.getServicePath(); //destino.getRes();   
     
}*/
     
        
}