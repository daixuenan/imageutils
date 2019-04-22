package com.dai.plugin.imageutils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.TextView;

import com.dai.plugin.imageutils.interfaces.OnLoadImageListener;

import java.io.Serializable;
import java.util.List;

/*
 * 查看大图
 */
public class ViewImageActivity<T> extends FragmentActivity {

    private static final String STATE_POSITION = "STATE_POSITION";
    public static final String EXTRA_IMAGE_INDEX = "image_index";
    public static final String EXTRA_IMAGE_URLS = "image_urls";

    private HackyViewPager mPager;
    private int pagerPosition;
    private TextView indicator;

    private List<T> images;

    private static OnLoadImageListener mOnLoadImageListener;

    public static <T> void start(Context context, List<T> dataList, int position, OnLoadImageListener onLoadImageListener) {
        mOnLoadImageListener = onLoadImageListener;
        Intent intent = new Intent(context, ViewImageActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(EXTRA_IMAGE_URLS, (Serializable) dataList);
        intent.putExtra(EXTRA_IMAGE_INDEX, position);
        context.startActivity(intent);
    }

    public static <T> void start(Context context, List<T> dataList) {
        start(context, dataList, 0, null);
    }

    public static <T> void start(Context context, List<T> dataList, OnLoadImageListener onLoadImageListener) {
        start(context, dataList, 0, onLoadImageListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_activity_view_image);

        pagerPosition = getIntent().getIntExtra(EXTRA_IMAGE_INDEX, 0);
        images = (List<T>) getIntent().getSerializableExtra(EXTRA_IMAGE_URLS);

        mPager = (HackyViewPager) findViewById(R.id.pager);
        ImagePagerAdapter mAdapter = new ImagePagerAdapter(getSupportFragmentManager(), images);
        mPager.setAdapter(mAdapter);

        indicator = (TextView) findViewById(R.id.indicator);
        CharSequence text = getString(R.string.viewpager_indicator, 1, mPager.getAdapter().getCount());
        indicator.setText(text);
        // 更新下标
        mPager.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageSelected(int arg0) {
                CharSequence text = getString(R.string.viewpager_indicator, arg0 + 1, mPager.getAdapter().getCount());
                indicator.setText(text);
            }
        });
        if (savedInstanceState != null) {
            pagerPosition = savedInstanceState.getInt(STATE_POSITION);
        }

        mPager.setCurrentItem(pagerPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_POSITION, mPager.getCurrentItem());
    }

    private class ImagePagerAdapter extends FragmentStatePagerAdapter {

        public List<T> fileList;

        public ImagePagerAdapter(FragmentManager fm, List<T> fileList) {
            super(fm);
            this.fileList = fileList;
        }

        @Override
        public int getCount() {
            return fileList.size();
        }

        @Override
        public Fragment getItem(int position) {
            return ImageDetailFragment.newInstance(fileList.get(position), mOnLoadImageListener);
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.viewimage_close_enter, R.anim.viewimage_close_exit);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mOnLoadImageListener = null;
    }
}
