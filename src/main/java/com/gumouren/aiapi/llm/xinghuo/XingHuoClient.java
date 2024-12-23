package com.gumouren.aiapi.llm.xinghuo;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gumouren.aiapi.util.HttpRequestUtil;
import com.gumouren.aiapi.llm.xinghuo.constant.XingHuoConfigConst;
import com.gumouren.aiapi.llm.xinghuo.entity.request.XingHuoRequest;
import com.gumouren.aiapi.llm.xinghuo.entity.response.XingHuoResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.sse.EventSourceListener;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author gumouren
 * @description: 星火大模型 https://www.xfyun.cn/doc/spark/HTTP%E8%B0%83%E7%94%A8%E6%96%87%E6%A1%A3.html#_1-%E6%8E%A5%E5%8F%A3%E8%AF%B4%E6%98%8E
 * @date 2024/12/22 20:08
 */
@Slf4j
public class XingHuoClient implements XingHuoApi {

    //星火大模型中命名为APIPassword
    private final String apiKey ;
    private  String host = XingHuoConfigConst.XingHuo_HOST;
    private OkHttpClient okHttpClient = new OkHttpClient
            .Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS).build();
    private ObjectMapper mapper = new ObjectMapper();

    public XingHuoClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public XingHuoClient(String apiKey, String host) {
        this.apiKey = apiKey;
        this.host = host;
    }

    public XingHuoClient(String apiKey, String host, OkHttpClient httpClient) {
        this.apiKey = apiKey;
        this.host = host;
        this.okHttpClient = httpClient;
    }


    @Override
    public String chat(String param) throws Exception {
        XingHuoRequest request = JSONUtil.toBean(param, XingHuoRequest.class);
        XingHuoResponse response = xingHuoChat(request);
        return JSONUtil.toJsonStr(response);
    }

    @Override
    public void streamChat(String param, EventSourceListener eventSourceListener) throws Exception {
        if (Objects.isNull(eventSourceListener)) {
            log.error("参数异常：EventSourceListener不能为空");
            throw new Exception("参数异常：EventSourceListener不能为空");
        }
        XingHuoRequest request = JSONUtil.toBean(param, XingHuoRequest.class);
        xingHuoStreamChat(request, eventSourceListener);
    }


    @Override
    public XingHuoResponse xingHuoChat(XingHuoRequest param) throws Exception {
        String url = host + XingHuoConfigConst.XingHuo_CHAT;
        log.info("进入星火chat,请求参数{}", param);
        String resultStr = HttpRequestUtil.execute(okHttpClient, apiKey, url, mapper.writeValueAsString(param));
        return JSONUtil.toBean(resultStr, XingHuoResponse.class);
    }

    @Override
    public void xingHuoStreamChat(XingHuoRequest param, EventSourceListener eventSourceListener) throws Exception {
        String url = host + XingHuoConfigConst.XingHuo_CHAT;
        param.setStream(true);
        log.info("进入星火chat流式,请求参数{}", param);
        HttpRequestUtil.execute(okHttpClient, apiKey, url, mapper.writeValueAsString(param), eventSourceListener);
    }

}
