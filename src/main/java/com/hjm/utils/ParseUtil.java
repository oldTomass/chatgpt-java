package com.hjm.utils;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import com.hjm.entity.imagebean.ImageEntity;
import com.hjm.entity.textbean.TextEntity;

import java.util.ArrayList;
import java.util.List;

public class ParseUtil {

    // Text：从response中解析出Text内容
    public static String parseText(String respText){
        TextEntity textEntity = new JSONObject(respText).toBean(TextEntity.class);
        StringBuilder sb = new StringBuilder();
        textEntity.getChoices().forEach((c) ->{
            sb.append(c.getText());
        });
        return sb.toString();
    }

    // Image：从response中解析出ImageUrl地址
    public static List<String> parseImageUrls(String respImages){
        ImageEntity imageEntity = new JSONObject(respImages).toBean(ImageEntity.class);
        List<String> urls = new ArrayList<>();
        imageEntity.getData().forEach((s) ->{
            urls.add(s.getUrl());
        });
        return urls;

    }
}
