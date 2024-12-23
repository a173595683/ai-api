package com.gumouren.aiapi.llm.qwen.entity.response.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.gumouren.aiapi.llm.qwen.entity.QwenMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
public  class Choice {
    // Message类，表示每个消息
    @JsonProperty("message")
    private QwenMessage message;


    // 停止原因，null：生成过程中，stop：stop token导致结束，length：生成长度导致结束
    @JsonProperty("finish_reason")
    private String finishReason;


}
