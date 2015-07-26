package com.bufferj.entity;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class Profile {

    private String id;
    private String service;

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
}
