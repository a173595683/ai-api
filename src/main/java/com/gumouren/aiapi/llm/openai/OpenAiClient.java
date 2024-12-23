package com.gumouren.aiapi.llm.openai;

import okhttp3.sse.EventSourceListener;

import java.util.EventListener;

/**
 * @author gumouren
 * @description: 等待完善
 * @date 2024/12/22 20:10
 */
public class OpenAiClient implements OpenAiApi{
    @Override
    public String chat(String param) throws Exception {
        return "";
    }

    @Override
    public void streamChat(String param, EventSourceListener eventSourceListener) throws Exception {

    }


}
