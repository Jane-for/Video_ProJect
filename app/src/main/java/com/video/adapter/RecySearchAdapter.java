package com.video.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.video.pojo.root.Eps;

import java.util.List;

import jane.com.vip.video_paradise.R;

public class RecySearchAdapter extends RecyclerView.Adapter<RecySearchAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_3_1, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//        Context context;
        Eps eps = epsList.get(i);
        viewHolder.btn_31_1.setText(eps.getName());
        viewHolder.btn_31_1.setTag(i);
        viewHolder.btn_31_1.setOnClickListener(listener);
//        viewHolder.btn_31_1.setOnClickListener(v -> new Fra_video().btn_31_1(eps));
    }

    @Override
    public int getItemCount() {
        return epsList.size();
    }


    private List<Eps> epsList;
    private View.OnClickListener listener;

    public RecySearchAdapter(List<Eps> epsList, View.OnClickListener listener) {
        this.epsList = epsList;
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public Button btn_31_1;

        public ViewHolder(View rootView) {
            super(rootView);
            this.btn_31_1 = (Button) rootView.findViewById(R.id.btn_31_1);
        }

    }
}
