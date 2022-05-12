package com.mvvmsourcecode.network;


import com.mvvmsourcecode.model.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiDataService {

    //Fetch all users --end point
    @GET("users")
    Call<ArrayList<UserModel>> getUserListAPI();
}
