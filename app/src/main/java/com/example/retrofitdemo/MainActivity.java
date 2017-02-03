package com.example.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.retrofitdemo.Controller.Interface.ApiInterface;
import com.example.retrofitdemo.Model.ApiHandler.ApiClient;
import com.example.retrofitdemo.Model.ItemObjects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<ItemObjects> call=apiInterface.getRepoUrls("android");
        call.enqueue(new Callback<ItemObjects>() {
            @Override
            public void onResponse(Call<ItemObjects> call, Response<ItemObjects> response) {
                Log.d("response",response.body().getItems().toString());
            }

            @Override
            public void onFailure(Call<ItemObjects> call, Throwable t) {
                Log.d("response",t.getMessage());
                t.printStackTrace();

            }
        });
    }
}
