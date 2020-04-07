package com.ascri.architecturetest.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class User {
    @JsonProperty("name")
    private String name = "";
    private String image = "";
    @JsonProperty("items")
    private List<String> items = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public User(String name, String image, List<String> items) {
        this.name = name;
        this.image = image;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
