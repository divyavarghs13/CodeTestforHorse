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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.demo.HorseDemo.util.RaceUtilitiy;

@Controller
@ResponseBody
@RequestMapping("/api")
public class WelcomeController {
	JAXBContext jaxbContext;

	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	private static final String xmlFile = "input_0.xml";

	@Autowired
	private HorseService horseService;

	@Autowired
	private RaceUtilitiy raceUtil;

	Map<Integer, Participant> participantMap = new HashMap<>();
	List<ParticipantLane> partList = new ArrayList<>();
	Map<Integer, List<ParticipantLane>> participantLoop = new HashMap<>();
	ParticipantLane partLaneObj = null;
	String resultData;

	@RequestMapping(value = "play", method = RequestMethod.GET, produces = "application/json")
	public String handleXMLPostRequest() throws IOException {

		try {

			JAXBContext context = JAXBContext.newInstance(Input.class);
			Unmarshaller um = context.createUnmarshaller();
			Input input2 = (Input) um.unmarshal(new FileReader(xmlFile));
			processXMLToPojo(input2);
			List<Participant> outputList = horseService.fetchWinner(participantLoop, participantMap);
			resultData = raceUtil.GetJSONData(outputList);
			return resultData;
		}

		catch (JSONException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultData;
	}

	public void processXMLToPojo(Input input) throws IOException {
		/**
		 * Retrieving Participant details as list from startList. Set a pojo class with
		 * Lane number as Participant ID along with other Participant data. Initialize a
		 * map with Key as Participant ID and Participant Object as Value
		 **/
		for (Participant participant : input.getStartList()) {
			partLaneObj = new ParticipantLane();
			partLaneObj.setPartId(participant.getLane());
			partLaneObj.setParticipant(participant);
			partLaneObj.setSpeed(10);
			participantMap.put(participant.getLane(), participant);
			partList.add(partLaneObj);
			logger.info(" Participant: " + participant.getName() + ", Lane: " + participant.getLane());
		}
		/**
		 * Initialize the map with key as 0 to consider as 1st loop and value as the
		 * list with participant details
		 **/
		participantLoop.put(0, partList);
		/**
		 * Retrieve the loop data from input xml file. The lane number is added to
		 * participant object and adding to the list
		 **/
		for (Loop loop : input.getPowerUps()) {
			ParticipantLane partLaneNewObj = null;
			partList = new ArrayList<>();
			for (Lane lane : loop.getLaneList()) {
				partLaneNewObj = new ParticipantLane();
				// logger.info("lane number :" + lane.getLanenumber()+", lane value :" +
				// lane.getLaneValue());
				partLaneNewObj.setPartId(lane.getLanenumber());
				partLaneNewObj.setSpeed(lane.getLaneValue());
				partLaneNewObj.setParticipant(participantMap.get(lane.getLanenumber()));
				partList.add(partLaneNewObj);
			}
			// System.out.println(" Loop number: " + loop.getNumber());
			/** We add the data to the map with key increasing each time in the loop **/
			participantLoop.put(loop.getNumber(), partList);

		}
	}
}
