package it.unibo.deathnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.ImplDeathNote;

class TestDeathNote {
    private static final int RULE = 3;
    private static final String CAUSE1 = "shot";
    private static final String CAUSE2 = "karting accident";
    private static final String CAUSE_DEF = "heart attack";
    private static final String NAME1 = "Mario";  
    private static final String NAME2 = "Jessica";  
    private DeathNote deathNote;

    @BeforeEach
    void setUp(){
        this.deathNote = new ImplDeathNote();
    }

    @Test
    public void testRule() {
        int array[] = new int[]{0, -RULE};
        for (int i : array) {
                assertThrowsExactly(IllegalArgumentException.class, new Executable() {
                    @Override
                    public void execute() throws Throwable { //Throwable è la classe degli errori
                        deathNote.getRule(i);
                    }
                });
        }
        
    }

    @Test
    public void testRuleNotNull(){
        for (String rule : DeathNote.RULES) {
            if(rule == null || rule == " "){
                throw new NullPointerException("the rule is null or blank");
            }
        }
    }

    @Test
    public void testName(){
        assertEquals(deathNote.isNameWritten(NAME1), false);
        deathNote.writeName(NAME1);
        assertEquals(deathNote.isNameWritten(NAME1), true);
        assertEquals(deathNote.isNameWritten(NAME2), false);
        assertEquals(deathNote.isNameWritten(" "), false);
    }


    @Test
    public void testCauseOfDeath(){

        assertThrows(IllegalStateException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                deathNote.writeDeathCause(CAUSE1);
            }
            
        });

        deathNote.writeName(NAME1);
        assertEquals(deathNote.getDeathCause(NAME1), CAUSE_DEF);

        deathNote.writeName(NAME2);
        //deathNote.writeDeathCause(CAUSE2);
        assertEquals(deathNote.writeDeathCause(CAUSE2), true);
        assertEquals(deathNote.getDeathCause(NAME2), CAUSE2);
        //RICONTROLLA
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
           throw new IllegalArgumentException();
        }
        deathNote.writeDeathCause(CAUSE1);
        assertEquals(deathNote.getDeathCause(NAME2), CAUSE2);
    }

}