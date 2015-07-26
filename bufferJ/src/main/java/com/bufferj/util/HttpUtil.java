package com.bufferj.util;

import com.bufferj.entity.Schedule;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class HttpUtil {

    public static List<NameValuePair> createFormData(List<Schedule> schedules) {
        List<NameValuePair> formData = new ArrayList<>();

        for (int i = 0; i < schedules.size(); i++) {
            Schedule schedule = schedules.get(i);

            for (String day : schedule.getDays()) {
                formData.add(new BasicNameValuePair("schedules[" + i + "][days][]", day));
            }

            for (String time : schedule.getTimes()) {
                formData.add(new BasicNameValuePair("schedules[" + i + "][times][]", time));
            }
        }

        return formData;
    }
}
