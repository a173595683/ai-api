package com.gumouren.aiapi.llm.doubao;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gumouren.aiapi.llm.doubao.constant.DouBaoConfigConst;
import com.gumouren.aiapi.util.HttpRequestUtil;
import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionResult;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.sse.EventSourceListener;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author gumouren
 * @description: 豆包大模型
 * @date 2024/12/22 20:10
 */
@Slf4j
public class DouBaoClient implements DouBaoApi{


    private final String apiKey;
    private String apiChatHost = DouBaoConfigConst.DOUBAO_HOST;
    private String apiChatBotHost;
    private ObjectMapper mapper = new ObjectMapper();
    private OkHttpClient okHttpClient = new OkHttpClient
            .Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS).build();



    public DouBaoClient(String apiKey) {
        this.apiKey = apiKey;
    }
    public DouBaoClient(String apiKey, String host) {
        this.apiKey = apiKey;
        this.apiChatHost = host;
    }
    public DouBaoClient(String apiKey, String host, String botHost) {
        this.apiKey = apiKey;
        this.apiChatHost = host;
        this.apiChatBotHost = botHost;
    }
    public DouBaoClient(String apiKey, String host, String botHost, OkHttpClient httpClient) {
        this.apiKey = apiKey;
        this.apiChatHost = host;
        this.apiChatBotHost = botHost;
        this.okHttpClient = httpClient;
    }


    @Override
    public String chat(String param) throws Exception {
        ChatCompletionRequest request = JSONUtil.toBean(param, ChatCompletionRequest.class);
        ChatCompletionResult response = douBaoChat(request);
        return JSONUtil.toJsonStr(response);

    }

    @Override
    public void streamChat(String param, EventSourceListener eventSourceListener) throws Exception {
        if (Objects.isNull(eventSourceListener)) {
            log.error("参数异常：EventSourceListener不能为空");
            throw new Exception("参数异常：EventSourceListener不能为空");
        }
        ChatCompletionRequest request = JSONUtil.toBean(param, ChatCompletionRequest.class);
        douBaoStreamChat(request, eventSourceListener);
    }


    @Override
    public ChatCompletionResult douBaoChat(ChatCompletionRequest param) throws Exception {
        String url = apiChatHost + DouBaoConfigConst.DOUBAO_CHAT;
        log.info("进入豆包chat,请求参数{}", param);
        String resultStr = HttpRequestUtil.execute(okHttpClient, apiKey, url, mapper.writeValueAsString(param));
        return JSONUtil.toBean(resultStr, ChatCompletionResult.class);
    }

    @Override
    public void douBaoStreamChat(ChatCompletionRequest param, EventSourceListener eventSourceListener) throws Exception {
        String url = apiChatHost + DouBaoConfigConst.DOUBAO_CHAT;
        param.setStream(true);
        log.info("进入豆包chat流式,请求参数{}", param);
        HttpRequestUtil.execute(okHttpClient, apiKey, url, mapper.writeValueAsString(param), eventSourceListener);
    }

    @Override
    public void douBaoStreamChatBot(ChatCompletionRequest param, EventSourceListener eventSourceListener) throws Exception {
        String url = apiChatBotHost + DouBaoConfigConst.DOUBAO_CHAT;
        param.setStream(true);
        log.info("进入豆包智能体chat流式,请求参数{}", param);
        HttpRequestUtil.execute(okHttpClient, apiKey, url, mapper.writeValueAsString(param), eventSourceListener);
    }
}
