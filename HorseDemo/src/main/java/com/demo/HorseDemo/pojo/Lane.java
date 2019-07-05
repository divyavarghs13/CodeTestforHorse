package com.demo.HorseDemo.pojo;

public class Lane
{
    private String number;

    private String content;

    public String getNumber ()
    {
        return number;
    }

    public void setNumber (String number)
    {
        this.number = number;
    }

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [number = "+number+", content = "+content+"]";
    }
}