package it.unibo.deathnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void setUp() {
        this.deathNote = new ImplDeathNote();
    }

    @Test
    void testRule() {
        final int[] array = {0, -RULE};
        for (final int i : array) {
                assertThrowsExactly(IllegalArgumentException.class, new Executable() {
                    @Override
                    public void execute() throws Throwable { //Throwable è la classe degli errori
                        deathNote.getRule(i);
                    }
                });
        }
    }

    @Test
    void testRuleNotNull() {
        for (final String rule : DeathNote.RULES) {
            if (rule == null || " ".equals(rule)) {
                throw new NullPointerException("the rule is null or blank"); //NOPMD
            }
        }
    }

    @Test
    void testName() {
        assertFalse(deathNote.isNameWritten(NAME1));
        deathNote.writeName(NAME1);
        assertTrue(deathNote.isNameWritten(NAME1));
        assertFalse(deathNote.isNameWritten(NAME2));
        assertFalse(deathNote.isNameWritten(" "));
    }

    @Test
    void testCauseOfDeath() {
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
        assertTrue(deathNote.writeDeathCause(CAUSE2));
        assertEquals(deathNote.getDeathCause(NAME2), CAUSE2);
        try {
            Thread.sleep(SLEEP1);
        } catch (final InterruptedException e) {
           throw (IllegalArgumentException) new IllegalArgumentException().initCause(e);
        }
        deathNote.writeDeathCause(CAUSE1);
        assertEquals(deathNote.getDeathCause(NAME2), CAUSE2);
    }

    @Test
    void testDetails() {
        assertThrows(IllegalArgumentException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                deathNote.getDeathDetails(NAME1);
            }
        });
        deathNote.writeName(NAME1);
        assertEquals(deathNote.getDeathDetails(NAME1), " ");
        //deathNote.writeDetails(DETAILS);
        assertTrue(deathNote.writeDetails(DETAILS1));
        assertEquals(deathNote.getDeathDetails(NAME1), DETAILS1);
        deathNote.writeName(NAME2);
        try {
            Thread.sleep(SLEEP2);
        } catch (final InterruptedException e) {
           throw (IllegalArgumentException) new IllegalArgumentException().initCause(e);
        }
        deathNote.writeDetails(DETAILS2);
        assertFalse(deathNote.writeDetails(DETAILS2));
        assertEquals(deathNote.getDeathDetails(NAME2), " ");
    }
}
