package com.demo.HorseDemo.model;


import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "harryKart")
@XmlAccessorType(XmlAccessType.FIELD)
public class Input implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int numberOfLoops;
	
	@XmlElementWrapper(name = "startList") 
	@XmlElement(name = "participant", type = Participant.class)
	private ArrayList<Participant> startList;


	private ArrayList<Loop> powerUps;
	
	public int getNumberOfLoops() {
		return numberOfLoops;
	}

	public void setNumberOfLoops(int numberOfLoops) {
		this.numberOfLoops = numberOfLoops;
	}	

	public ArrayList<Participant> getStartList() {
        if (startList==null) {
        	startList=new ArrayList<Participant>();
        }
		return this.startList;
	}
	public void setStartList(ArrayList<Participant> startList) {
		this.startList = startList;
	}

	public ArrayList<Loop> getPowerUps() {
		
		  if (powerUps==null) {
			  powerUps=new ArrayList<Loop>();
	        }
			return this.powerUps;
	}

	@XmlElementWrapper(name = "powerUps") 
	@XmlElement(name = "loop", type = Loop.class)
	public void setPowerUps(ArrayList<Loop> powerUps) {
		this.powerUps = powerUps;
	}

	@Override
	public String toString() {
		return "Input [numberOfLoops=" + numberOfLoops + ", startList=" + startList + ", powerUps=" + powerUps + "]";
	}

	
	


	

}
