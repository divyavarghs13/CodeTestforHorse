package com.demo.HorseDemo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "powerUps")
@XmlAccessorType(XmlAccessType.FIELD)
public class Loop implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@XmlAttribute
	private int number;
	
	//@XmlElementWrapper(name = "loop") 
	@XmlElement(name="lane" , type =Lane.class)
	private ArrayList<Lane> laneList;


	public Loop() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	


	public ArrayList<Lane> getLaneList() {
		if (laneList==null) {
			laneList=new ArrayList<Lane>();
        }
		return laneList;
	}


	public void setLaneList(ArrayList<Lane> laneList) {
		this.laneList = laneList;
	}


	@Override
	public String toString() {
		return "Loop [number=" + number + ", laneList=" + laneList + "]";
	}

	

	
}
