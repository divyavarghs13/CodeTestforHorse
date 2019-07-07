package com.demo.HorseDemo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "lane")
@XmlAccessorType(XmlAccessType.FIELD)
public class Lane {
	
	 public Lane() {
		super();
		// TODO Auto-generated constructor stub
	}

	@XmlAttribute(name="number")
	 private int lanenumber;
	
	@XmlValue
	private int laneValue;
	 	 

	public int getLanenumber() {
		return lanenumber;
	}
	
	public void setLanenumber(int lanenumber) {
		this.lanenumber = lanenumber;
	}
	
	

	public int getLaneValue() {
		return laneValue;
	}

	public void setLaneValue(int laneValue) {
		this.laneValue = laneValue;
	}

	

	
	 
	 
}
