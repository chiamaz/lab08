package it.unibo.deathnote.impl;

/**
 * Victim represents the cause of death, 
 * the details and the time, 
 * associated with the name of each victim.
 */
public final class Victim {
    private String cause;
    private String details;
    private int time;

    /**
     * Empty constructor.
     */
    public Victim() {
        /* This constructor is intentionally empty. 
        Nothing special is needed here. */ 
    }

    /**
     * @return the cause of the death of the victims.
     */
    public String getCause() {
        return cause;
    }

    /**
     * @return the details of the death of the victims.
     */
    public String getDetails() {
        return details;
    }

    /**
     * @return the time of death of the victims.
     */
    public int getTime() {
        return time;
    }

    /**
     * Sets this cause of death for the victim.
     * 
     * @param cause the cause of the human's death.
     */
    public void setCause(final String cause) {
        this.cause = cause;
    }

    /**
     * Sets this details of death for the victim.
     * 
     * @param details the details of the human's death.
     */
    public void setDetails(final String details) {
        this.details = details;
    }

    /**
     * Sets this time of death for the victim.
     * 
     * @param time of death.
     */
    public void setTime(final int time) {
        this.time = time;
    }
}
