package com.example.retrofitdemo.Controller.Interface;

import com.example.retrofitdemo.Model.ItemObjects;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Bunty on 02-02-2017.
 */

public interface ApiInterface {
    @GET("/repositories")
    Call<ItemObjects> getRepoUrls(@Query("q") String name);
}
