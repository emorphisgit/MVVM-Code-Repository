package com.mvvmsourcecode.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.mvvmsourcecode.R;
import com.mvvmsourcecode.databinding.ItemUserListBinding;
import com.mvvmsourcecode.model.UserModel;
import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    //initialize array list of model class
    private ArrayList<UserModel> mUserModelList;

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemUserListBinding itemUserListBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.item_user_list, viewGroup, false);

        return new UserViewHolder(itemUserListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        UserModel userModel = mUserModelList.get(i);
        userViewHolder.mItemUserListBinding.setUserModel(userModel);
    }

    @Override
    public int getItemCount() {
        //check size of model list
        if (mUserModelList != null) {
            return mUserModelList.size();
        } else {
            return 0;
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setUserList(ArrayList<UserModel> userModelArrayList) {
        this.mUserModelList = userModelArrayList;
        notifyDataSetChanged();
    }

    //Create View holder and set values using binding
    static class UserViewHolder extends RecyclerView.ViewHolder {

       final ItemUserListBinding mItemUserListBinding;
        public UserViewHolder(@NonNull ItemUserListBinding aItemUserListBinding) {
            super(aItemUserListBinding.getRoot());
            this.mItemUserListBinding = aItemUserListBinding;
        }
    }
}
