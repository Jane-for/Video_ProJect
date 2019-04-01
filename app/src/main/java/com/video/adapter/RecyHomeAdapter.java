package com.video.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.video.http.OkHttpUtil;
import com.video.pojo.home_x.Videos;
import com.video.pojo.home_x.ViewItemModels;

import java.io.IOException;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jane.com.vip.video_paradise.R;
import okhttp3.Request;
import okhttp3.Response;

import static com.shuyu.gsyvideoplayer.GSYVideoADManager.TAG;

public class RecyHomeAdapter extends RecyclerView.Adapter<RecyHomeAdapter.ViewHolder> {
    private List<ViewItemModels> viewItemModels;
    private View.OnClickListener listener;
    private Context context;

    public RecyHomeAdapter(Context context, List<ViewItemModels> viewItemModels, View.OnClickListener listener) {
        this.viewItemModels = viewItemModels;
        this.listener = listener;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_01, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.image_home_1.setImageDrawable();
        ViewItemModels viewItemModel = viewItemModels.get(position);
        List<Videos> videos = viewItemModel.getVideos();
        holder.te_home_name.setText(videos.get(position).getName());
        String img = videos.get(position).getImg();
        Log.i(TAG, "onBindViewHolder: img###" + img);
        Log.i(TAG, "onBindViewHolder: videos.get(position).getName()###" + videos.get(position).getName());
        OkHttpUtil.getInstance(context).getAsynHttp(img, new OkHttpUtil.OkHttpResultCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                try {
                    byte[] bytes = response.body().bytes();
                    Bitmap bitmap = new BitmapFactory().decodeByteArray(bytes, 0, bytes.length);
                    holder.image_home_1.setImageBitmap(bitmap);
                } catch (Exception e) {
                    try {
                        throw new Throwable("android.os.NetworkOnMainThreadException###"+e.toString()+"onBindViewHolder");
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                } finally {

                }
            }
        });
        Log.e(TAG, "onBindViewHolder: videos.get(position).getScore()###" + videos.get(position).getScore());
        holder.te_home_1.setText(videos.get(position).getScore() + "");
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
        public TextView te_home_name;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;

//            Bitmap bitmap = null;
//            image_home_1.setImageBitmap(bitmap);
            this.image_home_1 = (ImageView) rootView.findViewById(R.id.image_home_1);
            this.te_home_1 = (TextView) rootView.findViewById(R.id.te_home_1);
            this.te_home_name = (TextView) rootView.findViewById(R.id.te_home_name);
        }

    }
}
