package com.bufferj.example;

import com.bufferj.client.BufferJ;
import com.bufferj.client.BufferJException;
import com.bufferj.client.util.CreateUpdates;
import com.bufferj.entity.Profile;
import com.bufferj.entity.Update;
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

            CreateUpdates createUpdates = new CreateUpdates();
            createUpdates.addProfile(profiles.get(0));
            createUpdates.setText("First post using Buffer through BufferJ");
            createUpdates.setMediaLink("https://github.com/vitorenesduarte/bufferJ");
            createUpdates.setMediaPicture("http://blog.thebrokerlist.com/wp-content/uploads/2013/10/Buffer-App.png");
            List<Update> updatesCreated = buffer.create(createUpdates);
            
            for(Update update : updatesCreated){
                buffer.share(update);
            }

        } catch (IOException | BufferJException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
