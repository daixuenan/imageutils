# ViewImage

#### 介绍
查看大图，双击放大缩小，可手指缩放，单击退出。可自定义加载方法及实体类。

#### 安装教程

项目的root Gradle下添加 maven { url 'https://jitpack.io' }，如下

```markdown
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }

    allprojects {
        repositories {
            google()
            jcenter()
            maven { url 'https://jitpack.io' }
        }
    }
```
modle 的Gradle添加

```markdown
implementation 'com.github.daixuenan:imageutils:v1.0.0'
```

#### 使用说明

查看图片可直接传入List<String>参数，也可自定义图片加载方法。

1. 直接加载

```markdown
        //初始化数据，只能传入String类型。若传入其他实体类，需要使用自定义加载图片(图片是网上随便找的)
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
```

2. 自定义加载

自定义实体类ImageBean

```markdown

//一定要支持序列化
public class ImageBean implements Serializable {

    private String url;

    public ImageBean(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

```

加载图片

```markdown
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
                    public void onLoadImage(Context context, Object bean, PhotoView imageView) {
                        //PhotoView 继承ImageView，所以可以当作ImageView使用
                        if (bean instanceof ImageBean) {
                            //此处自定义图片加载方法 注意对imageView操作涉及到的context参数要用回调中的
                            Glide.with(context).load(((ImageBean) bean).getUrl()).into(imageView);
                        }
                    }
                });
```

#### 参与贡献

感谢PhotoView的作者