package com.gumouren.aiapi.llm.qwen;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gumouren.aiapi.llm.qwen.constant.QwenConfigConst;
import com.gumouren.aiapi.llm.qwen.entity.request.QwenRequest;
import com.gumouren.aiapi.llm.qwen.entity.response.QwenResponse;
import com.gumouren.aiapi.util.HttpRequestUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.sse.EventSourceListener;


import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author gumouren
 * @description: 千问大模型
 * @date 2024/12/22 20:09
 */
@Slf4j
public class QwenClient implements QwenApi{

    private final String apiKey ;
    private  String host = QwenConfigConst.QWEN_HOST;
    private OkHttpClient okHttpClient = new OkHttpClient
            .Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS).build();
    private ObjectMapper mapper = new ObjectMapper();

    public QwenClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public QwenClient(String apiKey, String host) {
        this.apiKey = apiKey;
        this.host = host;
    }

    public QwenClient(String apiKey, String host, OkHttpClient httpClient) {
        this.apiKey = apiKey;
        this.host = host;
        this.okHttpClient = httpClient;
    }

    @Override
    public String chat(String param) throws Exception {
        QwenRequest request = JSONUtil.toBean(param, QwenRequest.class);
        QwenResponse response = qwenChat(request);
        return JSONUtil.toJsonStr(response);
    }

    @Override
    public void streamChat(String param, EventSourceListener eventSourceListener) throws Exception {
        if (Objects.isNull(eventSourceListener)) {
            log.error("参数异常：EventSourceListener不能为空");
            throw new Exception("参数异常：EventSourceListener不能为空");
        }
        QwenRequest request = JSONUtil.toBean(param, QwenRequest.class);
        qwenStreamChat(request, eventSourceListener);
    }


    @Override
    public QwenResponse qwenChat(QwenRequest param) throws Exception {
        String url = host + QwenConfigConst.QWEN_CHAT;
        log.info("进入千问chat,请求参数{}", param);
        String resultStr = HttpRequestUtil.execute(okHttpClient, apiKey, url, mapper.writeValueAsString(param));
        return JSONUtil.toBean(resultStr, QwenResponse.class);
    }

    @Override
    public void qwenStreamChat(QwenRequest param, EventSourceListener eventSourceListener) throws Exception {
        String url = host + QwenConfigConst.QWEN_CHAT;
        log.info("进入千问chat流式,请求参数{}", param);
        HttpRequestUtil.execute(okHttpClient, apiKey, url, mapper.writeValueAsString(param), eventSourceListener);
    }
}
