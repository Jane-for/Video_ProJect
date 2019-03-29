package com.video.frag.frag_search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.shuyu.gsyvideoplayer.GSYVideoBaseManager;
import com.video.frag.frag_search.frag_internal.Fra_internal_1;
import com.video.frag.frag_search.frag_internal.Fra_internal_2;
import com.video.http.OKHTTP;
import com.video.main.Fra_video;
import com.video.pojo.root.Data;
import com.video.pojo.root.JsonRootBean;
import com.video.pojo.home.Home;
import com.video.pojo.home.Hot;
import com.video.pojo.home.New;
import com.video.util.ApiUtil;
import com.video.util.DataUtil;

import java.util.List;

import jane.com.vip.video_paradise.R;

import static android.content.ContentValues.TAG;
import static com.video.util.ApiUtil.API;

public class Fra_search extends Fragment implements View.OnClickListener {

    private EditText ed_search_1;
    private Button btn_search_1;


    private List<New> newList;
    private List<Hot> hotList;


    private List<Data> data;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fra_search, container, false);
        initView(view);

        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void initView(View view) {
        ed_search_1 = (EditText) view.findViewById(R.id.ed_search_1);
        btn_search_1 = (Button) view.findViewById(R.id.btn_search_1);
        btn_search_1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_search_1:
//                https://z1.m1907.cn/api/v/?z=bc901a8b3b752896e398a102cdbc5654&jx=%E6%B5%81%E6%B5%AA%E5%9C%B0%E7%90%83
                String ed = ed_search_1.getText().toString().trim();
                if (0 != ed.length()) {
                    String url = API + ed;
                    Log.i("tag", "onClick: url###" + url);
                    String js = OKHTTP.doGet(url);
                    while (!js.contains("type")) {
                        js = OKHTTP.doGet(url);
                    }
                    if (js.contains("}{\"type\": 4000")) {
                        Toast.makeText(getContext(), "查询速度过快", Toast.LENGTH_SHORT).show();
                    } else if (js.contains("\"type\":\"home\"")) {
                        Home home = new Gson().fromJson(js, Home.class);
                        hotList = home.hot;
                        newList = home.newX;
                        show(1);
                    } else {
                        JsonRootBean jsonRootBean = new Gson().fromJson(js, JsonRootBean.class);
                        data = jsonRootBean.getData();
                        show(2);
                    }
                } else {
//                    Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void show(int i) {
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        switch (i) {
            case 1:
                Log.i(TAG, "show: show###" + newList.size());
                fragmentTransaction.replace(R.id.fra_sear_1, new Fra_internal_1(newList, hotList));
                break;
            case 2:
                fragmentTransaction.replace(R.id.fra_sear_1, new Fra_internal_2(data));
                break;
        }
        fragmentTransaction.commit();
    }

    public void item_search_1(Context context, Data data) {
        Log.e(GSYVideoBaseManager.TAG, "item_search_1: data###" + data.getName());
        Log.e(GSYVideoBaseManager.TAG, "item_search_1: context###" + context.toString());
        Toast.makeText(context, data.getName() + "加载中...", Toast.LENGTH_SHORT).show();
        DataUtil.data = data;
        Log.e(TAG, "item_search_1:  DataUtil.data ###" + DataUtil.data.getName());
        Intent intent = new Intent(context, Fra_video.class);
        context.startActivity(intent);
    }
}
