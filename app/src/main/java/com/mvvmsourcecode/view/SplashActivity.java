package com.mvvmsourcecode.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.mvvmsourcecode.R;
import com.mvvmsourcecode.databinding.ActivitySplashBinding;
import com.mvvmsourcecode.model.SplashModel;
import com.mvvmsourcecode.viewmodel.SplashViewModel;

public class SplashActivity extends AppCompatActivity {
    private SplashViewModel splashViewModel;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Bind the views
        ActivitySplashBinding activitySplashBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_splash);
        ///init the View Model
        splashViewModel = new ViewModelProvider(this).get(SplashViewModel.class);
        activitySplashBinding.setSplashViewModel(splashViewModel);
        activitySplashBinding.setLifecycleOwner(this);
        observeSplashLiveData();
    }


    void observeSplashLiveData() {
        splashViewModel.loadScreenTimer();
        splashViewModel.getAccess().observe(SplashActivity.this, (Observer<Object>) o -> {
            SplashModel splashModel = (SplashModel) o;
            if (splashModel != null)
                //Call LoginActivity
                startActivity(new Intent(SplashActivity.this, UsersActivity.class));
            finish();
        });
    }
}
