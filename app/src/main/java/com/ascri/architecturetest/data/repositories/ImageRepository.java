package com.ascri.architecturetest.data.repositories;

import com.ascri.architecturetest.data.dataSources.remote.RestAPI;

import javax.inject.Inject;

public class ImageRepository {
    private RestAPI restAPI;

    @Inject
    public ImageRepository(RestAPI restAPI) {
        this.restAPI = restAPI;
    }

    public RestAPI getRestAPI() {
        return restAPI;
    }

    public void setRestAPI(RestAPI restAPI) {
        this.restAPI = restAPI;
    }
}
