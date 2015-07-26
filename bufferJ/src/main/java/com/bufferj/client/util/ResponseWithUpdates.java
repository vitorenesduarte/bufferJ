package com.bufferj.client.util;

import com.bufferj.entity.Update;
import java.util.List;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class ResponseWithUpdates {

    private Boolean success;
    private List<Update> updates;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Update> getUpdates() {
        return updates;
    }

    public void setUpdates(List<Update> updates) {
        this.updates = updates;
    }
}
