package com.gumouren.aiapi.llm.xinghuo.entity.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gumouren.aiapi.llm.doubao.constant.DouBaoModel;
import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.volcengine.ark.runtime.model.completion.chat.ChatTool;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author gumouren
 * @description:
 * @date 2024/12/22 20:08
 */
@Data
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class XingHuoRequest implements Serializable {


    @JsonProperty("model")
    private String model = DouBaoModel.DOUBAO_LITE_4K.getModel();
    /**
     * 用户与模型的对话历史，格式为 {"role": 角色, "content": 内容}。
     */
    @JsonProperty("messages")
    private List<XingHuoMessage> messages;

    private Boolean stream;

    private Double temperature;
    @JsonProperty("top_p")
    private Double topP;
    @JsonProperty("stream_options")
    private ChatCompletionRequest.ChatCompletionRequestStreamOptions streamOptions;
    private List<String> stop;
    @JsonProperty("max_tokens")
    private Integer maxTokens;
    @JsonProperty("presence_penalty")
    private Double presencePenalty;
    @JsonProperty("frequency_penalty")
    private Double frequencyPenalty;
    @JsonProperty("logit_bias")
    private Map<String, Integer> logitBias;
    private String user;
    private List<ChatTool> tools;
    @JsonProperty("function_call")
    private ChatCompletionRequest.ChatCompletionRequestFunctionCall functionCall;
    private Boolean logprobs;
    @JsonProperty("top_logprobs")
    private Integer topLogprobs;
    @JsonProperty("repetition_penalty")
    private Double repetitionPenalty;
    private Integer n;
    @JsonProperty("tool_choice")
    private Object toolChoice;
    @JsonProperty("response_format")
    private ChatCompletionRequest.ChatCompletionRequestResponseFormat responseFormat;
}
