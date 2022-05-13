package com.mvvmsourcecode.network;

import static com.mvvmsourcecode.constant.AppConstant.BASE_URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mvvmsourcecode.constant.AppConstant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {

    private static Retrofit mRetrofit;

    //Create instance of retrofit and Added timeout connection.
    public static ApiDataService getService() {
        if (mRetrofit == null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                    .callTimeout(2, TimeUnit.MINUTES)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS);

            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create());
            builder.client(httpClient.build());
            mRetrofit = builder.build();
        }

        return mRetrofit.create(ApiDataService.class);
    }
}