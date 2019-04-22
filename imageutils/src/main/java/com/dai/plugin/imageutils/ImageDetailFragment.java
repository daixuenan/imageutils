package com.dai.plugin.imageutils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.dai.plugin.imageutils.interfaces.OnLoadImageListener;

import java.io.Serializable;

/**
 * 单张图片显示Fragment
 */
public class ImageDetailFragment<T> extends Fragment {

    public PhotoView mImageView;
    private ProgressBar progressBar;
    public PhotoViewAttacher mAttacher;

    private T bean;

    private static OnLoadImageListener mOnLoadImageListener;

    public static <T> ImageDetailFragment newInstance(T bean, OnLoadImageListener onLoadImageListener) {
        mOnLoadImageListener = onLoadImageListener;
        final ImageDetailFragment f = new ImageDetailFragment();
        final Bundle args = new Bundle();
        args.putSerializable("bean", (Serializable) bean);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bean = (T) getArguments().getSerializable("bean");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.default_frame_image_detail, container, false);
        mImageView = (PhotoView) v.findViewById(R.id.image);
        mAttacher = new PhotoViewAttacher(mImageView);
        mAttacher.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View arg0, float arg1, float arg2) {
                getActivity().finish();
            }
        });
        progressBar = (ProgressBar) v.findViewById(R.id.loading);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        if (bean != null) {
            if (mOnLoadImageListener == null && bean instanceof String) {
                Glide.with(getActivity()).load(bean.toString()).into(mImageView);
            } else {
                mOnLoadImageListener.onLoadImage(bean, mImageView);
            }
        }
    }
}
