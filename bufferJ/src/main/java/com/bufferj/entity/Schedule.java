package com.bufferj.entity;

import java.util.List;
import java.util.Set;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class Schedule {

    private Set<String> days;
    private List<String> times;

    public Set<String> getDays() {
        return days;
    }

    public void addDay(Day day) {
        this.days.add(day.getName());
    }

    public List<String> getTimes() {
        return times;
    }

    public void addTime(Integer hour, Integer minute) {
        if (hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59) {
            this.times.add(hour + ":" + minute);
        }
    }

    @Override
    public String toString() {
        return "Schedule{" + "days=" + days + ", times=" + times + '}';
    }
}
