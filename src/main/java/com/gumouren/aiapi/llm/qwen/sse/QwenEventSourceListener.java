package com.gumouren.aiapi.llm.qwen.sse;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;

import java.util.Objects;

/**
 * @author gumouren
 * @description: 千问sse监听
 * @date 2024/12/22 20:09
 */
@Slf4j
public class QwenEventSourceListener extends EventSourceListener {
    @Override
    public void onOpen(EventSource eventSource, Response response) {
        log.info("qwen建立sse连接...");
    }

    @Override
    public void onEvent(EventSource eventSource, String id, String type, String data) {
        log.info("qwen返回数据：{}", data);
        //JSONObject jsonObject = JSONUtil.toBean(data, JSONObject.class);
        if (data.contains("\"finish_reason\":\"stop\"")) {
            log.info("OpenAI返回数据结束了");
            return;
        }
    }

    @Override
    public void onClosed(EventSource eventSource) {
        log.info("qwen关闭sse连接...");
    }

    @SneakyThrows
    @Override
    public void onFailure(EventSource eventSource, Throwable t, Response response) {
        if(Objects.isNull(response)){
            log.error("qwen  sse连接异常:{}", t);
            eventSource.cancel();
            return;
        }
        ResponseBody body = response.body();
        if (Objects.nonNull(body)) {
            log.error("qwen  sse连接异常data：{}，异常：{}", body.string(), t);
        } else {
            log.error("qwen sse连接异常data：{}，异常：{}", response, t);
        }
        eventSource.cancel();
    }
}
