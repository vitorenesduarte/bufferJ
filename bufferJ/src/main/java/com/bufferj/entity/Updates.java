package com.bufferj.entity;

import java.util.List;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class Updates {

    private Long total;
    private List<Update> updates;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<Update> getUpdates() {
        return updates;
    }

    public void setUpdates(List<Update> updates) {
        this.updates = updates;
    }

    @Override
    public String toString() {
        return "Updates{" + "total=" + total + ", updates=" + updates + '}';
    }
}
