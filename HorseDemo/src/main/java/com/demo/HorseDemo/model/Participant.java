package com.demo.HorseDemo.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "participant")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "lane", "name", "baseSpeed" })
public class Participant implements Serializable{
	
private static final long serialVersionUID = 1L;

private int lane;
private String name;
private int baseSpeed;

public int getLane() {
	return lane;
}

public String getName() {
	return name;
}
public int getBaseSpeed() {
	return baseSpeed;
}

public void setLane(int lane) {
	this.lane = lane;
}

public void setName(String name) {
	this.name = name;
}

public void setBaseSpeed(int baseSpeed) {
	this.baseSpeed = baseSpeed;
}

@Override
public String toString() {
	return "Participant [lane=" + lane + ", name=" + name + ", baseSpeed=" + baseSpeed + "]";
}


}
