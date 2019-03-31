package com.video.frag.frag_search.frag_internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.video.adapter.SearchListViewAdapter;
import com.video.pojo.home.Hot;
import com.video.pojo.home.New;

import java.util.List;

import jane.com.vip.video_paradise.R;



@SuppressLint("ValidFragment")
public class Fra_internal_1 extends Fragment {

    Context context;
    private ListView list_search_1;
    private ListView list_search_2;


    public static List<New> newList;
    public static List<Hot> hotList;


    public Fra_internal_1() {

    }

    public Fra_internal_1(List<New> newList, List<Hot> hotList) {
        this.newList = newList;
        this.hotList = hotList;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_sear_fragment_1, null);
        initView(view);
        context = getContext();
        show();



        return view;
    }

    private void show() {

        SearchListViewAdapter searchListViewAdapter = new SearchListViewAdapter("newList");
        list_search_1.setAdapter(searchListViewAdapter);
        searchListViewAdapter = new SearchListViewAdapter("hotList");
        list_search_2.setAdapter(searchListViewAdapter);

    }

    private void initView(View view) {
        list_search_1 = (ListView) view.findViewById(R.id.list_search_1);
        list_search_2 = (ListView) view.findViewById(R.id.list_search_2);
    }
}

