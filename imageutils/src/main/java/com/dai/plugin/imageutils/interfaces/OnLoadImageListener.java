package com.dai.plugin.imageutils.interfaces;

import com.dai.plugin.imageutils.PhotoView;

public interface OnLoadImageListener<T> {

    void onLoadImage(T bean, PhotoView imageView);
}
