package com.bufferj.client.util;

import com.bufferj.entity.Profile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class EditUpdate {

    private String text;
    private Boolean now;
    private String mediaLink;
    private String mediaDescription;
    private String mediaTitle;
    private String mediaPicture;
    private String mediaThumbnail;
    private Long scheduledAt;
    private String mediaPhoto;
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
