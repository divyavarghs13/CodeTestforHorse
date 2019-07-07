package com.demo.HorseDemo.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.demo.HorseDemo.model.Participant;
import com.demo.HorseDemo.model.ParticipantLane;

@Service
public class HorseService {

	public Participant fetchWinner(Map<Integer, List<ParticipantLane>> partLoopMap,Map<Integer,Participant> partList) {
		Participant outputObj=new Participant();
		
		List<ParticipantLane> partLaneList=null;
		Map<Integer,Integer> outputPartMap=new HashMap<>();
		Map<Integer,Integer> partSpeedMap=new HashMap<>();
		
		for(Integer loop:partLoopMap.keySet()) {
			partLaneList=partLoopMap.get(loop);
			for(ParticipantLane partLane:partLaneList) {
				int partlaneSpeed=0;
				if(partSpeedMap.get(partLane.getPartId())!=null)
					partlaneSpeed=partLane.getSpeed()+partSpeedMap.get(partLane.getPartId());
				else
					partlaneSpeed=partLane.getSpeed();
				partSpeedMap.put(partLane.getPartId(), partlaneSpeed);
				int partSpeed=1000/partlaneSpeed;
				if(outputPartMap.get(partLane.getPartId())!=null)
				partSpeed=partSpeed+outputPartMap.get(partLane.getPartId());
				outputPartMap.put(partLane.getPartId(),partSpeed);
			}
				
		}
		Map.Entry<Integer, Integer> outputEntry = null;

		for (Map.Entry<Integer, Integer> entry : outputPartMap.entrySet())
		{
		    if (outputEntry == null || entry.getValue().compareTo(outputEntry.getValue()) < 0)
		    {
		    	outputEntry = entry;
		    }
		}
		
		return partList.get(outputEntry.getKey());
		
	}
	
}
