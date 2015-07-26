package com.bufferj.client.util;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public enum Event {

    FAVORITES("favorites"),
    MENTIONS("mentions"),
    RETWEETS("retweets"),
    LIKES("likes"),
    COMMENTS("comments");

    private final String name;

    private Event(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
