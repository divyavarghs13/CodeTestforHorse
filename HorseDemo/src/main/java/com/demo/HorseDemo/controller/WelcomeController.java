package com.demo.HorseDemo.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.HorseDemo.model.Input;
import com.demo.HorseDemo.model.Lane;
import com.demo.HorseDemo.model.Loop;
import com.demo.HorseDemo.model.Participant;
import com.demo.HorseDemo.model.ParticipantLane;
import com.demo.HorseDemo.service.HorseService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@ResponseBody
public class WelcomeController {
	JAXBContext jaxbContext;

	private static final String xmlFile = "input_0.xml";
	
	@Autowired
	private HorseService horseService;

	@RequestMapping(value = "input", method = RequestMethod.GET)
	public void handleXMLPostRequest() throws IOException {
		try {
			JAXBContext context = JAXBContext.newInstance(Input.class);
			Unmarshaller um = context.createUnmarshaller();
			Input input2 = (Input) um.unmarshal(new FileReader(xmlFile));

			Map<Integer, Participant> participantMap = new HashMap<>();
			List<ParticipantLane> partList = new ArrayList<>();
			Map<Integer, List<ParticipantLane>> participantLoop = new HashMap<>();
			ParticipantLane partLaneObj = null;
			for (Participant participant : input2.getStartList()) {
				partLaneObj = new ParticipantLane();
				partLaneObj.setPartId(participant.getLane());
				partLaneObj.setParticipant(participant);
				partLaneObj.setSpeed(10);
				participantMap.put(participant.getLane(), participant);
				partList.add(partLaneObj);
				System.out.println(" Horse name: " + participant.getName());
			}
			participantLoop.put(0, partList);

			for (Loop loop : input2.getPowerUps()) {
				ParticipantLane partLaneNewObj = null;
				partList=new ArrayList<>();
				for (Lane lane : loop.getLaneList()) {
					partLaneNewObj = new ParticipantLane();
					System.out.println("lane number :" + lane.getLanenumber());
					System.out.println("lane value :" + lane.getLaneValue());
					partLaneNewObj.setPartId(lane.getLanenumber());
					partLaneNewObj.setSpeed(lane.getLaneValue());
					partLaneNewObj.setParticipant(participantMap.get(lane.getLanenumber()));
					partList.add(partLaneNewObj);
				}
				System.out.println(" Loop number: " + loop.getNumber());
				participantLoop.put(loop.getNumber(), partList);

			}
			System.out.println("Here ///" + participantLoop.size());
			Participant outputObj=horseService.fetchWinner(participantLoop, participantMap);
	  JSONObject outputJson=new JSONObject();
	        try { 
	        	outputJson.put("Lane", outputObj.getLane());
	        	outputJson.put("Name", outputObj.getName());
	            // get Oraganisation object as a json string 
	            String jsonStr = outputJson.toString(); 	  
	            // Displaying JSON String 
	            System.out.println(jsonStr); 
	        } 
	  
	        catch (JSONException e) { 
	            e.printStackTrace(); 
	        } 
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
