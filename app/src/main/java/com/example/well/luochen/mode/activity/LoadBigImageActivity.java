package com.example.well.luochen.mode.activity;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.well.luochen.R;
import com.example.well.luochen.utils.LogUtils;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Well on 2016/7/9.
 */
@EActivity(R.layout.activity_load_big_image)
public class LoadBigImageActivity extends BaseActivity {
    @Extra
    String url;

    @ViewById
    ImageView iv;

    @AfterViews
    void initAfterViews()
    {
        app.setSystemBar(this,android.R.color.black);

        Glide.with(LoadBigImageActivity.this).load(url).error(R.drawable.he).diskCacheStrategy(DiskCacheStrategy.SOURCE).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                LogUtils.logError("加载失败" + " e=" + e.toString() + " model=" + model);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        }).into(iv);
    }
}
