package com.bufferj.util;

import com.google.gson.Gson;
import java.lang.reflect.Type;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class JsonManager {

    private static final Gson gson = new Gson();

    public static <T extends Object> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
    
    public static <T extends Object> T fromJson(String json, Type type) {
        return gson.fromJson(json, type);
    }
}
