package com.bufferj.entity;

import java.util.List;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class Interactions {

    private Long total;
    private List<Interaction> interactions;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<Interaction> getInteractions() {
        return interactions;
    }

    public void setInteractions(List<Interaction> interactions) {
        this.interactions = interactions;
    }
}
