package com.demo.HorseDemo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "Lane")
@XmlAccessorType(XmlAccessType.FIELD)
public class Lane {
	
	 public Lane() {
		super();
		// TODO Auto-generated constructor stub
	}

	@XmlAttribute(name="number")
	 private int lanenumber;
	 	 
	 private int lane;

	public int getLanenumber() {
		return lanenumber;
	}
	
	public void setLanenumber(int lanenumber) {
		this.lanenumber = lanenumber;
	}

	public int getLane() {
		return lane;
	}

	public void setLane(int lane) {
		this.lane = lane;
	}

	@Override
	public String toString() {
		return "Lane [number=" + lanenumber + ", lanevalue=" + lane + "]";
	}
	 
	 
}
