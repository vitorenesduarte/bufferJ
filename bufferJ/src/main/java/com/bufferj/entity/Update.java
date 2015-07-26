package com.bufferj.entity;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class Update {

    private String id;
    private Long created_at; // timestamp
    private Long due_at; // timestamp
    private String profile_id;
    private String profile_service; // twitter, linkedin
    private Long sent_at; // timestamp
    private String service_update_id;
    private String status; // sent, buffer
    private String text;
    private String user_id;
    private String via; // safari, chrome, api, firefox

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Long createdAt) {
        this.created_at = createdAt;
    }

    public Long getDueAt() {
        return due_at;
    }

    public void setDueAt(Long dueAt) {
        this.due_at = dueAt;
    }

    public String getProfileId() {
        return profile_id;
    }

    public void setProfileId(String profileId) {
        this.profile_id = profileId;
    }

    public String getProfileService() {
        return profile_service;
    }

    public void setProfileService(String profileService) {
        this.profile_service = profileService;
    }

    public Long getSentAt() {
        return sent_at;
    }

    public void setSentAt(Long sentAt) {
        this.sent_at = sentAt;
    }

    public String getServiceUpdateId() {
        return service_update_id;
    }

    public void setServiceUpdateId(String serviceUpdateId) {
        this.service_update_id = serviceUpdateId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String userId) {
        this.user_id = userId;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }
}
