package edu.upc.androidapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {

    @POST("/dsaApp/Authentication/Login")
    Call<Usuario> loginUser(@Body Usuario user);

    @POST("/dsaApp/Authentication/addUser")
    Call<Usuario> createUser(@Body Usuario user);

    @GET ("/dsaApp/Item")
    Call<List<Item>> getItems();

    @GET ("/dsaApp/User/{userID}")
    Call<Usuario> getUser(@Path("userID") String userID);

    @GET ("/dsaApp/User/{userID}/Achievements")
    Call<Achievements> getAchievements(@Path("userID") String userID);

    @GET ("/dsaApp/User/{userID}/Inventory")
    Call<Inventory> getInventory(@Path("userID") String userID);

    @PATCH("/dsaApp/User/{userID}/UpdateInventory")
    Call<Inventory> updateInventory(@Path("userID") String userID,@Body Inventory inventory);

    @PATCH("/dsaApp/User/{userID}/UpdateCash")
    Call<Usuario> updateCash(@Path("userID") String userID,@Body Usuario user);



}
