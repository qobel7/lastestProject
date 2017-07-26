package com.example.qobel.organizator;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by qobel on 2.07.2017.
 */

public class UserRetrofitClient {

    public Retrofit userLogin(String baseUrl){

        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder();
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit;
    }

}
