package com.example.qobel.organizator.network;

import com.google.gson.annotations.SerializedName;

/**
 * Created by qobel on 3.07.2017.
 */

public class Status {

    @SerializedName("Response")
    private String response;
    @SerializedName("Error")
    private String error;

    public String getResponse() {
        return response;
    }

    public String getError() {
        return error;
    }
}
