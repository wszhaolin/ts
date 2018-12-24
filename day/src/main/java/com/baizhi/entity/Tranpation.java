package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Tranpation implements Serializable {
    private String id;
    private String username;
    private Date datetime;
    private String handle;
    private String result;

    @Override
    public String toString() {
        return "tranpation{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", datetime=" + datetime +
                ", handle='" + handle + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Tranpation() {
    }

    public Tranpation(String id, String username, Date datetime, String handle, String result) {
        this.id = id;
        this.username = username;
        this.datetime = datetime;
        this.handle = handle;
        this.result = result;
    }
}
