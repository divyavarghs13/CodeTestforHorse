package com.demo.HorseDemo.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.HorseDemo.model.Input;
import com.demo.HorseDemo.model.Loop;
import com.demo.HorseDemo.model.Participant;
import com.demo.HorseDemo.pojo.PowerUps;

@Controller
@ResponseBody
public class WelcomeController {	
	JAXBContext jaxbContext;
	
	private static final String xmlFile = "input_0.xml";
	
	@RequestMapping(value = "input",   method = RequestMethod.GET)
	public void handleXMLPostRequest() throws IOException {
		try {
			JAXBContext context = JAXBContext.newInstance(Input.class);
			Unmarshaller um = context.createUnmarshaller();
			Input input2 = (Input) um.unmarshal(new FileReader(xmlFile));
			for(Participant participant : input2.getStartList())				
			 {			
				System.out.println(" Horse name: " + participant.getName() );				
			}	
			for(Loop loop : input2.getPowerUps())				
			 {			
				System.out.println(" Loop number: " + loop.getNumber() );				
			}	
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}	
		  
}
