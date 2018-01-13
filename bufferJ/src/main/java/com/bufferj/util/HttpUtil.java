package com.bufferj.util;

import com.bufferj.client.util.CreateUpdates;
import com.bufferj.client.util.EditUpdate;
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

    // this and the next method should be refactored - do not repeat code (maybe with an interface)
    public static List<NameValuePair> createFormData(CreateUpdates updates) {
        List<NameValuePair> formData = new ArrayList<>();

        if (updates.getProfiles() != null) {
            for (Profile profile : updates.getProfiles()) {
                if (profile.getId() != null) {
                    formData.add(new BasicNameValuePair("profile_ids[]", profile.getId()));
                }
            }
        }

        if (updates.getText() != null) {
            formData.add(new BasicNameValuePair("text", updates.getText()));
        }

        if (updates.getShorten() != null) {
            formData.add(new BasicNameValuePair("shorten", updates.getShorten().toString()));
        }

        if (updates.getNow() != null) {
            formData.add(new BasicNameValuePair("now", updates.getNow().toString()));
        }

        if (updates.getTop() != null) {
            formData.add(new BasicNameValuePair("top", updates.getTop().toString()));
        }

        if (updates.getMediaLink() != null) {
            formData.add(new BasicNameValuePair("media[link]", updates.getMediaLink()));
        }

        if (updates.getMediaDescription() != null) {
            formData.add(new BasicNameValuePair("media[description]", updates.getMediaDescription()));
        }

        if (updates.getMediaTitle() != null) {
            formData.add(new BasicNameValuePair("media[title]", updates.getMediaTitle()));
        }

        if (updates.getMediaPicture() != null) {
            formData.add(new BasicNameValuePair("media[picture]", updates.getMediaPicture()));
        }

        if (updates.getMediaThumbnail() != null) {
            formData.add(new BasicNameValuePair("media[thumbnail]", updates.getMediaThumbnail()));
        }

        if (updates.getAttachment() != null) {
            formData.add(new BasicNameValuePair("attachment", updates.getAttachment().toString()));
        }

        if (updates.getScheduledAt() != null) {
            formData.add(new BasicNameValuePair("scheduled_at", updates.getScheduledAt().toString()));
        }

        if (updates.getMediaPhoto() != null) {
            formData.add(new BasicNameValuePair("media[photo]", updates.getMediaPhoto().toString()));
        }
        return formData;
    }

    public static List<NameValuePair> createFormData(EditUpdate update) {
        List<NameValuePair> formData = new ArrayList<>();

        if (update.getText() != null) {
            formData.add(new BasicNameValuePair("text", update.getText()));
        }

        if (update.getMediaLink() != null) {
            formData.add(new BasicNameValuePair("media[link]", update.getMediaLink()));
        }

        if (update.getMediaDescription() != null) {
            formData.add(new BasicNameValuePair("media[description]", update.getMediaDescription()));
        }

        if (update.getMediaTitle() != null) {
            formData.add(new BasicNameValuePair("media[title]", update.getMediaTitle()));
        }

        if (update.getMediaPicture() != null) {
            formData.add(new BasicNameValuePair("media[picture]", update.getMediaPicture()));
        }

        if (update.getMediaThumbnail() != null) {
            formData.add(new BasicNameValuePair("media[thumbnail]", update.getMediaThumbnail()));
        }

        if (update.getScheduledAt() != null) {
            formData.add(new BasicNameValuePair("scheduled_at", update.getScheduledAt().toString()));
        }
        if (update.getMediaPhoto() != null) {
            formData.add(new BasicNameValuePair("media[photo]", update.getMediaPhoto().toString()));
        }
        return formData;
    }
}
