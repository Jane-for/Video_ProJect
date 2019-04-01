package com.video.fragment.frag_search;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.shuyu.gsyvideoplayer.GSYVideoBaseManager;
import com.video.fragment.frag_search.frag_internal.Fra_internal_1;
import com.video.fragment.frag_search.frag_internal.Fra_internal_2;
import com.video.http.OKHTTP;
import com.video.http.OkHttpUtil;
import com.video.main.Fra_video;
import com.video.pojo.home.Home;
import com.video.pojo.root.Data;
import com.video.pojo.root.JsonRootBean;
import com.video.util.DataUtil;

import java.io.IOException;
import java.util.List;
import java.util.Timer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import jane.com.vip.video_paradise.R;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.ContentValues.TAG;
import static com.video.util.ApiUtil.API;
import static com.video.util.ApiUtil.API_REMOVE;

public class Fra_search extends Fragment implements View.OnClickListener {

    private EditText ed_search_1;
    private Button btn_search_1;


    private List<Data> data;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fra_search, container, false);
        initView(view);

        if (DataUtil.home != null) {
            Log.i(TAG, "onCreateView:DataUtil.home;### " + DataUtil.home.getType());
            show(1);
        }
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

    String js = null;
    Timer timer;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_search_1:
                String ed = ed_search_1.getText().toString().trim();
                if (0 != ed.length()) {
                    String url = API + ed;
                    Log.i(TAG, "onClick: url###" + url);

//                    OkHttpUtil.getInstance(getContext()).getAsynHttp(url, new OkHttpUtil.OkHttpResultCallback() {
//                        @Override
//                        public void onError(Request request, Exception e) {
//
//                        }
//
//                        @Override
//                        public void onResponse(Response response) throws IOException {
//                            js = response.body().string();
//                            Log.i(TAG, "onClick: js###  onResponse###" + js);
//                            if (js.length() == 0) {
//                                Log.i(TAG, "onClick: js###  onResponse###空了");
//                            } else {
//                                doInit();
//
//                            }
//                        }
//                    });
                    js = OKHTTP.doGet(url);
                    while (!js.contains("type")) {
                        js = OKHTTP.doGet(url);
                    }
                    doInit();

                }

                break;
        }
    }

    private void doInit() {
        if (js.contains("{\"type\": 4000}")) {
            remove_api();
        } else if (js.contains("\"type\":\"home\"")) {
            Home home = new Gson().fromJson(js, Home.class);
            DataUtil.home = home;
            show(1);
        } else {
            JsonRootBean jsonRootBean = new Gson().fromJson(js, JsonRootBean.class);
            data = jsonRootBean.getData();
            show(2);
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void remove_api() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = View.inflate(getContext(), R.layout.dia_search_api, null);
        ViewHolder viewHolder = new ViewHolder(view);
        Dialog dialog = builder.create();
        dialog.show();
        dialog.setContentView(view);
        dialog.getWindow().setLayout(1000,1000);
        viewHolder.web_api.loadUrl(API_REMOVE);
        WebSettings wSet = viewHolder.web_api.getSettings();
        wSet.setJavaScriptEnabled(true);
        viewHolder.web_api.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });


        /*
        不弹窗  解除api限制
         */
//        OkHttpUtil.getInstance(getContext()).getAsynHttp("https://z1.m1907.cn/api/captcha?t=t02FwHs-y_KeQeiyEqSksRT0etl_Ne-6E92m1t6ZiCHEF7vJxA3F9NLfLWu8XBjnw7Yc4UKtHI8l6PPVN6VRH6vQ6fFgOL2bk8sRiPSM2YrOLk9QkCQWOF4xw**&r=%402hJ",
//                new OkHttpUtil.OkHttpResultCallback() {
//                    @Override
//                    public void onError(Request request, Exception e) {
//
//                    }
//
//                    @Override
//                    public void onResponse(Response response) throws IOException {
//                        Log.e(TAG, "onResponse: response###" + response.body().string().toString());
//                    }
//                });
    }

    private void show(int i) {
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        switch (i) {
            case 1:
                Home home = DataUtil.home;
                Log.i(TAG, "show: show###" + home.getNewX().size());
                fragmentTransaction.replace(R.id.fra_sear_1, new Fra_internal_1(home.getNewX(), home.getHot()));
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

    public static
    class ViewHolder {
        public View rootView;
        public WebView web_api;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.web_api = (WebView) rootView.findViewById(R.id.web_api);
        }

    }
}
