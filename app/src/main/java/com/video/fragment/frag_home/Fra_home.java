package com.video.fragment.frag_home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.video.adapter.RecyHomeAdapter;
import com.video.http.OkHttpUtil;
import com.video.pojo.home_x.Body;
import com.video.pojo.home_x.HomeXX;
import com.video.pojo.home_x.ViewItemModels;

import java.io.IOException;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import jane.com.vip.video_paradise.R;
import okhttp3.Request;
import okhttp3.Response;

import static com.shuyu.gsyvideoplayer.GSYVideoADManager.TAG;
import static com.video.util.ApiUtil.HOME_API;

public class Fra_home extends Fragment implements View.OnClickListener {


    ViewHolder viewHolder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fra_home, container, false);
        viewHolder = new ViewHolder(view);
        getInfo();
        return view;
    }


    String js = "";
    List<ViewItemModels> viewItemModels;
    private void getInfo() {
        String url = HOME_API;

        OkHttpUtil.getInstance(getContext()).getAsynHttp(url, new OkHttpUtil.OkHttpResultCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                js = response.body().string();

                HomeXX homeXX = new Gson().fromJson(js, HomeXX.class);
                int co = homeXX.getCode();
                String message = homeXX.getMessage();


                Log.e(TAG, "getInfo:co### " + co);
                Log.e(TAG, "getInfo:message### " + message);
                Body body = homeXX.getBody();

                viewItemModels= body.getViewItemModels();
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                viewHolder.reay_home_1.setLayoutManager(staggeredGridLayoutManager);
                RecyHomeAdapter adapter = new RecyHomeAdapter(getContext(), viewItemModels, Fra_home.this);
                viewHolder.reay_home_1.setAdapter(adapter);
            }
        });




    }


    @Override
    public void onClick(View v) {

    }


    public static
    class ViewHolder {
        public View rootView;
        public RecyclerView reay_home_1;
        public RecyclerView reay_home_2;
        public RecyclerView reay_home_3;
        public RecyclerView reay_home_4;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.reay_home_1 = (RecyclerView) rootView.findViewById(R.id.reay_home_1);
            this.reay_home_2 = (RecyclerView) rootView.findViewById(R.id.reay_home_2);
            this.reay_home_3 = (RecyclerView) rootView.findViewById(R.id.reay_home_3);
            this.reay_home_4 = (RecyclerView) rootView.findViewById(R.id.reay_home_4);
        }

    }
}


