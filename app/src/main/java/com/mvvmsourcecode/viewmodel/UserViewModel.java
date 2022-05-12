package com.mvvmsourcecode.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mvvmsourcecode.model.UserModel;
import com.mvvmsourcecode.repository.UserRepository;

import java.util.ArrayList;


public class UserViewModel extends AndroidViewModel {

    private final UserRepository mUserListRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        mUserListRepository = new UserRepository();
    }

    //Fetch Users list
    public LiveData<ArrayList<UserModel>> getAllUserList() {
        return mUserListRepository.getUserMutableLiveDataList();
    }
}
