package com.mvvmsourcecode.viewmodel;

import static android.os.Looper.getMainLooper;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.mvvmsourcecode.constant.AppConstant;
import com.mvvmsourcecode.model.SplashModel;
public class SplashViewModel extends ViewModel {

    public MutableLiveData<SplashModel> splashMutableLiveData;

    public void loadScreenTimer() {
        new Handler(getMainLooper()).postDelayed(this::updateLiveData, AppConstant.SPLASH_TIME);
    }

    public void updateLiveData() {
        splashMutableLiveData.setValue(new SplashModel());
    }

    public MutableLiveData<SplashModel> getAccess() {
        if (splashMutableLiveData == null) {
            splashMutableLiveData = new MutableLiveData<>();
        }
        return splashMutableLiveData;
    }
}
