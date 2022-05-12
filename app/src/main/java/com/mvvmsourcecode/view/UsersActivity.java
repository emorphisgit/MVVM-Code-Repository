package com.mvvmsourcecode.view;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mvvmsourcecode.R;
import com.mvvmsourcecode.adapters.UserAdapter;
import com.mvvmsourcecode.databinding.ActivityMainBinding;
import com.mvvmsourcecode.utils.NetworkHandler;
import com.mvvmsourcecode.viewmodel.UserViewModel;

public class UsersActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    private UserViewModel mainViewModel;
    private UserAdapter mUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        ///init the View Model
        mainViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        // bind RecyclerView
        RecyclerView mRvUserList = activityMainBinding.mRvUsers;
        mRvUserList.setLayoutManager(new LinearLayoutManager(this));
        mRvUserList.setHasFixedSize(true);
        mRvUserList.setItemAnimator(new DefaultItemAnimator());
        mRvUserList.setNestedScrollingEnabled(true);

        //init the adapter
        mUserAdapter = new UserAdapter();
        //set the Adapter
        mRvUserList.setAdapter(mUserAdapter);

        if (NetworkHandler.isNetworkConnectionAvailable(this)) {
            activityMainBinding.noInternetLayout.setVisibility(View.GONE);
            getAllUserList();
        } else {
            activityMainBinding.noInternetLayout.setVisibility(View.VISIBLE);
        }

        activityMainBinding.mTvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void getAllUserList() {
        ///get the list of users from api response
        mainViewModel.getAllUserList().observe(this, aUserModel -> {
            //if any thing changes, update the UI
            mUserAdapter.setUserList(aUserModel);
        });
    }
}
