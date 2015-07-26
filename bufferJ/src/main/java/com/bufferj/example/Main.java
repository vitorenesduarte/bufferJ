package com.bufferj.example;

import com.bufferj.client.BufferJ;
import com.bufferj.client.Service;
import com.bufferj.entity.Profile;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        BufferJ buffer = new BufferJ("someAccessToken");

        //List<Profile> profiles = buffer.getProfiles();
        
        Profile profile = buffer.getProfile("asca890021");
        System.out.println("Profile id: " + profile.getId() + ", Service: " + profile.getService());
        
        List<Service> services = buffer.getRegisteredServices();
        System.out.println("Registered services: " + services);
        
        for(Service service : services){
            String sentUpdates = buffer.getSentUpdates(service);
            System.out.println(sentUpdates);
        }
        
    }
}
