package com.demo.HorseDemo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;


@XmlRootElement(name = "loop")
@XmlAccessorType(XmlAccessType.FIELD)
public class Lane {
	
	 public Lane() {
		super();
		// TODO Auto-generated constructor stub
	}
	 @XmlElement(name = "number")
	 private int number;
	
	@XmlValue
	private int laneValue;
	 	 
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getLaneValue() {
		return laneValue;
	}

	public void setLaneValue(int laneValue) {
		this.laneValue = laneValue;
	}

	

	
	 
	 
}
