package com.bufferj.entity;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public enum Day {

    MONDAY("mon"),
    TUESDAY("tue"),
    WEDNESDAY("wed"),
    THURSDAY("thu"),
    FRIDAY("fri"),
    SATURDAY("sat"),
    SUNDAY("sun");

    private final String name;

    private Day(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
