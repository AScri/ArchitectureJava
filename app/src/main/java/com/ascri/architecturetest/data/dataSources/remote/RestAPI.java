package com.ascri.architecturetest.data.dataSources.remote;

import com.ascri.architecturetest.data.models.ImageResponse;
import com.ascri.architecturetest.data.models.Repository;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestAPI {
    @GET("api/users")
    Single<ImageResponse> getImage(@Query("offset") int offset, @Query("limit") int limit);

    @GET("users/{user}/repos")
    Single<List<Repository>> listRepos(@Path("user") String user);
}
