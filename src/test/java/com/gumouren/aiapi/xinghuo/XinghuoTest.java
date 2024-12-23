package com.gumouren.aiapi.xinghuo;

import cn.hutool.json.JSONUtil;
import com.gumouren.aiapi.llm.LLMApi;
import com.gumouren.aiapi.llm.qwen.QwenApi;
import com.gumouren.aiapi.llm.qwen.QwenClient;
import com.gumouren.aiapi.llm.qwen.constant.QwenModel;
import com.gumouren.aiapi.llm.qwen.entity.QwenMessage;
import com.gumouren.aiapi.llm.qwen.entity.request.QwenRequest;
import com.gumouren.aiapi.llm.qwen.entity.request.input.Input;
import com.gumouren.aiapi.llm.qwen.sse.QwenEventSourceListener;
import com.gumouren.aiapi.llm.xinghuo.XingHuoApi;
import com.gumouren.aiapi.llm.xinghuo.XingHuoClient;
import com.gumouren.aiapi.llm.xinghuo.constant.XingHuoModel;
import com.gumouren.aiapi.llm.xinghuo.entity.request.XingHuoMessage;
import com.gumouren.aiapi.llm.xinghuo.entity.request.XingHuoRequest;
import com.gumouren.aiapi.llm.xinghuo.sse.XingHuoEventSourceListener;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessageRole;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * @author gumouren
 * @description: TODO
 * @date 2024/12/22 23:08
 */
public class XinghuoTest {

    String key = "";

    @Test
    public void chat() throws Exception {

        LLMApi llmApi = new XingHuoClient(key);
        XingHuoMessage sysmsg = XingHuoMessage.builder()
                .role(ChatMessageRole.SYSTEM.value()).content("你是一个rap大师").build();
        XingHuoMessage usermsg = XingHuoMessage.builder()
                .role(ChatMessageRole.USER.value()).content("帮我写四句押韵的歌词，表达对时光易逝的感叹").build();
        XingHuoRequest request = XingHuoRequest.builder()
                .model(XingHuoModel.LITE.getModel())
                .messages(Arrays.asList(sysmsg, usermsg)).build();

        String result = llmApi.chat(JSONUtil.toJsonStr(request));
        System.out.println(result);
    }

    @Test
    public void Stream() throws Exception {
        XingHuoEventSourceListener eventSourceListener = new XingHuoEventSourceListener();
        XingHuoApi api = new XingHuoClient(key);
        XingHuoMessage sysmsg = XingHuoMessage.builder()
                .role(ChatMessageRole.SYSTEM.value()).content("你是一个rap大师").build();
        XingHuoMessage usermsg = XingHuoMessage.builder()
                .role(ChatMessageRole.USER.value()).content("帮我写四句押韵的歌词，表达对时光易逝的感叹").build();
        XingHuoRequest request = XingHuoRequest.builder()
                .model(XingHuoModel.LITE.getModel())
                .messages(Arrays.asList(sysmsg, usermsg)).build();
        api.xingHuoStreamChat(request, eventSourceListener);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
