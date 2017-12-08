package com.bufferj.client.util;

import com.bufferj.entity.Profile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class CreateUpdates {

    private List<Profile> profiles;
    private String text;
    private Boolean shorten;
    private Boolean now;
    private Boolean top;
    private String mediaLink;
    private String mediaDescription;
    private String mediaTitle;
    private String mediaPicture;
    private String mediaThumbnail;
    private Boolean attachment;
    private Long scheduledAt;
    private String mediaPhoto;
    
    public CreateUpdates() {
        this.profiles = new ArrayList<>();
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void addProfile(Profile profile) {
        if (profiles == null) {
            profiles = new ArrayList<>();
        }

        profiles.add(profile);
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getShorten() {
        return shorten;
    }

    public void setShorten(Boolean shorten) {
        this.shorten = shorten;
    }

    public Boolean getNow() {
        return now;
    }

    public void setNow(Boolean now) {
        this.now = now;
    }

    public Boolean getTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public String getMediaLink() {
        return mediaLink;
    }

    public void setMediaLink(String mediaLink) {
        this.mediaLink = mediaLink;
    }

    public String getMediaDescription() {
        return mediaDescription;
    }

    public void setMediaDescription(String mediaDescription) {
        this.mediaDescription = mediaDescription;
    }

    public String getMediaTitle() {
        return mediaTitle;
    }

    public void setMediaTitle(String mediaTitle) {
        this.mediaTitle = mediaTitle;
    }

    public String getMediaPicture() {
        return mediaPicture;
    }

    public void setMediaPicture(String mediaPicture) {
        this.mediaPicture = mediaPicture;
    }

    public String getMediaThumbnail() {
        return mediaThumbnail;
    }

    public void setMediaThumbnail(String mediaThumbnail) {
        this.mediaThumbnail = mediaThumbnail;
    }

    public Boolean getAttachment() {
        return attachment;
    }

    public void setAttachment(Boolean attachment) {
        this.attachment = attachment;
    }

    public Long getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(Long scheduledAt) {
        this.scheduledAt = scheduledAt;
    }
	public String getMediaPhoto() {
		return mediaPhoto;
	}

	public void setMediaPhoto(String mediaPhoto) {
		this.mediaPhoto = mediaPhoto;
	}
}
