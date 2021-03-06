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
    private final MutableLiveData<ArrayList<UserModel>> mUserMutableLiveDataList = new MutableLiveData<>();


    //call to internet and  return  MutableLiveData
    public MutableLiveData<ArrayList<UserModel>> getUserMutableLiveDataList(MutableLiveData<Boolean> aUserListSuccess, MutableLiveData<String> aUserListErrorStr) {

        ///ini Retrofit Class
        final ApiDataService userDataService = RetrofitClient.getService();

        ///call the API that define In Interface
        Call<ArrayList<UserModel>> call = userDataService.getUserListAPI();

        call.enqueue(new Callback<ArrayList<UserModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<UserModel>> call, @NonNull Response<ArrayList<UserModel>> response) {

                if (response.body() != null) {
                    aUserListSuccess.setValue(true);
                    mUserList = response.body();
                    mUserMutableLiveDataList.setValue(mUserList);
                } else {
                    aUserListErrorStr.setValue(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<UserModel>> call, @NonNull Throwable t) {
                mUserMutableLiveDataList.postValue(null);
                aUserListErrorStr.setValue(t.getMessage());

            }
        });

        return mUserMutableLiveDataList;
    }

}



