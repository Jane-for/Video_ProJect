package com.video.http;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

public class OKHTTP {

    static String js = null;
    static OkHttpClient okHttpClient = new OkHttpClient();


    public static String doPost(String url, String toJson) {
        MediaType mediaType = MediaType.parse("Application/json;charset:utf-8");
        RequestBody body = RequestBody.create(mediaType, toJson);
        js = null;
        Request.Builder builder = new Request.Builder().post(body).url(url);
        final Request request = builder.build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Log.e(TAG, "onFailure: IOException###"+e.toString() );

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                js = response.body().string();
            }
        });

        while (js == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.i(TAG, "doPost: js###" + js);
        return js;
    }

    public static String doGet(String url) {

        js = null;
        Request.Builder builder = new Request.Builder().get().url(url);
        final Request request = builder.build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: IOException###"+e.toString() );

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                js = response.body().string();
            }
        });

        while (js == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Log.i(TAG, "doGet: js###" + js);
        return js;
    }

}
