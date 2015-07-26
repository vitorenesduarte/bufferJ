package com.bufferj.entity;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class Interaction {

    private String id;
    private Long createdAt; // timestamp
    private String event; // favorite, retweet
    private String interactionId;
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(String interactionId) {
        this.interactionId = interactionId;
    }

    public String getUsername() {
        return user.username;
    }

    public void setUsername(String username) {
        this.user.username = username;
    }

    public Long getFollowers() {
        return user.followers;
    }

    public void setFollowers(Long followers) {
        this.user.followers = followers;
    }

    public String getAvatar() {
        return user.avatar;
    }

    public void setAvatar(String avatar) {
        this.user.avatar = avatar;
    }

    public String getTwitterId() {
        return user.twitter_id;
    }

    public void setTwitterId(String twitterId) {
        this.user.twitter_id = twitterId;
    }

    private class User {

        private String username;
        private Long followers;
        private String avatar;
        private String twitter_id;
    }
}
