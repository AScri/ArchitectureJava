package com.ascri.architecturetest.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageResponse {
    private long id = 0;
    private String email = "";
    private String name = "";
    @JsonProperty("ident")
    private String ident = "";

    public ImageResponse(){}

    public ImageResponse(long id, String email, String name, String ident) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.ident = ident;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }
}
