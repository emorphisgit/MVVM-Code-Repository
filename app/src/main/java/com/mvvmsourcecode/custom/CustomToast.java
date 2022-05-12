package com.mvvmsourcecode.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mvvmsourcecode.R;


public class CustomToast extends Toast {
    private Context context;
    private String message;

    public CustomToast(Context context, String message) {
        super(context);
        this.context = context;
        this.message = message;
        View view = LayoutInflater.from(context).inflate(R.layout.toast_custom_layout, null);
        TextView txtMsg = view.findViewById(R.id.txt_message);
        txtMsg.setText(message);
        setView(view);
        setDuration(Toast.LENGTH_LONG);

    }


}
