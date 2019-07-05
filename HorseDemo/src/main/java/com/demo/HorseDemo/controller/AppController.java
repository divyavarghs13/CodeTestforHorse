package com.demo.HorseDemo.controller;
import java.util.Map;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.HorseDemo.pojo.MyPojo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@RestController
public class AppController {
	/**
	@PostMapping(path = "/read", consumes={MediaType.APPLICATION_XML_VALUE})
public void handleXMLPostRequest (@RequestBody MyPojo mypojo) {
    	System.out.println(mypojo);
}
	**/

	@RequestMapping(value="/read",method=RequestMethod.POST,consumes = MediaType.APPLICATION_XML_VALUE)
    public String convertXMLtoJson(@RequestBody MyPojo mypojo) {
        String json="";
        try {
        	/**
            ObjectMapper objectMapper = new XmlMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            ObjectMapper jsonMapper = new ObjectMapper();
           mypojo = objectMapper.readValue(mypojo, MyPojo.class);
         json =jsonMapper.writeValueAsString(mypojo);
           System.out.println(jsonMapper.writeValueAsString(mypojo));
         **/
           System.out.println(mypojo.toString());
          
          
         
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
