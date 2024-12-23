package com.gumouren.aiapi.util;

import cn.hutool.http.ContentType;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import okhttp3.sse.EventSources;

import java.io.IOException;


/**
 * @author gumouren
 * @description: 处理请求
 * @date 2024/12/22 20:56
 */
@Slf4j
public class HttpRequestUtil {

    /**
     * 非流式执行方法
     * @return
     */
    public static String execute(OkHttpClient okHttpClient, String apiKey, String url, String body) {
        String str = "";
        try {
            Request request = createRequest(apiKey, url, body, false);
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            str =  response.body().string();
        } catch (Exception e) {
            log.error("请求失败：{}", e);
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 流式执行方法
     * @return
     */
    public static String execute(OkHttpClient okHttpClient, String apiKey, String url, String body, EventSourceListener eventSourceListener) {
        String str = "";
        try {
            Request request = createRequest(apiKey, url, body, true);
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            EventSource.Factory factory = EventSources.createFactory(okHttpClient);
            //创建事件
            EventSource eventSource = factory.newEventSource(request, eventSourceListener);
        } catch (Exception e) {
            log.error("请求失败：{}", e);
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 创建请求
     * @param apiKey toekn
     * @param url 请求地址
     * @param body 请求参数
     * @param stream 是否流式
     * @return
     */
    private static Request createRequest(String apiKey, String url, String body, Boolean stream) {
        return new Request.Builder()
                .url(url)
                .addHeader("Accept", Boolean.TRUE.equals(stream) ? "text/event-stream" : "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + apiKey)
                .post(RequestBody.create(MediaType.parse(ContentType.JSON.getValue()), JSONUtil.toJsonStr(body)))
                .build();
    }

}
