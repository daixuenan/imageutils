package com.dai.plugin.imageutils.interfaces;

import android.content.Context;

import com.dai.plugin.imageutils.PhotoView;

public interface OnLoadImageListener<T> {

    void onLoadImage(Context context, T bean, PhotoView imageView);
}
