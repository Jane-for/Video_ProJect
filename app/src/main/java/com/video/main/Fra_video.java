package com.video.main;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shuyu.gsyvideoplayer.GSYBaseActivityDetail;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.video.adapter.RecySearchAdapter;
import com.video.pojo.root.Data;
import com.video.pojo.root.Eps;
import com.video.util.DataUtil;

import java.util.List;

import jane.com.vip.video_paradise.R;

public class Fra_video extends GSYBaseActivityDetail<StandardGSYVideoPlayer> implements View.OnClickListener {

    private TextView te_3_1;


    private Data data;
    private List<Eps> epsList;


    private RecyclerView list_3_1;
    public static StandardGSYVideoPlayer vide_3_1;

    private OrientationUtils orientationUtils;

    private Eps eps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();
        data = new Data();
        data = DataUtil.data;

        epsList = data.getSource().getEps();
        eps = epsList.get(0);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        list_3_1.setLayoutManager(staggeredGridLayoutManager);
        RecySearchAdapter adapter = new RecySearchAdapter(epsList, this);
        list_3_1.setAdapter(adapter);


        //增加title
        vide_3_1.getTitleTextView().setVisibility(View.GONE);
        vide_3_1.getBackButton().setVisibility(View.GONE);


        initVideoBuilderMode();
        show();

    }


    @Override
    public StandardGSYVideoPlayer getGSYVideoPlayer() {
        return vide_3_1;
    }

    @Override
    public GSYVideoOptionBuilder getGSYVideoOptionBuilder() {
        Log.e("tag", "getGSYVideoOptionBuilder: " + eps.getUrl());
        //内置封面可参考SampleCoverVideo
        ImageView imageView = new ImageView(this);
        //loadCover(imageView, url);
        return new GSYVideoOptionBuilder()
                .setThumbImageView(imageView)
                .setUrl(eps.getUrl())
                .setCacheWithPlay(true)
                .setVideoTitle(eps.getName())
                .setIsTouchWiget(true)
                .setRotateViewAuto(false)
                .setLockLand(false)
                .setShowFullAnimation(false)//打开动画
                .setNeedLockFull(true)
                .setSeekRatio(1);
    }

    @Override
    public void clickForFullScreen() {

    }


    @Override
    public boolean getDetailOrientationRotateAuto() {
        return true;
    }


    private void show() {
        te_3_1.setText(data.getName());

    }

    private void initView() {
        te_3_1 = (TextView) findViewById(R.id.te_3_1);
        list_3_1 = (RecyclerView) findViewById(R.id.list_3_1);
        vide_3_1 = (StandardGSYVideoPlayer) findViewById(R.id.vide_3_1);
    }


//    public void btn_31_1(Eps eps) {
//        this.eps = eps;
//        getGSYVideoOptionBuilder();
//        Log.e("tag", "btn_31_1: eps###" + eps.getUrl());
//
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_31_1:
                int i = (int) v.getTag();
                this.eps = epsList.get(i);




                vide_3_1.setUp(eps.getUrl(), true, eps.getName());


                Log.e("tag", "btn_31_1: eps###" + eps.getUrl());
                break;
        }
    }
}
