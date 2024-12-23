package com.gumouren.aiapi.qwen;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.gumouren.aiapi.llm.LLMApi;
import com.gumouren.aiapi.llm.qwen.QwenApi;
import com.gumouren.aiapi.llm.qwen.QwenClient;
import com.gumouren.aiapi.llm.qwen.constant.QwenModel;
import com.gumouren.aiapi.llm.qwen.entity.QwenMessage;
import com.gumouren.aiapi.llm.qwen.entity.request.QwenRequest;
import com.gumouren.aiapi.llm.qwen.entity.request.input.Input;
import com.gumouren.aiapi.llm.qwen.sse.QwenEventSourceListener;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author gumouren
 * @description: TODO
 * @date 2024/12/22 23:09
 */
public class QwenTest {

    private final String API_KEY = "";

    @Test
    public void chat() throws Exception {
        LLMApi llmApi = new QwenClient(API_KEY);
        QwenMessage sysmsg = QwenMessage.builder()
                .role("system")
                .content("你是一个rap大师").build();
        QwenMessage usermsg = QwenMessage.builder()
                .role("user")
                .content("帮我写四句押韵的歌词，表达对时光易逝的感叹").build();
        QwenRequest request = QwenRequest.builder()
                .model(QwenModel.QWEN_TURBO.getModel())
                .input(Input.builder().messages(Arrays.asList(sysmsg, usermsg)).build())
                .build();
        String result = llmApi.chat(JSONUtil.toJsonStr(request));
        System.out.println(result);
    }



    @Test
    public void Stream() throws Exception {

        QwenEventSourceListener eventSourceListener = new QwenEventSourceListener();
        QwenApi api = new QwenClient(API_KEY);

        List<QwenMessage> messages = new ArrayList<>();
        QwenMessage message = new QwenMessage();
        message.setRole("user");
        message.setContent("我是谁");
        messages.add(message);
        QwenRequest request = QwenRequest.builder()
                .model(QwenModel.QWEN_TURBO.getModel())
                .input(Input.builder().messages(messages).build()).build();
        api.qwenStreamChat(request, eventSourceListener);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
