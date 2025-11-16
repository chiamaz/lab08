package it.unibo.deathnote.impl;

import java.util.HashMap;
import java.util.Map;

import it.unibo.deathnote.api.DeathNote;

/**
 * Implementation of DeathNote.java.
 */
public final class ImplDeathNote implements DeathNote {
    private static final long MSEC1 = 40;
    private static final long MSEC2 = 6040;
    private static final String CAUSE_DEF = "heart attack";

    private final Map<String, Victim> map = new HashMap<>();
    private long time1;
    private String lastName;

    @Override
    public String getRule(final int ruleNumber) {
        if (ruleNumber < 1 || ruleNumber > RULES.size()) {
            throw new IllegalArgumentException("the given rule number is smaller than 1 or larger than the number of rules");
        }
        return RULES.get(ruleNumber - 1);
    }

    @Override
    public void writeName(final String name) {
        if (name == null) {
            throw new NullPointerException("the given name is null"); //NOPMD
        }
        map.put(name, new Victim());
        this.lastName = name;
        time1 = System.currentTimeMillis();
    }

    @Override
    public boolean writeDeathCause(final String cause) {
        if (cause == null || map.isEmpty()) {
            throw new IllegalStateException("the given cause is null or there is no name written");
        }

        final long time2 = System.currentTimeMillis();

        if (time2 - time1 <= MSEC1) {
            map.get(lastName).setCause(cause);
            //lastName=null;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean writeDetails(final String details) {
        if (details == null || map.isEmpty()) {
            throw new IllegalStateException("the given details is null or there is no name written");
        }

        final long time2 = System.currentTimeMillis();

        if (time2 - time1 <= MSEC2) {
            map.get(lastName).setDetails(details);
            //lastName=null;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getDeathCause(final String name) {
        if (!isNameWritten(name)) {
            throw new IllegalArgumentException("the name is not in the deathnote");
        }
        final String cause = map.get(name).getCause();
        if (cause == null) {
            return CAUSE_DEF;
        } else {
            return cause;
        }
    }

    @Override
    public String getDeathDetails(final String name) {
        if (!isNameWritten(name)) {
            throw new IllegalArgumentException("the name is not in the deathnote");
        }
        final String detail = map.get(name).getDetails();
        if (detail == null) {
            return " ";
        } else {
            return detail;
        }
    }

    @Override
    public boolean isNameWritten(final String name) {
        return map.containsKey(name);
    }

}
