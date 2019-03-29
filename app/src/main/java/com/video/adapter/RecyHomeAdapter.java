package com.video.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.video.pojo.home_x.Videos;
import com.video.pojo.home_x.ViewItemModels;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jane.com.vip.video_paradise.R;

import static com.shuyu.gsyvideoplayer.GSYVideoADManager.TAG;

public class RecyHomeAdapter extends RecyclerView.Adapter<RecyHomeAdapter.ViewHolder> {
    List<ViewItemModels> viewItemModels;
    View.OnClickListener listener;


    public RecyHomeAdapter(List<ViewItemModels> viewItemModels, View.OnClickListener listener) {
        this.viewItemModels = viewItemModels;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_01, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.image_home_1.setImageDrawable();
        ViewItemModels viewItemModel = viewItemModels.get(position);
        List<Videos> videos = viewItemModel.getVideos();
        holder.te_home_1.setText(videos.get(position).getMovieTypeName());
        holder.te_home_name.setText(videos.get(position).getName());
        Log.e(TAG, "onBindViewHolder: videos.get(position).getScore()###" + videos.get(position).getScore());
        holder.te_home_2.setText(videos.get(position).getScore() + "");
    }

    @Override
    public int getItemCount() {
        return viewItemModels.size();
    }


    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView image_home_1;
        public TextView te_home_1;
        public TextView te_home_2;
        public TextView te_home_name;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image_home_1 = (ImageView) rootView.findViewById(R.id.image_home_1);
            this.te_home_1 = (TextView) rootView.findViewById(R.id.te_home_1);
            this.te_home_2 = (TextView) rootView.findViewById(R.id.te_home_2);
            this.te_home_name = (TextView) rootView.findViewById(R.id.te_home_name);
        }

    }
}
