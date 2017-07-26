package com.example.qobel.organizator.network;

import com.example.qobel.organizator.R;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by qobel on 2.07.2017.
 */

public class ServisGenerater {

    public static String baseUrl = String.valueOf(R.string.baseUrl);
    public static Retrofit retrofit;
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://10.0.2.2/").addConverterFactory(GsonConverterFactory.create());
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static <S> S createService(Class<S> serviceClass){
        builder.client(httpClient.build());
        retrofit = builder.build();
        return retrofit.create(serviceClass);
    }

}
