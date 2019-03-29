package com.video.frag.frag_about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import jane.com.vip.video_paradise.R;

public class Fra_about extends Fragment implements View.OnClickListener {

    private TextView te_about_1;
    private TextView te_about_2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_about, container, false);

        initView(view);
        return view;
    }


    private void initView(View view) {
        te_about_1 = (TextView) view.findViewById(R.id.te_about_1);
        te_about_2 = (TextView) view.findViewById(R.id.te_about_2);

        te_about_1.setOnClickListener(this);
        te_about_2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.te_about_1:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/CarGuo/GSYVideoPlayer"));
                startActivity(intent);
                break;
            case R.id.te_about_2:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://shang.qq.com/open_webaio.html?sigt=f4f549ec2ecba57c5107715a86750b43d85dffc9c0b59ecb17ec5e2f2ef331cb32c2b5753565a2e8436541e6d015e6b1&sigu=62f76760381c13104d8fab9208362f5c49ecbadb84402f82cb75b080c143bff6e40838df442b425d&tuin=2964295321"));
                startActivity(intent);
                break;
        }
    }
}
