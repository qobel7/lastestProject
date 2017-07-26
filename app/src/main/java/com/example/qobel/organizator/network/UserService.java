package com.example.qobel.organizator.network;

import com.example.qobel.organizator.entity.OrganizationEntity;
import com.example.qobel.organizator.entity.UserEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by qobel on 3.07.2017.
 */

public interface UserService {
    @GET("/Oraga/index.php")
    Call<UserEntity> userLogin(@Query("email") String email, @Query("password") String password);


    @GET("/Oraga/userRegister")
    Call<UserEntity> userLogin(@Path("email") String email,@Path("name") String name,
                               @Path("surname") String surname,@Path("password") String password);
    @GET("/Oraga/oraganizationList.php")
    Call<List<OrganizationEntity>> getOrganizationList();
}
