package com.example.viewpagerapp;

public class Page {
    private String name;
    private int id;

    public Page(String name, int img_id) {
        this.name = name;
        this.id = img_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
