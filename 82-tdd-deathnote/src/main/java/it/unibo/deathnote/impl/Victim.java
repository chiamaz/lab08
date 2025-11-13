package it.unibo.deathnote.impl;

public class Victim {
    private String cause;
    private String details;
    private int time;

    public Victim(){

    }

    public String getCause() {
        return cause;
    }

    public String getDetails() {
        return details;
    }

    public int getTime() {
        return time;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
