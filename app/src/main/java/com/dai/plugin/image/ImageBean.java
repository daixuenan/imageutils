package com.dai.plugin.image;

import java.io.Serializable;

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
