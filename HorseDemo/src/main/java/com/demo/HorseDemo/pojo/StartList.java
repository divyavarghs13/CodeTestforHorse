package com.demo.HorseDemo.pojo;

public class StartList
{
    private Participant[] participant;

    public Participant[] getParticipant ()
    {
        return participant;
    }

    public void setParticipant (Participant[] participant)
    {
        this.participant = participant;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [participant = "+participant+"]";
    }
}
