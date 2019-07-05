package com.demo.HorseDemo.pojo;


public class Participant
{
private String baseSpeed;

private String name;

private String lane;

public String getBaseSpeed ()
{
return baseSpeed;
}

public void setBaseSpeed (String baseSpeed)
{
this.baseSpeed = baseSpeed;
}

public String getName ()
{
return name;
}

public void setName (String name)
{
this.name = name;
}

public String getLane ()
{
return lane;
}

public void setLane (String lane)
{
this.lane = lane;
}

@Override
public String toString()
{
return "ClassPojo [baseSpeed = "+baseSpeed+", name = "+name+", lane = "+lane+"]";
}
}

