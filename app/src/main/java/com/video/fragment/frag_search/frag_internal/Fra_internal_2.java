package com.video.fragment.frag_search.frag_internal;

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
import com.video.pojo.root.Data;

import java.util.List;

import jane.com.vip.video_paradise.R;

@SuppressLint("ValidFragment")
public class Fra_internal_2 extends Fragment {

    Context context;

    public static List<Data> data;
    public static ListView list_search_1;


    public Fra_internal_2() {
    }

    public Fra_internal_2(List<Data> data) {
        this.data = data;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_sear_fragment_2, null);

        initView(view);
        context = getContext();
        show();
        return view;
    }

    private void show() {
        SearchListViewAdapter searchListViewAdapter = new SearchListViewAdapter("data");
        list_search_1.setAdapter(searchListViewAdapter);

    }




    private void initView(View view) {
        list_search_1 = (ListView) view.findViewById(R.id.list_search_1);
    }
}
