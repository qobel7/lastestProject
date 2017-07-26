package com.example.qobel.organizator;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.qobel.organizator.entity.UserEntity;

import java.io.Serializable;

/**
 * Created by qobel on 2.07.2017.
 */

public class UserLocalStore implements Serializable {
    public static final String SP_NAME = "user_details";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context) {
        this.userLocalDatabase = context.getSharedPreferences(SP_NAME,0);
    }
    public void storeUserData(UserEntity userEntity){
        SharedPreferences.Editor editor= userLocalDatabase.edit();
        editor.putString("name",userEntity.getName());
        editor.putString("surname",userEntity.getSurname());
        editor.putString("location",userEntity.getLocation());
        editor.putInt("id",userEntity.getId());
        editor.commit();
    }
    public UserEntity getLoggedInUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userLocalDatabase.getInt("id",-1));
        userEntity.setName(userLocalDatabase.getString("name",""));
        userEntity.setSurname(userLocalDatabase.getString("surname",""));
        userEntity.setLocation(userLocalDatabase.getString("location",""));
        userEntity.setLoginStatus(userLocalDatabase.getBoolean("status",false));
        return userEntity;
    }
    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor editor = userLocalDatabase.edit();
        editor.putBoolean("status",loggedIn);
        editor.commit();
    }
    public void clearUserData(){
        SharedPreferences.Editor editor = userLocalDatabase.edit();
        editor.clear();
    }
}
