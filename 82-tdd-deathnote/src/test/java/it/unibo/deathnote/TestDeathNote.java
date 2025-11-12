package it.unibo.deathnote;

import org.junit.jupiter.api.BeforeEach;

import it.unibo.deathnote.api.DeathNote;

class TestDeathNote {
    private String name;
    private String cause;
    private String details;
    private int ruleNumber;

    @BeforeEach
    void setUp(){
        this.name = new String("mRossi");
        this.cause = new String("shot");
        this.details = new String("lot of blood");
        this.ruleNumber = 8;
    }

    

}