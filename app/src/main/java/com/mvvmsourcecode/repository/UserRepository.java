package com.mvvmsourcecode.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.mvvmsourcecode.model.UserModel;
import com.mvvmsourcecode.network.ApiDataService;
import com.mvvmsourcecode.network.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    //this is the data that we will fetch asynchronously
    private ArrayList<UserModel> mUserList = new ArrayList<>();

    //Show Error Message
    public final MutableLiveData<String> errorMsg = new MutableLiveData<>();

    private final MutableLiveData<ArrayList<UserModel>> mUserMutableLiveDataList = new MutableLiveData<>();

    //call to internet and  return  MutableLiveData
    public MutableLiveData<ArrayList<UserModel>> getUserMutableLiveDataList() {
        ///ini Retrofit Class
        final ApiDataService userDataService = RetrofitClient.getService();

        ///call the API that define In Interface
        Call<ArrayList<UserModel>> call = userDataService.getUserListAPI();

        call.enqueue(new Callback<ArrayList<UserModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<UserModel>> call, @NonNull Response<ArrayList<UserModel>> response) {
                mUserList = response.body();
                mUserMutableLiveDataList.setValue(mUserList);

            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<UserModel>> call, Throwable t) {
                mUserMutableLiveDataList.postValue(null);
                errorMsg.setValue(t.getMessage());
            }
        });

        return mUserMutableLiveDataList;
    }

}



