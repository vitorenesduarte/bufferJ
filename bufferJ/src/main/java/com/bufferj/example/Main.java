package com.bufferj.example;

import com.bufferj.client.BufferJ;
import com.bufferj.client.BufferJException;
import com.bufferj.client.Service;
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
public class Main {

    public static void main(String[] args) throws IOException {
        try {
            BufferJ buffer = new BufferJ("someAccessToken");
            List<Profile> profiles = buffer.getProfiles();

            List<Service> services = buffer.getRegisteredServices();
            System.out.println("Registered services: " + services);

            for (Service service : services) {
                Profile profile = buffer.getProfile(service);
                System.out.println("Profile id: " + profile.getId() + ", Service: " + profile.getService());
            }

            List<Schedule> schedules = buffer.getSchedules(Service.LINKEDIN);
            System.out.println(schedules);

            for (Service service : services) {
                Updates pendingUpdates = buffer.getPendingUpdates(service);
                System.out.println(pendingUpdates);

                Updates sentUpdates = buffer.getSentUpdates(service);
                System.out.println(sentUpdates);

                for (Update update : pendingUpdates.getUpdates()) {
                    Interactions interactions = buffer.getUpdateInteractions(update);
                }
            }

        } catch (IOException | BufferJException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
