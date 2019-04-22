package com.dai.plugin.image;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dai.plugin.imageutils.PhotoView;
import com.dai.plugin.imageutils.ViewImageActivity;
import com.dai.plugin.imageutils.interfaces.OnLoadImageListener;
import com.dai.plugin.imageutils.log.LogManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnViewImages = findViewById(R.id.btnViewImages);
        Button btnViewCustomImages = findViewById(R.id.btnViewCustomImages);
        btnViewImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewImages();
            }
        });
        btnViewCustomImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCustomsImages();
            }
        });
    }

    //默认图片
    private void viewImages() {
        //初始化数据，只能传入String类型。若传入其他实体类，需要试用自定义加载图片
        List<String> list = new ArrayList<>();
        list.add("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=e95179517d8da977512f802b8050f872/91529822720e0cf3740bf4990446f21fbf09aad0.jpg");
        list.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=d8d48aa8a151f3dedcb2bf64a4eff0ec/4610b912c8fcc3ce863f8b519c45d688d53f20d0.jpg");
        list.add("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=27b0e98083b1cb1321693a13ed5456da/1ad5ad6eddc451da92d38e84b8fd5266d01632b3.jpg");
        list.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=d9ef4716d888d43fefa997f24d1fd2aa/f703738da977391296f76502f6198618377ae284.jpg");
        list.add("https://ss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=3be4bb5513950a7b6a3548c43ad0625c/c8ea15ce36d3d539c1ecefa03487e950342ab084.jpg");
        list.add("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=e95179517d8da977512f802b8050f872/91529822720e0cf3740bf4990446f21fbf09aad0.jpg");
        list.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=d8d48aa8a151f3dedcb2bf64a4eff0ec/4610b912c8fcc3ce863f8b519c45d688d53f20d0.jpg");
        list.add("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=27b0e98083b1cb1321693a13ed5456da/1ad5ad6eddc451da92d38e84b8fd5266d01632b3.jpg");
        list.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=d9ef4716d888d43fefa997f24d1fd2aa/f703738da977391296f76502f6198618377ae284.jpg");
        list.add("https://ss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=3be4bb5513950a7b6a3548c43ad0625c/c8ea15ce36d3d539c1ecefa03487e950342ab084.jpg");

        //跳转加载
        ViewImageActivity.start(MainActivity.this, list);
    }

    //自定义加载图片
    private void viewCustomsImages() {
        //自定义实体类加载图片
        List<ImageBean> list = new ArrayList<>();
        list.add(new ImageBean("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=e95179517d8da977512f802b8050f872/91529822720e0cf3740bf4990446f21fbf09aad0.jpg"));
        list.add(new ImageBean("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=d8d48aa8a151f3dedcb2bf64a4eff0ec/4610b912c8fcc3ce863f8b519c45d688d53f20d0.jpg"));
        list.add(new ImageBean("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=27b0e98083b1cb1321693a13ed5456da/1ad5ad6eddc451da92d38e84b8fd5266d01632b3.jpg"));
        list.add(new ImageBean("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=d9ef4716d888d43fefa997f24d1fd2aa/f703738da977391296f76502f6198618377ae284.jpg"));
        list.add(new ImageBean("https://ss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=3be4bb5513950a7b6a3548c43ad0625c/c8ea15ce36d3d539c1ecefa03487e950342ab084.jpg"));
        list.add(new ImageBean("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=e95179517d8da977512f802b8050f872/91529822720e0cf3740bf4990446f21fbf09aad0.jpg"));
        list.add(new ImageBean("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=d8d48aa8a151f3dedcb2bf64a4eff0ec/4610b912c8fcc3ce863f8b519c45d688d53f20d0.jpg"));
        list.add(new ImageBean("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=27b0e98083b1cb1321693a13ed5456da/1ad5ad6eddc451da92d38e84b8fd5266d01632b3.jpg"));
        list.add(new ImageBean("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=d9ef4716d888d43fefa997f24d1fd2aa/f703738da977391296f76502f6198618377ae284.jpg"));
        list.add(new ImageBean("https://ss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=3be4bb5513950a7b6a3548c43ad0625c/c8ea15ce36d3d539c1ecefa03487e950342ab084.jpg"));

        //跳转加载 添加OnLoadImageListener参数后需要自行处理图片加载方法
        ViewImageActivity.start(MainActivity.this, list, new OnLoadImageListener() {
            @Override
            public void onLoadImage(Object bean, PhotoView imageView) {
                //PhotoView 继承ImageView，所以可以当作ImageView使用
                if (bean instanceof ImageBean) {
                    //此处自定义图片加载方法
                    LogManager.getLogger().i("imageUrl : ", ((ImageBean) bean).getUrl());
                }
            }
        });
    }
}
