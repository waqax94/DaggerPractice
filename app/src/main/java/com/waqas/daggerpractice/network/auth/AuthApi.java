package com.waqas.daggerpractice.network.auth;

import com.waqas.daggerpractice.models.User;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthApi {

    @GET("/users/{id}")
    Flowable<User> getUser(@Path("id") int id);
}
