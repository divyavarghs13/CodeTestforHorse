package com.demo.HorseDemo.pojo;

public class PowerUps
{
    private Loop[] loop;

    public Loop[] getLoop ()
    {
        return loop;
    }

    public void setLoop (Loop[] loop)
    {
        this.loop = loop;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [loop = "+loop+"]";
    }
}