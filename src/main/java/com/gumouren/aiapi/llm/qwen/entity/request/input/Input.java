package com.gumouren.aiapi.llm.qwen.entity.request.input;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gumouren.aiapi.llm.qwen.entity.QwenMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

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
public class Input implements Serializable {
    /**
     * 用户当前输入的期望模型执行指令，支持中英文。
     */
    @JsonProperty("prompt")
    private String prompt;

    /**
     * 用户与模型的对话历史，格式为 {"user": "用户输入", "bot": "模型输出"}。
     * 即将废弃，建议使用messages
     */
    @JsonProperty("history")
    @Deprecated
    private List<History> history;

    /**
     * 用户与模型的对话历史，格式为 {"role": 角色, "content": 内容}。
     */
    @JsonProperty("messages")
    private List<QwenMessage> messages;



}
