package com.baizhi.entity;

import java.io.Serializable;

public class Permission implements Serializable {
    private String id;
    private String resname;
    private String resurl;
    private String parentid;
    private String restag;
    private String pemtag;

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", resname='" + resname + '\'' +
                ", resurl='" + resurl + '\'' +
                ", parentid='" + parentid + '\'' +
                ", restag='" + restag + '\'' +
                ", pemtag='" + pemtag + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResname() {
        return resname;
    }

    public void setResname(String resname) {
        this.resname = resname;
    }

    public String getResurl() {
        return resurl;
    }

    public void setResurl(String resurl) {
        this.resurl = resurl;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getRestag() {
        return restag;
    }

    public void setRestag(String restag) {
        this.restag = restag;
    }

    public String getPemtag() {
        return pemtag;
    }

    public void setPemtag(String pemtag) {
        this.pemtag = pemtag;
    }

    public Permission() {
    }

    public Permission(String id, String resname, String resurl, String parentid, String restag, String pemtag) {
        this.id = id;
        this.resname = resname;
        this.resurl = resurl;
        this.parentid = parentid;
        this.restag = restag;
        this.pemtag = pemtag;
    }
}
