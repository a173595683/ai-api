package com.gumouren.aiapi.llm;

import okhttp3.sse.EventSourceListener;

import java.util.EventListener;

/**
 * @author gumouren
 * @description: 大语言模型通用API
 * @date 2024/12/22 19:57
 */
public interface LLMApi {

    /**
     * 聊天
     * @param param 请求结构，使用JSON
     * @return 【QwenResponse、ChatCompletionResponse】
     * @throws Exception
     */
    String chat(String param) throws Exception;

    /**
     * 流式聊天
     * @param param 请求结构，使用JSON
     * @param eventSourceListener sse接收器
     * @throws Exception
     */
    void streamChat(String param, EventSourceListener eventSourceListener) throws Exception;

}
