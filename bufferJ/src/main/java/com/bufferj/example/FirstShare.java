package com.bufferj.example;

import com.bufferj.client.BufferJ;
import com.bufferj.client.BufferJException;
import com.bufferj.client.util.Service;
import com.bufferj.client.util.CreateOrEditUpdates;
import com.bufferj.entity.Day;
import com.bufferj.entity.Interactions;
import com.bufferj.entity.Profile;
import com.bufferj.entity.Schedule;
import com.bufferj.entity.Update;
import com.bufferj.entity.Updates;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class FirstShare {

    public static void main(String[] args) throws IOException {
        try {
            BufferJ buffer = new BufferJ("myAccessToken");

            List<Profile> profiles = buffer.getProfiles();
            for (Profile profile : profiles) {
                System.out.println("Profile id: " + profile.getId());
            }

            CreateOrEditUpdates createUpdates = new CreateOrEditUpdates();
            createUpdates.addProfile(profiles.get(0));
            createUpdates.setText("First post using Buffer through BufferJ");
            createUpdates.setMediaLink("https://github.com/vitorenesduarte/bufferJ");
            createUpdates.setMediaPicture("http://blog.thebrokerlist.com/wp-content/uploads/2013/10/Buffer-App.png");
            List<Update> updatesCreated = buffer.createUpdates(createUpdates);
            
            for(Update update : updatesCreated){
                buffer.share(update);
            }

        } catch (IOException | BufferJException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
