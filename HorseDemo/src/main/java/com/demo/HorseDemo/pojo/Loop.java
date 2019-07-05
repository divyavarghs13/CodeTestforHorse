package com.demo.HorseDemo.pojo;

public class Loop
{
    private String number;

    private Lane[] lane;

    public String getNumber ()
    {
        return number;
    }

    public void setNumber (String number)
    {
        this.number = number;
    }

    public Lane[] getLane ()
    {
        return lane;
    }

    public void setLane (Lane[] lane)
    {
        this.lane = lane;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [number = "+number+", lane = "+lane+"]";
    }
}