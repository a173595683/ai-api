package com.gumouren.aiapi.llm.qwen;

import com.gumouren.aiapi.llm.LLMApi;
import com.gumouren.aiapi.llm.qwen.entity.request.QwenRequest;
import com.gumouren.aiapi.llm.qwen.entity.response.QwenResponse;
import okhttp3.sse.EventSourceListener;

/**
 * @author gumouren
 * @description: 千问
 * @date 2024/12/22 20:09
 */
public interface QwenApi extends LLMApi {

    /**
     * 聊天
     * @param param 请求结构，使用JSON
     * @return 【QwenResponse、ChatCompletionResponse】
     * @throws Exception
     */
    QwenResponse qwenChat(QwenRequest param) throws Exception;

    /**
     * 流式聊天
     * @param param 请求结构，使用JSON
     * @param eventSourceListener sse接收器
     * @throws Exception
     */
    void qwenStreamChat(QwenRequest param, EventSourceListener eventSourceListener) throws Exception;

}
