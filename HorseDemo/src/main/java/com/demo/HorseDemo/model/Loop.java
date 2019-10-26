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

import org.springframework.beans.factory.annotation.Autowired;

@XmlRootElement(name = "loop")
@XmlAccessorType(XmlAccessType.FIELD)
public class Loop implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@XmlAttribute
	private int number;
	

	private ArrayList<Lane> lane;


	//public Loop() {
	//super();
		// TODO Auto-generated constructor stub
	//}

	
	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public ArrayList<Lane> getLaneList() {
		if (lane==null) {
			lane=new ArrayList<Lane>();
        }
		return lane;
	}


	@XmlElementWrapper(name = "loop")
	@XmlElement(name = "lane", type = Lane.class)
	public void setLaneList(ArrayList<Lane> laneList) {
		this.lane = laneList;
	}


	@Override
	public String toString() {
		return "Loop [number=" + number + ", laneList=" + lane + "]";
	}



	

	
}