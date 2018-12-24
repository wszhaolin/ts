package com.baizhi.entity;

import java.io.Serializable;

public class Role implements Serializable {
    private String id;
    private String rolename;
    private String roletag;

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", rolename='" + rolename + '\'' +
                ", roletag='" + roletag + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoletag() {
        return roletag;
    }

    public void setRoletag(String roletag) {
        this.roletag = roletag;
    }

    public Role() {
    }

    public Role(String id, String rolename, String roletag) {
        this.id = id;
        this.rolename = rolename;
        this.roletag = roletag;
    }
}
