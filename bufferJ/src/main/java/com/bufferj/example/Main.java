package com.bufferj.example;

import com.bufferj.client.BufferJ;
import com.bufferj.client.BufferJException;
import com.bufferj.client.util.Service;
import com.bufferj.client.util.CreateUpdates;
import com.bufferj.client.util.EditUpdate;
import com.bufferj.client.util.Event;
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
public class Main {

    public static void main(String[] args) throws IOException {
        try {
            BufferJ buffer = new BufferJ("someAccessToken");

            List<Profile> profiles = buffer.getProfiles();
            for (Profile profile : profiles) {
                System.out.println("Profile id: " + profile.getId());
            }

            List<Service> services = buffer.getRegisteredServices();
            System.out.println("Registered services: " + services);

            for (Service service : services) {
                Profile profile = buffer.getProfile(service);
                System.out.println("Profile id: " + profile.getId() + ", Service: " + profile.getService());
            }

            List<Schedule> schedules = buffer.getSchedules(Service.LINKEDIN);
            System.out.println(schedules);

            for (Schedule schedule : schedules) {
                schedule.addDay(Day.MONDAY);
                schedule.addTime(8, 15);
            }

            buffer.updateSchedules(Service.LINKEDIN, schedules);

            schedules = buffer.getSchedules(Service.LINKEDIN);
            System.out.println(schedules);

            CreateUpdates createUpdates = new CreateUpdates();
            createUpdates.addProfile(profiles.get(0));
            createUpdates.setText("hello world!!");
            // only one update will be created since we only added one media profile

            List<Update> updatesCreated = buffer.create(createUpdates);
            for (int i = 0; i < updatesCreated.size(); i++) {
                System.out.println(updatesCreated.get(i));
                EditUpdate editUpdate = new EditUpdate();
                editUpdate.setText("shangri la " + i);
                buffer.edit(updatesCreated.get(i).getId(), editUpdate);
            }

            for (Service service : services) {
                Updates pendingUpdates = buffer.getPendingUpdates(service);
                for (Update pendingUpdate : pendingUpdates.getUpdates()) {
                    System.out.println(pendingUpdate);
                }

                Updates sentUpdates = buffer.getSentUpdates(service);
                System.out.println(sentUpdates);

                for (Update update : sentUpdates.getUpdates()) {
                    Interactions interactions = buffer.getInteractions(update, Event.COMMENTS);
                    System.out.println(interactions);
                }
            }

        } catch (IOException | BufferJException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
