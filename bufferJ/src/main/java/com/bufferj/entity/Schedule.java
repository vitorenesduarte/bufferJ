package com.bufferj.entity;

import java.util.List;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class Schedule {

    private List<String> days;
    private List<String> times;

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "Schedule{" + "days=" + days + ", times=" + times + '}';
    }
}
