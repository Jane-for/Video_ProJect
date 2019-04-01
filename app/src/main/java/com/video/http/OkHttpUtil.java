package com.video.http;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtil {
    private volatile static OkHttpUtil okHttpUtil;//会被多线程使用，所以使用关键字volatile
    private OkHttpClient client;
    private Handler mHandler;
    private OkHttpUtil(Context context){
        File sdcache = context.getExternalCacheDir();
        int cacheSize = 10 * 1024 *1024;//设置缓存大小
        OkHttpClient.Builder builder= new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .cache(new Cache(sdcache.getAbsoluteFile(),cacheSize));//设置缓存的路径
        client = builder.build();
        mHandler = new Handler();
    }
    public static OkHttpUtil getInstance(Context context){
        if (okHttpUtil == null){
            synchronized (OkHttpUtil.class){
                if (okHttpUtil == null){
                    okHttpUtil = new OkHttpUtil(context);
                }
            }
        }
        return okHttpUtil;
    }


    public void getAsynHttp(String url, final OkHttpResultCallback callback){
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                sendFailedCallback(call,e,callback);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                sendSuccessCallback(response,callback);
            }
        });
    }


    public void postForm(String url, Map<String,String > map, final OkHttpResultCallback callback){
        FormBody.Builder form = new FormBody.Builder();
        if (map != null && !map.isEmpty()){
            //遍历Map集合
            for(Map.Entry<String ,String> entry : map.entrySet()){
                form.add(entry.getKey(),entry.getValue());
            }
            RequestBody body = form.build();
            Request request = new Request.Builder().url(url).post(body).build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    sendFailedCallback(call,e,callback);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()&&response != null){
                        sendSuccessCallback(response,callback);
                    }
                }
            });
        }

    }


    private void sendFailedCallback(final Call call, final IOException e, final OkHttpResultCallback callback){
        mHandler.post(() -> {
            Log.i("main","当前线程："+Thread.currentThread().getName());
            if (callback != null){
                callback.onError(call.request(),e);
            }
        });
    }


    private void sendSuccessCallback(final Response response, final OkHttpResultCallback callback){
        mHandler.post(() -> {
            Log.i("main","当前线程："+Thread.currentThread().getName());
            if (callback != null){
                try {
                    callback.onResponse(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //创建接口，回调给调用者
    public interface OkHttpResultCallback{
        void onError(Request request, Exception e);
        void onResponse(Response response) throws IOException;
    }

}