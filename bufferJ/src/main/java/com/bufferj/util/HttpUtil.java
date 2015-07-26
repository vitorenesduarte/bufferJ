package com.bufferj.util;

import com.bufferj.client.util.CreateOrEditUpdates;
import com.bufferj.entity.Profile;
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

    public static List<NameValuePair> createFormData(CreateOrEditUpdates update) {
        List<NameValuePair> formData = new ArrayList<>();
        
        if(update.getProfiles() != null){
            for(Profile profile : update.getProfiles()){
                if(profile.getId() != null){
                    formData.add(new BasicNameValuePair("profile_ids[]", profile.getId()));
                }
            }
        }
        
        if(update.getText() != null){
            formData.add(new BasicNameValuePair("text", update.getText()));
        }
        
        if(update.getShorten() != null){
            formData.add(new BasicNameValuePair("shorten", update.getShorten().toString()));
        }
        
        if(update.getNow() != null){
            formData.add(new BasicNameValuePair("now", update.getNow().toString()));
        }

        if(update.getTop() != null){
            formData.add(new BasicNameValuePair("top", update.getTop().toString()));
        }

        if(update.getMediaLink() != null){
            formData.add(new BasicNameValuePair("media[link]", update.getMediaLink()));
        }
        
        if(update.getMediaDescription()!= null){
            formData.add(new BasicNameValuePair("media[description]", update.getMediaDescription()));
        }
        
        if(update.getMediaTitle() != null){
            formData.add(new BasicNameValuePair("media[title]", update.getMediaTitle()));
        }
        
        if(update.getMediaPicture() != null){
            formData.add(new BasicNameValuePair("media[picture]", update.getMediaPicture()));
        }
        
        if(update.getMediaThumbnail()!= null){
            formData.add(new BasicNameValuePair("media[thumbnail]", update.getMediaThumbnail()));
        }
        
        if(update.getAttachment() != null){
            formData.add(new BasicNameValuePair("attachment", update.getAttachment().toString()));
        }
        
        if(update.getScheduledAt() != null){
            formData.add(new BasicNameValuePair("scheduled_at", update.getScheduledAt().toString()));
        }
        
        return formData;
    }
}
