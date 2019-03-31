package com.video.frag.frag_home;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.video.adapter.RecyHomeAdapter;
import com.video.adapter.RecySearchAdapter;
import com.video.http.OKHTTP;
import com.video.main.MainActivity;
import com.video.pojo.home_x.BannerDatas;
import com.video.pojo.home_x.Body;
import com.video.pojo.home_x.HomeXX;
import com.video.pojo.home_x.ViewItemModels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import jane.com.vip.video_paradise.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.media.AudioRecord.SUCCESS;
import static com.shuyu.gsyvideoplayer.GSYVideoADManager.TAG;
import static com.video.util.ApiUtil.HOME_API;

public class Fra_Home extends Fragment implements View.OnClickListener {


    private RecyclerView reay_home_1;

    List<Bitmap> bitmapList;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fra_home, container, false);
        initView(view);
        bitmapList = new ArrayList<>();
        getInfo();

        return view;
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SUCCESS:
                    //通过message，拿到字节数组
                    byte[] Picture = (byte[]) msg.obj;
                    //使用BitmapFactory工厂，把字节数组转化为bitmap
                    Bitmap bitmap = BitmapFactory.decodeByteArray(Picture, 0, Picture.length);


                    bitmapList.add(bitmap);
                    break;

            }
        }
    };

    private void getInfo() {
        String url = HOME_API;
        String js = OKHTTP.doGet(url);

        HomeXX homeXX = new Gson().fromJson(js, HomeXX.class);
        int co = homeXX.getCode();
        String message = homeXX.getMessage();
        Log.e(TAG, "getInfo:co### " + co);
        Log.e(TAG, "getInfo:message### " + message);
        Body body = homeXX.getBody();
        List<ViewItemModels> viewItemModels = body.getViewItemModels();

//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        reay_home_1.setLayoutManager(staggeredGridLayoutManager);
//        RecyHomeAdapter adapter = new RecyHomeAdapter(viewItemModels, this);
//        reay_home_1.setAdapter(adapter);

        getActivity().runOnUiThread(() -> {
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
            reay_home_1.setLayoutManager(staggeredGridLayoutManager);
            RecyHomeAdapter adapter = new RecyHomeAdapter(viewItemModels, Fra_Home.this);
            reay_home_1.setAdapter(adapter);
        });




        getImg();
//        getImg();

    }

    private void getImg() {
//    private void getImg() {
//        OKHTTP.doGetIma(url).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                byte[] Picture_bt = response.body().bytes();
//                Message message = handler.obtainMessage();
//                message.obj = Picture_bt;
//                message.what = SUCCESS;
//                handler.sendMessage(message);
//            }
//        });
    }

//
//
//    }

    private void initView(View view) {
        reay_home_1 = (RecyclerView) view.findViewById(R.id.reay_home_1);
    }


    @Override
    public void onClick(View v) {

    }


}


