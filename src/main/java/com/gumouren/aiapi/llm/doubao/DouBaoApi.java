package com.gumouren.aiapi.llm.doubao;

import com.gumouren.aiapi.llm.LLMApi;
import com.gumouren.aiapi.llm.qwen.entity.request.QwenRequest;
import com.gumouren.aiapi.llm.qwen.entity.response.QwenResponse;
import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionResult;
import okhttp3.sse.EventSourceListener;

/**
 * @author gumouren
 * @description: 豆包
 * @date 2024/12/22 20:10
 */
public interface DouBaoApi extends LLMApi {

    /**
     * 聊天
     * @param param 请求结构，使用JSON
     * @return 【QwenResponse、ChatCompletionResponse】
     * @throws Exception
     */
    ChatCompletionResult douBaoChat(ChatCompletionRequest param) throws Exception;

    /**
     * 流式聊天
     * @param param 请求结构，使用JSON
     * @param eventSourceListener sse接收器
     * @throws Exception
     */
    void douBaoStreamChat(ChatCompletionRequest param, EventSourceListener eventSourceListener) throws Exception;

    /**
     * 流式智能体聊天
     * @param param 请求结构，使用JSON
     * @param eventSourceListener sse接收器
     * @throws Exception
     */
    void douBaoStreamChatBot(ChatCompletionRequest param, EventSourceListener eventSourceListener) throws Exception;
}
