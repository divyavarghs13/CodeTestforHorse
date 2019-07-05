package com.demo.HorseDemo.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


public class HarryKart
{
	
private String numberOfLoops;

private StartList startList;

private PowerUps powerUps;

public String getNumberOfLoops ()
{
return numberOfLoops;
}

public void setNumberOfLoops (String numberOfLoops)
{
this.numberOfLoops = numberOfLoops;
}

public StartList getStartList ()
{
return startList;
}

public void setStartList (StartList startList)
{
this.startList = startList;
}

public PowerUps getPowerUps ()
{
return powerUps;
}

public void setPowerUps (PowerUps powerUps)
{
this.powerUps = powerUps;
}

@Override
public String toString()
{
return "ClassPojo [numberOfLoops = "+numberOfLoops+", startList = "+startList+", powerUps = "+powerUps+"]";
}
}


