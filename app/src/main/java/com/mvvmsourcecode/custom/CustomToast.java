package com.mvvmsourcecode.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mvvmsourcecode.R;


public class CustomToast extends Toast {

    public CustomToast(Context aContext, String aMessage) {
        super(aContext);
        View view = LayoutInflater.from(aContext).inflate(R.layout.toast_custom_layout, null);
        TextView txtMsg = view.findViewById(R.id.txt_message);
        txtMsg.setText(aMessage);
        setView(view);
        setDuration(Toast.LENGTH_LONG);
    }


}
