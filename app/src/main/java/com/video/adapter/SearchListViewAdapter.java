package com.video.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.video.frag.frag_search.Fra_search;
import com.video.frag.frag_search.frag_internal.Fra_internal_1;
import com.video.frag.frag_search.frag_internal.Fra_internal_2;
import com.video.pojo.root.Data;
import com.video.pojo.home.Hot;
import com.video.pojo.home.New;

import java.util.ArrayList;
import java.util.List;

import jane.com.vip.video_paradise.R;

public class SearchListViewAdapter extends BaseAdapter {

    private List<Data> data;
    private List<New> newList;
    private List<Hot> hotList;
    Context context;


    public SearchListViewAdapter(String key) {
        if (key.equals("data")) {
            this.data = Fra_internal_2.data;
        } else if (key.equals("newList")) {
            this.newList = Fra_internal_1.newList;
            this.data = new ArrayList<>();
            for (New n : newList) {
                Data data = new Data();
                data.setName(n.getName());
                data.setSource(n.getSource());
                this.data.add(data);
            }

        } else if (key.equals("hotList")) {
            this.hotList =  Fra_internal_1.hotList;
            this.data = new ArrayList<>();
            for (Hot n : hotList) {
                Data data = new Data();
                data.setName(n.getName());
                data.setSource(n.getSource());
                this.data.add(data);
            }
        }
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (context == null) {
            context = parent.getContext();
        }
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_search_1, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final String name = data.get(position).getName();
        viewHolder.item_search_1.setText(name);


        convertView.setOnClickListener(v -> new Fra_search().item_search_1(context,data.get(position)));


        return convertView;
    }

    public
    class ViewHolder {
        public View rootView;
        public TextView item_search_1;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.item_search_1 = (TextView) rootView.findViewById(R.id.item_search_1);
        }

    }
}

