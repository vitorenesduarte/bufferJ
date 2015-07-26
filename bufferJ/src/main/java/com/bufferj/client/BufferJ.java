/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bufferj.client;

import com.bufferj.util.JsonManager;
import com.bufferj.util.HttpClient;
import com.bufferj.entity.Profile;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.utils.URIBuilder;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class BufferJ {

    private static final Logger logger = Logger.getLogger(BufferJ.class.getName());

    private static final String scheme = "https";
    private static final String apiEndpoint = "api.bufferapp.com";
    private static final String apiVersion = "1";
    private static final String responseFormat = "json";
    
    private static final Type profileListType = new TypeToken<List<Profile>>() {
    }.getType();

    private final String accessToken;

    public BufferJ(String accessToken) {
        this.accessToken = accessToken;
    }

    public List<Profile> getProfiles() throws IOException {
        URI uri = createUri("profiles");
        
        String response = HttpClient.getInstance().get(uri);
        List<Profile> profiles = JsonManager.fromJson(response, profileListType);
        
        return profiles;
    }
    
    public Profile getProfile(String profileId) throws IOException{
        URI uri = createUri("profiles/" + profileId);
        
        String response = HttpClient.getInstance().get(uri);
        Profile profile = JsonManager.fromJson(response, Profile.class);
        
        return profile;
    }
    
    public Profile getProfile(Service service) throws IOException {
        List<Profile> profiles = getProfiles();
        
        for(Profile profile : profiles){
            Service profileService = Service.getService(profile.getService());
            
            if(profileService.equals(service)){
                return profile;
            }
        }
        
        return null;
    }
    
    public List<Service> getRegisteredServices() throws IOException{
        List<Profile> profiles = getProfiles();
        
        if(profiles == null || profiles.isEmpty()){
            return null;
        }
        
        List<Service> services = new ArrayList<>();
        for(Profile profile : profiles){
            Service service = Service.getService(profile.getService());
                services.add(service);
        }
        
        return services;
    }
    
    public String getSchedules(Profile profile) throws IOException{
        URI uri = createUri("profiles/" + profile.getId() + "/schedules");
        
        String response = HttpClient.getInstance().get(uri);
        
        return response;
    }
    
    public String getSchedules(String profileId) throws IOException{
        Profile profile = getProfile(profileId);
        return getSchedules(profile);
    }
    
    public String getSchedules(Service service) throws IOException{
        Profile profile = getProfile(service);
        return getSchedules(profile);
    }
    
    // POST /profiles/:id/schedules/update
    
    public String getSentUpdates(Profile profile) throws IOException {
        URI uri = createUri("profiles/" + profile.getId() + "/updates/sent");
        
        String response = HttpClient.getInstance().get(uri);

        return response;
    }

    public String getSentUpdates(Service service) throws IOException{
        Profile profile = getProfile(service);
        
        return profile != null ? getSentUpdates(profile) : null;
    }
    
    private URI createUri(String path) {
        URI uri = null;

        try {
            uri = new URIBuilder()
                    .setScheme(scheme)
                    .setHost(apiEndpoint)
                    .setPath("/" + apiVersion + "/" + path + "." + responseFormat)
                    .setParameter("access_token", accessToken)
                    .build();

        } catch (URISyntaxException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return uri;
    }
}
