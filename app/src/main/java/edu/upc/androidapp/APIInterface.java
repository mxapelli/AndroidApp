package edu.upc.androidapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("/dsaApp/Authentication/Login")
    Call<Usuario> loginUser(@Body Usuario user);


    @POST("/dsaApp/Authentication/addUser")
    Call<Usuario> createUser(@Body Usuario user);


}
