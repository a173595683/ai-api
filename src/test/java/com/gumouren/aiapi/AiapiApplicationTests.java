package com.gumouren.aiapi;

import cn.hutool.json.JSONUtil;
import com.gumouren.aiapi.llm.LLMApi;
import com.gumouren.aiapi.llm.qwen.QwenClient;
import com.gumouren.aiapi.llm.qwen.constant.QwenModel;
import com.gumouren.aiapi.llm.qwen.entity.QwenMessage;
import com.gumouren.aiapi.llm.qwen.entity.request.QwenRequest;
import com.gumouren.aiapi.llm.qwen.entity.request.input.Input;
import com.gumouren.aiapi.llm.xinghuo.XingHuoClient;
import com.gumouren.aiapi.llm.xinghuo.constant.XingHuoModel;
import com.gumouren.aiapi.llm.xinghuo.entity.request.XingHuoMessage;
import com.gumouren.aiapi.llm.xinghuo.entity.request.XingHuoRequest;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessageRole;
import org.junit.Test;

import java.util.Arrays;


public class AiapiApplicationTests {


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
	public void chatcommong() throws Exception {
		String key = "EiefdrisovuNfnglAuWt:aOKLRsvxRDSLbNXLViGL";
		LLMApi llmApi = new XingHuoClient(key);
		XingHuoMessage sysmsg = XingHuoMessage.builder()
				.role(ChatMessageRole.SYSTEM.value()).content("你是一个rap大师").build();
		XingHuoMessage usermsg = XingHuoMessage.builder()
				.role(ChatMessageRole.USER.value()).content("帮我写四句押韵的歌词，表达对时光易逝的感叹").build();
		XingHuoRequest request = XingHuoRequest.builder()
				.model(XingHuoModel.LITE.getModel())
				.messages(Arrays.asList(sysmsg, usermsg)).build();
		System.out.println(JSONUtil.toJsonStr(request));
		String result = llmApi.chat(JSONUtil.toJsonStr(request));
		System.out.println(result);
	}

}
