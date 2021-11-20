package com.example.hdrecord.rvs;

public class Video {
    private int resourceid;
    private String name;
    private String address;

    public Video(int resourceid, String name, String address) {
        this.resourceid = resourceid;
        this.name = name;
        this.address = address;
    }

    public int getResourceid() {
        return resourceid;
    }

    public void setResourceid(int resourceid) {
        this.resourceid = resourceid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
