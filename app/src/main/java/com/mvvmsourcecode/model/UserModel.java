package com.mvvmsourcecode.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.SerializedName;
import com.mvvmsourcecode.R;

public class UserModel {

    @SerializedName("login")
    private String login;

    @SerializedName("avatar_url")
    private String avatar_url;

    @BindingAdapter({"avatar_url"})
    public static void loadImage(ImageView imageView, String imageURL) {

        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(new RequestOptions()
                        .circleCrop())
                .load(imageURL)
                .placeholder(R.drawable.ic_user_profile_circle)
                .into(imageView);
    }

    public String getLogin() {
        return login;
    }
    public String getAvatar() {
        return avatar_url;
    }

}
