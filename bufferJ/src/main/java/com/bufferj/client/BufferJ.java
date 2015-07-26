package com.bufferj.client;

import com.bufferj.util.JsonManager;
import com.bufferj.util.HttpClient;
import com.bufferj.entity.Profile;
import com.bufferj.entity.Schedule;
import com.bufferj.entity.Error;
import com.bufferj.entity.Update;
import com.bufferj.entity.Updates;
import com.bufferj.entity.User;
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
    private static final Type scheduleListType = new TypeToken<List<Schedule>>() {
    }.getType();

    private final String accessToken;

    public BufferJ(String accessToken) throws IOException, BufferJException {
        this.accessToken = accessToken;
        getUser();
    }

    private User getUser() throws IOException, BufferJException {
        URI uri = createUri("user");

        String response = HttpClient.getInstance().get(uri);
        Object result = JsonManager.fromJson(response, User.class);

        dealWithError(result);

        return (User) result;
    }

    public List<Profile> getProfiles() throws IOException {
        URI uri = createUri("profiles");

        String response = HttpClient.getInstance().get(uri);
        List<Profile> profiles = (List<Profile>) JsonManager.fromJson(response, profileListType);

        return profiles;
    }

    public Profile getProfile(String profileId) throws IOException, BufferJException {
        if (profileId == null) {
            return null;
        }

        URI uri = createUri("profiles/" + profileId);

        String response = HttpClient.getInstance().get(uri);
        Object result = JsonManager.fromJson(response, Profile.class);

        dealWithError(result);

        return (Profile) result;
    }

    public Profile getProfile(Service service) throws IOException {
        List<Profile> profiles = getProfiles();

        for (Profile profile : profiles) {
            if (profile.getService().equals(service.getName())) {
                return profile;
            }
        }

        return null;
    }

    public List<Service> getRegisteredServices() throws IOException {
        List<Profile> profiles = getProfiles();

        if (profiles == null || profiles.isEmpty()) {
            return null;
        }

        List<Service> services = new ArrayList<>();
        for (Profile profile : profiles) {
            Service service = Service.getService(profile.getService());
            services.add(service);
        }

        return services;
    }

    public List<Schedule> getSchedules(Profile profile) throws IOException, BufferJException {
        if (profile == null || profile.getId() == null) {
            return null;
        }

        URI uri = createUri("profiles/" + profile.getId() + "/schedules");

        String response = HttpClient.getInstance().get(uri);
        Object result = JsonManager.fromJson(response, scheduleListType);

        dealWithError(result);

        return (List<Schedule>) result;
    }

    public List<Schedule> getSchedules(String profileId) throws IOException, BufferJException {
        Profile profile = getProfile(profileId);
        return getSchedules(profile);
    }

    public List<Schedule> getSchedules(Service service) throws IOException, BufferJException {
        Profile profile = getProfile(service);
        return getSchedules(profile);
    }

    // TODO POST /profiles/:id/schedules/update
    private Update getUpdate(String updateId) throws IOException, BufferJException {
        if (updateId == null) {
            return null;
        }

        URI uri = createUri("updates/" + updateId);

        String response = HttpClient.getInstance().get(uri);
        Object result = JsonManager.fromJson(response, Update.class);

        dealWithError(result);

        return (Update) result;
    }

    private Updates getUpdates(URI uri) throws IOException, BufferJException {
        String response = HttpClient.getInstance().get(uri);
        Object result = JsonManager.fromJson(response, Updates.class);

        dealWithError(result);

        return (Updates) result;
    }

    public Updates getPendingUpdates(Profile profile) throws IOException, BufferJException {
        if (profile == null || profile.getId() == null) {
            return null;
        }

        URI uri = createUri("profiles/" + profile.getId() + "/updates/pending");
        return getUpdates(uri);
    }

    public Updates getPendingUpdates(String profileId) throws IOException, BufferJException {
        Profile profile = getProfile(profileId);
        return getPendingUpdates(profile);
    }

    public Updates getPendingUpdates(Service service) throws IOException, BufferJException {
        Profile profile = getProfile(service);
        return getPendingUpdates(profile);
    }

    public Updates getSentUpdates(Profile profile) throws IOException, BufferJException {
        if (profile == null || profile.getId() == null) {
            return null;
        }

        URI uri = createUri("profiles/" + profile.getId() + "/updates/sent");
        return getUpdates(uri);
    }

    public Updates getSentUpdates(String profileId) throws IOException, BufferJException {
        Profile profile = getProfile(profileId);
        return getSentUpdates(profile);
    }

    public Updates getSentUpdates(Service service) throws IOException, BufferJException {
        Profile profile = getProfile(service);
        return getSentUpdates(profile);
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

        System.out.println(uri.toString());
        
        return uri;
    }

    private void dealWithError(Object result) throws BufferJException {
        if (result instanceof Error) {
            throw new BufferJException(JsonManager.toJson(result));
        }
    }
}
