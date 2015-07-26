package com.bufferj.entity;

import java.util.ArrayList;
import java.util.HashSet;
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
        if(days == null){
            days = new HashSet<>();
        }
        
        this.days.add(day.getName());
    }

    public List<String> getTimes() {
        return times;
    }

    public void addTime(Integer hour, Integer minute) {
        if(times == null){
            times = new ArrayList<>();
        }

        if (hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59) {
            String time = toString(hour) + ":" + toString(minute);
            this.times.add(time);
        }
    }
    
    private String toString(Integer time){
        return (time >= 10 ? "" : "0") + time;
    }

    @Override
    public String toString() {
        return "Schedule{" + "days=" + days + ", times=" + times + '}';
    }
}
