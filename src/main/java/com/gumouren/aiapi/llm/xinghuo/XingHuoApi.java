package com.gumouren.aiapi.llm.xinghuo;

import com.gumouren.aiapi.llm.LLMApi;
import com.gumouren.aiapi.llm.xinghuo.entity.request.XingHuoRequest;
import com.gumouren.aiapi.llm.xinghuo.entity.response.XingHuoResponse;
import okhttp3.sse.EventSourceListener;

/**
 * @author gumouren
 * @description: 星火
 * @date 2024/12/22 20:08
 */
public interface XingHuoApi extends LLMApi {


    /**
     * 聊天
     * @param param 请求结构，使用JSON
     * @return ChatCompletionResult
     * @throws Exception
     */
    XingHuoResponse xingHuoChat(XingHuoRequest param) throws Exception;

    /**
     * 流式聊天
     * @param param 请求结构，使用JSON
     * @param eventSourceListener sse接收器
     * @throws Exception
     */
    void xingHuoStreamChat(XingHuoRequest param, EventSourceListener eventSourceListener) throws Exception;
}
