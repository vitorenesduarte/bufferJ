package com.bufferj.client.util;

import com.bufferj.entity.Update;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class ResponseWithUpdate {

    private Boolean success;
    private Update update;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Update getUpdate() {
        return update;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }
}
