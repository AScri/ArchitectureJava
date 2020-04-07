package com.ascri.architecturetest.data.models;

import org.jetbrains.annotations.NotNull;

public class Repository {
    private String id = "";
    private String name = "";

    public Repository() {
    }

    @NotNull
    @Override
    public String toString() {
        return "Repository{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
