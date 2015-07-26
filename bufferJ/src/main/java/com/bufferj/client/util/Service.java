package com.bufferj.client.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public enum Service {

    TWITTER("twitter"),
    FACEBOOK("facebook"),
    LINKEDIN("linkedin"),
    UNKNOWN("unknown");
    
    private final String name;
    private static final Map<String, Service> map = new HashMap<>();

    static {
        Service[] values = values();
        for (Service value : values) {
            map.put(value.getName(), value);
        }
    }

    private Service(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Service getService(String name) {
        Service service = map.get(name);
        if (service == null) {
            service = UNKNOWN;
        }

        return service;
    }
}
