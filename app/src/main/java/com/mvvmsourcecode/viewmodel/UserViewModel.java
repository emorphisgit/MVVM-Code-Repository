package com.mvvmsourcecode.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mvvmsourcecode.model.UserModel;
import com.mvvmsourcecode.repository.UserRepository;

import java.util.ArrayList;


public class UserViewModel extends ViewModel {

    public UserRepository mUserListRepository = new UserRepository();
    public MutableLiveData<Boolean> progressbarObservable = new MutableLiveData<>();

    public MutableLiveData<String> mUserListErrorStr = new MutableLiveData<>();
    public MutableLiveData<Boolean> mUserListSuccess = new MutableLiveData<>();


    //Fetch Users list
    public LiveData<ArrayList<UserModel>> getAllUserList() {
        progressbarObservable.postValue(true);
        return mUserListRepository.getUserMutableLiveDataList(mUserListSuccess, mUserListErrorStr);
    }
}
