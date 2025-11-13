package it.unibo.deathnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.ImplDeathNote;

class TestDeathNote {
    private static final int RULE = 3;
    private static final int SLEEP1 = 100;
    private static final int SLEEP2 = 6100;
    private static final String CAUSE1 = "shot";
    private static final String CAUSE2 = "karting accident";
    private static final String CAUSE_DEF = "heart attack";
    private static final String NAME1 = "Mario";  
    private static final String NAME2 = "Jessica";  
    private static final String DETAILS1 = "ran for too long";
    private static final String DETAILS2 = "out of breath";

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
        try {
            Thread.sleep(SLEEP1);
        } catch (InterruptedException e) {
           throw new IllegalArgumentException();
        }
        deathNote.writeDeathCause(CAUSE1);
        assertEquals(deathNote.getDeathCause(NAME2), CAUSE2);


    }

    @Test
    public void testDetails(){
        assertThrows(IllegalArgumentException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                deathNote.getDeathDetails(NAME1);
            }
            
        });
        
        deathNote.writeName(NAME1);
        assertEquals(deathNote.getDeathDetails(NAME1), " ");
        //deathNote.writeDetails(DETAILS);
        assertEquals(deathNote.writeDetails(DETAILS1), true);
        assertEquals(deathNote.getDeathDetails(NAME1), DETAILS1);
        
        deathNote.writeName(NAME2);
        try {
            Thread.sleep(SLEEP2);
        } catch (InterruptedException e) {
           throw new IllegalArgumentException();
        }
        deathNote.writeDetails(DETAILS2);
        assertEquals(deathNote.writeDetails(DETAILS2), false);
        assertEquals(deathNote.getDeathDetails(NAME2), " ");

    }

}