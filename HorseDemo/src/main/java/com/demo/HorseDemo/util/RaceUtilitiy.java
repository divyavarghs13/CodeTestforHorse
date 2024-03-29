package com.demo.HorseDemo.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.HorseDemo.controller.WelcomeController;
import com.demo.HorseDemo.model.Input;
import com.demo.HorseDemo.model.Lane;
import com.demo.HorseDemo.model.Loop;
import com.demo.HorseDemo.model.Participant;
import com.demo.HorseDemo.model.ParticipantLane;

@Component
public class RaceUtilitiy {
	
	private static final Logger logger = LoggerFactory.getLogger(RaceUtilitiy.class);
	private String jsonStr;
	public String GetJSONData(List<Participant> outputList){
		JSONArray outputArray = new JSONArray();
		JSONObject outputJson = new JSONObject();

		try {
			JSONObject participantJson = null;
			int counter = 1;
			for (Participant participant : outputList) {
				participantJson = new JSONObject();
				participantJson.put("horse", participant.getName());
				participantJson.put("Position", counter);
				counter++;
				outputArray.put(participantJson);
			}
			outputJson.put("ranking", outputArray);

			// get Organisation object as a json string
			 jsonStr = outputJson.toString();
			// Displaying JSON String
			logger.info(jsonStr);
			
	}

	catch (JSONException e) {
		e.printStackTrace();
	}
return jsonStr;
}
}