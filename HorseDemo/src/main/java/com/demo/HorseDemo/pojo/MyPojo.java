package com.demo.HorseDemo.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class MyPojo
{

    private HarryKart harryKart;

    public HarryKart getHarryKart ()
    {
        return harryKart;
    }

    public void setHarryKart (HarryKart harryKart)
    {
        this.harryKart = harryKart;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [harryKart = "+harryKart+"]";
    }
}
	