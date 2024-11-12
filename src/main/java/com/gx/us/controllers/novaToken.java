/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gx.us.controllers;

 
import com.gx.us.SapRequestExample;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eder Quadros 
 */

@RestController // Esse é um Controlador Rest
@RequestMapping( "/token" ) // Esse é o caminho do controlador  
public class novaToken
{
    // static String teste = "{\"Error\":\"Não foi possivel conectar\"}";
    // static String token = "{\"Error\":\"Token Inválido.\"}";
   //variaveis 
   String var , authorization, par ,baseurl, destino, sapclient; 
   
   
   
   
//    String csrf;
    /* @GetMapping(value = "/{userId}")
     public ResponseEntity getUser(@PathVariable("userId") String id){
         return new ResponseEntity("id: "+id,HttpStatus.ACCEPTED);
     }*/
    
    // @GetMapping 
    //  public String getAllUser(@RequestParam(value = "par", required = false) String par,@RequestParam(value = "baseurl", required = false) String baseurl, @RequestParam(value = "destino", required = false) String destino, @RequestParam(value = "sapclient", required = false) String sapclient) throws IOException{
        // return new ResponseEntity( "Destination: "+destino+" URI: "+baseurl +" Base "+par+" Sap-client "+sapclient ,HttpStatus.ACCEPTED); //SERVE PARA TESTAR SE FUNCIONA
            //baseurl = baseurl.replace("\/", "/");
           //   if (baseurl != null | baseurl.isBlank()){
        //  if (baseurl.isBlank()){
        //      return teste;  
        //  }else{
         // BuscaToken dest = new BuscaToken(baseurl, par, destino, var, sapclient);
        //  BuscaToken dest = new BuscaToken();
        //   return  dest.getRes(); 
    //   SapRequestExample dest = new SapRequestExample();  
    //     return  dest.getRes();
             
    //     }  
          @GetMapping 
     public String getAllUser(@RequestHeader HttpHeaders headers ) throws IOException{
   
         
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
         
         sapclient  = headers.get("sapclient").toString();         
         sapclient = sapclient.replace("[", "");
         sapclient = sapclient.replace("]", "");
         
         
         
        // authorization  = headers.get("authorization").toString();         
       //  authorization = authorization.replace("[", "");
        // authorization = authorization.replace("]", "");
         
        //authorization = destino+baseurl+par+sapclient;
         //return authorization;
    /// instancia vai aqui 
         SapRequestExample dest = new SapRequestExample(baseurl, par, destino, sapclient);
           return  dest.getRes();
             
  } 
 

 
     
     
    
     
     
     
    //http://localhost:8080/destination/?par=A_ProductCharcValue&baseurl=/sap/opu/odata/sap/API_CLFN_PRODUCT_SRV&destino=S4HANA_API_CLFN_PRODUCT_SRV 
     
  /*    @RequestMapping( method = RequestMethod.GET )
     public String testeapi() throws IOException {

         
            SapRequestExample dest = new SapRequestExample();  
         return  dest.getRes();
      //  TesteJava destino = new TesteJava();
      
    //  Conecta destino = new Conecta("/sap/opu/odata/sap/API_CLFN_PRODUCT_SRV", "A_ProductCharcValue", "S4HANA_API_CLFN_PRODUCT_SRV");
           
      
      //   return destino.getServicePath(); //destino.getRes();   
     
} */
     
        
}