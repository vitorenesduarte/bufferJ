package com.bufferj.entity;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class Profile {

    private String id;
    private String service;
    private String avatar;
    private String formatted_username;
    private String service_username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getService(){
        return service;
    }
    
    public void setService(String service){
        this.service = service;
    }

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getFormatted_username() {
		return formatted_username;
	}

	public void setFormatted_username(String formatted_username) {
		this.formatted_username = formatted_username;
	}

	public String getService_username() {
		return service_username;
	}

	public void setService_username(String service_username) {
		this.service_username = service_username;
	}
}