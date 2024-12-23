package com.gumouren.aiapi.llm.xinghuo.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.ark.runtime.model.completion.chat.ChatFunctionCall;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessage;
import com.volcengine.ark.runtime.model.completion.chat.ChatToolCall;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author gumouren
 * @description:
 * @date 2024/12/22 20:08
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC) // 确保构造方法是公共的
public class XingHuoMessage  {

    @JsonProperty("function_call")
    ChatFunctionCall functionCall;
    @JsonProperty("tool_calls")
    List<ChatToolCall> toolCalls;
    @JsonProperty("tool_call_id")
    String toolCallId;

    // 角色，可选值：system、user、assistant
    @JsonProperty("role")
    private String role;
    private String name;
    // 模型输出的内容
    @JsonProperty("content")
    private String content;

}
