package com.bufferj.util;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.bufferj.client.util.Error;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class JsonManager {

    private static final Gson gson = new Gson();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static Object fromJson(String json, Class<?> clazz) {
        Error error = getError(json);
        return error == null ? gson.fromJson(json, clazz) : error;
    }

    public static Object fromJson(String json, Type type) {
        Error error = getError(json);
        return error == null ? gson.fromJson(json, type) : error;
    }

    private static Error getError(String json) {
        Error error;
        try {
            error = gson.fromJson(json, Error.class);
        } catch (Exception e) {
            error = null;
        }

        return isValidError(error) ? error : null;
    }

    private static Boolean isValidError(Error error) {
        return error != null && error.getCode() != null && error.getCode() != null;
    }
}
