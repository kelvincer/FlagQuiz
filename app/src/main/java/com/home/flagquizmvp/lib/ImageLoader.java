package com.home.flagquizmvp.lib;

import android.widget.ImageView;

/**
 * Created by ykro.
 */
public interface ImageLoader {
    void load(ImageView imageView, String URL);
    void setOnFinishedImageLoadingListener(Object object);
}
