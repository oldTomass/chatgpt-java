package com.hjm.service;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import com.hjm.config.ChatConfig;
import com.hjm.utils.ParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@EnableConfigurationProperties(ChatConfig.class)
public class ChatService {

    // 获取APIKEY
    @Autowired
    ChatConfig chatconfig;

    // Text：allText
    public String chatText(String reqText) {
        //发起POST请求，将数据提交服务端
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");

        JSONObject json = new JSONObject();
        //选择模型
        json.set("model", "text-davinci-003");
        //设置请求头参数
        json.set("prompt", reqText); //设置输入的内容
        json.set("temperature", 0.9);
        json.set("max_tokens", 2048);
        json.set("top_p", 1);
        json.set("frequency_penalty", 0.0);
        json.set("presence_penalty", 0.6);

        HttpResponse response = HttpRequest.post("https://api.openai.com/v1/completions")
                .headerMap(headers, false)
                .bearerAuth(chatconfig.getAPIKEY())
                .body(String.valueOf(json))
                .timeout(5 * 60 * 1000)
                .execute();
        // 解析内容,获取相应内容
        return ParseUtil.parseText(response.body());
    }

    // Image
    public List<String> chatImage(String reqImage) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");

        JSONObject json = new JSONObject();
        //搜索关键字
        json.set("prompt", reqImage);
        //生成图片数
        json.set("n", 2);
        //生成图片大小
        json.set("size", "256x256");
        //返回格式
        json.set("response_format", "url");

        //发送请求
        HttpResponse response = HttpRequest.post("https://api.openai.com/v1/images/generations")
                .headerMap(headers, false)
                .bearerAuth(chatconfig.getAPIKEY())
                .body(String.valueOf(json))
                .timeout(5 * 60 * 1000)
                .execute();
        return ParseUtil.parseImageUrls(response.body());
    }
}
