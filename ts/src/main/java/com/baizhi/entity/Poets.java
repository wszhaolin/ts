package com.baizhi.entity;

public class Poets {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Poets{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Poets() {
    }

    public Poets(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
